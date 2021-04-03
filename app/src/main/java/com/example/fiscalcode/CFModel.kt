package com.example.fiscalcode

import java.util.*

enum class sesso  {MASCHIO, FEMMINA }

class CFModel {
    var firstName: String = ""
    var lastName: String = ""
    var gender: String =""
    var birthDate: String=""
    var borthPlace: String=""


    companion object {
        const val VOWELS = "AEIOU"
        const val CONSONANTS = "BCDFGHJKLMNPQRSTVWXYZ"
        const val MONTHS = "ABCDEHLMPRST"
        const val CHARACTERS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ"
        val ODDVALUES = listOf(
            1, 0, 5, 7, 9, 13, 15, 17, 19,
            21, 1, 0, 5, 7, 9, 13, 15, 17,
            19, 21, 2, 4, 18, 20, 11, 3, 6,
            8, 12, 14, 16, 10, 22, 25, 24, 23
        )
        val EVENVALUES = listOf (
            0, 1, 2, 3, 4, 5, 6, 7, 8,
            9, 0, 1, 2, 3, 4, 5, 6, 7,
            8, 9, 10, 11, 12, 13, 14, 15, 16,
            17, 18, 19, 20, 21, 22, 23, 24, 25
        )

    }

    fun encode() : String {
        val first15 = getLastNameCode() +
                getFirstNameCode() +
                getBirthAndSexCode() +
                getCountryCode()
        
        return first15 + getControlCode(first15)
    }

    private fun getControlCode(first15: String): String {
        var ret =""
        return ret
    }

    private fun getCountryCode(): String {
        var ret =""
        return ret
    }


    private fun getFirstNameCode(): String {
        var consonant = ""
        var vowels = ""
        val name = firstName.toUpperCase(Locale.getDefault())
        for (c in name) {
            if (c in CONSONANTS) consonant += c
            if (c in VOWELS) vowels += c
        }
        return (consonant + vowels + "XXX").substring(0, 3)
    }

    private fun getLastNameCode(): String {
        var consonant = ""
        var vowels = ""
        val name = lastName.toUpperCase(Locale.getDefault())
        for(c in name) {
            if (c in CONSONANTS) consonant += c
            if (c in VOWELS ) vowels += c
        }
        return (consonant + vowels + "XXX" ).substring(0,3)
    }

    private fun getBirthAndSexCode(): String {

        if( gender== "maschio") return "M"
        else return "FIGA"
    }
    
    
}
