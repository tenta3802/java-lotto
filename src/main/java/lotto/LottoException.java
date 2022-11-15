package lotto;

import java.util.Collections;
import java.util.List;

public class LottoException {

    public void inputMoneyException(int inputMoney) {
        if (!isNumber(inputMoney)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isNumber(int inputMoney) {
        if (inputMoney < 0) {
            return false;
        }
        return true;
    }

    public void winningNumberException(String winningNumber) {
        String[] winningNumbers = winningNumber.split(",");
        for (String number : winningNumbers) {
            int count = Collections.frequency(List.of(winningNumbers), number);
            if (count > 1) {
                System.out.println("[ERROR]: 중복된 숫자는 입력할 수 없습니다.");
                throw new IllegalArgumentException();
            }
            if (winningNumbers.length != 6) {
                System.out.println("[ERROR]: 당청 번호는 총 6자리를 입력해야 합니다.");
                throw new IllegalArgumentException();
            }
        }
    }

    public boolean isDuplicate(List<Integer> numbers) {
        for (int number : numbers) {
            int count = Collections.frequency(numbers, number);
            if (count > 1) {
                return false;
            }
        }
        return true;
    }

    public boolean isOverNumberRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                return false;
            }
        }
        return true;
    }

}
