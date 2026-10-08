import java.util.Scanner;
public class Main {

    private static int[][] map;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x1 = new int[n];
        int[] y1 = new int[n];
        int[] x2 = new int[n];
        int[] y2 = new int[n];
        for (int i = 0; i < n; i++) {
            x1[i] = sc.nextInt();
            y1[i] = sc.nextInt();
            x2[i] = sc.nextInt();
            y2[i] = sc.nextInt();
        }
        // Please write your code here.
        map = new int[200][200];
        for (int i = 0; i < n; i++) {
            coloring(x1[i], y1[i], x2[i], y2[i], i+1);
        }

        int count = 0;
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] > 0 && map[i][j] % 2 == 0) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    private static void coloring(int x1, int y1, int x2, int y2, int color) {
        for (int i = y1; i < y2; i++) {
            for (int j = x1; j < x2; j++) {
                map[i+100][j+100] = color;
            }
        }
    }
}
