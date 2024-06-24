package bakjoon.bakjoon30XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Exercise30552 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<String> absent = new Stack<>();
        int count = Integer.parseInt(br.readLine());
        for (int i = 0; i < count; i++) {
            String name = br.readLine();
            if (name.equals("Present!")) {
                absent.pop();
                continue;
            }
            absent.push(name);
        }

        if (absent.isEmpty()) {
            System.out.println("No Absences");
            return;
        }
        for (String name : absent) {
            System.out.println(name);
        }
    }
}
