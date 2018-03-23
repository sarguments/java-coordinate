package saru.view;

import saru.domain.Line;
import saru.domain.Point;

import java.util.*;

public class Output {
    public static final int MAX_VALUE = 25;
    private static final int EVEN = 2;

    private List<Line> lines;

    public Output(List<Line> lines) {
        this.lines = lines;
    }

    public void printVerticalAxis() {
        // 한줄씩 출력
        for (int i = 0; i < MAX_VALUE; i++) {
            // 수평 출력
            printLine(i);
            System.out.println();
        }
    }

    private void printLine(int row) {
        Line line = lines.get(row);

        // 하나씩 출력
        List<Point> points = line.getPoints();
        List<String> verticalNum = generateReverse();

        for (int j = 0; j < points.size(); j++) {
            Point point = points.get(j);
            if (printDot(point)) {
                continue;
            }

            if (j == 0) {
                System.out.print(verticalNum.get(row));
            }

            printSymbol(row, j);
        }
    }

    private boolean printDot(Point point) {
        if (point.isExist()) {
            System.out.printf("%-2s", ".");
            return true;
        }
        return false;
    }

    private void printSymbol(int row, int column) {
        if (row == (MAX_VALUE - 1) && column == 0) {
            System.out.printf("%-2s", "+");
            return;
        }

        if (column == 0) {
            System.out.printf("%-2s", "|");
            return;
        }

        if (row == (MAX_VALUE - 1)) {
            System.out.printf("%-2s", "-");
            return;
        }

        System.out.printf("%-2s", " ");
    }

    public void printHorizontalAxis() {
        printHorizontalNum();
    }

    private void printHorizontalNum() {
        List<Integer> genList = generate(0, MAX_VALUE);
        System.out.print("  ");
        for (int i : genList) {
            System.out.printf("%-4d", i);
        }
    }

    private void insertNum(List<Integer> resultList, int i) {
        if (i % EVEN == 0) {
            resultList.add(i);
        }
    }

    public List<String> generateReverse() {
        List<String> resultList = Arrays.asList("24", "  ", "22", "  ", "20",
                "  ", "18", "  ", "16", "  ", "14", "  ", "12", "  ", "10",
                "  ", " 8", "  ", " 6", "  ", " 4", "  ", " 2", "  ", "  ");
        return resultList;
    }

    public List<Integer> generate(int start, int end) {
        List<Integer> resultList = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            insertNum(resultList, i);
        }
        return resultList;
    }
}