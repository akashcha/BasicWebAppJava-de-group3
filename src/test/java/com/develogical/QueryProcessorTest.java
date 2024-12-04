package com.develogical;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class QueryProcessorTest {

    QueryProcessor queryProcessor = new QueryProcessor();

    @Test
    public void knowsAboutShakespeare() throws Exception {
        assertThat(queryProcessor.process("Shakespeare"), containsString("playwright"));
    }

    @Test
    public void isNotCaseSensitive() throws Exception {
        assertThat(queryProcessor.process("shakespeare"), containsString("playwright"));
    }

    @Test
    public void knowsTeamName() throws Exception {
        assertThat(queryProcessor.process("What is your name?"), containsString("RobTest"));
    }

    @Test
    public void testSubtractionQuery() {
        QueryProcessor queryProcessor = new QueryProcessor();

        String query = "What is 29 minus 17?";
        String result = queryProcessor.process(query);

        assertEquals("Subtraction query result should be 12", "12", result);
    }

    @Test
    public void testPrimeNumberQuerySingleValue() {
        QueryProcessor queryProcessor = new QueryProcessor();

        String query = "Which of the following numbers are primes: 3, 51, 57, 54, 33?";
        String result = queryProcessor.process(query);

        assertEquals("The query should return only the prime numbers from the list: 3", "3", result);
    }

    @Test
    public void testPrimeNumberQueryMultipleValue() {
        QueryProcessor queryProcessor = new QueryProcessor();

        String query = "Which of the following numbers are primes: 3, 5, 51, 57, 54, 33?";
        String result = queryProcessor.process(query);

        assertEquals("The query should return only the prime numbers from the list: 3, 5", "3, 5", result);
    }

    @Test
    public void testAdditionQuery() {
        QueryProcessor processor = new QueryProcessor();
        String query = "What is 67 plus 78 plus 29?";
        String response = processor.process(query);
        assertEquals("The sum of 67, 78, and 29 should be 174.", "174", response);
    }

    @Test
    public void testPowerCalculation() {
        QueryProcessor queryProcessor = new QueryProcessor();
        String query = "What is 76 to the power of 48?";
        String expected = "1901307798286118873731890304310405643875008041641610963159183577700321908301489151699582976";
        assertEquals("",expected, queryProcessor.process(query));
    }
}
