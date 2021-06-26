package com.masai.quikit.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.masai.quikit.adapter.DetailsAdapter
import com.masai.quikit.databinding.FragmentHomeBinding
import com.masai.quikit.interfaces.RecyclerClickListener
import com.masai.quikit.room.Details


class HomeFragment : Fragment(),RecyclerClickListener {

    private lateinit var relativeLayout:RelativeLayout
    var count=0;
    private lateinit var homeViewModel: HomeViewModel
    private var _binding: FragmentHomeBinding? = null
    private var detailsList : MutableList<Details> = mutableListOf()
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
                detailsList.clear()
                detailsList.addAll(it)
                detailsAdapter.updateDetails(detailsList)
            }
        })

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

         relativeLayout=binding.relativeLayout

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

        val helper = ItemTouchHelper(callback)
        helper.attachToRecyclerView(recycler)

    }
    var callback: ItemTouchHelper.SimpleCallback =
        object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val snackbar = Snackbar.make(relativeLayout, "Item Deleted", Snackbar.LENGTH_LONG)
                snackbar.show()
                count++
                Log.d("TAG", "onSwiped: "+count)
                homeViewModel.deleteDetails(count)
                detailsList.removeAt(viewHolder.adapterPosition)
                detailsAdapter.notifyDataSetChanged()
            }
        }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onDeleteClicked(position: Int, details: Details) {

    }
}