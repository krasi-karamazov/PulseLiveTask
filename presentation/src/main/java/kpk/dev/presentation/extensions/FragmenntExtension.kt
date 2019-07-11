package kpk.dev.presentation.extensions

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import androidx.fragment.app.Fragment

@SuppressLint("MissingPermission")
inline fun Fragment.isConnected(context: Context): Boolean {
    val connectivityManager =
        context.applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val activeNetworkInfo = connectivityManager.activeNetworkInfo
    return activeNetworkInfo != null && activeNetworkInfo.isConnected
}