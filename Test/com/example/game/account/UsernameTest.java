package com.example.game.account;

import com.example.game.scene.account.Username;
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
        @DisplayName("Username contains both digits and letters > 2 characters but < 16 characters")
        void usernameOnlyDigitsAndLetters() {
            assertTrue(Username.usernameIsValid("user123"));
        }

        @Test
        @DisplayName("Username contains only letters > 2 characters but < 16 characters")
        void usernameOnlyLetters() {
            assertTrue(Username.usernameIsValid("user"));
        }

        @Test
        @DisplayName("Username contains only digits > 2 characters but < 16 characters")
        void usernameOnlyDigits() {
            assertTrue(Username.usernameIsValid("123"));
        }
    }

    @Nested
    class InvalidUsername {
        @Test
        @DisplayName("Username contains special character")
        void usernameIsNotDigitOrLetters() {
            assertFalse(Username.usernameIsValid("user#@"));
        }

        @Test
        @DisplayName("Username < 3 characters")
        void username2Char() {
            assertFalse(Username.usernameIsValid("01"));
        }

        @Test
        @DisplayName("Username >15 characters")
        void username16Char() {
            assertFalse(Username.usernameIsValid("users01234567890"));
        }

        @Test
        @DisplayName("Username >15 characters")
        void usernameIsRunTime() {
            Assertions.assertThrows(ExceptionInInitializerError.class, () -> {
                Username.usernameIsValid("users01234567890");
            });
        }
    }
}