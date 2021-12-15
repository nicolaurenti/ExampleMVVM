package com.example.examplemvvm.mvvm.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.examplemvvm.mvvm.model.RandomModel
import com.example.examplemvvm.mvvm.viewmodel.states.RandomStates
import com.example.examplemvvm.mvvm.viewmodel.states.RandomData

class RandomViewModel: ViewModel() {


    private val model = RandomModel()
    private val mutableLiveData = MutableLiveData<RandomData>()

    fun getValue(): MutableLiveData<RandomData> = mutableLiveData

    fun generateValue() {
        mutableLiveData.value = RandomData(RandomStates.RANDOM, model.generateValue())
    }
}
