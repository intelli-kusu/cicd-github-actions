package com.kvk.graphqlapp.domain

import com.apollographql.apollo3.ApolloClient
import com.kvk.CountriesQuery
import com.kvk.CountryQuery
import com.kvk.graphqlapp.data.DetailedCountry
import com.kvk.graphqlapp.data.SimpleCountry
import com.kvk.graphqlapp.toDetailedCountry
import com.kvk.graphqlapp.toSimpleCountry

class ApolloCountryClient(
    private val apolloClient: ApolloClient
) : CountryClient {
    override suspend fun getCountries(): List<SimpleCountry> {
        return apolloClient
            .query(CountriesQuery())
            .execute()
            .data
            ?.countries
            ?.map { it.toSimpleCountry() } ?: emptyList()

    }

    override suspend fun getCountry(code: String): DetailedCountry? {
        return apolloClient
            .query(CountryQuery(code))
            .execute()
            .data
            ?.country
            ?.toDetailedCountry()
    }
}