package br.thiago.moviesjetpackcomposetmdb.movie.data.remote.api




import br.thiago.moviesjetpackcomposetmdb.BuildConfig
import br.thiago.moviesjetpackcomposetmdb.movie.data.remote.models.MovieDto
import br.thiago.moviesjetpackcomposetmdb.utils.K
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApiService {

    @GET(K.MOVIE_ENDPOINT)
    suspend fun fetchDiscoverMovie(
        @Query("api_key") apiKey: String = BuildConfig.apikey,
        @Query("include_adult") includeAdult: Boolean = false
    ): MovieDto

    @GET(K.TRENDING_MOVIE_ENDPOINT)
    suspend fun fetchTrendingMovie(
        @Query("api_key") apiKey: String = BuildConfig.apikey,
        @Query("include_adult") includeAdult: Boolean = false
    ): MovieDto
}