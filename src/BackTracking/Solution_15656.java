package BackTracking;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;


public class Solution_15656 {
    static int N, M;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] inputArr, arr;
    static LinkedHashSet<String> set = new LinkedHashSet();

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken()); //숫자 N
        M = Integer.parseInt(st.nextToken()); //수열 길이

        inputArr = new int[N + 1];
        arr = new int[N + 1];

        StringTokenizer stD = new StringTokenizer(br.readLine()," ");
        for (int i = 1; i <= N; i++) {
            inputArr[i] = Integer.parseInt(stD.nextToken());
        }

        Arrays.sort(inputArr);

        backTracking(1);

        for (String answer : set){
            bw.write(answer + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }

    static void backTracking(int depth) {
        if (depth == M + 1) {
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= M; i++) {
                sb.append(arr[i]).append(" ");
            }
            set.add(sb.toString());
            return;
        }

        for (int i = 1; i <= N; i++) {
            arr[depth] = inputArr[i];
            backTracking(depth + 1);
        }
    }

}

