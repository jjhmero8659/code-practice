package DP;

import java.io.*;
import java.util.StringTokenizer;


public class Solution_11727 {
    static int N;
    static long[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        dp = new long[N + 1];

        for (int i=1; i<=N; i++){
            if(i == 1){
                dp[i] = 1;
            } else if (i == 2) {
                dp[i] = 3;
            }
            dp[i] = (dp[i-1] + (2 * dp[i-2])) % 10007;
        }

        bw.write(dp[N] + "\n");

        bw.flush();
        bw.close();
    }

}