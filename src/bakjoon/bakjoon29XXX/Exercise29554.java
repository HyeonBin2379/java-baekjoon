package bakjoon.bakjoon29XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise29554 {

    private static int n;
    private static int[] jedi, sith;
    private static int[] increase1, increase2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        jedi = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        increase1 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        sith = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        increase2 = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int days = 0; days <= 1000000; days++) {
            if (isAllSkillsNotWorse(days)) {
                System.out.println(days);
                return;
            }
        }
        System.out.println("Strong is dark side of the force.");
    }

    private static boolean isAllSkillsNotWorse(int days) {
        for (int i = 0; i < n; i++) {
            if (jedi[i] + days*increase1[i] < sith[i] + days*increase2[i]) {
                return false;
            }
        }
        return true;
    }
}
