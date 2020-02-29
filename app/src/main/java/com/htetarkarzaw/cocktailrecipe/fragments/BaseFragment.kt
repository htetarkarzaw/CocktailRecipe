package com.htetarkarzaw.cocktailrecipe.fragments

import android.content.Context
import android.os.Bundle
import android.widget.ProgressBar
import androidx.appcompat.app.AlertDialog
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.github.ybq.android.spinkit.style.CubeGrid
import com.htetarkarzaw.cocktailrecipe.R


open class BaseFragment: Fragment() {

    var progressBar: ProgressBar? = null

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    fun loadingIndicator(layout: ConstraintLayout, show:Boolean){
        if (show == true) {
            if(progressBar != null){return}
            progressBar = ProgressBar(activity)//(activity,  null, android.R.attr.progressBarStyleLarge)
            val animation = CubeGrid()
            animation.color = ContextCompat.getColor(activity as Context, R.color.pink)
            progressBar!!.setIndeterminateDrawable(animation)
            progressBar!!.id = R.id.loading
            layout.addView(progressBar!!)


            val constraintSet = ConstraintSet()
            constraintSet.clone(layout)
            constraintSet.connect(progressBar!!.id, ConstraintSet.TOP, layout.id, ConstraintSet.TOP, 0)
            constraintSet.connect(progressBar!!.id, ConstraintSet.LEFT, layout.id, ConstraintSet.LEFT, 0)
            constraintSet.connect(progressBar!!.id, ConstraintSet.RIGHT, layout.id, ConstraintSet.RIGHT, 0)
            constraintSet.connect(progressBar!!.id, ConstraintSet.BOTTOM, layout.id, ConstraintSet.BOTTOM, 0)
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
}