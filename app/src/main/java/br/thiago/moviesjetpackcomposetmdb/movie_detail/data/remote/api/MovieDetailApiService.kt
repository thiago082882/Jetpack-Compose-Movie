package br.thiago.moviesjetpackcomposetmdb.movie_detail.data.remote.api


import br.thiago.moviesjetpackcomposetmdb.BuildConfig
import br.thiago.moviesjetpackcomposetmdb.movie.data.remote.models.MovieDto
import br.thiago.moviesjetpackcomposetmdb.movie_detail.data.remote.models.MovieDetailDto
import br.thiago.moviesjetpackcomposetmdb.utils.K
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

private const val MOVIE_ID = "movie_id"

interface MovieDetailApiService {

    @GET("${K.MOVIE_DETAIL_ENDPOINT}/{$MOVIE_ID}")
    suspend fun fetchMovieDetail(
        @Path(MOVIE_ID) movieId:Int,
        @Query("api_key") apiKey: String = BuildConfig.apikey,
        @Query("append_to_response") appendToResponse: String = "credits,reviews"
    ): MovieDetailDto

    @GET(K.MOVIE_ENDPOINT)
    suspend fun fetchMovie(
        @Query("api_key") apiKey: String = BuildConfig.apikey,
        @Query("include_adult") includeAdult: Boolean = false
    ): MovieDto

}