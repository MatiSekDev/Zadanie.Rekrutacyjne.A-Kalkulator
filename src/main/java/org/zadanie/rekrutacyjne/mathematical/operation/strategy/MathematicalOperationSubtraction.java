package org.zadanie.rekrutacyjne.mathematical.operation.strategy;

public class MathematicalOperationSubtraction implements MathematicalOperationStrategy{
    @Override
    public double performMathematicalOperation(double firstNumber, double secondNumber) {
        return firstNumber - secondNumber;
    }
}
