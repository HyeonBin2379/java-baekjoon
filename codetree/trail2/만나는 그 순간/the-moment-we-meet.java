import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Main {
    public static char[] d = new char[1000];
    public static int[] t = new int[1000];
    public static char[] d2 = new char[1000];
    public static int[] t2 = new int[1000];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        for (int i = 0; i < n; i++) {
            d[i] = sc.next().charAt(0);
            t[i] = sc.nextInt();
        }

        for (int i = 0; i < m; i++) {
            d2[i] = sc.next().charAt(0);
            t2[i] = sc.nextInt();
        }

        // Please write your code here.
        List<Integer> moveA = getTimeLine(n, d, t);
        List<Integer> moveB = getTimeLine(m, d2, t2);

        int timeRange = Math.min(moveA.size(), moveB.size());
        int answer = -1;
        for (int i = 1; i < timeRange; i++) {
            int a = moveA.get(i);
            int b = moveB.get(i);

            if (a == b) {
                answer = i;
                break;
            }
        }
        System.out.println(answer);
    }

    private static List<Integer> getTimeLine(int n, char[] d, int[] t) {
        List<Integer> move = new ArrayList<>();
        move.add(0);
        for (int i = 0; i < n; i++) {
            int inc = d[i] == 'R' ? 1 : -1;
            for (int j = 1; j <= t[i]; j++) {
                int curr = move.get(move.size()-1);
                move.add(curr+inc);
            }
        }
        return move;
    }
}