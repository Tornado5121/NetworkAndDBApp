package com.natife.example.networkandbdapp.base

interface UseCase<State, Action> {

    fun execute(state: State, action: Action) : Action

    fun canHandle(action: Action) : Boolean
}