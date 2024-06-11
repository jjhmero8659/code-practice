package BackTracking;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;


public class Solution_15658 {
    static int N;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] inputArr, operator;
    static int maxValue = Integer.MIN_VALUE;
    static int minValue = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken()); //숫자 N

        inputArr = new int[N];

        StringTokenizer stD = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            inputArr[i] = Integer.parseInt(stD.nextToken());
        }

        operator = new int[4];
        StringTokenizer stO = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(stO.nextToken());
        }

        backTracking(inputArr[0] , 1);
        bw.write(maxValue + "\n");
        bw.write(minValue + "\n");
        bw.flush();
        br.close();
        bw.close();
    }

    static void backTracking(int num, int depth) {
        if (depth == N) {
            maxValue = Math.max(num, maxValue);
            minValue = Math.min(num, minValue);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operator[i] > 0){
                operator[i]--;

                switch (i) {
                    case 0:
                        backTracking(num + inputArr[depth], depth + 1);
                        break;
                    case 1:
                        backTracking(num - inputArr[depth], depth + 1);
                        break;
                    case 2:
                        backTracking(num * inputArr[depth], depth + 1);
                        break;
                    case 3:
                        backTracking(num / inputArr[depth], depth + 1);
                        break;
                }

                operator[i]++;
            }

        }
    }

}

