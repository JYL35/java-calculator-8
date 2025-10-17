package calculator.service;

import java.util.List;

public class CalculatorService {

    private final String BASIC_DELIMITER = "[,:]";
    private final String PREFIX_CUSTOM_DELIMITER = "//";
    private final String SUFFIX_CUSTOM_DELIMITER = "\\n";

    // 숫자 추출
    public List<String> findNumber(String input) {
        List<String> extractedNumbers = List.of(input.split(BASIC_DELIMITER));

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
