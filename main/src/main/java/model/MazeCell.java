package model;

import enums.MazeCellEnum;
import enums.MazeWallEnum;
import model.Maze;

import java.util.ArrayList;
import java.util.List;

public class MazeCell {
    private Maze maze_;
    private MazeCellEnum mazeCell_;
    private boolean isVisited_;

    public MazeCell(char name, Maze maze) {
        maze_ = maze;
        mazeCell_ = MazeCellEnum.valueOf(name);
        isVisited_ = false;
    }

    public List<MazeWallEnum> accept(){
        if (isVisited_) { maze_.setIsMultiplePaths(); return new ArrayList<>(); }
        isVisited_ = true;
        maze_.incVisitedCellsCount();
        List<MazeWallEnum> doors = new ArrayList<>();
        for (MazeWallEnum side: MazeWallEnum.values()) {
            if (!mazeCell_.isWall(side)) {
                doors.add(side);
            }
        }
        return doors;
    }
}
