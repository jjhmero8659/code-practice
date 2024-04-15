package DP;

import java.io.*;


public class Solution_17626 {
    static int N;

    static long dp[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        dp = new long[N+1];

        dp[0] = 0;
        dp[1] = 1;

        for (int i=2; i<=N; i++){
            dp[i] = dp[i-1]; //전 값의 + 1이다. , 후에 +1 을 하기 때문에 전 값만 가져옴
            for (int j=1; j*j <= i; j++){
                dp[i] = Math.min(dp[i] , dp[i - (j*j)]);
            }
            dp[i] += 1;
        }

        bw.write(dp[N] + "\n");
        bw.flush();
        bw.close();
    }

}