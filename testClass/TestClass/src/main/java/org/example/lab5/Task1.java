package org.example.lab5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static java.lang.Thread.sleep;

public class Task1 {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote--allow-origin=*");
        WebDriver webDriver=new ChromeDriver(options);
        webDriver.get("https://www.baidu.com");
        //找到百度搜索框
        // WebElement element= webDriver.findElement(By.cssSelector(".s_ipt"));
        WebElement element=webDriver.findElement(By.xpath("//*[@id=\"kw\"]"));
        //输入一个 selenium 作为查询内容
        element.sendKeys("selenium");
        //点击一下百度按钮
        webDriver.findElement(By.cssSelector("#su")).click();
//        WebDriverWait wait = new WebDriverWait(webDriver, 10);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h3")));

        // 使用CSS选择器获取所有的<h3>标签
        List<WebElement> elements = webDriver.findElements(By.cssSelector("h3"));
//        System.out.println("显示所有<h3>标签的内容：");
//        for (WebElement element1 : elements) {
//            System.out.println("标题文本: " + element1.getText());
//        }
        if (elements.size() >= 10) {
            System.out.println("测试通过: 显示至少10个搜索结果，一共"+ elements.size() + " 个结果");
        } else {
            System.out.println("测试不通过: 搜索结果少于10个，只找到 " + elements.size() + " 个结果");
        }

        // 2. 验证搜索框文本是否包含“selenium”
        String searchText = webDriver.findElement(By.id("kw")).getAttribute("value");
        if (searchText.contains("selenium")) {
            System.out.println("测试通过: 搜索框包含文本‘selenium’");
        } else {
            System.out.println("测试不通过: 搜索框不包含文本‘selenium’");
        }
    }
}



