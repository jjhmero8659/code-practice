package DP;

import java.io.*;


public class Solution_11057 {
    static int N;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        dp = new int[N+1][10];

        for (int i=0; i<10; i++){
            dp[0][i] = 1;
        }

        for (int i=1; i<=N; i++){
            // N 자리 수
            for (int j=0; j<10; j++){
                // 0 ~ 9
                for (int k = j; k<10; k++){
                    dp[i][j] += dp[i-1][k];
                    dp[i][j] %= 10007;
                }
            }
        }

        bw.write(dp[N][0] + "\n");
        bw.flush();
        bw.close();
    }

}