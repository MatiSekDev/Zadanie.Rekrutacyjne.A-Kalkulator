package org.zadanie.rekrutacyjne.mathematical.operation.strategy;

public class MathematicalOperationAddition implements MathematicalOperationStrategy{
    @Override
    public double performMathematicalOperation(double firstNumber, double secondNumber) {
        return firstNumber + secondNumber;
    }
}
