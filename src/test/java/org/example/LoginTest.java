package org.example;

import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest {
    // Definimos las variables a nivel de clase
    static Playwright playwright;
    static Browser browser;
    BrowserContext context;
    Page page;

    @BeforeAll
    static void launchBrowser() {
        playwright = Playwright.create();
        // headless(false) para que el reclutador vea qué pasa
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
    }

    @BeforeEach
    void createContext() {
        context = browser.newContext();
        page = context.newPage();
    }

    @Test
    void testNavegacionTodoMVC() {
        page.navigate("https://demo.playwright.dev/todomvc");

        // Buscamos el input por su placeholder (Muy recomendado en Playwright)
        Locator input = page.getByPlaceholder("What needs to be done?");

        // Escribimos y damos Enter
        input.fill("Prueba técnica terminada");
        input.press("Enter");

        // Validamos que el elemento se creó en la lista
        assertTrue(page.locator(".todo-list").isVisible());
    }

    @AfterEach
    void closeContext() {
        context.close();
    }

    @AfterAll
    static void closeBrowser() {
        playwright.close();
    }
}