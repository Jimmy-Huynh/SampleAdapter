package com.ghien24s.sampleadapter

import android.app.Activity
import android.app.Dialog
import android.content.Context
import android.os.Handler
import android.util.TypedValue
import android.view.Gravity
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.Interpolator
import android.view.animation.TranslateAnimation
import androidx.coordinatorlayout.widget.CoordinatorLayout

class TopDialog(context: Context) : Dialog(context) {

    private val durationAnimationShow = 300
    private val durationAnimationHide = 100
    private val duration = 3000
    private val interpolatorShow: Interpolator? = null
    private val width = 0
    private var height: Int = 0
    private var interpolatorHide: android.view.animation.Interpolator? = null
    private var interpolatorSwipeToDimiss: android.view.animation.Interpolator? = null
    private lateinit var rlMain: CoordinatorLayout

    private fun init() {
        val window = this.window
        val wlp = window!!.attributes
        wlp.gravity = Gravity.TOP
        window.attributes = wlp
        //        getWindow().getAttributes().flags
//        val flag = (context as Activity).window.attributes.flags
//        window.setFlags(flag, flag)
//        window.setFlags(
//            WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL,
//            WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
//        )
        val dip = 80f
        val r = context.resources
        height = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            dip,
            r.displayMetrics
        ).toInt()

    }

    override fun create() {
        super.create()
        this.setContentView(R.layout.alert)
        init()
        rlMain = findViewById(R.id.alert)

    }

    override fun show() {
        rlMain = findViewById(R.id.alert)
        val animationShow = createAnimationShow()

        val animationClose = createAnimationClose()

        rlMain.startAnimation(animationShow)

        val handler = Handler()
        handler.postDelayed(
            {
                rlMain.startAnimation(animationClose)
            },
            (duration + durationAnimationShow).toLong()
        )
        handler.postDelayed(
            { this@TopDialog.dismiss() },
            (duration + durationAnimationShow + durationAnimationHide).toLong()
        )
        super.show()
    }

    private fun createAnimationShow(): Animation? {
        val animationShow: Animation = TranslateAnimation(0f, 0f, -height.toFloat(), 0f)
        animationShow.duration = durationAnimationShow.toLong()
        if (interpolatorShow != null) animationShow.interpolator = interpolatorShow
        animationShow.fillAfter = true
        return animationShow
    }

    private fun createAnimationClose(): Animation? {
        val animationClose: Animation = TranslateAnimation(0f, 0f, 0f, -height.toFloat())
        animationClose.duration = durationAnimationHide.toLong()
        animationClose.fillAfter = true
        if (interpolatorHide != null) animationClose.interpolator = interpolatorHide
        return animationClose
    }
}