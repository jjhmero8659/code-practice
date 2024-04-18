package DP;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;


public class Solution_2294 {
    static int N, K;
    static long[] dp;
    static ArrayList<Integer> coin;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken()); //동전 개수
        K = Integer.parseInt(st.nextToken());

        coin = new ArrayList<>(); //동전 배열

        for (int i = 0; i < N; i++) {
            int coinData = Integer.parseInt(br.readLine());
            if (!coin.contains(coinData)) {
                coin.add(coinData);
            }
        }

        Collections.sort(coin); //coin 배열 정렬

        dp = new long[K + 1];

        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;

        for (int i=0; i<coin.size(); i++){
            for (int j=coin.get(i); j<=K; j++){
                dp[j] = Math.min(dp[j] , dp[j - coin.get(i)] + 1);
            }
        }

        bw.write(dp[K] == Integer.MAX_VALUE ? "-1\n" : dp[K] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }


}