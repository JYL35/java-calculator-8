package calculator.service;

import java.util.List;

public class CalculatorService {

    private final String delimiter = "[,:]";

    // 숫자 추출
    public List<String> findNumber(String input) {
        List<String> extractedNumbers= List.of(input.split(delimiter));

        return extractedNumbers;
    }
}
