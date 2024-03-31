package Dijkstra;

import java.io.*;
import java.util.*;


public class Solution_5972 {
    static int N, M;
    static ArrayList<Info>[] graphs;
    static boolean[] visited;

    static int[] distance;
    static class Info {
        int s;

        int d;

        Info(int s, int d) {
            this.s = s;
            this.d = d;
        }

    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stF = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(stF.nextToken()); //정점 개수
        M = Integer.parseInt(stF.nextToken()); //간선 개수

        graphs = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        distance = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            graphs[i] = new ArrayList<>();
        }


        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int sp = Integer.parseInt(st.nextToken());
            int ep = Integer.parseInt(st.nextToken());
            int stover = Integer.parseInt(st.nextToken());

            graphs[sp].add(new Info(ep, stover));
            graphs[ep].add(new Info(sp, stover));
        }

        Arrays.fill(distance,Integer.MAX_VALUE);

        dijkstra();
        bw.write(distance[N] + "\n");

        bw.flush();
        bw.close();
    }

    static void dijkstra() {
        PriorityQueue<Info> pQ = new PriorityQueue<>((a,b) -> a.d - b.d); //거리순으로 우선 정렬
        pQ.add(new Info(1,0));
        distance[1] = 0;

        while (!pQ.isEmpty()){
            Info poll = pQ.poll();
            int n = poll.s;
            int d = poll.d;

            for (Info next : graphs[n]){
                int nextN = next.s;
                int nextD = d + next.d;
                if (distance[nextN] > nextD){ //현재 저장되어 있는 거리가 계산할 거리보다 크다면 갱신
                    distance[nextN] = nextD;
                    pQ.add(new Info(nextN,nextD));
                }
            }

        }
    }

}