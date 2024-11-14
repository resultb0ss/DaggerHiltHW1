package com.example.daggerhilthw1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.daggerhilthw1.databinding.FragmentMainBinding


class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container,false)

        val coinViewModel = ViewModelProvider(this).get(CoinFragmentViewModel::class.java)

        val customAdapter = CustomAdapter(coinViewModel.coins)
        binding.recyclerView.adapter = customAdapter
        binding.recyclerView.hasFixedSize()

        coinViewModel.coinsData.observe(viewLifecycleOwner){coins ->
            coins.clear()
            coins.addAll(coinViewModel.coins)
        }

        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }



}