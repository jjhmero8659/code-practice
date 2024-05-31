package Dijkstra;

import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Solution_18223 {
    static int N, M, F;
    static ArrayList<Node>[] graphs;
    static int[] distance;
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

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken()); //정점 개수
        M = Integer.parseInt(st.nextToken()); //연결 선 개수
        F = Integer.parseInt(st.nextToken()); //건우 의 위치

        graphs = new ArrayList[N + 1];
        distance = new int[N + 1];

        for (int i=1; i<=N; i++){
            graphs[i] = new ArrayList<>();
        }

        for (int i=0; i<M; i++){
            StringTokenizer stD = new StringTokenizer(br.readLine()," ");

            int s = Integer.parseInt(stD.nextToken());
            int e = Integer.parseInt(stD.nextToken());
            int v = Integer.parseInt(stD.nextToken());

            graphs[s].add(new Node(e,v));
            graphs[e].add(new Node(s,v));
        }


        bw.flush();
        bw.close();
    }


}