package br.thiago.moviesjetpackcomposetmdb.di


import br.thiago.moviesjetpackcomposetmdb.common.data.ApiMapper
import br.thiago.moviesjetpackcomposetmdb.movie.data.mapper_impl.MovieApiMapperImpl
import br.thiago.moviesjetpackcomposetmdb.movie.data.remote.api.MovieApiService
import br.thiago.moviesjetpackcomposetmdb.movie.data.remote.models.MovieDto
import br.thiago.moviesjetpackcomposetmdb.movie.data.repository_impl.MovieRepositoryImpl
import br.thiago.moviesjetpackcomposetmdb.movie.domain.models.Movie
import br.thiago.moviesjetpackcomposetmdb.movie.domain.repository.MovieRepository
import br.thiago.moviesjetpackcomposetmdb.utils.K
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MovieModule {

    private val json = Json {
        coerceInputValues = true
        ignoreUnknownKeys = true
    }

    @Provides
    @Singleton
    fun provideMovieRepository(
        movieApiService: MovieApiService,
        mapper: ApiMapper<List<Movie>, MovieDto>
    ): MovieRepository = MovieRepositoryImpl(
        movieApiService, mapper
    )

    @Provides
    @Singleton
    fun provideMovieMapper(): ApiMapper<List<Movie>, MovieDto> = MovieApiMapperImpl()

    @Provides
    @Singleton
    fun provideMovieApiService(): MovieApiService {
        val contentType = "application/json".toMediaType()
        return Retrofit.Builder()
            .baseUrl(K.BASE_URL)
            .addConverterFactory(json.asConverterFactory(contentType))
            .build()
            .create(MovieApiService::class.java)
    }


}