package BackTracking;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;


public class Solution_15663 {
    static int N, M;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] inputNum, arr;
    static boolean[] visited;
    static LinkedHashSet<String> answer = new LinkedHashSet<>();

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken()); //숫자 N
        M = Integer.parseInt(st.nextToken()); //수열 길이

        arr = new int[M + 1];
        inputNum = new int[N + 1];
        visited = new boolean[N + 1];

        StringTokenizer stD = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            inputNum[i] = Integer.parseInt(stD.nextToken());
        }

        Arrays.sort(inputNum);

        backTracking( 1);

        for (String ans : answer){
            bw.write(ans + "\n");
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
            answer.add(sb.toString());
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (visited[i] == false){
                visited[i] = true;
                arr[depth] = inputNum[i];
                backTracking(depth + 1);
                visited[i] = false;
            }
        }
    }
}

