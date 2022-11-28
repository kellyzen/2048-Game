package com.example.game.account;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class UsernameTest {
    @BeforeAll
    public static void setupAll() {
        System.out.println("Username Class Test");
    }

    @Nested
    class ValidUsername {
        @Test
        @DisplayName("Username contains both digits and letters")
        void usernameOnlyDigitsAndLetters() {
            assertTrue(Username.usernameIsValid("user123"));
        }

        @Test
        @DisplayName("Username contains only letters")
        void usernameOnlyLetters() {
            assertTrue(Username.usernameIsValid("user"));
        }

        @Test
        @DisplayName("Username contains only digits > 2 characters but less than 16 characters")
        void usernameOnlyDigits() {
            assertTrue(Username.usernameIsValid("123"));
        }
    }

    @Nested
    class InvalidUsername {
        @Test
        @DisplayName("Invalid input")
        void usernameIsNotDigitOrLetters() {
            assertFalse(Username.usernameIsValid("kelly#@"));
        }

        @Test
        @DisplayName("Invalid input")
        void usernameIsBlank() {
            assertFalse(Username.usernameIsValid(""));
        }

        @Test
        @DisplayName("Invalid input")
        void usernameIsRunTime() {
            Assertions.assertThrows(ExceptionInInitializerError.class, () -> {
                Username.usernameIsValid("");
            });
        }
    }
}