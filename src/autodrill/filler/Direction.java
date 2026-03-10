package autodrill.filler;

import arc.math.geom.Point2;

/**
 * 4방향(상하좌우)을 정의하는 열거형
 * 드릴의 출력 방향 및 좌표 계산에 사용됨
 */
public enum Direction {
    RIGHT(new Point2(1, 0), 0),
    UP(new Point2(0, 1), 1),
    LEFT(new Point2(-1, 0), 2),
    DOWN(new Point2(0, -1), 3);

    public final Point2 p;
    public final int r;

    Direction(Point2 p, int r) {
        this.p = p;
        this.r = r;
    }

    public int primaryAxis(Point2 p) {
        return p.x * this.p.x + p.y * this.p.y;
    }

    public int secondaryAxis(Point2 p) {
        return p.x * this.p.y + p.y * this.p.x;
    }

    public static Direction getOpposite(Direction direction) {
        switch (direction) {
            case RIGHT -> {
                return LEFT;
            }
            case UP -> {
                return DOWN;
            }
            case LEFT -> {
                return RIGHT;
            }
            default -> {
                return UP;
            }
        }
    }
}
