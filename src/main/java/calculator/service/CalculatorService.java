package calculator.service;

import calculator.exception.GlobalException;

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

        // 추출된 숫자가 정상인지 확인
        GlobalException.checkExtractedNumber(extractedNumbers);

        return extractedNumbers;
    }

    // 커스텀 구분자 찾기
    public String findCustomDelimiter(String input) {

        if(input.contains(PREFIX_CUSTOM_DELIMITER) && input.contains(SUFFIX_CUSTOM_DELIMITER)) {
            int prefixIdx = input.indexOf(PREFIX_CUSTOM_DELIMITER);
            int suffixIdx = input.indexOf(SUFFIX_CUSTOM_DELIMITER);

            GlobalException.checkCustomDelimiterIndex(prefixIdx);

            // 커스텀 구분자 추출
            String customDelimiter = input.substring(prefixIdx + PREFIX_CUSTOM_DELIMITER.length(), suffixIdx);

            // 커스텀 구분자가 정상인지 확인
            GlobalException.checkCustomDelimiter(customDelimiter);

            return customDelimiter;
        }

        return "";
    }

}
