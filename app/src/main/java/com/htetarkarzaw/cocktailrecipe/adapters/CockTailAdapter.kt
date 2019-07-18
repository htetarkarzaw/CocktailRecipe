package com.htetarkarzaw.cocktailrecipe.adapters

import android.content.Context
import android.view.ViewGroup
import com.htetarkarzaw.cocktailrecipe.viewholders.BaseViewHolder
import com.htetarkarzaw.cocktailrecipe.ClickCocktailDelecate
import com.htetarkarzaw.cocktailrecipe.viewholders.CocktailViewHolder
import com.htetarkarzaw.cocktailrecipe.R
import com.htetarkarzaw.cocktailrecipe.data.DrinkVO

class CockTailAdapter (context: Context, var delegate: ClickCocktailDelecate) :
    BaseRecyclerAdapter<CocktailViewHolder, DrinkVO>(context) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<DrinkVO> {
        val view = mLayoutInflator.inflate(R.layout.view_cocktail_list, parent, false)
        return CocktailViewHolder(view, delegate)
    }
}