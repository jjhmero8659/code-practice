package DP;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;


public class Solution_11053 {
    static int N;
    static int[] A;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        dp = new int[N + 1];
        A = new int[N + 1];


        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for (int i=1; i<=N; i++){
            A[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1; //최소 값은 1이다.
        }
        
        for (int i=1; i<=N; i++){
            for (int j=1; j<i; j++){
                if (A[j] < A[i]){
                    //이전 숫자 값중 현재 숫자보다 작다면
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }

        int max = 0;
        for (int num : dp){
            max = Math.max(num , max);
        }

        bw.write(max + "\n");
        bw.flush();
        bw.close();
    }

}