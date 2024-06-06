package BackTracking;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Solution_15655 {
    static int N, M;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] arr, inputArr;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken()); //숫자 N
        M = Integer.parseInt(st.nextToken()); //수열 길이

        arr = new int[M + 1];
        inputArr = new int[N + 1];

        StringTokenizer stD = new StringTokenizer(br.readLine(), " ");
        for (int i=1; i<= N; i++){
            inputArr[i] = Integer.parseInt(stD.nextToken());
        }

        Arrays.sort(inputArr);

        backTracking(1,1);

        bw.write(sb.toString() + " ");

        bw.flush();
        br.close();
        bw.close();
    }

    static void backTracking(int startIdx , int depth) {
        if (depth == M + 1){
            for (int i=1; i<=M; i++){
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i=startIdx; i<=N; i++){
            arr[depth] = inputArr[i];
            backTracking(i + 1, depth + 1);
        }
    }
}

