package DFS;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;


public class Solution_24483 {
    static int N, M, R;
    static ArrayList<Integer>[] tree;
    static int[] visited;

    static int[] depth;
    static int visitN = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        tree = new ArrayList[N + 1];
        visited = new int[N + 1];
        depth = new int[N+1];

        Arrays.fill(depth, -1);

        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer stL = new StringTokenizer(br.readLine(), " ");

            int pN = Integer.parseInt(stL.nextToken());
            int cN = Integer.parseInt(stL.nextToken());

            tree[pN].add(cN); // 양방향 연결
            tree[cN].add(pN);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(tree[i]); //오름 차순 정렬
        }

        dfs(R, 0);

        long result = 0;

        for (int i = 1; i <= N; i++) {
            long di = depth[i];
            long vi = visited[i];

            result += di * vi;
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
    }

    static void dfs(int n, int d) { //노드 숫자 , 깊이 d , 방문순서 v
        visited[n] = ++visitN; //방문 순서 대입
        depth[n] = d; //깊이 값 대입

        for (int node : tree[n]) {
            if (visited[node] == 0) {
                dfs(node, d + 1); //깊이, 방문 순서 증가
            }
        }
    }
}