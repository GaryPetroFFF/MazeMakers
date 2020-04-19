package enums;

public enum MazeWallEnum {
    NORTH(3),
    EAST(2),
    SOUTH(1),
    WEST(0);

    private final int index_;

    private MazeWallEnum(int index) {
        this.index_ = index;
    }

    public int getIndex() { return index_; }
}
