package TopologicalSorting;

import java.io.*;
import java.util.*;


public class Solution_1516 {
    static int N;
    static ArrayList<Integer>[] structure;
    static int[] workTime;
    static int[] parent;
    static int[] buildTime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //건물 수

        workTime = new int[N + 1];
        parent = new int[N + 1];
        buildTime = new int[N + 1];

        structure = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            structure[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            StringTokenizer stD = new StringTokenizer(br.readLine(), " ");

            workTime[i] = Integer.parseInt(stD.nextToken());

            while (true) {
                int data = Integer.parseInt(stD.nextToken());

                if (data == -1) {
                    break;
                }

                structure[data].add(i);
                parent[i]++;
            }
        }

        topologicalSort();

        for (int i=1; i<=N; i++){
            bw.write(buildTime[i] + "\n");
        }

        bw.flush();
        bw.close();
    }

    static void topologicalSort() {
        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            if (parent[i] == 0) {
                q.offer(i);
                buildTime[i] = workTime[i];
            }
        }

        while (!q.isEmpty()) {
            Integer now = q.poll();

            for (int next : structure[now]) {
                parent[next]--;
                buildTime[next] = Math.max(buildTime[next], buildTime[now] + workTime[next]);

                if (parent[next] == 0){
                    q.offer(next);
                }
            }
        }
    }
}