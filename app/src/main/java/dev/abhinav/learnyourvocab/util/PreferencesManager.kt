package dev.abhinav.learnyourvocab.util

import android.content.Context
import android.content.SharedPreferences
import java.time.LocalDate

class PreferencesManager(context: Context) {

    private val sharedPreferences: SharedPreferences = context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)

    fun setDate(date: LocalDate) {
        val dateString = date.toString()
        val editor = sharedPreferences.edit()
        editor.putString(PREF_LOCAL_DATE, dateString)
        editor.apply()
    }

    fun getDate(): LocalDate? {
        val dateString = sharedPreferences.getString(PREF_LOCAL_DATE, null)
        return dateString?.let {
            LocalDate.parse(it)
        }
    }

    fun setAllWordsEntered(value: Boolean) {
        val editor = sharedPreferences.edit()
        editor.putBoolean(PREF_ALL_WORDS_ENTERED, value)
        editor.apply()
    }

    fun getAllWordsEntered(): Boolean {
        return sharedPreferences.getBoolean(PREF_ALL_WORDS_ENTERED, false)
    }

    companion object {
        const val PREF_LOCAL_DATE = "local_date"
        const val PREF_ALL_WORDS_ENTERED = "all_words_entered"
    }
}