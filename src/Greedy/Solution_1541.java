package Greedy;

import java.io.*;
import java.util.StringTokenizer;


public class Solution_1541 {
    static String N;
    static long sum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = br.readLine();

        String[] splitStr = N.split("-"); //- 기준으로 자르기

        for (int i=0; i<splitStr.length; i++){
            long temp = tempSum(splitStr[i]);

            if (i == 0){
                sum += temp;
            }
            else{
                sum -= temp;
            }
        }

        bw.write(sum + "\n");
        bw.flush();
        bw.close();
    }

    static long tempSum(String splitStr){
        long sum = 0;

        String[] split = splitStr.split("[+]");

        for (int i=0; i<split.length; i++){
            sum += Long.parseLong(split[i]);
        }

        return sum;
    }
}