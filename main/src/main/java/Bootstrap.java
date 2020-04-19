import enums.MazeMakerEnum;
import model.Maze;
import model.MazeChecker;

import java.util.ArrayList;
import java.util.List;

public class Bootstrap {
    public static void main(String[] args) {
        MazeChecker mazeChecker = new MazeChecker();
        mazeChecker.input();
        mazeChecker.check();
        mazeChecker.output();
    }
}
