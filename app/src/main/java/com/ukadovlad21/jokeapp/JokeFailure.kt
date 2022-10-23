package com.ukadovlad21.jokeapp

import android.content.Context
import androidx.annotation.StringRes

interface JokeFailure {
    fun getMessage(): String
}

class NoConnection(private val resourceManager: ResourceManager): JokeFailure {
    override fun getMessage()= resourceManager.getString(R.string.no_connection)

}

class ServiceUnavailable(private val resourceManager: ResourceManager): JokeFailure {
    override fun getMessage()= resourceManager.getString(R.string.service_unavailable)

}

interface ResourceManager {
    fun getString(@StringRes stringResId: Int):String
}

class BaseResourceManager(private val context: Context): ResourceManager {
    override fun getString(stringResId: Int) = context.getString(stringResId)

}

