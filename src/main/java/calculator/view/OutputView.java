package calculator.view;

public class OutputView {

    public void resultOutput(double number) {
        Object result = formatOutput(number);

        System.out.println("결과 : " + result);
    }

    public Object formatOutput(double number) {
        if (number % 1 == 0) {
            return (long) number;
        }
        return number;
    }
}
