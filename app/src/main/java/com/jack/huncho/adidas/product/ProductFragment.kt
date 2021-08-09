package com.jack.huncho.adidas.product

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.jack.huncho.adidas.R
import com.jack.huncho.adidas.databinding.ProductFragmentBinding

class ProductFragment : Fragment() {

    private lateinit var viewModel: ProductViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: ProductFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.product_fragment, container, false
        )

         viewModel = ViewModelProvider(this).get(ProductViewModel::class.java)

        val adapter = ProductAdapter()
        binding.productList.adapter = adapter
        binding.productList.layoutManager = LinearLayoutManager(context)


        return binding.root

    }

}