package com.jack.huncho.adidas.product

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.jack.huncho.adidas.R
import com.jack.huncho.adidas.databinding.ListItemProductBinding


class ProductAdapter(private val productList: LiveData<List<Product>>)
    : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    class ViewHolder private constructor (private val binding: ListItemProductBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Product) {
            binding.image.setImageResource(R.drawable.ic_launcher_background)
            binding.tvName.text = item.name
            binding.tvDesc.text = item.description
            binding.tvPrice.text = item.currency
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

        holder.bind(productProperty)
    }

    override fun getItemCount(): Int {
        return productList.value!!.size
    }

}

