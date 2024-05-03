package DFS;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


public class Solution_2617 {
    static int N, M;
    static ArrayList<Integer>[] tMarbles;
    static ArrayList<Integer>[] sMarbles;
    static boolean[] visited;
    static int[] less;
    static int[] more;
    static long resultCnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken()); //구슬 개수
        M = Integer.parseInt(st.nextToken()); //관계 도

        tMarbles = new ArrayList[N + 1];
        sMarbles = new ArrayList[N + 1];
        less = new int[N + 1];
        more = new int[N + 1];


        for (int i = 1; i <= N; i++) {
            tMarbles[i] = new ArrayList<>();
            sMarbles[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer stD = new StringTokenizer(br.readLine(), " ");

            int sp = Integer.parseInt(stD.nextToken());
            int ep = Integer.parseInt(stD.nextToken());

            sMarbles[sp].add(ep);
            tMarbles[ep].add(sp);
        }

        int mid = N >> 1;

        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            less[i] = dfs_s(i);

            visited = new boolean[N + 1];
            more[i] = dfs_b(i);

            if (less[i] > mid || more[i] > mid) {
                resultCnt++;
            }
        }

        bw.write(resultCnt + "\n");
        bw.flush();
        br.close();
        bw.close();
    }

    static int dfs_s(int num) {
        int sum = 0;

        for (int next : sMarbles[num]) {
            if (visited[next] == false) {
                visited[next] = true;
                sum += dfs_s(next) + 1;
            }
        }

        return sum;
    }

    static int dfs_b(int num) {
        int sum = 0;

        for (int next : tMarbles[num]) {
            if (visited[next] == false) {
                visited[next] = true;
                sum += dfs_b(next) + 1;
            }
        }
        return sum;
    }
}