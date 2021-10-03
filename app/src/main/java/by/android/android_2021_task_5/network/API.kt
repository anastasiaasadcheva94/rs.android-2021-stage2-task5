package by.android.android_2021_task_5.network

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface API {
    @GET("search")
    suspend fun getDataFromAPI (
            @Query("api_key") api_key: String ="f163e28e-5d99-410d-8ae5-aef9498c065d",
            @Query("limit") limit: Int = 10,
            @Query("page") page: Int = 10,
            @Query("order") order: String = "Desc"
    ): Response<by.android.android_2021_task_5.model.Response>

    companion object{
        const val DEFAULT_PAGE_SIZE = 20
        const val MAX_PAGE_SIZE = 10
    }

}