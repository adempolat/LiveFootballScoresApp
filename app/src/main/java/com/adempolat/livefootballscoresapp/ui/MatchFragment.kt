package com.adempolat.livefootballscoresapp.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.adempolat.livefootballscoresapp.R
import com.adempolat.livefootballscoresapp.adapter.LeagueAdapter
import com.adempolat.livefootballscoresapp.adapter.MatchAdapter
import com.adempolat.livefootballscoresapp.data.GroupedMatch
import com.adempolat.livefootballscoresapp.viewmodel.MatchViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MatchFragment : Fragment(R.layout.fragment_match) {

    private val viewModel: MatchViewModel by viewModels()
    private lateinit var adapter: LeagueAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = LeagueAdapter(emptyList())
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        lifecycleScope.launch {
            viewModel.matches.collect { matches ->
                val groupedMatches = matches.groupBy { it.to.n }.map { GroupedMatch(it.key,it.value.first().to.flag, it.value) }
                adapter = LeagueAdapter(groupedMatches)
                recyclerView.adapter = adapter
            }
        }
    }
}
