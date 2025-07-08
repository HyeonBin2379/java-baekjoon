package baekjoon.baekjoon05XXX;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise5639 {

    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this(data, null, null);
        }
        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        void insert(int data) {
            if (data < this.data) {
                if (this.left == null) {
                    this.left = new Node(data);
                } else {
                    this.left.insert(data);
                }
            } else {
                if (this.right == null) {
                    this.right = new Node(data);
                } else {
                    this.right.insert(data);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Node root = new Node(Integer.parseInt(br.readLine()));

        String input;
        while ((input = br.readLine()) != null) {
            int num = Integer.parseInt(input);
            root.insert(num);
        }
        postorder(root);
    }

    private static void postorder(Node cur) {
        if (cur == null) {
            return;
        }
        postorder(cur.left);
        postorder(cur.right);
        System.out.println(cur.data);
    }
}
