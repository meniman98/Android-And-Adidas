package com.jack.huncho.adidas.product

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ExpandableListView
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jack.huncho.adidas.R
import com.jack.huncho.adidas.databinding.ListItemProductBinding


class ProductAdapter(private val productList: LiveData<List<Product>>, val clickListener: ProductListener)
    : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    class ViewHolder private constructor (private val binding: ListItemProductBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Product, clickListener: ProductListener) {
            binding.executePendingBindings()
            binding.clickListener = clickListener
            binding.image.setImageResource(R.drawable.ic_launcher_background)
            binding.tvName.text = item.name
            binding.tvDesc.text = item.description
            binding.tvPrice.text = "$ ${item.price}"
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)

                // TODO (03) Inflate layout using binding object assigned to ListItemSleepNightBinding.
                val binding = ListItemProductBinding.inflate(layoutInflater, parent, false)

                return ViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val productProperty = productList.value!![position]

        holder.bind(productProperty, clickListener)
    }

    override fun getItemCount(): Int {
        return productList.value!!.size
    }

}

class ProductListener(val clickListener: () -> Unit) {
    fun onClick() = clickListener()
}

