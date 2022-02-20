package kr.hs.dgsw.storeproject.util

import androidx.recyclerview.widget.DiffUtil
import kr.hs.dgsw.domain.model.entity.ProductData

object DiffUtil {
    val ProductDiffCallBack = object : DiffUtil.ItemCallback<ProductData>() {
        override fun areItemsTheSame(oldItem: ProductData, newItem: ProductData): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: ProductData, newItem: ProductData): Boolean =
            oldItem == newItem
    }
}
