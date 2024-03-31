package BFS;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Solution_1446 {
    static int N, M;
    static ArrayList<Info>[] road;
    static boolean[] visited;
    static long minD = Long.MAX_VALUE;

    static class Info {
        int e, d;

        Info(int e, int d) {
            this.e = e;
            this.d = d;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stF = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(stF.nextToken());
        M = Integer.parseInt(stF.nextToken());

        road = new ArrayList[10000 + 1];
        visited = new boolean[10000 + 1];


        for (int i = 0; i <= 10000; i++) {
            road[i] = new ArrayList<>();
        }


        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int sp = Integer.parseInt(st.nextToken());
            int ep = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            road[sp].add(new Info(ep, distance));
        }

        bfs();
        bw.write(minD + "\n");

        bw.flush();
        bw.close();
    }

    static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        int distance = 0;
        q.offer(new int[]{0, distance}); //시작 지점

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int nowP = now[0]; // 현재 위치
            int nowD = now[1]; //현재 거리

            if (nowP == M) { //도착 지점에 다달았다면
                minD = Math.min(minD, nowD);
                continue;
            }

            if (nowP > M) {
                continue;
            }

            q.offer(new int[]{nowP + 1, nowD + 1}); //현재 위치 , 거리 각각 1증가

            for (Info next : road[nowP]) {
                int nEnd = next.e; //도착지
                int nD = next.d; //거리
                q.offer(new int[]{nEnd, nowD + nD});
            }
        }
    }

}