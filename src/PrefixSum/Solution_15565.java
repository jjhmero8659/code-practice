package PrefixSum;

import java.io.*;
import java.util.StringTokenizer;


public class Solution_15565 {
    static int N,minNum;
    static int[] doll; //인형
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stF = new StringTokenizer(br.readLine()," ");


        N = Integer.parseInt(stF.nextToken());
        minNum = Integer.parseInt(stF.nextToken());
        doll = new int[N+2];

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for (int i=1; i<=N; i++){
            doll[i] = Integer.parseInt(st.nextToken());
        }
        
        int begin = 1;
        int end = 1;

        int lion = doll[1] == 1 ? 1 : 0; //첫번째 index 의 인형이 lion이면 1
        int minLen = Integer.MAX_VALUE;




        while (end <= N){
            if (lion >= minNum){
                minLen = Math.min(minLen , end - begin + 1);
                if (doll[begin] == 1){
                    lion--;
                }
                begin++;
            }
            else{
                end++;
                if (doll[end] == 1){
                    lion++;
                }
            }
        }


        if (minLen == Integer.MAX_VALUE){
            bw.write(-1+"\n");
        }
        else {
            bw.write(minLen+"\n");
        }
        bw.flush();
        bw.close();
    }


}