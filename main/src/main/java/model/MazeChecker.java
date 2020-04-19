package model;

import enums.MazeMakerEnum;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class MazeChecker {
    private List<Maze> mazeList_ = new ArrayList<>();
    private List<MazeMakerEnum> resultList_ = new ArrayList<>();

    public void input() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Input.txt"));
            String input;
            Integer height = null;
            Integer width = null;
            while (!(input = reader.readLine()).equals("0 0")) {
                height = Integer.valueOf(input.substring(0, input.indexOf(' ')));
                width = Integer.valueOf(input.substring(input.indexOf(' ') + 1));
                Maze maze = new Maze(height, width);
                for (int y = 0; y < height; y++) {
                    input = reader.readLine();
                    for (int x = 0; x < width; x++) {
                        maze.setMazeCell(x, y, input.charAt(x));
                    }
                }
                mazeList_.add(maze);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void check() {
        for (Maze maze: mazeList_) {
            resultList_.add(maze.checkMaze());
        }
    }

    public void output() {
        for (MazeMakerEnum result: resultList_) {
            System.out.println(result);
        }
    }
}
