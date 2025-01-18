package com.example.readytoenjoy.ui.activity

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.readytoenjoy.core.data.activity.Activity
import com.example.readytoenjoy.databinding.FragmentMyActivitiesListBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MyActivitiesListFragment : Fragment() {

    private lateinit var binding: FragmentMyActivitiesListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMyActivitiesListBinding.inflate(
            inflater,
            container,
            false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //¡?
        super.onViewCreated(view, savedInstanceState)


        binding.rvMyActivities.layoutManager = LinearLayoutManager(context)

        val adapter = ActivityListAdapter()
        val rv = binding.rvMyActivities
        //rv.adapter = adapter
        //(rv.adapter as  ActivityListAdapter).submitList(repository.getActivities())

        val createActivityButton = binding.floatingActionButton
        createActivityButton.setOnClickListener{
            val action = MyActivitiesListFragmentDirections.actionMyActivitiesListFragmentToCreateActivityFragment()
            findNavController().navigate(action)
        }


    }

    //¡?
    private fun toActivityDetail(activity: Activity) {
        val action = ActivitiesListFragmentDirections.actionActivitiesListFragmentToActivityInfoFragment()
        findNavController().navigate(action)
    }


}