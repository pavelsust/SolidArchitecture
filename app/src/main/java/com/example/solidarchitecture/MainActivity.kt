package com.example.solidarchitecture

import android.app.ProgressDialog
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.solidarchitecture.viewmodel.LoginViewModel
import com.example.solidarchitecture.viewmodel.ViewModelBuilder
import com.google.gson.JsonObject
import com.google.gson.JsonParser
import org.json.JSONException
import org.json.JSONObject

class MainActivity : AppCompatActivity(){


    lateinit var loginViewModel: LoginViewModel
    lateinit var progressDialog: ProgressDialog


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        progressDialog = ProgressDialog(this)
        progressDialog.setCancelable(false)
        progressDialog.setTitle("Loading...")

        loginViewModel = ViewModelBuilder.createLoginViewModel(this)

        findViewById<Button>(R.id.login).setOnClickListener {
            val jsonObject = JSONObject()
            var gsonObject = JsonObject()
            try {
                jsonObject.put("id", "1231238091283")
                jsonObject.put("name", "pavel")
                jsonObject.put("email", "email")
                jsonObject.put("avater", "abatar")
                jsonObject.put("site", "" + "facebook")
                jsonObject.put("platform", "rockerzs")
                jsonObject.put("country_code", "88")


            } catch (e: JSONException) {
                e.printStackTrace()
            }

            val jsonParser = JsonParser()
            gsonObject = jsonParser.parse(jsonObject.toString()) as JsonObject
            progressDialog.show()
            loginViewModel.getLoginApiCall(gsonObject)
        }

        loginViewModel.loginResponse.observe(this , Observer {
            Log.d("RESPONSE" , "${it.token}")
            Toast.makeText(this, "Success" , Toast.LENGTH_SHORT).show()
        })

        loginViewModel.isLoading.observe(this, Observer {
            if (!it){
                progressDialog.dismiss()
            }
        })

        loginViewModel.isError.observe(this, Observer {
            Log.d("RESPONSE" , "$it")
        })

    }
}