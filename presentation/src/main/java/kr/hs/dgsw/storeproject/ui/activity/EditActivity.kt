package kr.hs.dgsw.storeproject.ui.activity

import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import dagger.hilt.android.AndroidEntryPoint
import kr.hs.dgsw.domain.model.entity.ProductData
import kr.hs.dgsw.storeproject.R
import kr.hs.dgsw.storeproject.databinding.ActivityEditBinding
import kr.hs.dgsw.storeproject.ui.base.BaseActivity
import kr.hs.dgsw.storeproject.viewModel.EditViewModel

@AndroidEntryPoint
class EditActivity : BaseActivity<ActivityEditBinding, EditViewModel>() {
    override val mViewModel: EditViewModel by viewModels()
    override val layoutRes: Int
        get() = R.layout.activity_edit

    private var productId: Int = -1

    override fun observeViewModel() {
        bringData()

        with(mViewModel) {
            onSuccessPutProduct.observe(this@EditActivity, Observer {
                Toast.makeText(this@EditActivity, "수정 완료!!!", Toast.LENGTH_SHORT).show()
                finish()
            })

            onErrorPutProduct.observe(this@EditActivity, Observer {
                Toast.makeText(this@EditActivity, "오류가 발생했습니다.", Toast.LENGTH_SHORT).show()
            })
        }
    }

    private fun bringData() {
        val productData: ProductData = intent.getSerializableExtra("productData") as ProductData

        mBinding.editEtName.setText(productData.name)
        mBinding.editEtPrice.setText(productData.price.toString())

        productId = productData.id
    }

    fun onClickEditBtn() {
        val name: String = mBinding.editEtName.text.toString()
        val price: Int = Integer.parseInt(mBinding.editEtPrice.text.toString())

        mViewModel.putProduct(productId, name, price)
    }
}