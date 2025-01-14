package com.example.readytoenjoy.ui.adven

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.readytoenjoy.R
import com.example.readytoenjoy.databinding.FragmentAdventurersBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AdventurersFragment : Fragment() {
    private lateinit var binding: FragmentAdventurersBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_adventurers, container, false)
    }


}