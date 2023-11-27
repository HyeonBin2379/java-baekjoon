import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.StringTokenizer;

public class Exercise24092 {
    private static Long[] original;
    private static Long[] answer;
    private static int flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        original = new Long[len];
        for (int i = 0; i < original.length; i++) {
            original[i] = Long.parseLong(st.nextToken());
        }

        answer = new Long[len];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < answer.length; i++) {
            answer[i] = Long.parseLong(st.nextToken());
        }
        br.close();

        flag = 0;
        compareArray();
        quickSort(0, original.length-1);
        System.out.println(flag);
    }

    public static void quickSort(int start, int end) {
        if (start >= end || flag == 1) {
            return;
        }

        int pivot = partition(start, end);
        quickSort(start, pivot-1);
        quickSort(pivot+1, end);
    }
    public static int partition(int start, int end) {
        long pivot = original[end];
        int leftPos = start;
        int rightPos = end;

        while (leftPos < rightPos) {
            while (leftPos < rightPos && original[leftPos] < pivot) {
                leftPos++;
            }
            while (leftPos < rightPos && original[rightPos] >= pivot) {
                rightPos--;
            }

            swap(leftPos, rightPos);
            compareArray();
        }
        swap(rightPos, end);
        compareArray();
        return rightPos;
    }
    public static void swap(int i, int j) {
        long temp = original[i];
        original[i] = original[j];
        original[j] = temp;
    }
    public static void compareArray() {
        for (int i = 0; i < original.length; i++) {
            if (!Objects.equals(original[i], answer[i])) {
                return;
            }
        }
        flag = 1;
    }
}
