package Impl;

import java.io.*;
import java.util.*;


public class Solution_1920 {
    static int N, M;

    static int[] num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        num = new int[N];


        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num);

        M = Integer.parseInt(br.readLine());
        StringTokenizer stD = new StringTokenizer(br.readLine(), " ");

        for (int i = 1; i <= M; i++) {
            int findNum = Integer.parseInt(stD.nextToken());

            bw.write(bst(findNum) ? "1\n" : "0\n");
        }

        bw.flush();
        bw.close();
    }

    static boolean bst(int targetNum){
        int startIdx = 0;
        int endIdx = num.length - 1;

        while (startIdx <= endIdx){
            int midIdx = (startIdx + endIdx) / 2;
            int midVal = num[midIdx];

            if (midVal < targetNum){
                startIdx = midIdx + 1;
            }
            else if(midVal > targetNum){
                endIdx = midIdx - 1;
            }
            else{
                return true;
            }
        }
        return false;
    }

}