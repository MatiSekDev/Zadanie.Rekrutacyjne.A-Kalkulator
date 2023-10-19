package org.zadanie.rekrutacyjne.user.action.strategy;

import org.zadanie.rekrutacyjne.calculator.CalculatorConsoleService;
import org.zadanie.rekrutacyjne.onp.ReversePolishNotationService;

import java.util.Scanner;

public class UserActionDefault implements UserActionStrategy{
    @Override
    public void processUserAction(Scanner scanner, ReversePolishNotationService reversePolishNotationService, CalculatorConsoleService calculatorConsoleService) {
        calculatorConsoleService.printBadInputMessage();
    }
}
