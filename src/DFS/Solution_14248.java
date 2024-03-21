package DFS;

import java.io.*;
import java.util.StringTokenizer;


public class Solution_14248 {
    static int N, S;
    static int[] dy = {1, -1}; //동 서 ,좌 우로만 이동 가능
    static int[] rock;
    static boolean visited[];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        rock = new int[N + 1]; // 1 ~ N 까지
        visited = new boolean[N + 1]; // 방문 배열

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            rock[i] = Integer.parseInt(st.nextToken());
        }

        S = Integer.parseInt(br.readLine());

        dfs(S);

        int cnt = 0;

        for (boolean v : visited){
            if (v == true){
                cnt++;
            }
        }

        bw.write(cnt+"\n");

        bw.flush();
        bw.close();
    }

    static void dfs(int start) {
        visited[start] = true; //현재 지점 방문 true

        for (int i = 0; i < 2; i++) {
            int ns = start + (dy[i] * rock[start]);

            if (1<=ns && ns<=N){
                if (visited[ns] == false){
                    dfs(ns);
                }
            }
        }
    }
}