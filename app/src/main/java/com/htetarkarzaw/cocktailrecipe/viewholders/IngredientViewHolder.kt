package com.htetarkarzaw.cocktailrecipe.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.htetarkarzaw.cocktailrecipe.R
import com.htetarkarzaw.cocktailrecipe.data.IngredientVO
import kotlinx.android.synthetic.main.view_ingredient_list.view.*

class IngredientViewHolder(
    itemView: View
) : BaseViewHolder<IngredientVO>(itemView) {

    override fun setData(data: IngredientVO) {
        mData = data
        if (mData != null) {
            itemView.tvIngredient.text = mData!!.ingredient
            itemView.tvMeasure.text = mData!!.measure
            Glide.with(itemView.context)
                .asBitmap()
                .apply(getOption())
                .load("https://www.thecocktaildb.com/images/ingredients/"+mData!!.ingredient+".png")
                .into(itemView.ivIngerdient)
        }
    }

    fun getOption(): RequestOptions {

        return RequestOptions()
            .centerCrop()
            .placeholder(R.drawable.blank_photo)
            .error(R.drawable.blank_photo)
    }

    override fun onClick(v: View?) {
    }
}