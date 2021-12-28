package com.andre.mortgage.calculator;

import java.util.Scanner;

public class Main {
    public static final int NUMBER_OF_MONTHS = 12;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Principal: ");
        int principal = scanner.nextInt();
        System.out.print("AnnualRate: ");
        double annualPercentage = scanner.nextDouble();
        System.out.print("Period(Years): ");
        int periodInYears = scanner.nextInt();

        double monthlyRate = annualPercentage / 100 / NUMBER_OF_MONTHS;
        double ratePowered = Math.pow(1 + monthlyRate, 12 * periodInYears);
        double mortgage = principal * monthlyRate * ratePowered / (ratePowered - 1);

        System.out.println("Monthly payment: " + mortgage);
    }
}
