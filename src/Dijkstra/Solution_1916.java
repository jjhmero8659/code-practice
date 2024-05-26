package Dijkstra;

import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Solution_1916 {
    static int N,M,SP,EP;
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

        N = Integer.parseInt(br.readLine()); //도시 개수
        M = Integer.parseInt(br.readLine()); //버스 개수

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
        
        StringTokenizer stP = new StringTokenizer(br.readLine()," ");

        SP = Integer.parseInt(stP.nextToken());
        EP = Integer.parseInt(stP.nextToken());

        distance[SP] = 0;

        dijkstra();

        bw.write(distance[EP] + "\n");
        bw.flush();
        bw.close();
    }

    static void dijkstra() {
        PriorityQueue<Edge> pq = new PriorityQueue<>(
                (a,b) -> Integer.compare(a.distance,b.distance)
        );

        pq.offer(new Edge(SP,0)); //처음 시작점

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
                    pq.offer(new Edge(nextN, distance[nextN]));
                }
            }
        }

    }

}