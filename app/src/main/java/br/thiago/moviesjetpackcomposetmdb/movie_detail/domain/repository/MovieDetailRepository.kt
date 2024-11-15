package br.thiago.moviesjetpackcomposetmdb.movie_detail.domain.repository



import br.thiago.moviesjetpackcomposetmdb.movie.domain.models.Movie
import br.thiago.moviesjetpackcomposetmdb.movie_detail.domain.models.MovieDetail
import br.thiago.moviesjetpackcomposetmdb.utils.Response
import kotlinx.coroutines.flow.Flow

interface MovieDetailRepository {
    fun fetchMovieDetail(movieId: Int): Flow<Response<MovieDetail>>
    fun fetchMovie(): Flow<Response<List<Movie>>>
}