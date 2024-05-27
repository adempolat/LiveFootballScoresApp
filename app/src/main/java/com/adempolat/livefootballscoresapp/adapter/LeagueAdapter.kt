package com.adempolat.livefootballscoresapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.adempolat.livefootballscoresapp.R
import com.adempolat.livefootballscoresapp.data.GroupedMatch
import com.bumptech.glide.Glide

class LeagueAdapter(private val groupedMatches: List<GroupedMatch>) : RecyclerView.Adapter<LeagueAdapter.LeagueViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LeagueViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_league, parent, false)
        return LeagueViewHolder(view)
    }

    override fun onBindViewHolder(holder: LeagueViewHolder, position: Int) {
        holder.bind(groupedMatches[position])
    }

    override fun getItemCount(): Int = groupedMatches.size

    class LeagueViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val leagueName: TextView = itemView.findViewById(R.id.leagueName)
        private val leagueLogo: ImageView = itemView.findViewById(R.id.leagueLogo)
        private val matchesRecyclerView: RecyclerView = itemView.findViewById(R.id.matchesRecyclerView)


        fun bind(groupedMatch: GroupedMatch) {
            leagueName.text = groupedMatch.league
            matchesRecyclerView.layoutManager = LinearLayoutManager(itemView.context)
            matchesRecyclerView.adapter = MatchAdapter(groupedMatch.matches)
            Glide.with(itemView.context)
                .load(groupedMatch.leagueLogo)
                .into(leagueLogo)
        }
    }
}
