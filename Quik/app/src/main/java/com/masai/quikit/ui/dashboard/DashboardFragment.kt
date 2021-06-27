package com.masai.quikit.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.masai.quikit.R
import com.masai.quikit.adapter.DashboardAdapter
import com.masai.quikit.adapter.DetailsAdapter
import com.masai.quikit.databinding.FragmentDashboardBinding
import com.masai.quikit.room.Details
import com.masai.quikit.ui.home.HomeViewModel

class DashboardFragment : Fragment() {

    private lateinit var dashboardViewModel: HomeViewModel
    private var _binding: FragmentDashboardBinding? = null
    private var detailsList = emptyList<Details>()
    private lateinit var dashBroadAdapter:DashboardAdapter

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        //search data
       val buttonSeaech=binding.btnSearch
        val etTextView:EditText=binding.etDashboard
        buttonSeaech.setOnClickListener {
            dashboardViewModel.getData(etTextView.text.toString()).observe(viewLifecycleOwner,{
                it?.let {
                    detailsList=it
                    dashBroadAdapter.updateDetails(detailsList)
                }
            })
        }



        dashboardViewModel.getAllDetails().observe(viewLifecycleOwner,{
            it?.let {
                detailsList=it
                dashBroadAdapter.updateDetails(detailsList)
            }
        })

        setRecycler()
        return root

    }
    private fun setRecycler() {
        dashBroadAdapter= DashboardAdapter(detailsList)
        val linearLayoutManager = LinearLayoutManager(activity)
        val recycler : RecyclerView = binding.rvRecyclerView
        recycler.layoutManager=linearLayoutManager
        recycler.adapter = dashBroadAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}