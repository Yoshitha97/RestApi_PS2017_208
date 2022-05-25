package com.example.restapi_ps_2017_208

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResultListener
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.restapi_ps_2017_208.adapter.Adapter2
import com.example.restapi_ps_2017_208.api.Comment
import com.example.restapi_ps_2017_208.api.RetrofitAPI
import com.example.restapi_ps_2017_208.databinding.FragmentThirdBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class ThirdFragment : Fragment() {

    private var _binding: FragmentThirdBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentThirdBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setFragmentResultListener("requestKey1") { _, bundle ->
            val selectedPostId = bundle.getInt("postId")


            val recyclerView = binding.recyclerview2

            recyclerView.layoutManager = LinearLayoutManager(this.context)

            val apiInterface = RetrofitAPI.create().getComments()


            apiInterface.enqueue( object : Callback<List<Comment>> {
                override fun onResponse(
                    call: Call<List<Comment>>,
                    response: Response<List<Comment>>
                ) {
                    if(response?.body()!= null) {
                        val data = ArrayList<Comment>()
                        response.body()!!.forEach(){
                            if(selectedPostId == it.postId)
                            {
                               data.add(it)

                            }
                        }
                      val adapter = Adapter2(data)
                        recyclerView.adapter = adapter


                    }
                }

                override fun onFailure(call: Call<List<Comment>>?, t: Throwable?) {
                    Log.i("ThirdFragment","Failed to retrieve")

                }


            })

        }

    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}