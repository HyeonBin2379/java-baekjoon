import java.util.Scanner;
public class Main {

    private static int[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }
        // Please write your code here.

        map = new int[200][200];
        for (int i = 0; i < n; i++) {
            coloring(y[i], x[i]);
        }

        int count = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 1) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    private static void coloring(int row, int col) {
        for (int i = row; i < row+8; i++) {
            for (int j = col; j < col+8; j++) {
                if (map[i+100][j+100] == 0) {
                    map[i+100][j+100] = 1;
                }
            }
        }
    }
}