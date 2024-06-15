package BackTracking;

import java.io.*;
import java.util.StringTokenizer;


public class Solution_14889 {
    static int N, M;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static boolean[] arr;
    static int[][] status;
    static boolean[] visited;

    static int MIN_RESULT = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine()); //숫자 N

        status = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer stD = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= N; j++) {
                status[i][j] = Integer.parseInt(stD.nextToken());
            }
        }

        arr = new boolean[N + 1];

        visited = new boolean[N + 1];

        backTracking(0, 1);

        bw.write(MIN_RESULT + " ");

        bw.flush();
        br.close();
        bw.close();
    }

    static void backTracking(int depth, int start) {
        if (depth == N / 2) {
            MIN_RESULT = Math.min(MIN_RESULT, getResult());
            return;
        }

        for (int i = start; i <= N; i++) {
            arr[i] = true;
            backTracking(depth + 1, i + 1);
            arr[i] = false;
        }
    }

    static int getResult() {
        int start = 0;
        int link = 0;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) continue;

                if (arr[i] && arr[j]) {
                    start += status[i][j];
                }

                if (!arr[i] && !arr[j]) {
                    link += status[i][j];
                }
            }
        }

        return Math.abs(start - link);
    }
}
