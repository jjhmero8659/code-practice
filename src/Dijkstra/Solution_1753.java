package Dijkstra;

import java.io.*;
import java.util.*;


public class Solution_1753 {
    static int N,M,SP;
    static ArrayList<Edge>[] nodeList;
    static int[] distance;
    static boolean[] visited;
    static final int INF = 987654321;

    static class Edge {
        int num;
        int distance;
        public Edge(int num, int distance) {
            this.num = num;
            this.distance = distance;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken()); //정점 개수
        M = Integer.parseInt(st.nextToken()); //간선 개수
        
        SP = Integer.parseInt(br.readLine()); //시작 정점

        nodeList = new ArrayList[N+1];
        distance = new int[N+1];
        visited = new boolean[N+1];

        for (int i=1; i<=N; i++){
            nodeList[i] = new ArrayList<>();
        }

        for (int i=1; i<=N; i++){
            distance[i] = INF;
        }

        for (int i=0; i<M; i++){
            StringTokenizer stD = new StringTokenizer(br.readLine()," ");
            int s = Integer.parseInt(stD.nextToken());
            int e = Integer.parseInt(stD.nextToken());
            int v = Integer.parseInt(stD.nextToken());

            nodeList[s].add(new Edge(e,v));
        }

        dijkstra();

        for (int i=1; i<=N; i++){
            if (distance[i] == INF){
                bw.write( "INF\n");
            }
            else{
                bw.write(distance[i] + "\n");
            }
        }


        bw.flush();
        bw.close();
    }

    static void dijkstra() {
        PriorityQueue<Edge> pq = new PriorityQueue<>(
                (a,b) -> Integer.compare(a.distance, b.distance)
        );

        distance[SP] = 0;
        pq.offer(new Edge(SP , 0));

        while (!pq.isEmpty()){
            Edge now = pq.poll();
            int nowN = now.num;

            if (visited[nowN]){
                continue;
            }

            visited[nowN] = true;

            for (Edge next : nodeList[nowN]){
                int nextN = next.num;
                int nextD = next.distance;

                if (distance[nextN] > distance[nowN] + nextD){
                    distance[nextN] = distance[nowN] + nextD;
                    pq.add(new Edge(nextN , distance[nowN] + nextD));
                }
            }
        }
    }

}