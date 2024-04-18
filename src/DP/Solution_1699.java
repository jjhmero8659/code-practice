package DP;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;


public class Solution_1699 {
    static int N;
    static long[] dp;
    static ArrayList<Integer> nums = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        dp = new long[N + 1];

        Arrays.fill(dp , Integer.MAX_VALUE);

        int initN = 1;
        while (true){
            if (initN * initN <= N){
                nums.add(initN);
                initN++;
            }
            else{
                break;
            }
        }

        dp[0] = 0;

        for (int i=0; i<nums.size(); i++){
            int powN = nums.get(i) * nums.get(i);
            for (int j=powN; j<=N; j++){
                dp[j] = Math.min(dp[j] , dp[j - (powN)] + 1);
            }
        }

        bw.write(dp[N] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }


}