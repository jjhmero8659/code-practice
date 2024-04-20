package DP;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;


public class Solution_2225 {
    static int N, K;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken()); //최종 합
        K = Integer.parseInt(st.nextToken()); //사용할 정수 개수

        dp = new long[K+1][N+1];

        for (int i=0; i<=N; i++){
            dp[1][i] = 1;
        }

        for (int i=1; i<=K; i++){
            dp[i][0] = 1;
        }

        for (int i=2; i<=K; i++){
            for (int j=1; j<=N; j++){
                dp[i][j] = dp[i][j-1] + dp[i-1][j];
                dp[i][j] %= 1000000000;
            }
        }

        bw.write(dp[K][N] % 1000000000 + "\n");
        bw.flush();
        bw.close();
        br.close();
    }


}