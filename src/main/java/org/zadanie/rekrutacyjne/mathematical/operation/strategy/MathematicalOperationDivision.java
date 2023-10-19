package org.zadanie.rekrutacyjne.mathematical.operation.strategy;

import org.zadanie.rekrutacyjne.utils.ConstUtils;

public class MathematicalOperationDivision implements MathematicalOperationStrategy{
    @Override
    public double performMathematicalOperation(double firstNumber, double secondNumber) {
        if (secondNumber == 0) {
            throw new ArithmeticException(ConstUtils.EXCEPTION_MESSAGE_CAN_NOT_DIVIDE_BY_ZERO);
        }
        return firstNumber / secondNumber;
    }
}
