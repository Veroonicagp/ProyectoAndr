package com.example.readytoenjoy.ui.adven

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.readytoenjoy.R
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ActivitiesAdvenListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_activities_adven_list, container, false)
    }


}