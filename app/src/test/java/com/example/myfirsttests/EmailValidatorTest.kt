package com.example.myfirsttests

import junit.framework.Assert.assertFalse
import junit.framework.Assert.assertTrue
import org.junit.Test

class EmailValidatorTest {

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
}

//Добавьте в приложение MyFirstTests несколько тестов в качестве негативного тестирования. Например, убедитесь, что почта без указания домейна не будет пропущена программой. Какие еще негативные тесты вы можете написать?
//Выберите приложение, над которым вы уже работали в течение вашего обучения. Напишите для него несколько Unit-тестов и убедитесь, что они выполняются корректно;
//Добавьте в приложение методы, которые можно проверить в тестах на:
//assertEquals;
//assertNotEquals;
//assertArrayEquals;
//assertNull;
//assertNotNull;
//assertSame.

