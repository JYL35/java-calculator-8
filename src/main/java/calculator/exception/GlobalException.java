package calculator.exception;

import java.util.List;

public class GlobalException {

    public static void checkExtractedNumber(List<String> numbers) {
        try {
            for (String num : numbers) {
                // 추출된 숫자에 문자열이 포함되어있을 경우 예외 발생
                double changedNum = Double.parseDouble(num);

                // 음수일 경우 예외 발생
                if(changedNum < 0) {
                    throw new IllegalArgumentException();
                }
            }
        }
        catch(NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkCustomDelimiterIndex(int prefixIdx) {
        if (prefixIdx != 0) {
            // "//"가 문자열 처음이 아니면 예외 발생
            throw new IllegalArgumentException();
        }
    }

    public static void checkCustomDelimiter(String delimiter) {
        try {
            // 커스텀 구분자가 입력되지 않은 경우 예외 발생
            if (delimiter.isEmpty()) {
                throw new IllegalArgumentException();
            }

            // 커스텀 구분자가 숫자인 경우 예외 발생
            if (delimiter.matches("[+-]?\\d*(\\.\\d+)?")) {
                throw new IllegalArgumentException();
            }
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
