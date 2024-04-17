package DP;

import java.io.*;
import java.util.StringTokenizer;


public class Solution_2293 {
    static int N,K;
    static long[] dp;
    static int[] coin;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dp = new long[K+1]; //동전 경우의 수
        coin = new int[N]; //동전 가치 배열
        
        for (int i=0; i<N; i++){
            coin[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = 1; //동전을 놓지않아서 0을 만드는 1가지

        for (int c = 0; c<N; c++){
            for (int i=coin[c]; i<=K; i++){
                dp[i] = dp[i] + dp[i - coin[c]];
            }
        }

        bw.write(dp[K] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    
}