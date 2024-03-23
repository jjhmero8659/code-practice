package PrefixSum;

import java.io.*;
import java.util.StringTokenizer;


public class Solution_21318 {
    static int N,K;
    static int[] score; //악보
    static int[] mistake; // 실수 합 배열
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        score = new int[N+1];
        mistake = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        for (int i=1; i<=N; i++){
            score[i] = Integer.parseInt(st.nextToken());

        }

        for (int i=2; i<=N; i++){ // 두번째 악보부터 마지막 까지
            if (score[i] < score[i-1]){
                mistake[i] = mistake[i-1] + 1;
            }
            else {
                mistake[i] = mistake[i-1];
            }
        }


        K = Integer.parseInt(br.readLine());
        for (int i=1; i<=K; i++){
            StringTokenizer stD = new StringTokenizer(br.readLine(), " ");
            int result = solution(Integer.parseInt(stD.nextToken()) , Integer.parseInt(stD.nextToken()));
            bw.write(result + "\n");
        }

        bw.flush();
        bw.close();
    }

    static int solution(int begin , int end){
        return mistake[end] - mistake[begin];
    }
}