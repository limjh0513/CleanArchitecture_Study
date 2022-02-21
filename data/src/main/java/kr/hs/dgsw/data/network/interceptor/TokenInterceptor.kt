package kr.hs.dgsw.data.network.interceptor

import android.app.Application
import kr.hs.dgsw.data.util.SharedPreferenceManager
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class TokenInterceptor @Inject constructor(private val application: Application) : Interceptor {
    private var token: String? = null

    override fun intercept(chain: Interceptor.Chain): Response {
        setToken()

        if (token != null) {
            val request = chain.request().newBuilder().header("Authorization", token!!).build()
            return chain.proceed(request)
        } else {
            val request = chain.request().newBuilder().build()
            return chain.proceed(request)
        }
    }

    private fun setToken() {
        token = SharedPreferenceManager.getToken(application)
    }
}