package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String userInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");

        String input = Console.readLine();

        // 빈 문자열일 경우 0으로 변경
        if (input.isEmpty()) {
            input = "0";
        }

        return input;
    }
}
