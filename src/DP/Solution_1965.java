package DP;

import java.io.*;
import java.util.StringTokenizer;


public class Solution_1965 {
    static int N;
    static long[] box;
    static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine()); //상자 개수

        box = new long[N];
        dp = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for (int i=0; i<N; i++){
            box[i] = Integer.parseInt(st.nextToken()); //상자 크기 입력
            dp[i] = 1; //최소 값
        }

        for (int i=1; i<N; i++){
            for (int j=0; j<i; j++){
                if (box[i] > box[j]){
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }

        long max = 0;
        for (long dpN : dp){
            max = Math.max(dpN , max);
        }

        bw.write(max + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    
}