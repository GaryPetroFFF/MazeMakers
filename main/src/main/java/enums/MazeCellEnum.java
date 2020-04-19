package enums;

public enum MazeCellEnum {
    CELL_0(0),
    CELL_1(1),
    CELL_2(2),
    CELL_3(3),
    CELL_4(4),
    CELL_5(5),
    CELL_6(6),
    CELL_7(7),
    CELL_8(8),
    CELL_9(9),
    CELL_A(10),
    CELL_B(11),
    CELL_C(12),
    CELL_D(13),
    CELL_E(14),
    CELL_F(15);

    private int walls_;

    private MazeCellEnum(int walls) {
        walls_ = walls;
    }

    public boolean isWall(MazeWallEnum side) {
        return (walls_ >> side.getIndex() & 1) == 1;
    }

    public static MazeCellEnum valueOf(char name) {
        switch(name) {
            case '0':
                return CELL_0;
            case '1':
                return CELL_1;
            case '2':
                return CELL_2;
            case '3':
                return CELL_3;
            case '4':
                return CELL_4;
            case '5':
                return CELL_5;
            case '6':
                return CELL_6;
            case '7':
                return CELL_7;
            case '8':
                return CELL_8;
            case '9':
                return CELL_9;
            case 'A':
                return CELL_A;
            case 'B':
                return CELL_B;
            case 'C':
                return CELL_C;
            case 'D':
                return CELL_D;
            case 'E':
                return CELL_E;
            case 'F':
                return CELL_F;
            default:
                return null;
        }
    }
}
