package com.example.simpleretrofit

import android.app.ProgressDialog
import android.os.Bundle
import android.telecom.Call
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val progressDialog = ProgressDialog(this).apply {
            setMessage("Loading...")
            show()
        }

        //call retrofit
        val service = RetrofitClientInstance().getRetrofitInstance().create(GetDataService::class.java)
        val call = service.getAllPhotos()


        call.enqueue(object : Callback<List<PhotoData>>{
            override fun onFailure(call: retrofit2.Call<List<PhotoData>>, t: Throwable) {
                progressDialog.dismiss()
                Toast.makeText(applicationContext,"err : ${t.message}",Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(
                call: retrofit2.Call<List<PhotoData>>,
                response: Response<List<PhotoData>>
            ) {
                setDataList(response.body()!!)
                progressDialog.dismiss()
            }
        })
    }
    fun setDataList(list:List<PhotoData>){
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = CustomAdapter(this,list)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter
    }


}
