package bakjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Exercise1991 {
    private static final Map<String, List<String>> tree = new LinkedHashMap<>();
    private static String answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int nodeCount = Integer.parseInt(br.readLine());
        for (int i = 0; i < nodeCount; i++) {
            String[] tokens = br.readLine().split(" ");
            for (int j = 1; j < tokens.length; j++) {
                if (!tree.containsKey(tokens[0])) {
                    tree.put(tokens[0], new ArrayList<>());
                }
                tree.get(tokens[0]).add(tokens[j]);
            }
        }
        br.close();

        answer = "";
        preOrder("A");
        System.out.println(answer);
        answer = "";
        inOrder("A");
        System.out.println(answer);
        answer = "";
        postOrder("A");
        System.out.println(answer);
    }

    public static void preOrder(String currNode) {
        if (currNode.equals(".")) {
            return;
        }
        answer += currNode;
        preOrder(tree.get(currNode).get(0));
        preOrder(tree.get(currNode).get(1));
    }
    public static void inOrder(String currNode) {
        if (currNode.equals(".")) {
            return;
        }
        inOrder(tree.get(currNode).get(0));
        answer += currNode;
        inOrder(tree.get(currNode).get(1));
    }
    public static void postOrder(String currNode) {
        if (currNode.equals(".")) {
            return;
        }
        postOrder(tree.get(currNode).get(0));
        postOrder(tree.get(currNode).get(1));
        answer += currNode;
    }
}
