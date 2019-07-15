package com.tws.refactoring.extract_method;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class OwingPrinterTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    public void printOwing() {
        List<Order> order = new ArrayList<>();
        order.add(new Order(1.00));
        order.add(new Order(2.00));

        OwingPrinter owingPrinter = new OwingPrinter();
        owingPrinter.printOwing("aaa",order);

        assertEquals("*****************************\r\n" +
                "****** Customer totals ******\r\n" +
                "*****************************\r\n" +
                "name: aaa\r\n" +
                "amount: 3.0\r\n",outContent.toString());


    }
}