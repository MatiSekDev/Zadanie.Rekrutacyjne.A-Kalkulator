package org.zadanie.rekrutacyjne.calculator;

import org.zadanie.rekrutacyjne.onp.ReversePolishNotationService;
import org.zadanie.rekrutacyjne.utils.ConstUtils;

import java.util.Scanner;

public class CalculatorConsoleService {
    public void printWelcomeMessages() {
        System.out.println(ConstUtils.CONSOLE_MESSAGE_CALCULATOR);
        System.out.println(ConstUtils.CONSOLE_MESSAGE_HASHTAGS);
        System.out.println(ConstUtils.CONSOLE_MESSAGE_CALCULATE);
        System.out.println(ConstUtils.CONSOLE_MESSAGE_EXIT);
        System.out.println(ConstUtils.CONSOLE_MESSAGE_HASHTAGS);
    }

    public void printBadInputMessage() {
        System.out.print(ConstUtils.CONSOLE_MESSAGE_ERROR_BAD_INPUT);
    }

    public void takeAndProcessUserInput(Scanner scanner, ReversePolishNotationService reversePolishNotationService) {
        System.out.print(ConstUtils.CONSOLE_MESSAGE_MATHEMATICAL_OPERATION);

        try {
            String mathematicalEquation = scanner.nextLine();
            String mathematicalEquationOtpFormat = reversePolishNotationService.equationToOnp(mathematicalEquation);
            double result = reversePolishNotationService.evaluateOnp(mathematicalEquationOtpFormat);
            System.out.println(ConstUtils.CONSOLE_MESSAGE_RESULTS + result);
            System.out.println(ConstUtils.CONSOLE_MESSAGE_HASHTAGS);
            System.out.print(ConstUtils.CONSOLE_MESSAGE_WAIT_FOR_INPUT);
            scanner.nextLine();
        } catch (IllegalAccessException illegalAccessException) {
            System.out.println(ConstUtils.EXCEPTION_MESSAGE_SOMETHING_WENT_WRONG);
        }
    }

    public void exit() {
        System.exit(0);
    }
}
