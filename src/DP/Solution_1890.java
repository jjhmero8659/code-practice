package DP;

import java.io.*;
import java.util.StringTokenizer;


public class Solution_1890 {
    static int N;
    static long[][] dp; // 각 숫자가 마지막에 위치하는 경우의 수 배열
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());

        dp = new long[N][N]; // 해당 영역 도착 경로 개수
        map = new int[N][N];


        for (int i = 0; i < N; i++) {
            StringTokenizer stD = new StringTokenizer(br.readLine()," ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(stD.nextToken());
            }
        }

        dp[0][0] = 1; // (0,0) 에서 (0,0)으로 도착하는 default = 1

        for (int i=0; i<N; i++){
            for (int j=0; j<N; j++){
                if (i == N-1 && j == N-1){
                    break;
                }

                if (dp[i][j] > 0){
                    int jump = map[i][j];

                    if (i + jump < N){
                        dp[i + jump][j] += dp[i][j];
                    }

                    if (j + jump < N){
                        dp[i][j + jump] += dp[i][j];
                    }
                }
            }
        }

        bw.write( dp[N-1][N-1] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }


}