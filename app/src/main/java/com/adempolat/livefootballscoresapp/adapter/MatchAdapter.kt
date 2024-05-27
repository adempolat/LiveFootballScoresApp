package com.adempolat.livefootballscoresapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.adempolat.livefootballscoresapp.R
import com.adempolat.livefootballscoresapp.data.Match
import com.bumptech.glide.Glide
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class MatchAdapter(private val matches: List<Match>) : RecyclerView.Adapter<MatchAdapter.MatchViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MatchViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_match, parent, false)
        return MatchViewHolder(view)
    }

    override fun onBindViewHolder(holder: MatchViewHolder, position: Int) {
        holder.bind(matches[position])
    }

    override fun getItemCount(): Int = matches.size

    class MatchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val homeTeam: TextView = itemView.findViewById(R.id.homeTeam)
        private val awayTeam: TextView = itemView.findViewById(R.id.awayTeam)
        private val totalScore: TextView = itemView.findViewById(R.id.totalScore)
        private val halfScore: TextView = itemView.findViewById(R.id.halfScore)
        private val matchTime: TextView = itemView.findViewById(R.id.matchTime)


        fun bind(match: Match) {
            homeTeam.text = match.ht.sn
            awayTeam.text = match.at.sn
            if (match.sc.abbr != "SCHEDULED") {
                totalScore.text = "${match.sc.ht.c} - ${match.sc.at.c}"
                halfScore.text = "${match.sc.ht.ht} - ${match.sc.at.ht}"
                matchTime.text = match.sc.abbr
            } else {
                totalScore.text = " T - T "
                matchTime.text = SimpleDateFormat("HH:mm", Locale.getDefault()).format(Date(match.d))
            }


        }
    }
}
