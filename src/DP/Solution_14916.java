package DP;

import java.io.*;
import java.util.Arrays;


public class Solution_14916 {
    static int N;
    static long coin = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        while (true){
            if (N < 0){
                bw.write("-1\n");
                break;
            }

            if (N % 5 == 0){
                coin += N / 5;
                bw.write(coin + " \n");
                break;
            }
            else{
                N -= 2;
                coin++;
            }
        }

        bw.flush();
        bw.close();
    }

}