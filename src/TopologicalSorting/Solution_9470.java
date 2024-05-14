package TopologicalSorting;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Solution_9470 {
    static int N, M, T, TN;
    static ArrayList<Integer>[] relation;
    static ArrayList<River> riverInfo;
    static int[] parent;

    static class River {
        int i;
        int cnt;

        public River(int i, int cnt) {
            this.i = i;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            TN = Integer.parseInt(st.nextToken()); //현재 테스트 케이스 번호
            N = Integer.parseInt(st.nextToken()); //노드 수
            M = Integer.parseInt(st.nextToken()); //간선 수

            relation = new ArrayList[N + 1];
            parent = new int[N + 1];
            riverInfo = new ArrayList<>();
            riverInfo.add(new River(-1, -1));

            for (int i = 1; i <= N; i++) {
                relation[i] = new ArrayList<>();
                riverInfo.add(new River(-1, 0));
            }

            for (int i = 0; i < M; i++) {
                StringTokenizer stD = new StringTokenizer(br.readLine(), " ");
                int sp = Integer.parseInt(stD.nextToken());
                int ep = Integer.parseInt(stD.nextToken());

                relation[sp].add(ep);
                parent[ep]++;
            }

            topologicalSort();


            bw.write(TN + " " + riverInfo.get(N).i + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void topologicalSort() {
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            if (parent[i] == 0) {
                q.offer(i);
                River river = riverInfo.get(i);
                river.i = 1;
            }
        }

        while (!q.isEmpty()) {
            Integer now = q.poll();
            River nowRiver = riverInfo.get(now);

            if (nowRiver.cnt >= 2) {
                nowRiver.i++;
                nowRiver.cnt = 1;
            }

            for (int next : relation[now]) {
                parent[next]--;
                River nextRiver = riverInfo.get(next);

                if (nowRiver.i > nextRiver.i) {
                    nextRiver.i = nowRiver.i;
                    nextRiver.cnt = 1;
                } else if (nowRiver.i == nextRiver.i) {
                    nextRiver.cnt++;
                }

                if (parent[next] == 0) {
                    q.offer(next);
                }
            }
        }
    }
}