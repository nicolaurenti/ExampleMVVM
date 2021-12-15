package com.example.examplemvvm.mvvm.viewmodel.states

data class RandomData(
    val state: RandomStates = RandomStates.INITIAL,
    val value: Int = 0
)
