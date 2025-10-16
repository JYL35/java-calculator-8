package calculator;

import calculator.model.Calculator;

import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        List<String> numberList = Arrays.asList("1", "2", "4");
        int result = calculator.addNumber(numberList);
        System.out.println(result);
    }
}
