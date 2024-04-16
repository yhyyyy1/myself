package org.example.lab5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Task2 {

    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote--allow-origin=*");

        //a. Open Chrome browser and navigate to https://the-internet.herokuapp.com/login
        // 将这一步 放到测试用例中定义
        WebDriver webDriver = new ChromeDriver(options);
        webDriver.get("https://the-internet.herokuapp.com/login");
        System.out.println(login(webDriver, "tomsmith1", "SuperSecretPassword!"));
    }


    public static boolean login(WebDriver webDriver, String usernameInput, String passwordInput) {
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--remote--allow-origin=*");
//
//        //a. Open Chrome browser and navigate to https://the-internet.herokuapp.com/login
//        // 将这一步 放到测试用例中定义
//        WebDriver webDriver = new ChromeDriver(options);
//        webDriver.get("https://the-internet.herokuapp.com/login");

        //b. 输入有效的账户密码
        WebElement username = webDriver.findElement(By.id("username"));
        WebElement password = webDriver.findElement(By.id("password"));
        username.sendKeys(usernameInput);  // 有效的账户名——tomsmith
        password.sendKeys(passwordInput);  // 有效的密码——SuperSecretPassword

        //c. 点击登录按钮
        WebElement loginButton = webDriver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();

        //d. Verify that the user is redirected to the home page(verify the top green bar)

        //仅仅判断了成功的情况是不够的
//        WebElement successMessage = ExpectedConditions.visibilityOfElementLocated(By.className("success"));
        WebDriverWait wait = new WebDriverWait(webDriver, 3);
        try {
            // 先尝试查找成功消息
            WebElement successMessage = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.className("success"))
            );
            if (successMessage != null) {
                return true;  // 登录成功
            }
        } catch (Exception ignore) {
            // 如果没有找到成功消息，捕获异常但不处理，继续检查错误消息
        }

        try {
            // 然后检查错误消息
            WebElement errorMessage = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(By.className("error"))
            );
            if (errorMessage != null) {
                return false;  // 登录失败
            }
        } catch (Exception ignore) {
            // 如果没有找到错误消息，同样捕获异常但不处理
        }

        System.out.println("在等待时间内未出现成功或错误消息。");
        return false; // 在等待时间内未找到任何相关消息，可能是出现了其他问题
    }
}
