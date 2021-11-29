package com.example.myfirsttests

import junit.framework.Assert.*
import org.junit.Assert.assertNotEquals
import org.junit.Test

class EmailTransformationTest {

    @Test
    fun emailValidator_CorrectEmailSimple_ReturnsTrue() {
        assertTrue(EmailValidator().isValidEmail("name@email.com"))
    }

    @Test
    fun emailValidator_CorrectEmailSubDomain_ReturnsTrue() {
        assertTrue(EmailValidator().isValidEmail("name@email.co.uk"))
    }

    @Test
    fun emailValidator_InvalidEmailNoTld_ReturnsFalse() {
        assertFalse(EmailValidator().isValidEmail("name@email"))
    }

    @Test
    fun emailValidator_InvalidEmailDoubleDot_ReturnsFalse() {
        assertFalse(EmailValidator().isValidEmail("name@email..com"))
    }

    @Test
    fun emailValidator_InvalidEmailNoUsername_ReturnsFalse() {
        assertFalse(EmailValidator().isValidEmail("@email.com"))
    }

    @Test
    fun emailValidator_EmptyString_ReturnsFalse() {
        assertFalse(EmailValidator().isValidEmail(""))
    }

    @Test
    fun emailValidator_NullEmail_ReturnsFalse() {
        assertFalse(EmailValidator().isValidEmail(null))
    }

    @Test
    fun emailConverter_FirstCharCapital_Equals() {
        assertEquals("waw@mail.ru", EmailConverter().convertFirstCharToNonCapital("Waw@mail.ru"))
    }

    @Test
    fun emailConverter_AllCharsCapital_NotEquals() {
        assertNotEquals("GOO@GOOGLE.CoM", EmailConverter().convertToNonCapital("GOO@GOOGLE.CoM"))
    }

    @Test
    fun emailConverter_SomeCharsCapital_NotEquals() {
        assertNotEquals("GoO@GOOgLe.CoM", EmailConverter().convertToNonCapital("GOO@GOOGLE.CoM"))
    }

    @Test
    fun emailConverter_NullInserted_ReturnsNull() {
        assertNull(EmailConverter().convertToCharArray(null))
    }

    @Test
    fun emailConverter_CorrectEmailInserted_ReturnsNotNull() {
        assertNotNull(EmailConverter().convertToCharArray("go@mail.com"))
    }

    @Test
    fun emailConverter_CorrectEmailInserted_Equals() {
        assertEquals("gobox@mail.com" ,EmailConverter().addBoxToName("go@mail.com"))
    }

    @Test
    fun emailConverter_CorrectEmailInserted_NotSame() {
        assertNotSame("gobox@mail.com" ,EmailConverter().addBoxToName("go@mail.com"))
    }

    @Test
    fun emailConverter_SeveralAtSigns_ReturnsNull() {
        assertNull(EmailConverter().addBoxToName("go@mail@dot.com"))
    }

    @Test
    fun emailConverter_WrongCharDivider_ReturnsNull() {
        assertNull(EmailConverter().addBoxToName("gobo#yandex.com"))
    }

}
