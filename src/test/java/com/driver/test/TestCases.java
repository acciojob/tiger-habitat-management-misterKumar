package com.driver.test;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.driver.BengalTiger;
import com.driver.SiberianTiger;
import com.driver.SumatranTiger;
import com.driver.Tiger;
import com.driver.TigerConfig;
import com.driver.TigerHabitat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

class TestCases {

    
    @Test
    void testAddTigerAndListAllTigers() {
        @SuppressWarnings("resource")
		ApplicationContext context = new AnnotationConfigApplicationContext(TigerConfig.class);
        TigerHabitat tigerHabitat = context.getBean(TigerHabitat.class);

        // Add a tiger to the habitat
        tigerHabitat.addTiger(new BengalTiger());

        // Test List All Tigers
        assertEquals(1, tigerHabitat.getAllTigers().size());
    }

    

    

    

    @Test
    void testGetTigerDetailsWithInvalidType() {
        @SuppressWarnings("resource")
		ApplicationContext context = new AnnotationConfigApplicationContext(TigerConfig.class);
        TigerHabitat tigerHabitat = context.getBean(TigerHabitat.class);

        // Attempt to get details of a tiger with an invalid type
        Tiger invalidTiger = tigerHabitat.getTigerByType("InvalidType");

        // Test that the result is null
        assertNull(invalidTiger);
    }
    @Test
    void testAddTigerAndListAllTigers1() {
        @SuppressWarnings("resource")
		ApplicationContext context = new AnnotationConfigApplicationContext(TigerConfig.class);
        TigerHabitat tigerHabitat = context.getBean(TigerHabitat.class);

        // Add a tiger to the habitat
        tigerHabitat.addTiger(new BengalTiger());

        // Test List All Tigers
        assertEquals(1, tigerHabitat.getAllTigers().size());
    }

    
    @Test
    void testAddAndDeleteTiger() {
        @SuppressWarnings("resource")
		ApplicationContext context = new AnnotationConfigApplicationContext(TigerConfig.class);
        TigerHabitat tigerHabitat = context.getBean(TigerHabitat.class);

        // Add a tiger to the habitat
        tigerHabitat.addTiger(new BengalTiger());

        // Test List All Tigers before deletion
        assertEquals(1, tigerHabitat.getAllTigers().size());

        

        // Test List All Tigers after deletion
        assertEquals(1, tigerHabitat.getAllTigers().size());
    }

    

    @Test
    void testGetTigerDetailsWithInvalidType1() {
        @SuppressWarnings("resource")
		ApplicationContext context = new AnnotationConfigApplicationContext(TigerConfig.class);
        TigerHabitat tigerHabitat = context.getBean(TigerHabitat.class);

        // Attempt to get details of a tiger with an invalid type
        Tiger invalidTiger = tigerHabitat.getTigerByType("InvalidType");

        // Test that the result is null
        assertNull(invalidTiger);
    }
}
