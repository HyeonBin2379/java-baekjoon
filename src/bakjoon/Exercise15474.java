package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exercise15474 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        br.close();
        int setACost = (int) Math.ceil((double)input[0]/input[1])*input[2];
        int setBCost = (int) Math.ceil((double)input[0]/input[3])*input[4];
        System.out.println(Math.min(setACost, setBCost));
    }
}
