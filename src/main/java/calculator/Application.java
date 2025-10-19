package calculator;

import calculator.controller.CalculatorController;
import calculator.model.Calculator;
import calculator.service.CalculatorService;
import calculator.view.InputView;
import calculator.view.OutputView;

public class Application {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        CalculatorService calculatorService = new CalculatorService();
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        CalculatorController calculatorController = new CalculatorController(calculator,
                calculatorService, inputView, outputView);
        calculatorController.calculatorStart();
    }
}
