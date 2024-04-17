package DP;

import java.io.*;
import java.util.StringTokenizer;


public class Solution_1520 {
    static int N, M;
    static long[][] dp;
    static long[][] map;
    static boolean visited[][];
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
        visited = new boolean[N][M];


        for (int i = 0; i < N; i++) {
            StringTokenizer stD = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Long.parseLong(stD.nextToken());
            }
        }

        dp[0][0] = 1; // (0,0) 에서 (0,0)으로 도착하는 default = 1

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == N - 1 && j == N - 1) {
                    break;
                }

                if (dp[i][j] > 0) { //해당 영역에 도달하는 경우의 수가 있다면
                    // 이후 탐색이 가능하다.
                    long nowH = map[i][j]; //현재 높이

                    for (int h = 0; h < 4; h++) {
                        int nx = i + dx[h];
                        int ny = j + dy[h];

                        if (0 <= nx && nx < N && 0 <= ny && ny < N) {
                            if (nowH > map[nx][ny]){
                                dp[nx][ny] += dp[i][j];
                                visited[nx][ny] = true;
                            }
                        }
                    }
                }
            }
        }

        bw.write(dp[N - 1][N - 1] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }


}