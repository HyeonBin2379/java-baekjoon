package algorithm.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Exercise1822 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Set<Integer> setA = Arrays.stream(br.readLine().split(" ", n))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(TreeSet::new));
        Set<Integer> setB = Arrays.stream(br.readLine().split(" ", m)).map(Integer::parseInt).collect(Collectors.toSet());

        for (Integer element : setB) {
            setA.remove(element);
        }

        System.out.println(setA.size());
        setA.forEach(value -> System.out.print(value + " "));
    }
}
