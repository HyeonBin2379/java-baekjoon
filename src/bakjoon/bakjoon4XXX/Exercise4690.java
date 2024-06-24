package bakjoon.bakjoon4XXX;

public class Exercise4690 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        for (int a = 6; a <= 100; a++) {
            for (int b = 2; b <= a; b++) {
                for (int c = b; c <= a; c++) {
                    for (int d = c; d <= a; d++) {
                        if (a*a*a == b*b*b + c*c*c + d*d*d) {
                            sb.append(String.format("Cube = %d, Triple = (%d,%d,%d)\n", a, b, c, d));
                        }
                    }
                }
            }
        }
        System.out.print(sb);
    }
}
