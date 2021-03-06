package kr.hs.dgsw.data.util

import android.content.Context
import android.content.SharedPreferences

object SharedPreferenceManager {
    private const val PREF_TOKEN = "token"
    private const val PREF_NAME = "name"
    private const val PREF_ID = "id"

    fun setToken(context: Context, token: String) {
        getDefaultSharedPreferences(context).edit().putString(PREF_TOKEN, token).apply()
    }

    fun getToken(context: Context): String? {
        return getDefaultSharedPreferences(context).getString(PREF_TOKEN, null)
    }

    fun setUserName(context: Context, name: String) {
        getDefaultSharedPreferences(context).edit().putString(PREF_NAME, name).apply()
    }

    fun getUserName(context: Context): String? {
        return getDefaultSharedPreferences(context).getString(PREF_NAME, null)
    }

    fun setUserId(context: Context, id: Int) {
        getDefaultSharedPreferences(context).edit().putInt(PREF_ID, id).apply()
    }

    fun getUserId(context: Context): Int {
        return getDefaultSharedPreferences(context).getInt(PREF_ID, -1)
    }

    private fun getDefaultSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(getDefaultSharedPreferencesName(context),
            getDefaultSharedPreferencesMode())
    }

    private fun getDefaultSharedPreferencesName(context: Context): String {
        return context.packageName.toString() + "_preferences"
    }

    private fun getDefaultSharedPreferencesMode(): Int {
        return Context.MODE_PRIVATE
    }
}