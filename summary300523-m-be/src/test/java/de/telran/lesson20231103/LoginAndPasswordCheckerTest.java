package de.telran.lesson20231103;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LoginAndPasswordCheckerTest {

    private static LoginAndPasswordChecker checker;

    @BeforeAll
    public static void init(){
        checker = new LoginAndPasswordChecker();
    }

    @Test
    public void checkLogin(){
        assertTrue(checker.checkLoginAndPassword("john", "123", "123"));
        assertTrue(checker.checkLoginAndPassword("johnR123_", "123", "123"));
        assertTrue(checker.checkLoginAndPassword("123", "123", "123"));
        assertTrue(checker.checkLoginAndPassword("___", "123", "123"));
        assertFalse(checker.checkLoginAndPassword("", "123", "123"));
        assertFalse(checker.checkLoginAndPassword("*", "123", "123"));
        assertFalse(checker.checkLoginAndPassword("qqqqqqqqqqqqqqqqqqqq", "123", "123"));
        assertThrows(NullPointerException.class, () -> checker.checkLoginAndPassword(null, "123", "123"));
    }

    @Test
    public void checkPassword(){
        assertTrue(checker.checkLoginAndPassword("john", "qwe", "qwe"));
        assertTrue(checker.checkLoginAndPassword("john", "___", "___"));
        assertTrue(checker.checkLoginAndPassword("john", "qwe123___", "qwe123___"));
        assertFalse(checker.checkLoginAndPassword("john", "", ""));
        assertFalse(checker.checkLoginAndPassword("john", "@", "@"));
        assertFalse(checker.checkLoginAndPassword("john", "qqqqqqqqqqqqqqqqqqqq", "qqqqqqqqqqqqqqqqqqqq"));
        assertThrows(NullPointerException.class, () -> checker.checkLoginAndPassword("john", null, "123"));
    }

    @Test
    @Disabled
    public void checkConfirmPassword(){
        assertTrue(checker.checkLoginAndPassword("john", "321", "321"));
        assertFalse(checker.checkLoginAndPassword("john", "321", "123"));
        assertThrows(NullPointerException.class, () -> checker.checkLoginAndPassword("john", "123", null));
    }

}
