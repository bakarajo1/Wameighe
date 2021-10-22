package com.example.myapplication.ui.main

import android.os.Binder
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log.d
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.R
import com.example.myapplication.RerofitInstance
import com.example.myapplication.TodoAdapter
import com.example.myapplication.databinding.MainFragmentBinding
import com.example.myapplication.databinding.SingleLayBinding
import retrofit2.HttpException
import java.io.IOException

class MainFragment : Fragment() {

    private  var binding: MainFragmentBinding?=null

     var todoAdapter = TodoAdapter()

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)




    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        setupRecycler()

        lifecycleScope.launchWhenCreated {
            binding?.progressBar?.isVisible=true
            val response= try{
                RerofitInstance.api.getTodos()
            } catch (e: IOException){
                d("dd","IOex")
                return@launchWhenCreated
            } catch (e:HttpException) {
                d("dd", "httpex")
                return@launchWhenCreated
            }


            if (response.isSuccessful && response.body()!=null){
                todoAdapter.todos=response.body()!!.content!!




            }
            else{
                d("dd","dsdds")
            }
            binding?.progressBar?.isVisible=false

        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
         binding = MainFragmentBinding.bind(view)

    }

    override fun onDestroyView() {
        // Consider not storing the binding instance in a field
        // if not needed.
        binding = null
        super.onDestroyView()
    }
    private fun setupRecycler()= binding?.recycler.apply {
        var adapter=todoAdapter
        binding?.recycler?.adapter=adapter
        this?.layoutManager=LinearLayoutManager(requireContext())
    }
}