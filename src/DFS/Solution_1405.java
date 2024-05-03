package DFS;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Solution_1405 {
    static int N;
    static boolean[][] visited = new boolean[30][30];
    static int[] dx = {0, 0, 1, -1}; // 동 서 남 북
    static int[] dy = {1, -1, 0, 0}; // 동 서 남 북
    static double[] percent = new double[4]; //동 서 남 북
    static double resultPercent = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken()); //로봇의 이동 횟수

        for (int i = 0; i < 4; i++) {
            percent[i] = Double.parseDouble(st.nextToken()) * 0.01;
        }

        visited[15][15] = true;
        dfs(15, 15, 0, 1);

        bw.write(resultPercent + "\n");
        bw.flush();
        br.close();
        bw.close();
    }

    static void dfs(int x, int y, int cnt, double percentage) {
        if (cnt == N) {
            resultPercent += percentage;
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            double nextP = percentage * percent[i];

            if (0 <= nx && nx < 30 && 0 <= ny && ny < 30) {
                if (visited[nx][ny] == false) {
                    visited[nx][ny] = true;
                    dfs(nx, ny, cnt + 1, nextP);
                    visited[nx][ny] = false;
                }
            }
        }
    }
}