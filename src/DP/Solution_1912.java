package DP;

import java.io.*;
import java.util.StringTokenizer;


public class Solution_1912 {
    static int N;
    static int[] num;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        num = new int[N];
        dp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine() , " ");

        for (int i=0; i<N; i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        for (int i=0; i<N; i++){
            if (i == 0){
                dp[i] = num[i];
                continue;
            }

            dp[i] = Math.max(dp[i-1] + num[i] , num[i]);
        }

        int max = Integer.MIN_VALUE;
        for (int dpN : dp){
            max = Math.max(dpN, max);
        }

        bw.write(max + "\n");
        bw.flush();
        bw.close();
    }

}