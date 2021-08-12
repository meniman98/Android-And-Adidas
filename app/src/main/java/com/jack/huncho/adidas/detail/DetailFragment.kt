package com.jack.huncho.adidas.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.jack.huncho.adidas.R
import com.jack.huncho.adidas.databinding.DetailFragmentBinding

class DetailFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: DetailFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.detail_fragment, container, false
        )
        binding.lifecycleOwner = this

        val product = DetailFragmentArgs.fromBundle(requireArguments()).product

        val factory = DetailViewModelFactory(product)

        binding.viewModel = ViewModelProvider(this, factory).get(DetailViewModel::class.java)

        return binding.root
    }
}