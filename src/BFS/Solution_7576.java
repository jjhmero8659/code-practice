package BFS;

import java.io.*;
import java.util.*;


public class Solution_7576 {
    static int N, M, R;
    static int[][] box;
    static boolean[][] visited;
    static Queue<int[]> q = new LinkedList<>();
    static int[] dx = {0, 1, 0, -1}; //동 남 서 북
    static int[] dy = {1, 0, -1, 0}; //동 남 서 북


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        box = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            StringTokenizer stL = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                int tStat = Integer.parseInt(stL.nextToken());
                box[i][j] = tStat;

                if (tStat == 1) {
                    q.offer(new int[]{i, j});
                    visited[i][j] = true;

                }
            }
        }

        if (checkTomato() == true) {
            bw.write("0\n");
            bw.flush();
            bw.close();
            return;
        }

        int day = bfs();

        if (checkTomato() == false) {
            bw.write("-1\n");
        } else {
            bw.write(day + "\n");
        }


        bw.flush();
        bw.close();
    }

    static int bfs() {
        int day = -1; //시작일

        while (!q.isEmpty()) {
            int size = q.size();

            for (int j = 0; j < size; j++) {
                int now[] = q.poll();
                int nowX = now[0];
                int nowY = now[1];

                for (int i = 0; i < 4; i++) {
                    int nextX = nowX + dx[i];
                    int nextY = nowY + dy[i];

                    if (0 <= nextX && 0 <= nextY && nextX < N && nextY < M) {
                        if (visited[nextX][nextY] == false && box[nextX][nextY] == 0) {
                            q.offer(new int[]{nextX, nextY}); //다음 Queue 삽입
                            box[nextX][nextY] = 1; //익은 토마토로 변경
                            visited[nextX][nextY] = true; //방문 true
                        }
                    }
                }
            }

            day++; //1일 증가
        }

        return day;
    }

    static boolean checkTomato() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (box[i][j] == 0) {
                    return false;
                }
            }
        }

        return true;
    }

}