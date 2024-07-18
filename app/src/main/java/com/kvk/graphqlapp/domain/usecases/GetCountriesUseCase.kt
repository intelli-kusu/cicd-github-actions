package com.kvk.graphqlapp.domain.usecases

import com.kvk.graphqlapp.data.SimpleCountry
import com.kvk.graphqlapp.domain.CountryClient


//use-cases are for following clean architecture
class GetCountriesUseCase(
    private val countryClient: CountryClient
) {
    suspend fun execute(): List<SimpleCountry> {
        return countryClient.getCountries().sortedBy { it.name }
    }
}