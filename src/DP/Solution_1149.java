package DP;

import java.io.*;
import java.util.StringTokenizer;


public class Solution_1149 {
    static int N;
    static long[][] home;
    static long[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken()); //집의 개수

        home = new long[N][3];
        dp = new long[N][3];

        for (int i=0; i<N; i++){
            StringTokenizer stD = new StringTokenizer(br.readLine()," ");
            for (int j=0; j<3; j++){
                home[i][j] = Long.parseLong(stD.nextToken());
            }
        }

        for (int i=0; i<3; i++){
            dp[0][i] = home[0][i];
        }

        for (int i=1; i<N; i++){
            dp[i][0] = Math.min(dp[i-1][1] , dp[i-1][2]) + home[i][0];
            dp[i][1] = Math.min(dp[i-1][0] , dp[i-1][2]) + home[i][1];
            dp[i][2] = Math.min(dp[i-1][0] , dp[i-1][1]) + home[i][2];
        }

        long minResult = Long.MAX_VALUE;

        for (long cost : dp[N-1]){
            minResult = Math.min(minResult, cost);
        }

        bw.write(minResult + "\n");
        bw.flush();
        bw.close();
        br.close();
    }


}