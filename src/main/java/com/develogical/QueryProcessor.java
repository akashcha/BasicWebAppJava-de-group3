package com.develogical;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

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
                int num1 = Integer.parseInt(parts[2]);
                int num2 = Integer.parseInt(parts[4].replaceAll("[^0-9]", ""));
                return String.valueOf(num1 - num2);
            } catch (NumberFormatException ignored) {
                return "Error processing subtraction query";
            }
        }

        if (query.toLowerCase().contains("which of the following numbers are primes")) {
            String numbersPart = query.substring(query.indexOf(":") + 1).trim();
            if (numbersPart.endsWith("?")) {
                numbersPart = numbersPart.substring(0, numbersPart.length() - 1).trim();
            }

            String[] numberStrings = numbersPart.split(",\\s*");
            List<String> primes = new ArrayList<>();

            for (String numberStr : numberStrings) {
                try {
                    int number = Integer.parseInt(numberStr.trim());
                    if (isPrime(number)) {
                        primes.add(String.valueOf(number));
                    }
                } catch (NumberFormatException e) {
                    // do nothing
                }
            }
            return String.join(", ", primes);
        }

        if (query.toLowerCase().matches(".*what is (\\d+)( plus (\\d+))*\\??")) {

            String numbersPart = query.replaceAll("[^0-9\\s]", "").trim();
            String[] numberStrings = numbersPart.split("\\s+"); // Split by spaces
            int sum = 0;
            for (String numberStr : numberStrings) {
                sum += Integer.parseInt(numberStr.trim());
            }
            return String.valueOf(sum);
        }
        if (query.toLowerCase().matches(".*what is \\d+ to the power of \\d+\\??.*")) {
            try {
                String baseAndExponent = query.replaceAll("[^0-9 ]", "").trim();
                String[] parts = baseAndExponent.split(" ");
                
                if (parts.length < 2) {
                    return "Invalid input for power calculation.";
                }
                
                int base = Integer.parseInt(parts[0]);
                int exponent = Integer.parseInt(parts[5]);
                BigInteger result = BigInteger.valueOf(base).pow(exponent);
                return result.toString();
            } catch (NumberFormatException e) {
                return "Invalid input for power calculation.";
            }
        }

        return "";
    }

    private boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}