package com.ghien24s.sampleadapter

import LogoutSuccessfulDialog
import android.annotation.SuppressLint
import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.util.Size
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.view.animation.TranslateAnimation
import android.widget.PopupWindow
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.ViewPropertyAnimatorListenerAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.ghien24s.sampleadapter.adapter.CategoryAdapter
import com.ghien24s.sampleadapter.databinding.ActivityMainBinding
import com.ghien24s.sampleadapter.model.Category


class MainActivity : AppCompatActivity(), CategoryAdapter.OnItemClickListener {

    private lateinit var binding: ActivityMainBinding
    lateinit var categoryAdapter: CategoryAdapter

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val cate1 = Category("0001", "Category 1", "Tag 1", "Desc 1", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSGrV7Kw4AmcYR36sFr2O2-OA5rJsPahKBzwnz03DtIZkr4WJgQEIRARAhSYNXifFhRtPk&usqp=CAU")
        val cate2 = Category("0002", "Category 2", "Tag 2", "Desc 1", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSGrV7Kw4AmcYR36sFr2O2-OA5rJsPahKBzwnz03DtIZkr4WJgQEIRARAhSYNXifFhRtPk&usqp=CAU")
        val cate3 = Category("0003", "Category 3", "Tag 3", "Desc 1", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSGrV7Kw4AmcYR36sFr2O2-OA5rJsPahKBzwnz03DtIZkr4WJgQEIRARAhSYNXifFhRtPk&usqp=CAU")
        val cate4 = Category("0004", "Category 4", "Tag 4", "Desc 1", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSGrV7Kw4AmcYR36sFr2O2-OA5rJsPahKBzwnz03DtIZkr4WJgQEIRARAhSYNXifFhRtPk&usqp=CAU")
        val cate5 = Category("0005", "Category 5", "Tag 5", "Desc 1", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSGrV7Kw4AmcYR36sFr2O2-OA5rJsPahKBzwnz03DtIZkr4WJgQEIRARAhSYNXifFhRtPk&usqp=CAU")

        var categories: List<Category> = listOf(cate1, cate2, cate3, cate4, cate5)

        var isShow = true
        categoryAdapter = CategoryAdapter(applicationContext, this)


        binding.apply {
            rcCategory.apply {
                adapter = categoryAdapter
                layoutManager = LinearLayoutManager(applicationContext)
//                layoutManager =
//                    GridLayoutManager(applicationContext, 1, GridLayoutManager.HORIZONTAL, false)
            }

            btnToggle.setOnClickListener {view->

                val topDialog = LogoutSuccessfulDialog(this@MainActivity)
                topDialog.show()
//                mydialog()




//                showPopupWindow(window.decorView)
//                custom(view)
//                val inflater = LayoutInflater.from(applicationContext)
//                val snackView: View = inflater.inflate(R.layout.alert, null, false)
//
//                val snack: Snackbar = Snackbar.make(window.decorView,"dadasdasdas", 2000)
//                snack.anchorView = (window.decorView.rootView)
//                createAlert(window.decorView.rootView as ViewGroup)

//                val inflater = LayoutInflater.from(applicationContext)
//                val snackView: View = inflater.inflate(R.layout.alert, null, false)

//                val view:Snackbar.SnackbarLayout = snack.view as Snackbar.SnackbarLayout
//                view.setBackgroundColor(android.R.color.transparent)
//                val params = view.layoutParams as FrameLayout.LayoutParams
//                params.gravity = Gravity.TOP
////                params.topMargin =  -view.height
//                view.layoutParams = params
//                view.startAnimation(AnimationUtils.loadAnimation(applicationContext, R.anim.slide_in_snack_bar))
//                view.animation = AnimationUtils.loadAnimation(applicationContext, R.anim.slide_in_snack_bar)
//                view.setPadding(0, 0, 0, 0)
//                view.addView(snackView, 0)
//                snack.setAnimationMode(BaseTransientBottomBar.ANIMATION_MODE_SLIDE)
//                snack.addCallback(object : Snackbar.Callback() {
//                    override fun onShown(sb: Snackbar?) {
//                        super.onShown(sb)
//                        view.animation = AnimationUtils.loadAnimation(applicationContext, R.anim.slide_in_snack_bar)
//                    }
//                    override fun onDismissed(transientBottomBar: Snackbar, event: Int) {
//                        view.startAnimation(AnimationUtils.loadAnimation(applicationContext, R.anim.slide_out_snack_bar))
//                    }
//                })

//                view.bringToFront()
//                snack.show()
//                val inflater = LayoutInflater.from(applicationContext)
//                val view: View = inflater.inflate(R.layout.alert, null, false)
//                container.addView(view)
//                view.translationY = -view.height.toFloat()
//                ViewCompat.animate(view)
//                    .translationY(0f)
//                    .setDuration(3000)
//                    .setListener(object : ViewPropertyAnimatorListenerAdapter() {
//                        override fun onAnimationStart(view: View) {
//
//                        }
//
//                        override fun onAnimationEnd(view: View) {
//
//                        }
//                    })
//                    .start()
            }
        }
        categoryAdapter.submitList(categories)


    }

    private fun createAlert(viewGroup: ViewGroup) {

        val inflater = LayoutInflater.from(applicationContext)
        val view: View = inflater.inflate(R.layout.alert, viewGroup, false)
        view.translationY = view.height.toFloat()
        ViewCompat.animate(view)
            .translationY(0f)
            .setDuration(3000)
            .setListener(object : ViewPropertyAnimatorListenerAdapter() {
                override fun onAnimationStart(view: View) {

                }

                override fun onAnimationEnd(view: View) {

                }
            })
            .start()
    }
    private fun showPopupWindow(anchor: View) {
        PopupWindow(anchor.context).apply {
            isOutsideTouchable = true
            val inflater = LayoutInflater.from(anchor.context)
            contentView = inflater.inflate(R.layout.alert, null).apply {
                measure(
                    View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
                    View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED)
                )
            }
//            contentView.setBackgroundColor(R.)
        }.also { popupWindow ->
            // Absolute location of the anchor view
            val location = IntArray(2).apply {
                anchor.getLocationOnScreen(this)
            }
            val size = Size(
                popupWindow.contentView.measuredWidth,
                popupWindow.contentView.measuredHeight
            )
            popupWindow.showAtLocation(
                anchor,
                Gravity.TOP or Gravity.START,
                location[0] - (size.width - anchor.width) / 2,
                location[1] - size.height
            )
        }
    }

    private fun showPictureialog() {
        val dialog = Dialog(
            this
        )

        // Setting dialogview
        val window = dialog.window
        window!!.setGravity(Gravity.TOP)
        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        dialog.setTitle(null)
        dialog.setContentView(R.layout.alert)
        dialog.setCancelable(true)
        dialog.show()
    }
    private fun custom(view:View) {
        val inflater = LayoutInflater.from(applicationContext)
//        val view: View = LayoutInflater.from(applicationContext).inflate(R.layout.alert)
        val view: View = inflater.inflate(R.layout.alert, null, false)
        val popUpWindow = PopupWindow(
            view, ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        popUpWindow.contentView = view
        popUpWindow.showAsDropDown(view)
    }

    override fun onItemClick(category: Category) {
        Log.d("Jimmy", category.name!!)
    }

    fun slideDown(view: View) {
        val animate = TranslateAnimation(
            0f,  // fromXDelta
            0f,  // toXDelta
            0f,  // fromYDelta
            view.height.toFloat()
        ) // toYDelta
        animate.duration = 500
        animate.fillAfter = true
        view.startAnimation(animate)
        Handler().postDelayed(Runnable { view.visibility = View.GONE }, 500)
    }

    fun mydialog() {
        var dialog = Dialog(this@MainActivity)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(R.layout.alert)
        dialog.window!!.attributes.windowAnimations = R.style.dialogAnimation
        dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialog.window!!.setDimAmount(0f)
        dialog.window!!.setGravity(Gravity.TOP)
        dialog.show()
    }


}