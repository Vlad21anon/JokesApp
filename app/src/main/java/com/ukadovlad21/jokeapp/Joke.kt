package com.ukadovlad21.jokeapp

class Joke(
    private val text: String,
    private val punchline:String
){
    fun getJokeUi() = "$text\n$punchline"



}