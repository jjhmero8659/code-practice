package Greedy;

import java.io.*;
import java.util.StringTokenizer;


public class Solution_1052 {
    static Long N, K;
    static long buyBottleN = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Long.parseLong(st.nextToken());
        K = Long.parseLong(st.nextToken());

        String bitN = Long.toBinaryString(N);
        int oneCnt = Long.bitCount(N);

        if (oneCnt > K){
            //물병의 개수가 요구 사항보다 크다면
            //물병을 사면서 합치기 시작

            int index = findIndex(bitN);

            String tString = bitN.substring(index);

            long tNum = Long.parseLong(tString,2);

            if (tNum != 0){
                buyBottleN = Math.pow(2,bitN.length() - )
            }
        }


        bw.flush();
        bw.close();
    }

    static int findIndex(String bitN){
        for (int i=0; i<bitN.length(); i++){ //문자열 전체 까지
            if (K == 0){
                return i;
            }
            if (bitN.charAt(i) == '1'){
                K--;
            }
        }
        return -1;
    }


}