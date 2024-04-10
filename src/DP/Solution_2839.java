package DP;

import java.io.*;


public class Solution_2839 {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        int bucket = 0;
        while (N > 0){
            if (N % 5 == 0){
                bucket += N / 5;
                break;
            }
            
            if (N < 3){ //최소 봉지로도 나눌 수 없음
                bucket = -1;
                break;
            }

            N -= 3;
            bucket++;
        }

        bw.write(bucket + "\n");
        bw.flush();
        bw.close();
    }

}