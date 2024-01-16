package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Exercise1431 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        String[] serialNumber = new String[count];
        for (int i = 0; i < count; i++) {
            serialNumber[i] = br.readLine();
        }
        br.close();

        Arrays.sort(serialNumber, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() != o2.length()) {
                    return o1.length()-o2.length();
                } else if (getSum(o1) != getSum(o2)) {
                    return getSum(o1)-getSum(o2);
                } else {
                    return o1.compareTo(o2);
                }
            }
            public int getSum(String str) {
                int sum = 0;
                for (char x : str.toCharArray()) {
                    if (Character.isDigit(x)) {
                        sum += Integer.parseInt(Character.toString(x));
                    }
                }
                return sum;
            }
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(serialNumber[i]).append("\n");
        }
        System.out.print(sb);
    }
}
