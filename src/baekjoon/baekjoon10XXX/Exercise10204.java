package baekjoon.baekjoon10XXX;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Exercise10204 {

    private static final int INF = 987654321;
    private static class Edge {
        String node1;
        String node2;
        Edge(String n1, String n2) {
            node1 = n1;
            node2 = n2;
        }
    }

    private static int solveNeighborhoods(int numNodes, ArrayList<Edge> edges, String n) {
        int[][] dist = new int[numNodes+1][numNodes+1];
        for (int i = 0; i <= numNodes; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }
        for (Edge e : edges) {
            int from = e.node1.charAt(1) - '0';
            int to = e.node2.charAt(1) - '0';
            dist[from][to] = 1;
            dist[to][from] = 1;
        }
        for (int k = 1; k <= numNodes; k++) {
            for (int i = 1; i <= numNodes; i++) {
                for (int j = 1; j <= numNodes; j++) {
                    dist[i][j] = Math.min(dist[i][k]+dist[k][j], dist[i][j]);
                }
            }
        }
        int villain = n.charAt(1)-'0';
        return (int) IntStream.rangeClosed(1, numNodes)
                .filter(index -> index != villain && dist[villain][index] <= 2)
                .count();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numTests = sc.nextInt();

        for (int t = 0; t < numTests; t++) {
            int numNodes = sc.nextInt();
            int numEdges = sc.nextInt();
            ArrayList<Edge> edges = new ArrayList<>();
            for(int i = 0; i < numEdges; i++) {
                edges.add(new Edge(sc.next(), sc.next()));
            }
            String n = sc.next();
            int res = solveNeighborhoods(numNodes, edges, n);

            System.out.println("The number of supervillains in 2-hop neighborhood of " + n + " is " + res);
        }

        sc.close();
    }
}
