import java.util.Scanner;

public class Main {

    private static int[][] map;
    private static int count;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rect1_x1 = sc.nextInt();
        int rect1_y1 = sc.nextInt();
        int rect1_x2 = sc.nextInt();
        int rect1_y2 = sc.nextInt();
        
        int rect2_x1 = sc.nextInt();
        int rect2_y1 = sc.nextInt();
        int rect2_x2 = sc.nextInt();
        int rect2_y2 = sc.nextInt();
        // Please write your code here.

        map = new int[2000][2000];
        coloring(rect1_y1, rect1_y2, rect1_x1, rect1_x2, true);
        coloring(rect2_y1, rect2_y2, rect2_x1, rect2_x2, false);

        int minRow = 0, maxRow = 0;
        int minCol = 0, maxCol = 0;
        int count = 0;
        for (int i = rect1_y1; i < rect1_y2; i++) {
            for (int j = rect1_x1; j < rect1_x2; j++) {
                if (map[i+1000][j+1000] == 1) {
                    if (count == 0) {
                        minRow = i;
                        minCol = j;
                        maxRow = i;
                        maxCol = j;
                        count++;
                    }
                    minRow = Math.min(i, minRow);
                    minCol = Math.min(j, minCol);
                    maxRow = Math.max(i, maxRow);
                    maxCol = Math.max(j, maxCol);
                }
            }
        }

        count = 0;
        if (!isSamePoint(minRow, minCol, maxRow, maxCol)) {
            for (int i = minRow; i <= maxRow; i++) {
                for (int j = minCol; j <= maxCol; j++) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    private static void coloring(int minRow, int maxRow, int minCol, int maxCol, boolean isColor) {
        for (int i = minRow; i < maxRow; i++) {
            for (int j = minCol; j < maxCol; j++) {
                map[i+1000][j+1000] = isColor ? 1 : 0;
            }
        }
    }

    private static boolean isSamePoint(int minRow, int minCol, int maxRow, int maxCol) {
        return minRow == maxRow && minCol == maxCol;
    }
 }