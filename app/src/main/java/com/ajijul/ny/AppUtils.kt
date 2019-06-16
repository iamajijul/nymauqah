package com.ajijul.ny

import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*

class AppUtils {

    companion object{
        fun convertDate(inputFormat: String, outputFormat: String, date: String?): String {
            val input = SimpleDateFormat(inputFormat, Locale.US)
            val output = SimpleDateFormat(outputFormat, Locale.US)
            try {
                return output.format(input.parse(date))
            } catch (e: Exception) {
                e.printStackTrace()
            }

            return ""
        }
    }
}