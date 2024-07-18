package com.kvk.graphqlapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apollographql.apollo3.ApolloClient
import com.kvk.graphqlapp.data.SimpleCountry
import com.kvk.graphqlapp.domain.ApolloCountryClient
import com.kvk.graphqlapp.domain.usecases.GetCountriesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CountriesViewModel : ViewModel() {
    private val _countriesState = MutableStateFlow<List<SimpleCountry?>>(emptyList())
    val countriesState = _countriesState.asStateFlow()

    private val apolloClient = ApolloClient.Builder()
        .serverUrl("https://countries.trevorblades.com/graphql")
        .build()
    private val countryClient = ApolloCountryClient(apolloClient)
    private val countriesUseCase = GetCountriesUseCase(countryClient)

    fun getCountries() {
        viewModelScope.launch {
            _countriesState.value = countriesUseCase.execute()
        }
    }


}