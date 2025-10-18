package calculator.model;

import java.util.List;

public class Calculator {

    // 더하기 기능
    public double addNumber(List<String> numberList) {
        double result = 0;

        for (String num : numberList) {
            result += Double.parseDouble(num);
        }

        return result;
    }
}
