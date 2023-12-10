package com.example.manshatsoultancommunity.features.news.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.manshatsoultancommunity.HomeViewPagerAdapter
import com.example.manshatsoultancommunity.databinding.FragmentAdsBinding
import com.example.manshatsoultancommunity.databinding.FragmentHomeBinding
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class HomeFragment: Fragment() {
    private lateinit var binding : FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val categoriesFragments = arrayListOf(
            GeneralFragment(),
            RIPFragment(),
            SportFragment(), /*More*/
        )
        val viewPager2Adapter = HomeViewPagerAdapter(categoriesFragments,childFragmentManager,lifecycle)
        binding.viewPager2Home.adapter = viewPager2Adapter

        TabLayoutMediator(binding.tabLayout,binding.viewPager2Home) { tab, position ->
            when (position) {
                0 -> tab.text = "عـــام"
                1 -> tab.text = "صفحة الوفيات"
                2 -> tab.text = "رياضة"
            }
        }.attach()
    }
}