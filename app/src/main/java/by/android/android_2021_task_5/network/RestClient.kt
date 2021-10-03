package by.android.android_2021_task_5.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RestClient {

    private val BASE_URL = "https://api.thecatapi.com/v1/images/"
    private var retrofit: Retrofit? = null

    private fun getRetrofit(): Retrofit? {
        if (retrofit == null) {
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
        return retrofit
    }

    var service: API = getRetrofit()!!.create(API::class.java)
}