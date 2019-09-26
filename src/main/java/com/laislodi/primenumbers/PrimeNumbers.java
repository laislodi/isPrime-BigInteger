package com.laislodi.primenumbers;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class PrimeNumbers {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String n = scanner.nextLine();

        while (!n.equals("exit")) {

            BigInteger number = new BigInteger(n);

            int length = n.length();
            if (length > 1 && isOdd(n, length) ||
                    isPrime(number)) {
                System.out.println("prime");
            } else {
                System.out.println("not prime");
            }
            n = scanner.nextLine();
        }
        scanner.close();
    }

    private static boolean isOdd(String n, int length) {
        return n.charAt(length - 1) != '0' && n.charAt(length - 1) != '2' &&
                n.charAt(length - 1) != '4' && n.charAt(length - 1) != '6' &&
                n.charAt(length - 1) != '8';
    }

    private static boolean isPrime(BigInteger n) {
        System.out.println("isPrime?");
        BigInteger zero = BigInteger.ZERO;
        BigInteger one = BigInteger.ONE;
        BigInteger two = new BigInteger("2");
        BigInteger three = new BigInteger("3");

        if ((n.equals(one) || (!n.equals(two) && n.remainder(two).equals(zero)))) {
            //if (n == 1 || (n != 2 && n % 2 == 0)) {
            return false;
        }
        // test each odd number from 3 to sqrt(n)
        BigInteger half = n.divide(two);
        System.out.println("half = " + half);

        for (BigInteger i = three; i.compareTo(n) < 0; i = i.add(two)) {
            System.out.println("i = " + i);
            if (n.remainder(i).equals(zero)) {
                return false;
            }
        }
        //# n is necessarily prime
        return true;
    }
}


