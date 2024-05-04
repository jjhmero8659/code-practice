package Greedy;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;


public class Solution_13413 {
    static int N, T;
    static char[] init;
    static long wCnt = 0;
    static long bCnt = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine());
            wCnt = 0;
            bCnt = 0;


            init = br.readLine().toCharArray();

            String target = br.readLine();
            for (int i=0; i<N; i++){
                char targetC = target.charAt(i);
                if (init[i] == 'W'){
                    if (init[i] != targetC){ //init == W 이고 target == B일 경우
                        wCnt++;
                    }
                }
                else{
                    if (init[i] != targetC){ //init == B 이고 target == W일 경우
                        bCnt++;
                    }
                }
            }

            bw.write(Math.max(wCnt,bCnt) + "\n");
        }



        bw.flush();
        bw.close();
    }

}