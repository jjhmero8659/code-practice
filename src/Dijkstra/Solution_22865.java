package Dijkstra;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Solution_22865 {
    static int N, M;

    static ArrayList<Integer> friends;
    static ArrayList<Edge>[] graph;
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

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); //정점 개수

        StringTokenizer stF = new StringTokenizer(br.readLine(), " ");
        friends = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            friends.add(Integer.parseInt(stF.nextToken()));
        }

        M = Integer.parseInt(br.readLine());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer stD = new StringTokenizer(br.readLine(), " ");

            int s = Integer.parseInt(stD.nextToken());
            int e = Integer.parseInt(stD.nextToken());
            int v = Integer.parseInt(stD.nextToken());

            graph[s].add(new Edge(e, v));
            graph[e].add(new Edge(s, v));
        }

        int[] dist1 = dijkstra(friends.get(0));
        int[] dist2 = dijkstra(friends.get(1));
        int[] dist3 = dijkstra(friends.get(2));

        int[] minD = new int[N + 1];
        for (int i=1; i<=N; i++){
            minD[i] = Math.min(dist1[i], Math.min(dist2[i], dist3[i]));
        }

        int maxD = 0;
        int resultN = -1;

        for (int i=1; i<=N; i++){
            if (maxD < minD[i]){
                maxD = minD[i];
                resultN = i;
            }
        }

        bw.write(resultN + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static int[] dijkstra(int start) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist , Integer.MAX_VALUE);

        dist[start] = 0;

        PriorityQueue<Edge> pq = new PriorityQueue<>(
                (a, b) -> Integer.compare(a.distance, b.distance)
        );

        pq.offer(new Edge(start, 0)); //시작점 추가

        while (!pq.isEmpty()) {
            Edge now = pq.poll();
            int cur = now.num;

            for (Edge next : graph[now.num]) {
                int nextNum = next.num;
                int nextD = next.distance;
                if (dist[nextNum] > dist[cur] + nextD) {
                    dist[nextNum] = dist[cur] + nextD;
                    pq.offer(new Edge(nextNum , dist[nextNum]));
                }
            }
        }

        return dist;
    }
}

