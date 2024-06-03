package Dijkstra;

import java.io.*;
import java.util.*;


public class Solution_1584 {
    static int N, M;
    static boolean[][] visited = new boolean[501][501];
    static final int WARNING = 1;
    static final int DEATH = -1;
    static int[][] map = new int[501][501];
    static int[][] distance = new int[501][501];
    static int[] dx = {0, 0, 1, -1}; //동 서 남 북
    static int[] dy = {1, -1, 0, 0}; //동 서 남 북

    static class Point {
        int x;
        int y;
        int cnt;

        public Point(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine()); //위험구역 개수


        for (int i = 0; i < N; i++) {
            StringTokenizer stP = new StringTokenizer(br.readLine(), " ");

            int x1 = Integer.parseInt(stP.nextToken());
            int y1 = Integer.parseInt(stP.nextToken());

            int x2 = Integer.parseInt(stP.nextToken());
            int y2 = Integer.parseInt(stP.nextToken());

            setArea(x1, y1, x2, y2, WARNING);
        }

        M = Integer.parseInt(br.readLine()); //죽음구역 개수

        for (int i = 0; i < M; i++) {
            StringTokenizer stP = new StringTokenizer(br.readLine(), " ");

            int x1 = Integer.parseInt(stP.nextToken());
            int y1 = Integer.parseInt(stP.nextToken());

            int x2 = Integer.parseInt(stP.nextToken());
            int y2 = Integer.parseInt(stP.nextToken());

            setArea(x1, y1, x2, y2, DEATH);
        }


        bfs();

        bw.write(visited[500][500] ? distance[500][500] + "\n" : "-1\n");

        bw.flush();
        bw.close();
    }

    static void setArea(int x1, int y1, int x2, int y2, int stat) {
        int lx = Math.min(x1, x2);
        int hx = Math.max(x1, x2);

        int ly = Math.min(y1, y2);
        int hy = Math.max(y1, y2);

        for (int x = lx; x <= hx; x++) {
            for (int y = ly; y <= hy; y++) {
                map[x][y] = stat;
            }
        }
    }

    static boolean range(int x, int y) {
        return 0 <= x && x < 501 && 0 <= y && y < 501;
    }

    static void bfs() {
        PriorityQueue<Point> pq = new PriorityQueue<>(
                (a, b) -> Integer.compare(a.cnt, b.cnt)
        );

        pq.offer(new Point(0, 0, 0));
        visited[0][0] = true;
        distance[0][0] = 0;

        while (!pq.isEmpty()) {
            Point now = pq.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (!range(nx, ny)) {
                    continue;
                }

                if (visited[nx][ny] == false && map[nx][ny] != DEATH) {
                    visited[nx][ny] = true;
                    distance[nx][ny] = distance[now.x][now.y] + map[nx][ny];
                    pq.offer(new Point(nx, ny, distance[nx][ny]));
                }
            }
        }
    }

}