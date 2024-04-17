package DP;

import java.io.*;
import java.util.StringTokenizer;


public class Solution_1520 {
    static int N, M;
    static long[][] dp;
    static long[][] map;
    static int[] dx = {0, 1, 0, -1}; // 동 남 서 북
    static int[] dy = {1, 0, -1, 0}; // 동 남 서 북

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stP = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(stP.nextToken()); // 세로
        M = Integer.parseInt(stP.nextToken()); // 가로

        dp = new long[N][M]; // 해당 영역 도착 경로 개수
        map = new long[N][M];


        for (int i = 0; i < N; i++) {
            StringTokenizer stD = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                map[i][j] = Long.parseLong(stD.nextToken());
                dp[i][j] = -1;
            }
        }

        bw.write(dfs(0, 0) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static long dfs(int x, int y) {
        if (x == N - 1 && y == M - 1) {
            return 1; //도달
        }

        //방문 기록이 없다면
        if (dp[x][y] == -1) {
            dp[x][y] = 0; //현재 영역을 0 초기화

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i]; //다음 x
                int ny = y + dy[i]; //다음 y

                if (0 <= nx && nx < N && 0 <= ny && ny < M) {
                    if (map[x][y] > map[nx][ny]){
                        dp[x][y] += dfs(nx,ny);
                    }
                }
            }
        }

        return dp[x][y];
    }

}