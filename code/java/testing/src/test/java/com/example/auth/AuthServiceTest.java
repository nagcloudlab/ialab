package com.example.auth;

import com.example.model.Account;
import com.example.repo.AccountRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnJre;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.mockito.Mockito;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AuthServiceTest {

    private AccountRepository accountRepositoryMock;
    private AuthService authService;

    @BeforeEach
    public void setUp() throws Exception {
        accountRepositoryMock = mock(AccountRepository.class);
        when(accountRepositoryMock.findByUsername("foo"))
                .thenReturn(new Account("foo", "secret"));
        authService = new AuthService(accountRepositoryMock);
    }

    @Test
    @Order(1)
    @Tag("auth")
    @DisplayName("Valid Credentials")
    public void validUsernameAndPassword() {
        boolean actual = authService.authenticate("foo", "secret");
        assertTrue(actual);
        verify(accountRepositoryMock).findByUsername("foo");
    }

    @Disabled
    @Test
    @Order(2)
    @Tag("auth")
    @DisplayName("Invalid Credentials")
    public void invalidUsernameAndPassword() {
        when(accountRepositoryMock.findByUsername("foo"))
                .thenReturn(new Account("foo", "secret"));
        boolean actual = authService.authenticate("foo", "invalid");
        assertFalse(actual);
        verify(accountRepositoryMock).findByUsername("foo");
    }


    @Disabled
    @Test
    @Order(3)
    @Tag("auth")
    public void usernameNotExist() {
        Exception e = assertThrows(AccountNotFoundException.class, () -> authService.authenticate("unknown", "shhh"));
    }


}
