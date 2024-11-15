package br.thiago.moviesjetpackcomposetmdb.movie_detail.data.remote.models


import br.thiago.moviesjetpackcomposetmdb.movie_detail.data.remote.models.Result
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ReviewsDto(
    @SerialName("page")
    val page: Int? = null,
    @SerialName("results")
    val results: List<Result?>? = null,
    @SerialName("total_pages")
    val totalPages: Int? = null,
    @SerialName("total_results")
    val totalResults: Int? = null
)