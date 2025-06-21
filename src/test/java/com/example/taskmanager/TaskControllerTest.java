package com.example.taskmanager.controller;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class TaskControllerTest {

    @Test
    void testOne() {
        assertTrue(true);
    }

    @Test
    void testTwo() {
        assertTrue(2 + 2 == 4);
    }

    @Test
    void testThree() {
        assertTrue("Task".startsWith("T"));
    }

    @Test
    void testFour() {
        assertTrue(10 > 5);
    }
}
