package calculator;

import calculator.controller.CalculatorController;
import calculator.model.Calculator;
import calculator.service.CalculatorService;

public class Application {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        CalculatorService calculatorService = new CalculatorService();

        CalculatorController calculatorController = new CalculatorController(calculator, calculatorService);
        calculatorController.calculatorStart();
    }
}
