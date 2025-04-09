package zed.rainxch.plmarch2025minichallenges.data.service

import retrofit2.http.GET
import zed.rainxch.plmarch2025minichallenges.domain.model.AstroDTO

interface ApiService {

    @GET("astros.json")
    suspend fun getAstro(): AstroDTO
}