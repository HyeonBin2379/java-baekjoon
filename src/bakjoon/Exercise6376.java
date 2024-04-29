package bakjoon;

public class Exercise6376 {

    private static int[] fact;

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        fact = new int[10];
        for (int i = 0; i < 10; i++) {
            if (i < 2) {
                fact[i] = 1;
            } else {
                fact[i] = fact[i-1] * i;
            }
        }

        sb.append("n e\n").append("- -----------\n");
        for (int i = 0; i < 10; i++) {
            double e = getE(i);
            if (i < 2) {
                sb.append(String.format("%d %.0f\n", i, e));
            } else if (i == 2) {
                sb.append(String.format("%d %.1f\n", i, e));
            } else {
                sb.append(String.format("%d %.9f\n", i, e));
            }
        }
        System.out.print(sb);
    }

    private static double getE(int n) {
        double result = 0.0;
        for (int i = 0; i <= n; i++) {
            result += (double) 1 / fact[i];
        }
        return result;
    }
}
