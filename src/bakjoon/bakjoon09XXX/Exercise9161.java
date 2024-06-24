package bakjoon.bakjoon09XXX;

public class Exercise9161 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        for (int i = 100; i < 1000; i++) {
            for (int j = 100; j < 1000; j++) {
                if (i % 111 == 0 && j % 111 == 0) {
                    continue;
                }
                if (i*(j % 100) == j*(i/10) && (i % 10) == (j / 100)) {
                    sb.append(String.format("%d / %d = %d / %d\n", i, j, i/10, j%100));
                }
            }
        }
        System.out.print(sb);
    }
}
