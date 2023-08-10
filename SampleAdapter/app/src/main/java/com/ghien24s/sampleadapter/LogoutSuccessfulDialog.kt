import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Handler
import android.os.Looper
import android.util.TypedValue
import android.view.Gravity
import android.view.ViewGroup
import android.view.Window
import android.view.animation.Animation
import android.view.animation.TranslateAnimation
import android.widget.RelativeLayout
import com.ghien24s.sampleadapter.R

class LogoutSuccessfulDialog(context: Context) : Dialog(context) {

    private val duration = DIALOG_DURATION
    private val durationAnimationShow = DIALOG_DURATION_SHOW
    private val durationAnimationHide = DIALOG_DURATION_HIDE
    private var rlMain: RelativeLayout? = null
    private var height = DIALOG_DEFAULT_HEIGHT

    init {
        val window = this.window
        if (window != null) {
            window.requestFeature(Window.FEATURE_NO_TITLE)
            window.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            window.setGravity(Gravity.TOP)
            window.setDimAmount(0f)
            setContentView(R.layout.alert)
            window.setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            init(context)
        }


    }


    private fun init(context: Context) {
        rlMain = findViewById(R.id.alert)
        val dip = 80f
        val r = context.resources
        height = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            dip,
            r.displayMetrics
        ).toInt()
    }

    override fun show() {
        val animationShow = createAnimationShow()
        val animationClose = createAnimationClose()
        rlMain?.startAnimation(animationShow)

        Handler(Looper.getMainLooper()).postDelayed({
            rlMain?.startAnimation(animationClose)
        }, (duration + durationAnimationShow).toLong())

        Handler(Looper.getMainLooper()).postDelayed({
            dismiss()
        }, (duration + durationAnimationShow + durationAnimationHide).toLong())

//        val handler = Handler()
//        handler.postDelayed(
//            { rlMain!!.startAnimation(animationClose) },
//            (duration + durationAnimationShow).toLong()
//        )
//        handler.postDelayed(
//            { dismiss() },
//            (duration + durationAnimationShow + durationAnimationHide).toLong()
//        )

        setCanceledOnTouchOutside(true)
        super.show()
    }

    private fun createAnimationShow(): Animation {
        val animationShow: Animation = TranslateAnimation(ZERO, ZERO, -height.toFloat(), ZERO)
        animationShow.duration = durationAnimationShow.toLong()
        animationShow.fillAfter = true
        return animationShow
    }

    private fun createAnimationClose(): Animation {
        val animationClose: Animation = TranslateAnimation(ZERO, ZERO, ZERO, -height.toFloat())
        animationClose.duration = durationAnimationHide.toLong()
        animationClose.fillAfter = true
        return animationClose
    }

    companion object {
        const val DIALOG_DURATION = 3000
        const val DIALOG_DURATION_SHOW = 300
        const val DIALOG_DURATION_HIDE = 200
        const val DIALOG_DEFAULT_HEIGHT = 0
        const val ZERO = 0f
    }

}