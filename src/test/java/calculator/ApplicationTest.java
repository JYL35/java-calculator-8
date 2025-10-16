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
    @DisplayName("기본 구분자 처리 테스트")
    void findNumberTest() {
        String input = "1,2:5";
        List<String> testNumbers = List.of("1", "2", "5");

        List<String> resultNumbers = calculatorService.findNumber(input);

        assertThat(resultNumbers).containsAll(testNumbers);
    }

    @Test
    @DisplayName("더하기 테스트")
    void addNumberTest() {
        int testNumber = 8;

        List<String> inputNumber = List.of("1", "2", "5");

        int resultNumber = calculator.addNumber(inputNumber);

        assertThat(resultNumber).isEqualTo(testNumber);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}