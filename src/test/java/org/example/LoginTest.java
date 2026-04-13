package org.example;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;

public class LoginTest {

    @Test
    void miPrimerTest() {
        try (Playwright playwright = Playwright.create()) {
            // Lanzamos el navegador
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            Page page = browser.newPage();

            // Vamos a una página de prueba
            page.navigate("https://www.google.com");

            // Imprimimos el título para verificar
            System.out.println("El título es: " + page.title());

            browser.close();
        }
    }
}