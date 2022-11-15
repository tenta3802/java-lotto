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

    public void winningException(String winningNumber) {
        String[] winningNumbers = winningNumber.split(",");
        for (String number : winningNumbers) {
            int count = Collections.frequency(List.of(winningNumbers), number);
            if (count > 1) {
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
            if (number < 0 || number > 45) {
                return false;
            }
        }
        return true;
    }
}
