package baekjoon.baekjoon07XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise7568 {

    static class Person {
        int weight;
        int height;

        public Person(int weight, int height) {
            this.weight = weight;
            this.height = height;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Person[] input = new Person[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            input[i] = new Person(weight, height);
        }

        int[] answer = new int[n];
        Arrays.fill(answer, 1);
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                if (input[i].weight < input[j].weight && input[i].height < input[j].height) {
                    answer[i]++;
                } else if (input[i].weight > input[j].weight && input[i].height > input[j].height) {
                    answer[j]++;
                }
            }
        }
        Arrays.stream(answer).forEach(value -> System.out.print(value + " "));
    }
}
