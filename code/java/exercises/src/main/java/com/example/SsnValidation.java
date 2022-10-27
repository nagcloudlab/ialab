package com.example;

public class SsnValidation {
    public static void main(String[] args) {

        String ssnInput = "242-43-3344";

        //way-1
//        boolean isValid=ssnInput.matches("\\d{3}-\\d{2}-\\d{4}");
//        System.out.println(isValid);

        //way-2

        boolean isValid = true;
        if (ssnInput.length() == 11) {
            for (int i = 0; i < ssnInput.length(); i++) {
                char c = ssnInput.charAt(i);
                if (i == 3 || i == 6) {
                    if (c != '-') {
                        isValid = false;
                        break;
                    }
                } else {
//                    if (!Character.isDigit(c)) {
                    if ("0123456789".indexOf(c) == -1) {
                        isValid = false;
                        break;
                    }
                }
            }

        } else {
            isValid = false;
        }

        if (isValid) {
            System.out.println("Valid ssn");
        } else {
            System.out.println("Invalid ssn");
        }

    }

}
