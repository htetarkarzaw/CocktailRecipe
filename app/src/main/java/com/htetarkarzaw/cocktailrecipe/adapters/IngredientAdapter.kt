package com.htetarkarzaw.cocktailrecipe.adapters

import android.content.Context
import android.view.ViewGroup
import com.htetarkarzaw.cocktailrecipe.viewholders.BaseViewHolder
import com.htetarkarzaw.cocktailrecipe.R
import com.htetarkarzaw.cocktailrecipe.data.IngredientVO
import com.htetarkarzaw.cocktailrecipe.viewholders.IngredientViewHolder

class IngredientAdapter (context: Context) :
    BaseRecyclerAdapter<IngredientViewHolder, IngredientVO>(context) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<IngredientVO> {
        val view = mLayoutInflator.inflate(R.layout.view_ingredient_list, parent, false)
        return IngredientViewHolder(view)
    }
}