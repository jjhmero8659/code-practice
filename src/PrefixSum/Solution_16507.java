package PrefixSum;

import java.io.*;
import java.util.StringTokenizer;


public class Solution_16507 {
    static int N,M,Q;
    static int[][] P,S;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        P = new int[N+1][M+1]; //Photo
        S = new int[N+1][M+1]; //Photo 합 배열
        

        for (int i=1; i<=N; i++){
            StringTokenizer stD = new StringTokenizer(br.readLine()," ");
            for (int j=1; j<=M; j++){
                P[i][j] = Integer.parseInt(stD.nextToken());
            }
        }

        for (int i=1; i<=N; i++){
            S[i][1] = S[i-1][1] + P[i][1];
        }

        for (int i=1; i<=M; i++){
            S[1][i] = S[1][i-1] + P[1][i];
        }

        for (int i=2; i<=N; i++){
            for (int j=2; j<=M; j++){
                S[i][j] = S[i][j-1] + S[i-1][j] - S[i-1][j-1] + P[i][j];
            }
        }
        
        for (int i=1; i<=Q; i++){
            StringTokenizer stP = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(stP.nextToken());
            int y1 = Integer.parseInt(stP.nextToken());
            int x2 = Integer.parseInt(stP.nextToken());
            int y2 = Integer.parseInt(stP.nextToken());

            bw.write(solve(x1,y1,x2,y2)+"\n");
        }

        bw.flush();
        bw.close();
    }

    static int solve(int x1,int y1,int x2,int y2){
        int result = S[x2][y2] - S[x2][y1-1] - S[x1-1][y2] + S[x1-1][y1-1];
        int num = (y2-y1 + 1) * (x2 - x1 + 1);

        return result/num;
    }

}