package com.jack.huncho.adidas.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.jack.huncho.adidas.R
import com.jack.huncho.adidas.databinding.DetailFragmentBinding
import com.jack.huncho.adidas.network.ReviewApiService
import com.jack.huncho.adidas.repo.ReviewRepo
import com.jack.huncho.adidas.review.ReviewAdapter

class DetailFragment : Fragment() {

    private val repo = ReviewRepo(ReviewApiService())


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
        val factory = DetailViewModelFactory(product, repo)
        val viewModel: DetailViewModel by lazy {
            ViewModelProvider(this, factory).get(DetailViewModel::class.java)
        }

        // recyclerview
        binding.reviewList.layoutManager = LinearLayoutManager(context)
        val adapter = ReviewAdapter(viewModel.property)

        viewModel.property.observe(viewLifecycleOwner, {
            binding.reviewList.also {
                binding.reviewList.adapter = adapter
            }
        })

        return binding.root
    }
}