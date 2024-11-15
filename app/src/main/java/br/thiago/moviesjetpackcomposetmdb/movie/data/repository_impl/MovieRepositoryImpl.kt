package br.thiago.moviesjetpackcomposetmdb.movie.data.repository_impl


import br.thiago.moviesjetpackcomposetmdb.common.data.ApiMapper
import br.thiago.moviesjetpackcomposetmdb.movie.data.remote.api.MovieApiService
import br.thiago.moviesjetpackcomposetmdb.movie.data.remote.models.MovieDto
import br.thiago.moviesjetpackcomposetmdb.movie.domain.models.Movie
import br.thiago.moviesjetpackcomposetmdb.movie.domain.repository.MovieRepository
import br.thiago.moviesjetpackcomposetmdb.utils.Response
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow

class MovieRepositoryImpl(
    private val movieApiService: MovieApiService,
    private val apiMapper: ApiMapper<List<Movie>, MovieDto>
) : MovieRepository {
    override fun fetchDiscoverMovie(): Flow<Response<List<Movie>>> = flow {
        emit(Response.Loading())
        val movieDto = movieApiService.fetchDiscoverMovie()
        apiMapper.mapToDomain(movieDto).apply {
            emit(Response.Success(this))
        }
    }.catch { e ->
        emit(Response.Error(e))
    }

    override fun fetchTrendingMovie(): Flow<Response<List<Movie>>> = flow {
        emit(Response.Loading())
        val movieDto = movieApiService.fetchTrendingMovie()
        apiMapper.mapToDomain(movieDto).apply {
            emit(Response.Success(this))
        }
    }.catch { e ->
        emit(Response.Error(e))
    }
}