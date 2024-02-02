package dev.abhinav.learnyourvocab

import android.app.Application
import com.google.ai.client.generativeai.GenerativeModel
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class LearnYourVocabApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())

        val generativeModel = GenerativeModel(
            modelName = "gemini-pro",
            apiKey = "AIzaSyAI4C-0DpQ1DST892aCLArGKwhzRb_JMZ4"
        )
    }
}