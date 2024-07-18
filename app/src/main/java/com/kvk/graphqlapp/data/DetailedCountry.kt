package com.kvk.graphqlapp.data

data class DetailedCountry (
    val code: String,
    val name: String,
    val capital: String,
    val emoji: String,
    val currency: String?,
    val languages: List<String>,
    val continent: String
)