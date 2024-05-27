package com.adempolat.livefootballscoresapp.service

import com.adempolat.livefootballscoresapp.data.MatchResponse
import retrofit2.http.GET

interface ApiService {
    @GET("sport/SOCCER/matches")
    suspend fun getMatches(): MatchResponse
}