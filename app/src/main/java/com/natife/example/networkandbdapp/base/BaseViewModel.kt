package com.natife.example.networkandbdapp.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

abstract class BaseViewModel<State, Action>(
    private val reducer: Reducer<State, Action>,
    private val useCase: List<UseCase<State, Action>>
) : ViewModel() {

    val mutableState = MutableLiveData(reducer.initialState)
    val state:LiveData<State> = mutableState

    fun action(action: Action) {
        val currentState = mutableState.value ?: return
        val newState = reducer.reduce(currentState, action)
        mutableState.value = newState
        useCase.filter { it.canHandle(action) }.forEach {
            val result = it.execute(newState, action)
            action(result)
        }
    }
}