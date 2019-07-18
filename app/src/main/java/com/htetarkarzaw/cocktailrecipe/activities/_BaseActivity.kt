package com.htetarkarzaw.cocktailrecipe.activities

import android.content.Context
import android.os.Bundle
import android.widget.ProgressBar
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.content.ContextCompat
import com.github.ybq.android.spinkit.style.CubeGrid
import com.htetarkarzaw.cocktailrecipe.R


open class _BaseActivity: AppCompatActivity(){

    var progressBar: ProgressBar? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        val window = window

// clear FLAG_TRANSLUCENT_STATUS flag:
//        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)

// add FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS flag to the window
//        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)

// finally change the color
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            window.statusBarColor = ContextCompat.getColor(applicationContext, com.whitemerak.japatomo.R.color.white2)
//        }
    }

    fun loadingIndicator(layout: ConstraintLayout, show:Boolean){
        if (show == true) {
            if(progressBar != null){return}
            progressBar = ProgressBar(this)//(activity,  null, android.R.attr.progressBarStyleLarge)
            val animation = CubeGrid()
            animation.color = ContextCompat.getColor(this, R.color.pink)
            progressBar!!.indeterminateDrawable = animation
            progressBar!!.id = R.id.loading
            layout.addView(progressBar!!)


            val constraintSet = ConstraintSet()
            constraintSet.clone(layout)
            constraintSet.connect(progressBar!!.getId(), ConstraintSet.TOP, layout.getId(), ConstraintSet.TOP, 0)
            constraintSet.connect(progressBar!!.getId(), ConstraintSet.LEFT, layout.getId(), ConstraintSet.LEFT, 0)
            constraintSet.connect(progressBar!!.getId(), ConstraintSet.RIGHT, layout.getId(), ConstraintSet.RIGHT, 0)
            constraintSet.connect(progressBar!!.getId(), ConstraintSet.BOTTOM, layout.getId(), ConstraintSet.BOTTOM, 0)
            constraintSet.applyTo(layout)

        }else{
            if(progressBar == null){return}
            layout.removeView(progressBar!!)
            progressBar = null
        }

    }

    fun showAlert(context:Context, title:String, message:String, useTwoBtn:Boolean, function:Runnable){
        val builder = AlertDialog.Builder(context)
        builder.setTitle(title)
        builder.setMessage(message)
        if (useTwoBtn) {
            builder.setPositiveButton("Yes") { dialog, _ ->
                function.run()
                dialog.dismiss()
            }
            builder.setNegativeButton("No") { dialog, _ -> dialog.dismiss() }
        }else {
            builder.setPositiveButton("Ok") { dialog, _ -> dialog.dismiss() }
        }
        val productDialog = builder.create()
        productDialog.show()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home ->
                finish()
        }

        return super.onOptionsItemSelected(item)
    }


}
