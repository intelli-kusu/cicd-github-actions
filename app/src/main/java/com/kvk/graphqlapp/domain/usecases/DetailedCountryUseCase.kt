package com.kvk.graphqlapp.domain.usecases

import com.kvk.graphqlapp.data.DetailedCountry
import com.kvk.graphqlapp.data.SimpleCountry
import com.kvk.graphqlapp.domain.CountryClient


//use-cases are for following clean architecture
class DetailedCountryUseCase(
    private val countryClient: CountryClient
) {

    suspend fun execute(code: String): DetailedCountry? {
        return countryClient.getCountry(code)
    }
}