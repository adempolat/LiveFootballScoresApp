package com.adempolat.livefootballscoresapp.data

data class GroupedMatch(
    val league: String,
    val leagueLogo: String,
    val matches: List<Match>
)