package bakjoon.bakjoon2XXX;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Exercise2042 {
    private static long[] arr;
    private static long[] tree;
    private static long diff, right;
    private static int index, left;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] NMK = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        arr = new long[NMK[0]];
        tree = new long[NMK[0]*4];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
        setTree(0, arr.length-1, 1);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < NMK[1]+NMK[2]; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());
            if (a == 1) {
                index = b - 1;
                diff = c - arr[b - 1];
                changeValue(0, arr.length - 1, 1);
            } else {
                left = b-1;
                right = c-1;
                bw.write(getSum(0, arr.length-1, 1) + "\n");
            }
        }
        br.close();
        bw.flush();
        bw.close();
    }

    public static long setTree(int start, int end, int nodeNum) {
        if (start == end) {
            return tree[nodeNum] = arr[start];
        } else {
            int mid = (start + end) / 2;
            return tree[nodeNum] = setTree(start, mid, nodeNum*2) + setTree(mid+1, end, nodeNum*2+1);
        }
    }
    public static void changeValue(int start, int end, int node) {
        if (index < start || index > end) { // 범위 밖에 있는 경우
            return;
        }

        tree[node] += diff; // 우선 트리의 값을 바꿈
        if (start == end) { // leaf 노드인 경우
            arr[index] = tree[node];
            return;
        }
        // 하위에 있는 노드도 바꿔줌
        int mid = (start + end) / 2;
        changeValue(start, mid, node * 2);
        changeValue(mid + 1, end, node * 2 + 1);
    }
    public static long getSum(int start, int end, int node) {
        if (left > end || right < start) {
            return 0;
        }
        if (left <= start && end <= right) {
            return tree[node];
        }
        int mid = (start + end) / 2;
        return getSum(start, mid, node*2) + getSum(mid+1, end, node*2+1);
    }
}
