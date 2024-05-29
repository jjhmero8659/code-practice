package Dijkstra;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Solution_14284 {
    static int N, M, SP, EP;
    static ArrayList<Node>[] graphs;
    static boolean[] visited;
    static int[] distance;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static final int INF = 987654321;

    static class Node {
        int num;
        int cost;

        public Node(int num, int cost) {
            this.num = num;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graphs = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        distance = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            graphs[i] = new ArrayList<>();
        }

        for (int i = 0; i <= N; i++) {
            distance[i] = INF;
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer stD = new StringTokenizer(br.readLine(), " ");

            int s = Integer.parseInt(stD.nextToken());
            int e = Integer.parseInt(stD.nextToken());
            int v = Integer.parseInt(stD.nextToken());

            graphs[s].add(new Node(e, v));
            graphs[e].add(new Node(s, v));
        }

        StringTokenizer stP = new StringTokenizer(br.readLine(), " ");

        SP = Integer.parseInt(stP.nextToken());
        EP = Integer.parseInt(stP.nextToken());

        dijkstra();

        bw.write(distance[EP] + "\n");

        bw.flush();
        br.close();
        bw.close();
    }

    static void dijkstra() {
        distance[SP] = 0;
        visited[SP] = true;

        PriorityQueue<Node> pq = new PriorityQueue<>(
                (a, b) -> Integer.compare(a.cost, b.cost)
        );

        pq.offer(new Node(SP, 0));

        while (!pq.isEmpty()) {
            Node now = pq.poll();

            for (Node next : graphs[now.num]) {

                if (visited[next.num] == false) {
                    if (distance[next.num] > distance[now.num] + next.cost) {
                        distance[next.num] = distance[now.num] + next.cost;
                        pq.offer(new Node(next.num, distance[next.num]));
                    }
                }
            }
        }
    }


}