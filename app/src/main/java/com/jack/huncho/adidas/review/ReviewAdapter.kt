package com.jack.huncho.adidas.review

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.jack.huncho.adidas.databinding.ListItemReviewBinding

class ReviewAdapter(private val reviewList: LiveData<List<Review>>) : RecyclerView.Adapter<ReviewAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.review = reviewList.value!![position]
    }

    override fun getItemCount(): Int {
        if (reviewList.value.isNullOrEmpty()) {
            return 0
        }
        return reviewList.value!!.size
    }

    class ViewHolder private constructor(val binding: ListItemReviewBinding): RecyclerView.ViewHolder(binding.root) {
        companion object {
            fun from(parent: ViewGroup) : ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ListItemReviewBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }
}