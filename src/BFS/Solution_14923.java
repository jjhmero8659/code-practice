package BFS;

import java.io.*;
import java.util.*;


public class Solution_14923 {
    static int N, M;
    static int HX, HY, EX, EY;
    static int[][] maze;
    static boolean[][][] visited;
    static int[] dx = {0, 0, 1, -1}; //동 서 남 북
    static int[] dy = {1, -1, 0, 0}; //동 서 남 북

    static int minResult = Integer.MAX_VALUE;

    static class Info {
        int x;
        int y;
        int magic;
        int moveCnt;

        public Info(int x, int y, int magic, int moveCnt) {
            this.x = x;
            this.y = y;
            this.magic = magic;
            this.moveCnt = moveCnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stM = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(stM.nextToken());
        M = Integer.parseInt(stM.nextToken());

        maze = new int[N][M];

        StringTokenizer stH = new StringTokenizer(br.readLine(), " ");
        HX = Integer.parseInt(stH.nextToken()) - 1;
        HY = Integer.parseInt(stH.nextToken()) - 1;

        StringTokenizer stE = new StringTokenizer(br.readLine(), " ");
        EX = Integer.parseInt(stE.nextToken()) - 1;
        EY = Integer.parseInt(stE.nextToken()) - 1;

        for (int i = 0; i < N; i++) {
            StringTokenizer stD = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                maze[i][j] = Integer.parseInt(stD.nextToken());
            }
        }

        bw.write(bfs() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }


    static int bfs() {
        PriorityQueue<Info> q = new PriorityQueue<>(
                (a, b) -> Integer.compare(a.moveCnt, b.moveCnt)
        );

        visited = new boolean[N][M][2];

        q.offer(new Info(HX, HY, 0, 0)); //시작 위치
        visited[HX][HY][0] = true;

        while (!q.isEmpty()) {
            Info poll = q.poll();

            if (poll.x == EX && poll.y == EY) {
                return poll.moveCnt;
            }

            for (int i = 0; i < 4; i++) {
                int nx = poll.x + dx[i];
                int ny = poll.y + dy[i];
                int moveCnt = poll.moveCnt;

                if (possibleArea(nx, ny)) {
                    if (maze[nx][ny] == 0 && visited[nx][ny][poll.magic] == false){
                        visited[nx][ny][poll.magic] = true;
                        q.offer(new Info(nx,ny,poll.magic , moveCnt + 1));
                    }
                    else if (maze[nx][ny] == 1 && poll.magic == 0) {
                        visited[nx][ny][1] = true;
                        q.offer(new Info(nx,ny,1,moveCnt + 1));
                    }
                }
            }
        }

        return -1;
    }

    static boolean possibleArea(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < M;
    }

}