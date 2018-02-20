package com.javarush.task.task26.task2613;

import com.javarush.task.task26.task2613.command.CommandExecutor;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;

import java.util.Locale;

public class CashMachine {
    public static CurrencyManipulator manipulator;

    public static final String RESOURCE_PATH = CashMachine.class.getPackage().getName() + ".resources.";

    public static void main(String[] args) {


        try {
            String currencyCode = ConsoleHelper.askCurrencyCode();
            manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(currencyCode);
            Locale.setDefault(Locale.ENGLISH);
            CommandExecutor.execute(Operation.LOGIN);
            while (true) {
                Operation operation = ConsoleHelper.askOperation();
                CommandExecutor.execute(operation);
                if (operation.equals(Operation.EXIT))
                    break;
            }

        } catch (InterruptOperationException e) {
            ConsoleHelper.printExitMessage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
