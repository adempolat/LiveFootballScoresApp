package com.adempolat.livefootballscoresapp.repository

import com.adempolat.livefootballscoresapp.data.Match
import com.adempolat.livefootballscoresapp.service.ApiService
import javax.inject.Inject

class MatchRepository @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun getMatches(): List<Match> {
        return apiService.getMatches().data.sortedBy { it.d }
    }
}

