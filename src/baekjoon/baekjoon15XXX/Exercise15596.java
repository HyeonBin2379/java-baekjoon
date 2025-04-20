package baekjoon.baekjoon15XXX;

public class Exercise15596 {

    public static void main(String[] args) {
        System.out.println(sum(new int[] {1, 2, 3, 4}));
    }

    private static long sum(int[] a) {
        long ans = 0;
        for (int j : a) {
            ans += j;
        }
        return ans;
    }
}
