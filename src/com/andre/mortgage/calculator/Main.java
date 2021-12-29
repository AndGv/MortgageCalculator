package com.andre.mortgage.calculator;

import java.util.Scanner;

public class Main {
    public static final int MONTHS_PER_YEAR = 12;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Principal ($1k - $1M): ");
        int principal = scanner.nextInt();

        while (principal < 1_000 || principal > 1_000_000) {
            System.out.println("Enter a number between 1,000 - 1,000,000.");
            System.out.print("Principal ($1k - $1M): ");
            principal = scanner.nextInt();
        }
        System.out.print("Annual rate: ");
        double annualRate = scanner.nextDouble();
        while (annualRate < 0 || annualRate > 30) {
            System.out.println("Enter a number between 0 - 30.");
            System.out.print("Annual rate: ");
            annualRate = scanner.nextInt();
        }

        System.out.print("Period(Years): ");
        int periodInYears = scanner.nextInt();
        while (periodInYears < 0 || periodInYears > 50) {
            System.out.println("Enter a number between 0 - 50");
            System.out.print("Period(Years):");
            periodInYears = scanner.nextInt();
        }

        double monthlyRate = annualRate / 100 / MONTHS_PER_YEAR;
        double ratePowered = Math.pow(1 + monthlyRate, MONTHS_PER_YEAR * periodInYears);
        double mortgage = principal * monthlyRate * ratePowered / (ratePowered - 1);
        System.out.println("Monthly payment: " + mortgage);
    }
}
