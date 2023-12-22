package dev.abhinav.learnyourvocab.util

import android.content.Context
import android.content.SharedPreferences
import java.time.LocalDate

class PreferencesManager(context: Context) {

    private val sharedPreferences: SharedPreferences = context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)

    fun setWord1(word: String) {
        val editor = sharedPreferences.edit()
        editor.putString(PREF_WORD_1, word)
        editor.apply()
    }

    fun getWord1() : String? {
        return sharedPreferences.getString(PREF_WORD_1, "")
    }

    fun setWord2(word: String) {
        val editor = sharedPreferences.edit()
        editor.putString(PREF_WORD_2, word)
        editor.apply()
    }

    fun getWord2() : String? {
        return sharedPreferences.getString(PREF_WORD_2, "")
    }

    fun setWord3(word: String) {
        val editor = sharedPreferences.edit()
        editor.putString(PREF_WORD_3, word)
        editor.apply()
    }

    fun getWord3() : String? {
        return sharedPreferences.getString(PREF_WORD_3, "")
    }

    fun setWord4(word: String) {
        val editor = sharedPreferences.edit()
        editor.putString(PREF_WORD_4, word)
        editor.apply()
    }

    fun getWord4() : String? {
        return sharedPreferences.getString(PREF_WORD_4, "")
    }

    fun setWord5(word: String) {
        val editor = sharedPreferences.edit()
        editor.putString(PREF_WORD_5, word)
        editor.apply()
    }

    fun getWord5() : String? {
        return sharedPreferences.getString(PREF_WORD_5, "")
    }

    fun setDate(date: LocalDate) {
        val dateString = date.toString()
        val editor = sharedPreferences.edit()
        editor.putString(PREF_LOCAL_DATE, dateString)
        editor.apply()
    }

    fun getDate(): LocalDate? {
        val dateString = sharedPreferences.getString(PREF_LOCAL_DATE, LocalDate.now().toString())
        return dateString?.let {
            LocalDate.parse(it)
        }
    }

    companion object {
        const val PREF_WORD_1 = "word_1"
        const val PREF_WORD_2 = "word_2"
        const val PREF_WORD_3 = "word_3"
        const val PREF_WORD_4 = "word_4"
        const val PREF_WORD_5 = "word_5"
        const val PREF_LOCAL_DATE = "local_date"
    }
}