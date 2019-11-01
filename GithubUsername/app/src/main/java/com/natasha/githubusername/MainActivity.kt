package com.natasha.githubusername

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.natasha.githubusername.data.User
import com.natasha.githubusername.di.component
import com.natasha.githubusername.service.Api
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var api: Api

    private lateinit var viewModel: MainViewModel
    private lateinit var factory: MainViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        component.inject(this)

        factory = MainViewModelFactory(api)
        viewModel = ViewModelProviders.of(this, factory).get(MainViewModel::class.java)

        viewModel.fullName.observe(this, Observer { name ->
            fullName.text = name
        })
    }

    override fun onStart() {
        super.onStart()
        search.setOnClickListener {
            viewModel.searchUser(username.text.toString())
        }
    }
}
