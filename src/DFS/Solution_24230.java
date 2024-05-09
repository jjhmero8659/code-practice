package DFS;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Solution_24230 {
    static int N;
    static ArrayList<Integer>[] tree; //정점 배열
    static int[] target;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken()); //정점 개수

        tree = new ArrayList[N + 1];
        target = new int[N + 1];

        StringTokenizer stC = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
            target[i] = Integer.parseInt(stC.nextToken());
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer stD = new StringTokenizer(br.readLine(), " ");

            int sp = Integer.parseInt(stD.nextToken());
            int ep = Integer.parseInt(stD.nextToken());

            tree[sp].add(ep);
            tree[ep].add(sp);
        }

        bw.write(dfs(1, 0) + "\n");
        bw.flush();
        bw.close();
    }


    static int dfs(int now, int parent) {
        int ans = target[now] == target[parent] ? 0 : 1;

        for (int next : tree[now]) {
            if (next == parent) continue;
            ans += dfs(next, now);
        }

        return ans;
    }

}