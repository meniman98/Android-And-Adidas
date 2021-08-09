package com.jack.huncho.adidas.product

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jack.huncho.adidas.R
import com.jack.huncho.adidas.databinding.ListItemProductBinding


class ProductAdapter : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    val p1: Product = Product("1", 1, "1", "a", "asd", "dsa")
    val p2: Product = Product("1", 1, "1", "a", "asd", "dsa")

    var data: Array<Product> = arrayOf(p1, p2)

    class ViewHolder private constructor (val binding: ListItemProductBinding) : RecyclerView.ViewHolder(binding.root) {

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
        val item = data[position]

        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return data.size
    }

}

