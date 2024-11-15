package br.thiago.moviesjetpackcomposetmdb.common.data

interface ApiMapper<Domain,Entity> {
    fun mapToDomain(apiDto:Entity):Domain

}