package com.example.retrofit

import androidx.paging.PagingSource
import androidx.paging.PagingState
import kotlinx.coroutines.delay
import java.lang.Exception

private const val STARTING_PAGE = 0 //0 chi sahifadan boshlaganman

//bu yerda qayerda malumot olishni yozishimiz kere
class UserPagingSource(val apiInterface: ApiInterface):PagingSource<Int,User>() {
    override fun getRefreshKey(state: PagingState<Int, User>): Int? {
        return null //kere bolmasa null deb quyamiz
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, User> {
        val startKey = params.key?: STARTING_PAGE

        return try {
            if (startKey!= STARTING_PAGE) delay(3000)
            //malumotlarni olib kelish
            val response = apiInterface.getAllUserByPage(startKey,params.loadSize)
            val userList = response.body()?.userList
            LoadResult.Page(
                userList ?: emptyList(),
                prevKey = if (startKey == STARTING_PAGE) null else startKey - 1,
                nextKey = if (userList == null || userList.isEmpty()) null else startKey + 1
            )
        }catch (e:Exception){
            LoadResult.Error(e)
        }

    }
}