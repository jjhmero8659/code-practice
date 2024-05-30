package Dijkstra;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Solution_1238 {
    static int N, M, TP;
    static ArrayList<Node>[] graphs;
    static int[][] distance;
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
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stF = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(stF.nextToken()); //정점 개수
        M = Integer.parseInt(stF.nextToken()); //간선 개수
        TP = Integer.parseInt(stF.nextToken()); //최종 도착점

        graphs = new ArrayList[N + 1];
        distance = new int[N + 1][N + 1];

        for (int i=1; i<=N; i++){
            for (int j=1; j<=N; j++){
                if (i==j){
                    distance[i][j] = 0;
                }
                else{
                    distance[i][j] = INF;
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            graphs[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer stD = new StringTokenizer(br.readLine(), " ");

            int s = Integer.parseInt(stD.nextToken());
            int e = Integer.parseInt(stD.nextToken());
            int v = Integer.parseInt(stD.nextToken());

            graphs[s].add(new Node(e, v));
        }

        for (int i=1; i<=N; i++){
            dijkstra(i);
        }

        bw.write(findLazy() + "\n");

        bw.flush();
        bw.close();
    }

    static void dijkstra(int sP) {
        PriorityQueue<Node> pq = new PriorityQueue<>(
                (a, b) -> Integer.compare(a.cost, b.cost)
        );

        distance[sP][sP] = 0;

        pq.offer(new Node(sP,0));

        while (!pq.isEmpty()){
            Node now = pq.poll();

            for (Node next : graphs[now.num]){
                if (distance[sP][next.num] > distance[sP][now.num] + next.cost){
                    distance[sP][next.num] = distance[sP][now.num] + next.cost;
                    pq.offer(new Node(next.num , distance[sP][next.num]));
                }
            }
        }
    }

    static int findLazy(){
        int min = 0;

        for (int i=1; i<=N; i++){
            min = Math.max(distance[i][TP] + distance[TP][i] , min);
        }

        return min;
    }

}