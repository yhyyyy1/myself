package org.example.lab5;

import org.example.lab5.Task2;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
public class Task2Test {
    private static WebDriver webDriver;

    @BeforeAll
    public static void setupClass() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote--allow-origin=*");
        webDriver = new ChromeDriver(options);
    }

    @BeforeEach
    public void setupTest() {
        // Set the static webDriver in Task2 here if it was designed to be set externally.
        Task2.setWebDriver(webDriver); // Assuming you have a setter for WebDriver in Task2.
    }

    @Test
    public void testInvalidUsername() {
        boolean result = Task2.login("incorrectUser", "SuperSecretPassword!");
        assertFalse(result, "Test failed: Login should fail with incorrect username.");
    }

    @Test
    public void testInvalidPassword() {
        boolean result = Task2.login("tomsmith", "incorrectPassword");
        assertFalse(result, "Test failed: Login should fail with incorrect password.");
    }

    @Test
    public void testEmptyUsername() {
        boolean result = Task2.login("", "SuperSecretPassword!");
        assertFalse(result, "Test failed: Login should fail with empty username.");
    }

    @Test
    public void testEmptyPassword() {
        boolean result = Task2.login("tomsmith", "");
        assertFalse(result, "Test failed: Login should fail with empty password.");
    }

    @AfterEach
    public void tearDownTest() {
        webDriver.manage().deleteAllCookies();
    }

    @AfterAll
    public static void tearDownClass() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}
