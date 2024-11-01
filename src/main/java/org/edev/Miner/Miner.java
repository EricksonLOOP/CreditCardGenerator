package org.edev.Miner;

import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Miner {
    public void AcessarPage() {
        System.setProperty("webdriver.edge.driver", "E:\\ProjetosProgramacao\\WhatsappSpamMesages\\msedgedriver.exe");

        // Configurando as opções antes de iniciar o driver
        EdgeOptions options = new EdgeOptions();
        options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});

        // Inicializando o driver com as opções
        WebDriver driver = new EdgeDriver(options);

        try {
            // Espera implícita
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get("https://buy.stripe.com/7sIaGJcXl7bhboQ7ss");

            // Espera explícita para o elemento
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            Navigation(driver, "Roberto", wait);
        } finally {
            // Fechar o driver após a execução

        }
    }

    public void Navigation(WebDriver driver, String randoName, WebDriverWait wait) {
        try {
            WebElement nome = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[1]/div/div/div[2]/main/div/form/div[1]/div/div/div[1]/div/div/div[2]/div[1]/div[1]/div/div/span/input")));
            if (nome.isDisplayed()) {
                nome.click();
                nome.sendKeys(randoName);
            } else {
                System.out.println("Não encontrado.");
            }
        } catch (NoSuchElementException e) {
            System.out.println("Elemento não encontrado: " + e.getMessage());
        } catch (TimeoutException e) {
            System.out.println("Tempo esgotado ao esperar pelo elemento: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro inesperado: " + e.getMessage());
        }
    }
}
