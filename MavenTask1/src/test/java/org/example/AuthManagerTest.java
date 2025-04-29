package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class AuthManagerTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private HashPassword passwordHasher;

    @Mock
    private User user;

    @InjectMocks
    private AuthManager authManager;

    private User validUser;
    private String validEmail;
    private String validPassword;
    private String incorrectPassword;
    private String nonExistentEmail;

    @BeforeEach
    public void setUp() {

        MockitoAnnotations.initMocks(this);
        validEmail = "user@example.com";
        validPassword = "validPassword123";
        incorrectPassword = "wrongPassword123";
        nonExistentEmail = "nonexistent@example.com";

//        validUser = new User(validEmail, "hashedPassword123");

        when(user.getHashedPassword()).thenReturn(validPassword);
        when(userRepository.findByEmail(validEmail)).thenReturn(user);
        when(userRepository.findByEmail(nonExistentEmail)).thenReturn(null);
        when(passwordHasher.matches(validPassword, validPassword)).thenReturn(true);
//        when(passwordHasher.matches(validPassword, user.getHashedPassword())).thenReturn(true);
//        when(passwordHasher.matches(incorrectPassword, user.getHashedPassword())).thenReturn(false);
//        when(userRepository.findByEmail(nonExistentEmail)).thenReturn(null);
    }

    @Test
    public void testLogin_ValidCredentials() {
        User result = authManager.login(validEmail, validPassword);
        assertEquals(result, user);
    }

    @Test
    public void testLogin_InvalidPassword() {

        InvalidCredentialsException exception = assertThrows(InvalidCredentialsException.class, () -> {
            authManager.login(validEmail, incorrectPassword);
        });
        assertEquals("Incorrect password", exception.getMessage(), "Exception message should match");
    }

    @Test
    public void testLogin_UserNotFound() {

        User result = authManager.login(nonExistentEmail, validPassword);
        assertNull(result, "Login should return null if the user is not found");
    }

    @Test
    public void testLogin_EmailNull() {

        InvalidCredentialsException exception = assertThrows(InvalidCredentialsException.class, () -> {
            authManager.login(null, validPassword);
        });
        assertEquals("Email cannot be null", exception.getMessage(), "Exception message for null email should match");
    }

    @Test
    public void testLogin_PasswordNull() {

        InvalidCredentialsException exception = assertThrows(InvalidCredentialsException.class, () -> {
            authManager.login(validEmail, null);
        });
        assertEquals("Password cannot be null", exception.getMessage(), "Exception message for null password should match");
    }

    @Test
    public void testLogin_PasswordHashMismatch() {

        when(passwordHasher.matches(validPassword, validUser.getHashedPassword())).thenReturn(false);

        InvalidCredentialsException exception = assertThrows(InvalidCredentialsException.class, () -> {
            authManager.login(validEmail, validPassword);
        });
        assertEquals("Incorrect password", exception.getMessage(), "Exception message for mismatched password should match");
    }
}
