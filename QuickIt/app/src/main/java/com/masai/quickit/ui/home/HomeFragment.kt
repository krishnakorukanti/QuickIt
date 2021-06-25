package com.masai.quickit.ui.home

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.masai.quickit.R
import com.masai.quickit.room_database.DetailsEntity
import com.masai.quickit.view_model.DetailsAdapter
import com.masai.quickit.view_model.DetailsViewModel
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment(R.layout.fragment_home) {
      lateinit var detailsAdapter: DetailsAdapter
      val detailList:MutableList<DetailsEntity> = mutableListOf()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel=ViewModelProviders.of(this).get(DetailsViewModel::class.java)
        val linearLayoutManager=LinearLayoutManager(context)
         detailsAdapter=DetailsAdapter(detailList)
        rvRecyclerView.layoutManager=linearLayoutManager
        rvRecyclerView.adapter=detailsAdapter

        viewModel.getAllDetails.observe(viewLifecycleOwner, Observer {
            detailList.addAll(it)
            detailsAdapter.notifyDataSetChanged()
        })
        val detailsEntity=DetailsEntity("dhanshree","http/sdf/dfg","application")
        viewModel.addDetails(detailsEntity)

    }



}