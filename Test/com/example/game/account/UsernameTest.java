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
        @DisplayName("Username length > 2 characters only digits and letters")
        void username3Char() {
            assertTrue(Username.checkUsernameLength("123"));
        }

        @Test
        @DisplayName("Username length < 15 characters only digits and letters")
        void username15Char() {
            assertTrue(Username.checkUsernameLength("user1234567890"));
        }

        @Test
        @DisplayName("Username contains only letters > 2 characters but < 16 characters")
        void usernameOnlyLetters() {
            assertTrue(Username.checkUsernameCharacter("user"));
        }

        @Test
        @DisplayName("Username contains only digits > 2 characters but < 16 characters")
        void usernameOnlyDigits() {
            assertTrue(Username.checkUsernameCharacter("123"));
        }

        @Test
        @DisplayName("Username contains both digits and letters > 2 characters but < 16 characters without blank space")
        void usernameIsValid() {
            assertTrue(Username.usernameIsValid("user123"));
        }
    }

    @Nested
    class InvalidUsername {
        @Test
        @DisplayName("Username contains special character(s)")
        void usernameIsNotDigitOrLetters() {
            assertFalse(Username.checkUsernameCharacter("user#@"));
        }

        @Test
        @DisplayName("Username length < 3 characters")
        void username2Char() {
            assertFalse(Username.checkUsernameLength("01"));
        }

        @Test
        @DisplayName("Username length >14 characters")
        void username16Char() {
            assertFalse(Username.checkUsernameLength("users1234567890"));
        }

        @Test
        @DisplayName("Username with blank space(s)")
        void usernameBlankSpace() {
            assertFalse(Username.checkUsernameBlankSpace("user name"));
        }
    }
}