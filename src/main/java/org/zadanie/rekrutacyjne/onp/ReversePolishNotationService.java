package org.zadanie.rekrutacyjne.onp;

import org.zadanie.rekrutacyjne.calculator.Calculator;
import org.zadanie.rekrutacyjne.utils.ConstUtils;
import java.util.Stack;
public class ReversePolishNotationService {

    public double evaluateOnp(String onp) throws IllegalAccessException {
        Stack<Double> stackOfOperands= new Stack<>();
        String[] onpTokens = onp.split(ConstUtils.REGEX_BY_WHITE_SPACES);

        for (String onpToken : onpTokens) {
            if (onpToken.matches(ConstUtils.REGEX_ACCEPTED_MATHEMATICAL_OPERATORS)) {
                Calculator calculator = new Calculator(onpToken.charAt(0));
                double secondOperand = stackOfOperands.pop();
                double firstOperand = stackOfOperands.pop();
                stackOfOperands.push(
                        calculator.performMathematicalOperation(
                                firstOperand,
                                secondOperand
                        )
                );
            } else if (isDouble(onpToken)) {
                stackOfOperands.push(Double.parseDouble(onpToken));

            }
        }
        if (stackOfOperands.size() != 1) {
            throw new IllegalAccessException(ConstUtils.EXCEPTION_MESSAGE_MALFORMED_EQUATION);
        }
        return stackOfOperands.pop();
    }

    private boolean isDouble(String double_) {
        try {
            Double.parseDouble(double_);
        }
        catch (NumberFormatException numberFormatException) {
            return false;
        }
        return true;
    }

    private int getPrecedence(Character character) {
        if ((character == ConstUtils.CONST_CHARACTER_ADDITION_SYMBOL) ||
            (character == ConstUtils.CONST_CHARACTER_SUBTRACTION_SYMBOL)) {
            return 1;
        }
        else if ((character == ConstUtils.CONST_CHARACTER_MULTIPLICATION_SYMBOL) ||
                 (character == ConstUtils.CONST_CHARACTER_DIVISION_SYMBOL)) {
            return 2;
        }
        return -1;
    }
    public String equationToOnp(String equation) {
        Stack<Character> stack = new Stack<>();
        StringBuilder onp = new StringBuilder();
        StringBuilder currentNumber = new StringBuilder();
        int index = -1;

        for (Character character : equation.toCharArray()) {
            index = index + 1;
            if (character.toString().matches(ConstUtils.REGEX_ACCEPTED_MATHEMATICAL_ELEMENTS) ||
                (character.compareTo(ConstUtils.CONST_CHARACTER_DOT) == 0)) {
                currentNumber.append(character);
                if (equation.length() == (index + 1)) {
                    onp.append(currentNumber).append(ConstUtils.CONST_CHARACTER_WHITE_SPACE);
                }
            } else {
                if (currentNumber.length() > 0) {
                    onp.append(currentNumber).append(ConstUtils.CONST_CHARACTER_WHITE_SPACE);
                    currentNumber.setLength(0);
                }

                if (character == ConstUtils.CONST_CHARACTER_LEFT_PAREN) {
                    stack.push(character);
                } else if (character == ConstUtils.CONST_CHARACTER_RIGHT_PAREN) {
                    while (!stack.isEmpty() && stack.peek() != ConstUtils.CONST_CHARACTER_LEFT_PAREN) {
                        onp.append(stack.pop()).append(ConstUtils.CONST_CHARACTER_WHITE_SPACE);
                    }
                    stack.pop();
                } else {
                    while (!stack.isEmpty() && getPrecedence(character) <= getPrecedence(stack.peek())
                            && character.toString().matches(ConstUtils.REGEX_ACCEPTED_MATHEMATICAL_OPERATORS)) {
                        onp.append(stack.pop()).append(ConstUtils.CONST_CHARACTER_WHITE_SPACE);
                    }
                    stack.push(character);
                }
            }
        }

        while (!stack.isEmpty()) {
            if (stack.peek() == ConstUtils.CONST_CHARACTER_LEFT_PAREN) {
                throw new ArithmeticException(ConstUtils.EXCEPTION_MESSAGE_MALFORMED_EQUATION);
            }
            onp.append(stack.pop()).append(ConstUtils.CONST_CHARACTER_WHITE_SPACE);
        }
        return onp.toString();
    }
}
