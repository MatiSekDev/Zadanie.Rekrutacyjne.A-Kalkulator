package org.zadanie.rekrutacyjne.calculator;

import org.zadanie.rekrutacyjne.onp.ReversePolishNotationService;
import org.zadanie.rekrutacyjne.user.action.strategy.UserActionCalculation;
import org.zadanie.rekrutacyjne.user.action.strategy.UserActionDefault;
import org.zadanie.rekrutacyjne.user.action.strategy.UserActionExit;
import org.zadanie.rekrutacyjne.user.action.strategy.UserActionStrategy;
import org.zadanie.rekrutacyjne.utils.ConstUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CalculatorConsoleController {
    private final Scanner scanner = new Scanner(System.in);
    private final CalculatorConsoleService calculatorConsoleService = new CalculatorConsoleService();
    private final ReversePolishNotationService reversePolishNotationService = new ReversePolishNotationService();

    public void run () {
        Map<Character, UserActionStrategy> userActions = new HashMap<>();
        userActions.put(ConstUtils.CONST_CHARACTER_C, new UserActionCalculation());
        userActions.put(ConstUtils.CONST_CHARACTER_E, new UserActionExit());

        while (true) {
            try {
            calculatorConsoleService.printWelcomeMessages();
            char userInput = scanner.nextLine().toLowerCase().charAt(0);

            UserActionStrategy userAction = userActions.getOrDefault(userInput, new UserActionDefault());
            userAction.processUserAction(scanner, reversePolishNotationService, calculatorConsoleService);
            } catch (Exception exception) {
               System.out.println(ConstUtils.EXCEPTION_MESSAGE_MALFORMED_EQUATION);
               System.out.println(ConstUtils.EXCEPTION_MESSAGE_PLEASE_TRY_AGAIN);
                System.out.println(ConstUtils.CONSOLE_MESSAGE_HASHTAGS);
            }
        }
    }
}
