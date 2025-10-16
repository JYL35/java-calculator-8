package calculator;

import calculator.model.Calculator;
import calculator.service.CalculatorService;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        CalculatorService calculatorService = new CalculatorService();

        List<String> numberList = calculatorService.findNumber("1,2:5");
        int result = calculator.addNumber(numberList);

        System.out.println(result);
    }
}
