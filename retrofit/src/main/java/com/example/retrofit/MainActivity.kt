package com.example.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.ItemDecoration
import com.example.retrofit.databinding.ActivityMainBinding
import com.example.retrofit.databinding.ItemLayoutBinding
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var todoAdapter: TodoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        todoAdapter = TodoAdapter()

        //retrofitni yaratish ker
        val retrofit = Retrofit
            .Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://jsonplaceholder.typicode.com")
            .build()
        val api = retrofit.create(ApiInterface::class.java)
        lifecycleScope.launch {
            //qachonki bizga javob kelsa //responce - javob
            val response = api.getTodoList().body()
            //nullable oldin tekshirib olamiz
            response?.apply {
                todoAdapter.submitList(this)
            }
            Log.d("TAG", "onCreate: ${response?.joinToString()}")
        }

        val manager = LinearLayoutManager(this@MainActivity)
        //recyclerViewga manager xamda adapterni biriktirib quyishimiz kere boladi
        binding.recyclerView.apply {
            adapter  = todoAdapter
            layoutManager = manager
            addItemDecoration(DividerItemDecoration(this@MainActivity,manager.orientation))
        }
    }
}