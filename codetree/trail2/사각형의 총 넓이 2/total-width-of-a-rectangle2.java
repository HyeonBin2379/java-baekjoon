import java.util.Scanner;
public class Main {
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

        int[][] map = new int[200][200];
        for (int i = 0; i < n; i++) {
            for (int j = y1[i]; j < y2[i]; j++) {
                for (int k = x1[i]; k < x2[i]; k++) {
                    if (map[j+100][k+100] == 0) {
                        map[j+100][k+100] = 1;
                    }
                }
            }
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
}