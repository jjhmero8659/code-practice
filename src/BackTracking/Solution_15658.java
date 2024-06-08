package BackTracking;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;


public class Solution_15658 {
    static int N;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] inputArr, arr , operator;
    static int maxValue = Integer.MIN_VALUE;
    static int minValue = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken()); //숫자 N

        inputArr = new int[N + 1];
        arr = new int[N + 1];

        StringTokenizer stD = new StringTokenizer(br.readLine()," ");
        for (int i = 1; i <= N; i++) {
            inputArr[i] = Integer.parseInt(stD.nextToken());
        }

        operator = new int[4];
        StringTokenizer stO = new StringTokenizer(br.readLine()," ");
        for (int i=0; i<4; i++){
            operator[i] = Integer.parseInt(stO.nextToken());
        }




        bw.flush();
        br.close();
        bw.close();
    }

    static void backTracking(int num, int depth) {
        if (depth == N + 1){
            maxValue = Math.max(num , maxValue);
            minValue = Math.min(num , minValue);
            return;
        }
    }

}

