package controller;

import lotto.*;
import view.InputView;
import view.OutputView;

import java.util.List;

public class MainController {
    private int money;
    private int lottoCount;
    private List<List<Integer>> lotteries;
    private int bonusNumber;
    private String winningNumbers;
    private List<Integer> winningLottery;
    int[] winningNumberCount;
    private final String MONEY_INPUT_ERROR = "[ERROR]: 숫자 외 다른 문자를 입력하셨습니다.";

    public void run() {
        moneyController();
    }

    public void moneyController() {
        try {
            money = InputView.inputMoney();
        } catch (IllegalArgumentException e) {
            System.out.println(MONEY_INPUT_ERROR);
            new LottoException().inputMoneyException(money);
        }
        lottoCount = new LottoStore().calculatePurchasedLottoCount(money);
        OutputView.printLottoCount(lottoCount);
        makeLottoController();
    }

    public void makeLottoController() {
        lotteries = new LottoMachine().createLotto(lottoCount);
        OutputView.printLotteries(lotteries);
        makeWinningLottoController();
    }

    public void makeWinningLottoController() {
        winningNumbers = InputView.inputWinningNumbers();
        new LottoException().winningException(winningNumbers);
        winningLottery = new WinningLotto().creteWinningNumbers(winningNumbers);
        compareLottoController();
    }

    public void compareLottoController() {
        bonusNumber = InputView.inputBonusNumber();
        winningNumberCount = new LottoBank().compareBonusNumber(lottoCount, bonusNumber,
                lotteries, winningLottery);
        OutputView.printResult(winningNumberCount);
        OutputView.printWinningMessage();
        profitRateController();
    }

    public void profitRateController() {
        double profitRate = new LottoBank().calculateTotalMoney(winningNumberCount, money);
        OutputView.printProfitRate(profitRate);
    }
}
