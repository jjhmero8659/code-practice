package BFS;

import java.io.*;
import java.util.*;


public class Solution_24444 {
    static int N,M,R;
    static ArrayList<Integer>[] graph;
    static int[] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        visited = new int[N+1];

        for (int i=1; i<=N; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i=0; i<M; i++){
            StringTokenizer stL = new StringTokenizer(br.readLine(), " ");

            int s = Integer.parseInt(stL.nextToken());
            int e = Integer.parseInt(stL.nextToken());

            graph[s].add(e); //양방향 연결
            graph[e].add(s);
        }

        for (int i=1; i<=N; i++){
            Collections.sort(graph[i]);
        }

        bfs(R);

        for (int i=1; i<=N; i++){
            bw.write(visited[i] + "\n");
        }

        bw.flush();
        bw.close();
    }

    static void bfs(int root) {
        Queue<Integer> q = new LinkedList<>();
        int vO = 1; //방문 첫번째  = 1

        q.add(root); //루트 노드 추가
        visited[root] = vO;

        while (!q.isEmpty()){
            int idx = q.poll();

            for (int nIdx : graph[idx]){
                if (visited[nIdx] == 0){
                    visited[nIdx] = ++vO;
                    q.offer(nIdx);
                }
            }
        }
    }

}