package com.example.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.PagingSource
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.ItemDecoration
import com.example.retrofit.databinding.ActivityMainBinding
import com.example.retrofit.databinding.ItemLayoutBinding
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var todoAdapter: TodoAdapter
    private lateinit var userAdapter:UserAdapter
    val TAG = "TAG"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        todoAdapter = TodoAdapter()

        //retrofitni yaratish ker
        val retrofit = Retrofit
            .Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://reqres.in")
            .build()
        val api = retrofit.create(ApiInterface::class.java)

        userAdapter = UserAdapter()
        val manager = LinearLayoutManager(this@MainActivity)
        //recyclerViewga manager xamda adapterni biriktirib quyishimiz kere boladi
        binding.recyclerView.apply {
            adapter  = userAdapter
            layoutManager = manager
            addItemDecoration(DividerItemDecoration(this@MainActivity,manager.orientation))
        }

        val flow: Flow<PagingData<User>> = Pager(
            config = PagingConfig(pageSize = 3, enablePlaceholders = false),
            pagingSourceFactory = {UserPagingSource(api)}
        ).flow


        lifecycleScope.launch {
           flow.collect{
               userAdapter.submitData(it)
           }
        }

        lifecycleScope.launch {
            userAdapter.loadStateFlow.collect{
                //it.append //pastdan load boladi
                binding.progressHorizontal.isVisible = it.source.append is LoadState.Loading
            }
        }

    }
}