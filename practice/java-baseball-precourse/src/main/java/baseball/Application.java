package baseball;

import baseball.controllers.NumberBaseballGame;
import baseball.models.ComputerPlayer;
import baseball.models.HumanPlayer;
import baseball.models.Player;
import baseball.utils.DataInputValidation;
import baseball.utils.RandomNumber;
import baseball.views.DataInput;
import baseball.views.DataOutput;

public class Application {
    public static void main(String[] args) {
        //TODO: 숫자 야구 게임 구현
        Player human = new HumanPlayer(new DataInputValidation(), new DataInput());
        Player computer = new ComputerPlayer(new RandomNumber());
        DataOutput output = new DataOutput();
        NumberBaseballGame game = new NumberBaseballGame(human, computer, output);
        game.startGame();
    }
}
