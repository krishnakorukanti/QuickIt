package com.masai.quikit.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.masai.quikit.R
import com.masai.quikit.adapter.DetailsAdapter
import com.masai.quikit.databinding.FragmentHomeBinding
import com.masai.quikit.interfaces.RecyclerClickListener
import com.masai.quikit.room.Details
import com.masai.quikit.viewholder.DetailsViewHolder

class HomeFragment : Fragment(),RecyclerClickListener {

    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null
    private var detailsList = emptyList<Details>()
    private lateinit var detailsAdapter: DetailsAdapter


    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)
//        for (i in 1..10)
//        homeViewModel.insertDetailsToDB(content = "Check $i")

        homeViewModel.getAllDetails().observe(viewLifecycleOwner,{
            it?.let {
                detailsList=it
                detailsAdapter.updateDetails(detailsList)
            }
        })

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root


//        homeViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })
        setRecycler()
        return root
    }

    private fun setRecycler() {
        detailsAdapter = DetailsAdapter(detailsList,this)
        val linearLayoutManager = LinearLayoutManager(activity)
        val recycler : RecyclerView = binding.recyclerHome
        recycler.layoutManager=linearLayoutManager

        recycler.adapter = detailsAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onDeleteClicked(position: Int, details: Details) {

    }
}