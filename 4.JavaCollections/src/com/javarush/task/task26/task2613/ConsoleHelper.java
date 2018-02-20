package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ResourceBundle;

import static com.javarush.task.task26.task2613.Operation.getAllowableOperationByOrdinal;

public class ConsoleHelper {
    private static ResourceBundle res = ResourceBundle.getBundle(CashMachine.class.getPackage().getName() +
            ".resources.common_en");

    private static BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws InterruptOperationException {
        try {
            String message = bis.readLine();
            if (message.equalsIgnoreCase("EXIT"))
                throw new InterruptOperationException();
            return message;
        } catch (IOException ignore) {

        }
        return null;
    }

    public static String askCurrencyCode() throws InterruptOperationException {
        writeMessage(res.getString("choose.currency.code"));
        String currencyCode = readString();
        while (currencyCode.length() != 3) {
            writeMessage("Please enter correct currency code");
            currencyCode = readString();
        }

        return currencyCode.toUpperCase();

    }

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException {
        String[] array;
        writeMessage(res.getString("choose.denomination.and.count.format"));

        while (true) {
            String s = readString();
            array = s.split(" ");
            int k;
            int l;
            try {
                k = Integer.parseInt(array[0]);
                l = Integer.parseInt(array[1]);
            } catch (Exception e) {
                writeMessage(res.getString("invalid.data"));
                continue;
            }
            if (k <= 0 || l <= 0 || array.length > 2) {
                writeMessage(res.getString("invalid.data"));
                continue;
            }
            break;
        }
        return array;
    }

    public static Operation askOperation() throws InterruptOperationException {
        writeMessage(res.getString("choose.operation"));
        while (true) {
            String code = readString();
            int num;
            try {
                num = Integer.parseInt(code);
                return getAllowableOperationByOrdinal(num);
            } catch (Exception e) {
                writeMessage("Invalid code");
                continue;
            }
        }
    }

    public static void printExitMessage() {
        ConsoleHelper.writeMessage(res.getString("the.end"));

    }

}
