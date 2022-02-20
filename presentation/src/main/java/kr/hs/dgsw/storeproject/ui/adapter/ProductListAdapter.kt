package kr.hs.dgsw.storeproject.ui.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kr.hs.dgsw.domain.model.entity.ProductData
import kr.hs.dgsw.storeproject.R
import kr.hs.dgsw.storeproject.databinding.StoreItemBinding
import kr.hs.dgsw.storeproject.ui.activity.DetailActivity
import kr.hs.dgsw.storeproject.util.DiffUtil

class ProductListAdapter: ListAdapter<ProductData, ProductListAdapter.ViewHolder>(DiffUtil.ProductDiffCallBack) {
    var context: Context? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: StoreItemBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.store_item, parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }


    inner class ViewHolder(private val binding: StoreItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ProductData){
            binding.product = item

            binding.itemView.setOnClickListener {
                val intent = Intent(context, DetailActivity::class.java)
                intent.putExtra("id", item.id)
                context?.startActivity(intent)
            }
        }
    }

}