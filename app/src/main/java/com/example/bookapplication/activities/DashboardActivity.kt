package com.example.bookapplication.activities

import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bookapplication.R
import com.example.bookapplication.adapter.MyAdapter
import com.example.bookapplication.api.ApiClient
import com.example.bookapplication.api.ApiService
import com.example.bookapplication.models.DashboardResponse
import com.example.bookapplication.models.EntityDetails
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@AndroidEntryPoint
class DashboardActivity : AppCompatActivity() {
    @Inject
    lateinit var apiService: ApiService

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        // Get keypass from Intent
        val keypass = intent.getStringExtra("KEYPASS") ?: "books"

        // Set up RecyclerView
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

//         Initialize Retrofit
//        val retrofit = ApiClient.getRetrofitInstance()
//        val apiService = retrofit.create(ApiService::class.java)

        // Get API data
        apiService.getEntities(keypass).enqueue(object : Callback<DashboardResponse> {
            override fun onResponse(call: Call<DashboardResponse>, response: Response<DashboardResponse>) {
                if (response.isSuccessful) {
                    val dashboardResponse = response.body()
                    val entityList = dashboardResponse?.entities ?: emptyList()
                    if (entityList.isEmpty()) {
                        Log.e("DashboardActivity", "Received empty entity list from API")
                    } else {
                        adapter = MyAdapter(entityList)
                        recyclerView.adapter = adapter
                    }
                } else {
                    // Handle response error
                    Log.e("DashboardActivity", "API response error: ${response.code()} ${response.message()}")
                }
            }

            override fun onFailure(call: Call<DashboardResponse>, t: Throwable) {
                // Handle network failure
                Log.e("DashboardActivity", "Network error: ${t.message}", t)
            }
        })

    }

}