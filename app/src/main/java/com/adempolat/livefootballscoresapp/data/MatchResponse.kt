package com.adempolat.livefootballscoresapp.data

data class MatchResponse(
    val success: Boolean,
    val data: List<Match>
)

data class Match(
    val i: Int,
    val sgi: Int,
    val d: Long,
    val st: String,
    val bri: Int,
    val ht: Team,
    val at: Team,
    val sc: Score,
    val to: Tournament,
    val v: String
)

data class Team(
    val i: Int,
    val n: String,
    val p: Int,
    val sn: String
)

data class Score(
    val st: Int,
    val abbr: String,
    val ht: ScoreInfo,
    val at: ScoreInfo
)

data class ScoreInfo(
    val r: Int,
    val c: Int,
    val ht: Int
)

data class Tournament(
    val i: Int,
    val n: String,
    val sn: String,
    val p: Int,
    val flag: String
)
