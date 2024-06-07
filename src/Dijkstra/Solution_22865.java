package Dijkstra;

import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Solution_22865 {
    static int N,M;

    static int[] friends;
    static ArrayList<Edge>[] graph;
    static int[][] distance;
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

        StringTokenizer stF = new StringTokenizer(br.readLine()," ");
        friends = new int[3];
        for (int i=0; i<3; i++){
            friends[i] = Integer.parseInt(stF.nextToken());
        }

        M = Integer.parseInt(br.readLine());

        graph = new ArrayList[N+1];
        for (int i=1; i<=N; i++){
            graph[i] = new ArrayList<>();
        }

        for (int i=0; i<M; i++){
            StringTokenizer stD = new StringTokenizer(br.readLine()," ");

            int s = Integer.parseInt(stD.nextToken());
            int e = Integer.parseInt(stD.nextToken());
            int v = Integer.parseInt(stD.nextToken());

            graph[s].add(new Edge(e,v));
            graph[e].add(new Edge(s,v));
        }

        distance = new int[N+1][N+1];

        for (int i=1; i<=N; i++){
            for (int j=1; j<=N; j++){
                if (i != j){
                    distance[i][j] = INF;
                }
            }
        }

        for (int i=1; i<=N; i++){
            dijkstra(i);
        }

        bw.flush();
        bw.close();
    }

    static void dijkstra(int start){
        visited = new boolean[N + 1];
        PriorityQueue<Edge> pq = new PriorityQueue<>(
                (a,b) -> Integer.compare(a.distance,b.distance)
        );

        pq.offer(new Edge(start , 0)); //시작점 추가
        visited[start] = true; //방문 True

        while (!pq.isEmpty()){
            Edge now = pq.poll();

            for (Edge next : graph[now.num]){
                if (visited[next.num] == false){
                    if (distance[start][next.num] > distance[start][now.num] + next.distance){
                        visited[next.num] = true;
                        distance[start][next.num] = distance[start][now.num] + next.distance;
                        pq.offer(new Edge(next.num , distance[start][next.num]));
                    }
                }
            }
        }
    }

}