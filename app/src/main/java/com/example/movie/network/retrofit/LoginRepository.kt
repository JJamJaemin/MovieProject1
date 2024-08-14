package com.example.movie.network

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.widget.Toast
import com.example.movie.Login.Credentials
import com.example.movie.MainActivity
import com.example.movie.network.retrofit.RetrofitClient
import com.example.movie.network.retrofit.UserResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginRepository {

    fun checkCredentials(creds: Credentials, context: Context) {
        if (creds.isNotEmpty()) {
            val call = RetrofitClient.getSupabaseApiService().getUser(creds.login, creds.pwd)
            call.enqueue(object : Callback<UserResponse> {
                override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                    if (response.isSuccessful) {
                        val user = response.body()
                        if (user != null && user.userid == creds.login && user.password == creds.pwd) {
                            context.startActivity(Intent(context, MainActivity::class.java))
                            (context as Activity).finish()
                        } else {
                            Toast.makeText(context, "Wrong Credentials", Toast.LENGTH_SHORT).show()
                        }
                    } else {
                        Toast.makeText(context, "Network Error", Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                    Toast.makeText(context, "Network Failure", Toast.LENGTH_SHORT).show()
                }
            })
        } else {
            Toast.makeText(context, "Please enter credentials", Toast.LENGTH_SHORT).show()
        }
    }
}
