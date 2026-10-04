import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] array = new int[2001];

        int curr = 1000;
        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            char dir = sc.next().charAt(0);
            // Please write your code here.

            switch (dir) {
                case 'L':
                    for (int j = curr-1; j >= curr-x; j--) {
                        array[j]++;
                    }
                    curr = curr-x;
                    break;
                case 'R':
                    for (int j = curr; j < curr+x; j++) {
                        array[j]++;
                    }
                    curr = curr+x;
                    break;
            }
        }

        int answer = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] >= 2) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}