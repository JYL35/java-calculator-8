package calculator.model;

import java.util.List;

public class Calculator {
    private int result;

    // 더하기 기능
    public int addNumber(List<String> numberList) {

        for (String num : numberList) {
            result += Integer.parseInt(num);
        }

        return result;
    }
}
