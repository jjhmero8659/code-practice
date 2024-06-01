package Dijkstra;

import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Solution_18223 {
    static int N, M, F;
    static ArrayList<Node>[] graphs;
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

        int[] minjunD = dijkstra(1);
        int[] gunwooD = dijkstra(F);

        if (minjunD[N] == minjunD[F] + gunwooD[N]){
            bw.write("SAVE HIM");
        }
        else{
            bw.write("GOOD BYE");
        }

        bw.flush();
        bw.close();
    }

    static int[] dijkstra(int index){
        PriorityQueue<Node> pq = new PriorityQueue<>(
                (a,b) -> Integer.compare(a.cost,b.cost)
        );

        int[] distance = new int[N + 1];


        for (int i=1; i<=N; i++){
            distance[i] = INF;
        }

        distance[index] = 0;

        pq.offer(new Node(index,0));

        while (!pq.isEmpty()){
            Node now = pq.poll();

            for (Node next : graphs[now.num]){
                if (distance[next.num] > distance[now.num] + next.cost){
                    distance[next.num] = distance[now.num] + next.cost;
                    pq.offer(new Node(next.num , distance[next.num]));
                }
            }
        }

        return distance;
    }


}