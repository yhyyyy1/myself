package org.example.lab5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Task2 {

    public static void main(String[] args) {
        System.out.println(login("tomsmith","SuperSecretPassword!"));
    }
    public static boolean login(String usernameInput, String passwordInput){
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote--allow-origin=*");

        //a. Open Chrome browser and navigate to https://the-internet.herokuapp.com/login
        WebDriver webDriver=new ChromeDriver(options);
        webDriver.get("https://the-internet.herokuapp.com/login");

        //b. 输入有效的账户密码
        WebElement username = webDriver.findElement(By.id("username"));
        WebElement password = webDriver.findElement(By.id("password"));
        username.sendKeys(usernameInput);  // 有效的账户名——tomsmith
        password.sendKeys(passwordInput);  // 有效的密码——SuperSecretPassword

        //c. 点击登录按钮
        WebElement loginButton = webDriver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();

        //d. Verify that the user is redirected to the home page(verify the top green bar)
        WebElement successMessage = webDriver.findElement(By.className("success"));
        if (successMessage.isDisplayed() && successMessage.getText().contains("You logged into a secure area!")) {
            System.out.println("Login successful and verified!");
        } else {
            System.out.println("Login failed or verification failed.");
            return false;
        }

        //e. Fallback to the previous interface
        webDriver.navigate().back();
        return true;
    }
}
