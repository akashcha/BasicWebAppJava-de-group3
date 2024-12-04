package com.develogical;

public class QueryProcessor {

    public String process(String query) {

        if (query.toLowerCase().contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        }

        if (query.contains("your name")) {
            return "RobTest";
        }

        if (query.toLowerCase().matches(".*what is \\d+ minus \\d+.*")) {
            try {
                String[] parts = query.split(" ");
                int num1 = Integer.parseInt(parts[2]); // The first number
                int num2 = Integer.parseInt(parts[4].replaceAll("[^0-9]", "")); // Remove any non-numeric characters
                return String.valueOf(num1 - num2);
            } catch (NumberFormatException ignored) {
                return "Error processing subtraction query";
            }
        }

        return "";
    }

}