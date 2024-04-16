package org.example.lab5;

import org.example.lab5.Task2;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task2Test {
    private static WebDriver driver;

    @BeforeAll
    public static void setupDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origin=*");
        driver = new ChromeDriver(options);
    }

    @BeforeEach
    public void navigateToLoginPage() {
        driver.get("https://the-internet.herokuapp.com/login");
    }

    @Test
    public void testValidLogin() {
        assertTrue(Task2.login(driver, "tomsmith", "SuperSecretPassword!"), "Valid credentials should return true.");
    }

    @Test
    public void testInvalidUsername() {
        assertFalse(Task2.login(driver, "wrongUser", "SuperSecretPassword!"), "Invalid username should return false.");
    }

    @Test
    public void testInvalidPassword() {
        assertFalse(Task2.login(driver, "tomsmith", "wrongPassword"), "Invalid password should return false.");
    }

    @Test
    public void testEmptyUsername() {
        assertFalse(Task2.login(driver, "", "SuperSecretPassword!"), "Empty username should return false.");
    }

    @Test
    public void testEmptyPassword() {
        assertFalse(Task2.login(driver, "tomsmith", ""), "Empty password should return false.");
    }

    @AfterAll
    public static void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}
