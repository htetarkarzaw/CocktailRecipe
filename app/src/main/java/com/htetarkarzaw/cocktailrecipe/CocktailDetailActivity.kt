package com.htetarkarzaw.cocktailrecipe

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.htetarkarzaw.cocktailrecipe.activities._BaseActivity
import com.htetarkarzaw.cocktailrecipe.adapters.IngredientAdapter
import com.htetarkarzaw.cocktailrecipe.data.DetailVO
import com.htetarkarzaw.cocktailrecipe.data.IngredientVO
import com.htetarkarzaw.cocktailrecipe.viewmodels.DetailViewModel
import kotlinx.android.synthetic.main.activity_cocktail_detail.*
import kotlinx.android.synthetic.main.content_cocktail_detail.*

import kotlinx.android.synthetic.main.fragment_cocktail.rootlayout
import kotlin.collections.ArrayList

class CocktailDetailActivity : _BaseActivity() {
    companion object {
        fun newInstance(context: Context, cocktailId: Long): Intent {
            val intent = Intent(context, CocktailDetailActivity::class.java)
            intent.putExtra("cocktailId", cocktailId)
            return intent
        }
    }

    private var cocktailId: Long = 0
    private lateinit var cocktailDetail: DetailVO
    private lateinit var viewModel: DetailViewModel
    private lateinit var ingredientList: List<IngredientVO>
    private lateinit var ingredientAdapter: IngredientAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cocktail_detail)
        setSupportActionBar(toolbar_details)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        ingredientList = ArrayList()
        viewModel = ViewModelProviders.of(this).get(DetailViewModel::class.java)
        if (intent.hasExtra("cocktailId")) {
            cocktailId = intent.getLongExtra("cocktailId", 0)
        }
        ingredientAdapter = IngredientAdapter(this)
        rcIngredient.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        rcIngredient.adapter = ingredientAdapter
        getDetail()
        viewModel.getDetails().observe(this, androidx.lifecycle.Observer { apiResponse ->
            if (apiResponse != null && apiResponse.isNotEmpty()) {
                cocktailDetail = apiResponse[0]
                ingredientAdapter.clearData()
                setupDetail(cocktailDetail)
            } else {
                val errorMessage: String? = "Something is wrong!\nPlease Try Again"
                showAlert(this, "Sorry!", errorMessage!!, true, Runnable { getDetail() })
            }
            loadingIndicator(rootlayout, false)
        })

        viewModel.getError().observe(this, androidx.lifecycle.Observer {
            loadingIndicator(rootlayout, false)
            var errorMessage: String? = "Unable to connect!\nPlease Try Again"
            showAlert(this, "Sorry!", errorMessage!!, true, Runnable { getDetail() })
            return@Observer
        })
    }

    private fun setupDetail(detail: DetailVO) {
        tvToolbarTitle.text = detail.strDrink
        tvCocktailTitle.text = detail.strDrink
        tvCategory.text = detail.strCategory
        tvInstructions.text = detail.strInstructions
        if (detail.strTags == null || detail.strTags.equals("")) {
            tvTags.visibility = View.GONE
        } else {
            tvTags.text = detail.strTags
        }
        Glide.with(this)
            .asBitmap()
            .apply(getOption())
            .load(detail.strDrinkThumb)
            .into(ivCocktail)
        val ingredientList = detail.getIngredientList()
        ingredientAdapter.appendNewData(ingredientList)
    }

    private fun getOption(): RequestOptions {

        return RequestOptions()
            .centerCrop()
            .placeholder(R.drawable.blank_photo)
            .error(R.drawable.blank_photo)
    }

    private fun getDetail() {
        viewModel.loadDetails(cocktailId)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> onBackPressed()
        }
        return true
    }

}
