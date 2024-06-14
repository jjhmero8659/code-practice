package BackTracking;

import java.io.*;
import java.util.StringTokenizer;


public class Solution_14889 {
    static int N, M;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static int[] start, link;
    static int[][] status;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(br.readLine()); //숫자 N

        status = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            StringTokenizer stD = new StringTokenizer(br.readLine(), " ");
            for (int j = 1; j <= N; j++) {
                status[i][j] = Integer.parseInt(stD.nextToken());
            }
        }

        start = new int[N / 2];
        link = new int[N / 2];

        visited = new boolean[N + 1];

        backTracking(0);

        bw.write(sb.toString() + " ");

        bw.flush();
        br.close();
        bw.close();
    }

    static void backTracking(int depth) {
        int outOfBound = (N / 2);
        if (depth == outOfBound) {
            int startStat = 0;
            for (int i = 0; i < outOfBound; i++) {
                int t1 = start[i];
                int t2 = start[i + 1];

                startStat += status[t1][t2] + status[t2][t1];
            }

            for (int i = 1; i <= N; i++) {
                if (visited[i] == false){
                    link
                }
            }
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (visited[i] == false) {
                visited[i] = true;
                start[depth] = i;
                backTracking(depth + 1);
                visited[i] = false;
            }

        }
    }
}
