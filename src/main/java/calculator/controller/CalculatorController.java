package calculator.controller;

import calculator.model.Calculator;
import calculator.service.CalculatorService;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class CalculatorController {
    Calculator calculator;
    CalculatorService calculatorService;

    public CalculatorController(Calculator calculator, CalculatorService calculatorService) {
        this.calculator = calculator;
        this.calculatorService = calculatorService;
    }

    public void calculatorStart() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        List<String> numberList = calculatorService.findNumByDelimiter(input);
        int result = calculator.addNumber(numberList);

        System.out.println("결과 : " + result);
    }
}
