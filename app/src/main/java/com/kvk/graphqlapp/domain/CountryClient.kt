package com.kvk.graphqlapp.domain

import com.kvk.graphqlapp.data.DetailedCountry
import com.kvk.graphqlapp.data.SimpleCountry


//clean architecture, abstraction
//in future we can use other type of mechanism than Graphql (maybe retrofit)
//without compromising the contract
interface CountryClient {
    suspend fun getCountries(): List<SimpleCountry>

    suspend fun getCountry(code: String): DetailedCountry?
}