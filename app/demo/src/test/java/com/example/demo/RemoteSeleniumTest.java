package com.example.demo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RemoteSeleniumTest {

    private WebDriver driver;

    @LocalServerPort
    private int port;
    
    @BeforeEach
    public void setUp() throws Exception {
        // ================================================================================
        // Dockerを利用する時のLinux環境用の設定

        // Selenium Hub のURL（docker-composeで起動した場合のコンテナ名とポートに合わせる）
        // URL seleniumHubUrl = new URL("http://selenium-hub:4444/wd/hub");

        // // Chrome の能力を定義
        // DesiredCapabilities capabilities = new DesiredCapabilities();
        // capabilities.setBrowserName("chrome");
        // capabilities.setPlatform(Platform.ANY);

        // driver = new RemoteWebDriver(seleniumHubUrl, capabilities);
        // ================================================================================


        // ================================================================================
        // Windows環境用の設定

        // ChromeDriver.exeを別途用意しなくてもいい感じにやってくれる
        driver = new ChromeDriver();
        // ================================================================================
    }


    // 実際のテスト内容
    @Test
    public void searchSpringBootForGoogle() throws Exception {
        // Googleトップページにアクセス
        driver.get("https://www.google.com");
        Thread.sleep(500);

        driver.findElement(By.name("q")).sendKeys("Spring Boot");
        Thread.sleep(2000);

        System.out.println(driver.getTitle());
    }

    @Test
    public void searchMyPage() throws Exception {
        driver.get("http://localhost:" + port + "/");
        Thread.sleep(2000);
    }


    // テスト実行後に後処理を行う
    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
