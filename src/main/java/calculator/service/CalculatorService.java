package calculator.service;

import java.util.List;

public class CalculatorService {

    private final String delimiter = "[,:]";

    // 기본 구분자 처리
    public List<String> findNumber(String input) {
        List<String> extractedNumbers= List.of(input.split(delimiter));

        return extractedNumbers;
    }
}
