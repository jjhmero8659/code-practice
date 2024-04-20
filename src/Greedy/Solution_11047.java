package Greedy;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Solution_11047 {
    static int N;
    static long M;
    static long[] coin;
    static long resultC = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine() , " ");

        N = Integer.parseInt(st.nextToken()); //동전 개수
        M = Long.parseLong(st.nextToken()); //Target
        
        coin = new long[N];

        for (int i=0; i<N; i++){
            coin[i] = Long.parseLong(br.readLine());
        }
        
        int cP = N-1; //현재 금액에 맞는 동전 최대 값 인덱스

        while (M != 0){
            for (int i=cP; i>=0; i--){
                if (coin[i] <= M){
                    cP = i;
                    break;
                }
            }

            resultC += (M / coin[cP]);
            M = M % coin[cP];
        }
        bw.write(resultC + "\n");
        bw.flush();
        bw.close();
    }

}