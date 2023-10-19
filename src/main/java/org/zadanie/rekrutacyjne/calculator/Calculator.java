package org.zadanie.rekrutacyjne.calculator;

import org.zadanie.rekrutacyjne.mathematical.operation.strategy.*;
import org.zadanie.rekrutacyjne.utils.ConstUtils;

public class Calculator {
    private MathematicalOperationStrategy mathematicalOperationStrategy;

    public Calculator(Character operator) {
        switch (operator) {
            case '+' -> {
                this.mathematicalOperationStrategy = new MathematicalOperationAddition();
            }
            case '-' -> {
                this.mathematicalOperationStrategy = new MathematicalOperationSubtraction();
            }
            case '*' -> {
                this.mathematicalOperationStrategy = new MathematicalOperationMultiplication();
            }
            case '/' -> {
                this.mathematicalOperationStrategy = new MathematicalOperationDivision();
            }
            default -> throw new IllegalArgumentException(ConstUtils.EXCEPTION_MESSAGE_BAD_OPERATOR);
        }
    }

    public double performMathematicalOperation(double firstNumber, double secondNumber) {
        return this.mathematicalOperationStrategy.performMathematicalOperation(firstNumber, secondNumber);
    }


}
