package com.example.bookapplication.activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.bookapplication.R
import com.example.bookapplication.api.ApiClient
import com.example.bookapplication.api.ApiService
import com.example.bookapplication.models.LoginRequest
import com.example.bookapplication.models.LoginResponse
import dagger.hilt.android.AndroidEntryPoint
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    @Inject
    lateinit var apiService: ApiService;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)

        //Getting values from the layout
        val userNameInput = findViewById<EditText>(R.id.username_field);
        val passwordInput = findViewById<EditText>(R.id.password_field);
        val loginButton = findViewById<Button>(R.id.login_button);

//        //Initialize Retrofit
//        val retrofit = ApiClient.getRetrofitInstance();
//        val apiService = retrofit.create(ApiService::class.java)

        loginButton.setOnClickListener{
            val username = userNameInput.text.toString().trim()
            val password = passwordInput.text.toString().trim()

            //Create login request object
            val loginRequest = LoginRequest(username, password)

            apiService.userLogin(loginRequest).enqueue(object : Callback<LoginResponse>{
                override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>){
                    if(response.isSuccessful) {
                        val loginResponse = response.body()
                        loginResponse?.let {
                            val keypass = it.keypass

                            val intent = Intent (this@LoginActivity, DashboardActivity::class.java)
                            intent.putExtra("KEYPASS", keypass)
                            startActivity(intent)
                            finish()
                        }
                    } else {
                        val errorMessage = response.message() ?: "Error occurred"
                        Toast.makeText(this@LoginActivity, "Error: $errorMessage", Toast.LENGTH_SHORT).show()

                        Log.d("TAG", "onResponse: $errorMessage")
                    }
                }

                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    Toast.makeText(this@LoginActivity, "Network Error: ${t.message}", Toast.LENGTH_SHORT).show()
                }
            })

        }

    }
}