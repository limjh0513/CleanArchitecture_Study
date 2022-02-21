package kr.hs.dgsw.storeproject.ui.activity

import android.content.Intent
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import dagger.hilt.android.AndroidEntryPoint
import kr.hs.dgsw.storeproject.R
import kr.hs.dgsw.storeproject.databinding.ActivityPostBinding
import kr.hs.dgsw.storeproject.ui.base.BaseActivity
import kr.hs.dgsw.storeproject.viewModel.PostViewModel

@AndroidEntryPoint
class PostActivity : BaseActivity<ActivityPostBinding, PostViewModel>() {
    override val mViewModel: PostViewModel by viewModels()
    override val layoutRes: Int
        get() = R.layout.activity_post

    override fun observeViewModel() {
        with(mViewModel) {
            onSuccessPostProduct.observe(this@PostActivity, Observer {
                Toast.makeText(this@PostActivity, "작성 성공!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this@PostActivity, DetailActivity::class.java)
                intent.putExtra("id", it.id)
                startActivity(intent)

                finish()
            })

            onErrorPostProduct.observe(this@PostActivity, Observer {
                Toast.makeText(this@PostActivity, "작성 중 문제가 발생했습니다. 다시 시도해주세요요", Toast.LENGTH_SHORT)
                    .show()
            })
        }
    }

    fun onClickPostBtn() {
        val name: String = mBinding.etPostName.text.toString()
        val price: Int = Integer.parseInt(mBinding.etPostPrice.text.toString())

        Log.e("af", "${name} ${price}")

        if (name.isNotEmpty() && price > 0) {
            mViewModel.postProduct(name, price)
        } else {
            Toast.makeText(this, "이름과 가격(0원 이상)을 모두 입력해주세요", Toast.LENGTH_SHORT).show()
        }
    }
}