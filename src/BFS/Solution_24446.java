package BFS;

import java.io.*;
import java.util.*;


public class Solution_24446 {
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

        Arrays.fill(visited,-1);

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

        bfs(R);

        for (int i=1; i<=N; i++){
            bw.write(visited[i] + "\n");
        }

        bw.flush();
        bw.close();
    }

    static void bfs(int root) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {root,0}); //시작 정점 , depth = 0 시작
        visited[root] = 0;

        while (!q.isEmpty()){
            int[] pD = q.poll();
            int cn = pD[0]; //노드 번호
            int cd = pD[1]; //노드 depth

            for (int v : graph[cn]){
                if (visited[v] == -1){
                    q.offer(new int[] {v,cd+1});
                    visited[v] = cd + 1;
                }
            }
        }
    }

}