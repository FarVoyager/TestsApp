package com.example.myfirsttests

import java.lang.StringBuilder

class EmailConverter {

    fun convertFirstCharToNonCapital(email: String?): String {
        val firstChar = email?.get(0)?.lowercaseChar()
        if (firstChar != null) {
            return email.replaceFirst(email.get(0), firstChar, true)
        } else
            return ""
    }

    fun convertToNonCapital(email: String?): String {
        if (email != null) {
            return email.lowercase()
        } else {
            return ""
        }
    }

    fun addBoxToName(email: String?): String? {
        if (email != null) {
            val splitStr = email.split("@")
            if (splitStr.size == 2) {
                val str = StringBuilder().apply {
                    append(splitStr[0])
                    append("box")
                    append("@")
                    append(splitStr[1])
                }
                return str.toString()
            } else return null
        } else return null
    }

    fun convertToCharArray(email: String?): CharArray? {
        if (email != null) {
            return email.toCharArray()
        } else {
            return null
        }
    }

}