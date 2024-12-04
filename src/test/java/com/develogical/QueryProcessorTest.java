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

        assertEquals("12", result, "Subtraction query result should be 12");
    }
}
