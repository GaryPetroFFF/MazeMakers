package model;

import enums.MazeMakerEnum;
import enums.MazeWallEnum;
import exceptions.MultiplePathsException;

import java.util.List;

public class Maze {
    private int height_;
    private int width_;
    private MazeCell[][] mazeCells_;
    private MazeCellVisitor visitor_ = new MazeCellVisitor();
    private int visitedCellsCount_;
    private boolean isMultiplePaths_ = false;
    private int exitsCount_ = 0;

    public Maze(int height, int width) {
        height_ = height;
        width_ = width;
        mazeCells_ = new MazeCell[width_][height_];
        visitedCellsCount_ = 0;
    }

    public void setMazeCell(int x, int y, char name) {
        mazeCells_[x][y] = new MazeCell(name, this);
    }

    public MazeMakerEnum checkMaze() {
        visitor_.visit(0, 0, null);
        if (exitsCount_ != 2) {
            return MazeMakerEnum.NO_SOLUTION;
        }
        if (visitedCellsCount_ != height_ * width_) {
            return MazeMakerEnum.UNREACHABLE_CELL;
        }
        if (isMultiplePaths_) {
            return MazeMakerEnum.MULTIPLE_PATHS;
        }
        return MazeMakerEnum.MAZE_OK;
    }

    public void setIsMultiplePaths() { isMultiplePaths_ = true; }

    public void incVisitedCellsCount() { visitedCellsCount_++; }

    class MazeCellVisitor {
        public void visit(int x, int y, MazeWallEnum bannedDirection) {
            List<MazeWallEnum> doors = mazeCells_[x][y].accept();
            doors.remove(bannedDirection);
            for (MazeWallEnum door : doors) {
                switch (door) {
                    case NORTH:
                        if (y - 1 < 0) { exitsCount_++; break; }
                        visit(x, y - 1, MazeWallEnum.SOUTH);
                        break;
                    case EAST:
                        if (x + 1 == width_) { exitsCount_++; break; }
                        visit(x + 1, y, MazeWallEnum.WEST);
                        break;
                    case WEST:
                        if (x - 1 < 0) { exitsCount_++; break; }
                        visit(x - 1, y, MazeWallEnum.EAST);
                        break;
                    case SOUTH:
                        if (y + 1 == height_) { exitsCount_++; break; }
                        visit(x, y + 1, MazeWallEnum.NORTH);
                        break;
                }
            }
        }
    }
}
