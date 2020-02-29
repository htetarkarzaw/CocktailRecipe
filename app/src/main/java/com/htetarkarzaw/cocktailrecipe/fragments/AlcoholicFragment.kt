package com.htetarkarzaw.cocktailrecipe.fragments

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.htetarkarzaw.cocktailrecipe.ClickCocktailDelecate
import com.htetarkarzaw.cocktailrecipe.CocktailDetailActivity
import com.htetarkarzaw.cocktailrecipe.R
import com.htetarkarzaw.cocktailrecipe.adapters.CockTailAdapter
import com.htetarkarzaw.cocktailrecipe.data.DrinkVO
import com.htetarkarzaw.cocktailrecipe.viewmodels.MainViewModel
import kotlinx.android.synthetic.main.fragment_cocktail.*

class AlcoholicFragment : BaseFragment(), ClickCocktailDelecate {

    private lateinit var viewModel: MainViewModel
    private var isAlcoholic = true

    private var cocktailAdapter: CockTailAdapter? = null

    fun newInstance(imageId: Boolean?): AlcoholicFragment {
        val fragment = AlcoholicFragment()
        val args = Bundle()
        args.putBoolean("isAlcoholic", imageId!!)
        fragment.arguments = args
        return fragment
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        isAlcoholic = arguments?.getBoolean("isAlcoholic") ?: true
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_cocktail, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        rootlayout.setBackgroundColor(Color.parseColor("#ffffff"))
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        cocktailAdapter = CockTailAdapter(this.requireContext(),this)
        var layoutManager = GridLayoutManager(this.requireContext(), 2)
        rcViewHome.layoutManager = layoutManager
        rcViewHome.adapter = cocktailAdapter
        loadingIndicator(rootlayout, true)
        getCocktail()
        viewModel.getCocktails().observe(this, Observer { apiResponse ->
            val responseData = apiResponse
            setupList(responseData)
            loadingIndicator(rootlayout, false)
        })

        viewModel.getError().observe(this, Observer { apiResponse ->
//            val responseData = apiResponse
            loadingIndicator(rootlayout, false)
            var errorMessage: String? = "Unable to connect!\nPlease Try Again"
//            if (responseData != null) {
//                errorMessage = responseData
//            }
            this.context?.let { showAlert(it, "Sorry!", errorMessage!!, true, Runnable { getCocktail() }) }
            return@Observer
        })

        val temp = HashMap<String,String>()
        temp["FN"] = "CR"
        temp["fromCustmer"] = "09400420034"
        temp["name"] = "aung aung"
        temp["email"] = "aung@gmail.com"
        temp["lang"] = "EN"
        temp["channel"] = "mobileApp"
        temp["deviceModel"] = ""
        temp["devicePlatform"] = ""
        temp["deviceVersion"] = ""
        temp["deviceManufacturer"] = ""
        temp["packageName"] = ""
        temp["versionNumber"] = ""
        temp["isVirtualDevice"] = "true"
        temp["geoLatitude"] = ""
        temp["geoLongitude"] = ""
        temp["appClientName"] = "Myanmar"
        temp["appType"] = "PRODUCTION"
        temp["deviceIP"] = ""
        temp["uniqueDeviceKey"] = "1560840679390"
        val request = mapToXml(temp)
        viewModel.loadTest(request)
    }

    private fun mapToXml(mMap:HashMap<String,String>):String{
        var temp ="<?xml version=\"1.0\" encoding=\"UTF-8\" ?><Request "
        for ((key, value) in mMap) {
            temp+= "$key= \"$value\" "
        }
        temp+="></Request>"
        return  temp
    }


    private fun setupList(list: List<DrinkVO>?) {
        if (list != null) {
            cocktailAdapter?.appendNewData(list)
        }
    }


    private fun getCocktail() {
        if (isAlcoholic) {
            viewModel.loadCocktails("Alcoholic")
        }else{
            viewModel.loadCocktails("Non_Alcoholic")
        }
    }

    override fun clickCocktail(drinkVO: DrinkVO?) {
        startActivity(CocktailDetailActivity.newInstance(this.requireContext(),  drinkVO!!.idDrink))
    }
}