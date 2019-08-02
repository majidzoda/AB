package com.google.firebase.samples.apps.mlkit.com.google.firebase.samples.apps.mlkit.java.api

import android.util.Log
import okhttp3.MediaType
import okhttp3.RequestBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Response

class CallHelper {
    fun buildJsonFromText(txt: String) = RequestBody
            .create(MediaType.parse("application/json"), JSONObject().put("text", txt).toString())

    var canMakeCall = true

    fun makeTestCall(txt: String = "Stella") {
        if (!canMakeCall) return
        RetrofitHelper
                .buildRetrofit()
                .getItem(buildJsonFromText(txt))
                .enqueue(object : retrofit2.Callback<Array<RetrofitHelper.Model>> {
                    override fun onFailure(call: Call<Array<RetrofitHelper.Model>>, t: Throwable) {
                        val a = t.localizedMessage
                        Log.i("Error", a ?: "")
                        canMakeCall = true
                    }

                    override fun onResponse(call: Call<Array<RetrofitHelper.Model>>, response: Response<Array<RetrofitHelper.Model>>) {
                        val a = response.body()?.toString().orEmpty()
                        Log.i("Success", a)
                        canMakeCall = true
                    }
                })
    }

}