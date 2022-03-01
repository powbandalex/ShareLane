package junitdemo;

import org.junit.jupiter.api.*;

public class JunitDemoClass {

    @BeforeAll
    public static void junitBeforeAll() {
        System.out.println("I'm before all methods");
    }

    @BeforeEach
    public void junitBeforeEach() {
        System.out.println("I'm before each method and will post this text before each test");
    }

    @Test
    @Tag("QA")
    @Disabled
    @DisplayName("My first junit method")
    public void junitTestOneMethod() {
        System.out.println("I'm test 1 method");
    }

    @Test
    @Tag("Prod")
    @DisplayName("Oops, I did it again")
    public void junitTestTwoMethod() {
        System.out.println("I'm test 2 method");
        Assertions.assertEquals(3,4);
    }

    @AfterEach
    public void junitAfterEach() {
        System.out.println("I'm after each method and will post this text after each test");
    }

    @AfterAll
    public static void junitAfterAll() {
        System.out.println("I'm after all methods");
    }
}
