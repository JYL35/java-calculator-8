package calculator.controller;

import calculator.model.Calculator;
import calculator.service.CalculatorService;
import calculator.view.InputView;
import calculator.view.OutputView;

import java.util.List;

public class CalculatorController {
    Calculator calculator;
    CalculatorService calculatorService;
    InputView inputView;
    OutputView outputView;

    public CalculatorController(Calculator calculator,
                                CalculatorService calculatorService,
                                InputView inputView, 
                                OutputView outputView) {
        this.calculator = calculator;
        this.calculatorService = calculatorService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void calculatorStart() {
        String input = inputView.userInput();

        List<String> numberList = calculatorService.findNumByDelimiter(input);
        double result = calculator.addNumber(numberList);

        outputView.resultOutput(result);
    }
}
