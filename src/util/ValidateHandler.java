package util;

import java.util.Scanner;

public class ValidateHandler {

    private static final Scanner sc = new Scanner(System.in);

    public static int getInt(String msg, int min, int max) {
        int n;
        while (true) {
            try {
                System.out.print(msg);
                n = Integer.parseInt(sc.nextLine().trim());
                if (n < min || n > max) {
                    System.out.println("Input must be between " + min + " and " + max);
                    continue;
                }
                return n;
            } catch (NumberFormatException e) {
                System.out.println("Invalid number! Try again.");
            }
        }
    }

    public static double getDouble(String msg, double min, double max) {
        double n;
        while (true) {
            try {
                System.out.print(msg);
                n = Double.parseDouble(sc.nextLine().trim());
                if (n < min || n > max) {
                    System.out.println("Input must be between " + min + " and " + max);
                    continue;
                }
                return n;
            } catch (NumberFormatException e) {
                System.out.println("Invalid number! Try again.");
            }
        }
    }

    public static String getString(String msg) {
        String s;
        while (true) {
            System.out.print(msg);
            s = sc.nextLine().trim();
            if (s.isEmpty()) {
                System.out.println("String cannot be empty!");
            } else {
                return s;
            }
        }
    }
}
