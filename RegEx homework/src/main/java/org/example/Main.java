package org.example;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        System.out.println("Enter your email: ");
        Scanner scanner = new Scanner(System.in);
        String email = scanner.nextLine();
        System.out.println("Is your email valid:  " + validateString(email, emailPattern));

        System.out.println("Enter your IP: ");
        String ip = scanner.nextLine();
        System.out.println("Is your email valid:  " + validateString(ip, ipPattern));

        System.out.println("Enter your card: ");
        String card = scanner.nextLine();
        System.out.println("Is your card valid:  " + validateString(card, creditCardPattern));
    }
    public static boolean validateString(String text, String pattern){
        Pattern searchPattern = Pattern.compile(pattern);
        Matcher matcher = searchPattern.matcher(text);
        return matcher.find();
    }

    static String emailPattern = "^[a-zA-Z0-9.!#$%&'*+\\/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$";
    static String ipPattern = "^\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}$";
    static String creditCardPattern = "(^4[0-9]{12}(?:[0-9]{3})?$)|(^(?:5[1-5][0-9]{2}|222[1-9]|22[3-9][0-9]|2[3-6][0-9]{2}|27[01][0-9]|2720)[0-9]{12}$)|(3[47][0-9]{13})|(^3(?:0[0-5]|[68][0-9])[0-9]{11}$)|(^6(?:011|5[0-9]{2})[0-9]{12}$)|(^(?:2131|1800|35\\d{3})\\d{11}$)";


}