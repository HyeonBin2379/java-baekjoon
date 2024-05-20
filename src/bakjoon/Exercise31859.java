package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Exercise31859 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int regNum = Integer.parseInt(st.nextToken());
        String input = st.nextToken();

        String newStr = Arrays.stream(input.split("")).distinct().collect(Collectors.joining());
        int num = input.length()-newStr.length() + 4;
        StringBuilder sb = new StringBuilder((regNum+1906) + newStr + num);
        System.out.println("smupc_" + sb.reverse());
    }
}
