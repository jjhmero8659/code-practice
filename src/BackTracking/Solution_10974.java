package BackTracking;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Solution_10974 {
    static int N;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] arr;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken()); //숫자 N

        arr = new int[N + 1];
        visited = new boolean[N + 1];

        backTracking(1);

        bw.write(sb.toString() + " ");
        bw.flush();
        br.close();
        bw.close();
    }

    static void backTracking(int depth) {
        if (depth == N + 1){
            for (int i=1; i<=N; i++){
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i=1; i<=N; i++){
            if (visited[i] == false){
                visited[i] = true;
                arr[depth] = i;
                backTracking(depth + 1);
                visited[i] = false;
            }
        }
    }
}

