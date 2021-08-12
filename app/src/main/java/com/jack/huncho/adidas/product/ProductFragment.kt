package com.jack.huncho.adidas.product

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.jack.huncho.adidas.R
import com.jack.huncho.adidas.databinding.ProductFragmentBinding
import com.jack.huncho.adidas.network.ProductApiService
import com.jack.huncho.adidas.repo.ProductRepo

class ProductFragment : Fragment() {

    private val repo = ProductRepo(ProductApiService())
    private val factory = ProductViewModelFactory(repo)

    private val viewModel: ProductViewModel by lazy {
        ViewModelProvider(this, factory).get(ProductViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding: ProductFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.product_fragment, container, false
        )

        binding.lifecycleOwner = this

        binding.productList.layoutManager = LinearLayoutManager(context)

        val adapter = ProductAdapter(viewModel.property, ProductListener {
            /*TODO add ID to direction*/
            val action = ProductFragmentDirections.actionProductFragmentToDetail("2")
            findNavController().navigate(action)
        })

        viewModel.property.observe(viewLifecycleOwner, {
            binding.productList.also {
                binding.productList.adapter = adapter
            }
        })

        viewModel.status.observe(viewLifecycleOwner, {
            viewModel.onSnack(binding.root, it)
        })


        return binding.root

    }

}