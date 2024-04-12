package DP;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Solution_11048 {
    static int N, M;
    static int[][] map;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stF = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(stF.nextToken()); //세로
        M = Integer.parseInt(stF.nextToken()); //가로

        map = new int[N + 1][M + 1];
        dp = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                dp[i][j] = Math.max(dp[i - 1][j] + map[i][j], dp[i][j - 1] + map[i][j]);
            }
        }

        bw.write(dp[N][M] + "\n");
        bw.flush();
        bw.close();
    }

}