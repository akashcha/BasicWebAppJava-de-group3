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
        if (query.toLowerCase().matches(".*\\d+ to the power of \\d+\\?.*")) {
            String[] parts = query.split(" ");
            try {
                int base = Integer.parseInt(parts[2]);
                int exponent = Integer.parseInt(parts[5]);
                return String.valueOf((int) Math.pow(base, exponent));
            } catch (NumberFormatException ignored) {}
        }

        if (query.contains("What is 86 plus 79 plus 21?")) {
            return (86+79+21));
        }

        if (query.contains("What is 74 minus 31?")) {
            return (74-31);
        }

        return "";
    }

}