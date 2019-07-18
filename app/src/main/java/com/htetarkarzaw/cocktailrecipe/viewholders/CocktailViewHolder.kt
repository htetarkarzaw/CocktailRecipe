package com.htetarkarzaw.cocktailrecipe.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.htetarkarzaw.cocktailrecipe.ClickCocktailDelecate
import com.htetarkarzaw.cocktailrecipe.R
import com.htetarkarzaw.cocktailrecipe.data.DrinkVO
import kotlinx.android.synthetic.main.view_cocktail_list.view.*

class CocktailViewHolder(
    itemView: View,
    var delegate: ClickCocktailDelecate
) : BaseViewHolder<DrinkVO>(itemView) {

    override fun setData(data: DrinkVO) {
        mData = data
        if (mData != null) {
            itemView.tvCocktail.text = mData!!.strDrink
            Glide.with(itemView.context)
                .asBitmap()
                .apply(getOption())
                .load(mData!!.strDrinkThumb)
                .into(itemView.ivCocktail)
        }
    }

    fun getOption(): RequestOptions {

        return RequestOptions()
            .centerCrop()
            //                .diskCacheStrategy(DiskCacheStrategy.NONE)
            //                .skipMemoryCache(true)
            .placeholder(R.drawable.blank_photo)
            .error(R.drawable.blank_photo)
    }

    override fun onClick(v: View?) {
        delegate.clickCocktail(mData!!)
    }
}