package DFS;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Solution_1967 {
    static int N;
    static ArrayList<Node>[] tree;
    static boolean[] visited;
    static long maxD = 0;

    static class Node{
        int n;
        long distance;

        public Node(int n, long distance) {
            this.n = n;
            this.distance = distance;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        visited = new boolean[N+1];
        tree = new ArrayList[N+1];

        for (int i=1; i<=N; i++){
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            tree[s].add(new Node(e,distance)); //양방향 연결
            tree[e].add(new Node(s,distance));
        }

        for (int i = 1; i <= N; i++) {
            if (tree[i].size() == 1){
                //leaf 노드라면?
                Arrays.fill(visited,false);
                dfs(i , 0);
            }
        }


        bw.write(maxD + "\n");
        bw.flush();
        bw.close();
    }

    static void dfs(int start , long depth) {
        visited[start] = true;

        if (tree[start].size() == 1 && depth > 0){
            maxD = Math.max(maxD , depth);
            return;
        }

        for (Node next : tree[start]){
            //연결된 간선 탐색
            int nextN = next.n; //다음 노드 번호
            long nextD = next.distance; //다음 노드 까지의 간선 거리

            if (visited[nextN] == false){
                dfs(nextN, depth + nextD);
            }
        }
    }

}