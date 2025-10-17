package calculator.service;

import java.util.List;

public class CalculatorService {

    private final String BASIC_DELIMITER = "[,:]";
    private final String PREFIX_CUSTOM_DELIMITER = "//";
    private final String SUFFIX_CUSTOM_DELIMITER = "\\n";

    // 구분자 별 숫자 추출
    public List<String> findNumByDelimiter(String input) {
        String customDelimiter = findCustomDelimiter(input);

        if(customDelimiter.isEmpty()) {
            return findNumber(input, BASIC_DELIMITER);
        }

        // custom 구분자가 존재할 경우 뒤의 식만 따로 추출
        String subInput = input.substring(input.indexOf(SUFFIX_CUSTOM_DELIMITER) + 2, input.length());

        return findNumber(subInput, customDelimiter + "|" + BASIC_DELIMITER);
    }

    // 숫자 추출
    public List<String> findNumber(String input, String delimiter) {
        List<String> extractedNumbers = List.of(input.split(delimiter));

        return extractedNumbers;
    }

    // 커스텀 구분자 찾기
    public String findCustomDelimiter(String input) {

        if(input.contains(PREFIX_CUSTOM_DELIMITER) && input.contains(SUFFIX_CUSTOM_DELIMITER)) {
            int prefixIdx = input.indexOf(PREFIX_CUSTOM_DELIMITER);
            int suffixIdx = input.indexOf(SUFFIX_CUSTOM_DELIMITER);

            if (prefixIdx != 0 || suffixIdx == 2) {
                // "//"가 문자열 처음이 아니면 예외, "\n"이 index 2에 위치해있으면 커스텀 구분자가 없으므로 예외
                System.out.println("예외 발생! 추후에 개발");
            }

            // 커스텀 구분자 추출
            String customDelimiter = input.substring(prefixIdx + PREFIX_CUSTOM_DELIMITER.length(), suffixIdx);

            return customDelimiter;
        }

        return "";
    }

}
