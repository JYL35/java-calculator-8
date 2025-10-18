package calculator;

import calculator.model.Calculator;
import calculator.service.CalculatorService;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ApplicationTest extends NsTest {
    CalculatorService calculatorService = new CalculatorService();
    Calculator calculator = new Calculator();

    @Test
    @DisplayName("숫자 추출 테스트")
    void findNumberTest() {
        String input = "1,2:5";
        List<String> testNumbers = List.of("1", "2", "5");

        List<String> resultNumbers = calculatorService.findNumber(input, "[,:]");

        assertThat(resultNumbers).containsAll(testNumbers);
    }

    @Test
    @DisplayName("더하기 테스트")
    void addNumberTest() {
        double testNumber = 8;

        List<String> inputNumber = List.of("1", "2", "5");

        double resultNumber = calculator.addNumber(inputNumber);

        assertThat(resultNumber).isEqualTo(testNumber);
    }

    @Test
    @DisplayName("커스텀 구분자 추출 테스트")
    void findCustomDelimiterTest() {
        String input = "//;\\n3;4;5";
        String testDelimiter = ";";

        String resultDelimiter = calculatorService.findCustomDelimiter(input);

        assertThat(resultDelimiter).isEqualTo(testDelimiter);
    }

    @Test
    @DisplayName("구분자 별 숫자 추출 테스트(기본 구분자)")
    void findNumByDelimiterTest1() {
        String input = "3,4:5";
        List<String> testNumbers = List.of("3", "4", "5");

        List<String> resultNumbers = calculatorService.findNumByDelimiter(input);

        assertThat(resultNumbers).containsAll(testNumbers);
    }

    @Test
    @DisplayName("구분자 별 숫자 추출 테스트(커스텀 구분자)")
    void findNumByDelimiterTest2() {
        String input = "//;\\n3;4;5:6,7";
        List<String> testNumbers = List.of("3", "4", "5", "6", "7");

        List<String> resultNumbers = calculatorService.findNumByDelimiter(input);

        assertThat(resultNumbers).containsAll(testNumbers);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}