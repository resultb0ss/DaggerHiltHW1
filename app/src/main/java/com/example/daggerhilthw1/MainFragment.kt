package com.example.daggerhilthw1

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.daggerhilthw1.databinding.FragmentMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    val customAdapter by lazy { CustomAdapter(emptyList<CoinModel>()) }



    @SuppressLint("NotifyDataSetChanged")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater, container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val coinViewModel = ViewModelProvider(this).get(CoinFragmentViewModel::class.java)

        binding.recyclerView.adapter = customAdapter
        binding.recyclerView.hasFixedSize()

        coinViewModel.coinsData.observe(viewLifecycleOwner){coins ->
            customAdapter.updateList(coins)
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }



}