package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;

public class Exercise30445 {

    private static final Set<Character> happy = Set.of('H', 'A', 'P', 'Y');
    private static final Set<Character> sad = Set.of('S', 'A', 'D');

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine();
        int happyCnt = (int) word.chars().filter(value -> happy.contains((char)value)).count();
        int sadCnt = (int) word.chars().filter(value -> sad.contains((char)value)).count();

        if (happyCnt == 0 && sadCnt == 0) {
            System.out.printf("%.2f\n", 50.0);
        } else {
            System.out.printf("%.2f\n", (double)happyCnt*100/(happyCnt+sadCnt));
        }
    }
}
