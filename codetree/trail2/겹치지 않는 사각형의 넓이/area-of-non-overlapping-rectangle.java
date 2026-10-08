import java.util.Scanner;
public class Main {

    private static int[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int ax1 = sc.nextInt();
        int ay1 = sc.nextInt();
        int ax2 = sc.nextInt();
        int ay2 = sc.nextInt();

        int bx1 = sc.nextInt();
        int by1 = sc.nextInt();
        int bx2 = sc.nextInt();
        int by2 = sc.nextInt();
        
        int mx1 = sc.nextInt();
        int my1 = sc.nextInt();
        int mx2 = sc.nextInt();
        int my2 = sc.nextInt();
        // Please write your code here.

        map = new int[2000][2000];
        coloring(ay1, ay2, ax1, ax2, true);
        coloring(by1, by2, bx1, bx2, true);
        coloring(my1, my2, mx1, mx2, false);

        int count = 0;
        for (int i = 0; i < 2000; i++) {
            for (int j = 0; j < 2000; j++) {
                if (map[i][j] == 1) {
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
}