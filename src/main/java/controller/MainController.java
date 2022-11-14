package controller;

import lotto.LottoBank;
import lotto.LottoMachine;
import lotto.LottoStore;
import lotto.WinningLotto;
import view.InputView;
import view.OutputView;

import java.util.List;

public class MainController {
    private int lottoCount;
    private int bonusNumber;
    private List<List<Integer>> totalLotteries;
    private List<Integer> winningNumbers;

    public void run() {
        moneyController();
    }

    public void moneyController() {
        int inputMoney = InputView.inputMoney();
        lottoCount = new LottoStore().calculateLottoCount(inputMoney);
        OutputView.printLottoCount(lottoCount);
        makeLottoController();
    }

    public void makeLottoController() {
        totalLotteries = new LottoMachine().createLotto(lottoCount);
        new LottoMachine().sortLottoNumbers(totalLotteries);
        OutputView.printLotteries(totalLotteries);
        makeWinningLottoController();
    }

    public void makeWinningLottoController() {
        String winningNumber = InputView.inputWinningNumber();
        winningNumbers = new WinningLotto().creteWinningNumbers(winningNumber);
        compareController();
    }

    public void compareController() {
        new LottoBank().calculateWinningMatchNumber(lottoCount, totalLotteries, winningNumbers);
        bonusNumber = InputView.inputBonusNumber();
        int [] winningNumberMatchCount = new LottoBank().compareBonusNumber(lottoCount, bonusNumber,
                totalLotteries, winningNumbers);
        OutputView.printResult(winningNumberMatchCount);
    }
}
