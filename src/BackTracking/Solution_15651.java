package BackTracking;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;


public class Solution_15651 {
    static int N, M;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] arr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken()); //숫자 N
        M = Integer.parseInt(st.nextToken()); //수열 길이

        arr = new int[M + 1];

        backTracking(1);

        bw.write(sb.toString() + " ");

        bw.flush();
        br.close();
        bw.close();
    }

    static void backTracking(int depth) {
        if (depth == M + 1) {

            for (int i = 1; i <= M; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            arr[depth] = i;
            backTracking(depth + 1);
        }
    }
}

