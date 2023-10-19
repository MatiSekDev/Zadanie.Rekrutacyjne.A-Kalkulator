package org.zadanie.rekrutacyjne.user.action.strategy;

import org.zadanie.rekrutacyjne.calculator.CalculatorConsoleService;
import org.zadanie.rekrutacyjne.onp.ReversePolishNotationService;

import java.util.Scanner;

public interface UserActionStrategy {
    void processUserAction(Scanner scanner, ReversePolishNotationService reversePolishNotationService, CalculatorConsoleService calculatorConsoleService);
}
