package com.org.TimeConverter.TimeConverter.Utilities;

public class NumToTimeConverter {

        private static final String[] tensNames = {
                "", "ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"
        };

        private static final String[] numNames = {
                "", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve",
                "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"
        };

        public static String convertNumberToWords(int number) {
            if (number < 0 || number > 59) {
                throw new IllegalArgumentException("Invalid number: " + number);
            }

            if (number < 20) {
                return numNames[number];
            }

            int tensDigit = number / 10;
            int onesDigit = number % 10;

            return tensNames[tensDigit] + " " + numNames[onesDigit];

        }
    }