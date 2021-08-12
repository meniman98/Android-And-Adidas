package com.jack.huncho.adidas.product

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ExpandableListView
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jack.huncho.adidas.R
import com.jack.huncho.adidas.databinding.ListItemProductBinding


class ProductAdapter(private val productList: LiveData<List<Product>>, private val clickListener: ProductListener)
    : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    class ViewHolder private constructor (val binding: ListItemProductBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(clickListener: ProductListener) {
            binding.clickListener = clickListener
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)


                val binding = ListItemProductBinding.inflate(layoutInflater, parent, false)

                return ViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // this line here allows you to attach a product to the viewholder
        holder.binding.product = productList.value!![position]
        holder.bind(clickListener)
    }

    override fun getItemCount(): Int {
        if (productList.value == null) {
            return 0
        }
        return productList.value!!.size
    }

}

class ProductListener(val clickListener: (product: Product) -> Unit) {
    fun onClick(product: Product) = clickListener(product)
}

