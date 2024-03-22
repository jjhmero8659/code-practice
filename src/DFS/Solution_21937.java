package DFS;

import java.io.*;
import java.util.*;


public class Solution_21937 {
    static int N, M, X;
    static ArrayList<Integer>[] graph;
    static boolean visited[];
    static int cnt = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken()); //노드 수
        M = Integer.parseInt(st.nextToken()); //연결 선 수

        visited = new boolean[N + 1];
        graph = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer stD = new StringTokenizer(br.readLine(), " ");

            int start = Integer.parseInt(stD.nextToken());
            int end = Integer.parseInt(stD.nextToken());

            graph[end].add(start);
        }

        X = Integer.parseInt(br.readLine()); //타겟

        dfs(X);

        bw.write(cnt-1 + "\n"); //역순 탐색 이므로 시작 노드 제외

        bw.flush();
        bw.close();
    }

    static void dfs(int start) {

        visited[start] = true; //현재 index 방문 true
        cnt++;

        for (int vertex : graph[start]) { //현재 node 연결 선 탐색
            if (visited[vertex] == false) {
                dfs(vertex);
            }
        }
    }
}