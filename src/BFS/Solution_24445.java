package BFS;

import java.io.*;
import java.util.*;


public class Solution_24445 {
    static int N,M,R;
    static ArrayList<Integer>[] graph;
    static int[] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stL = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(stL.nextToken()); // 노드 개수
        M = Integer.parseInt(stL.nextToken()); // 연결 선 개수
        R = Integer.parseInt(stL.nextToken()); // 시작 정점

        graph = new ArrayList[N+1];
        visited = new int[N+1];

        for (int i=1; i<=N; i++){
            graph[i] = new ArrayList<>();
        }

        for (int i=0; i<M; i++){
            StringTokenizer stD = new StringTokenizer(br.readLine(), " ");

            int sp = Integer.parseInt(stD.nextToken());
            int ep = Integer.parseInt(stD.nextToken());
            
            graph[sp].add(ep); //양방향 노드 연결
            graph[ep].add(sp);
        }

        for (int i=1; i<=N; i++){
            Collections.sort(graph[i],Collections.reverseOrder());
        }
        
        dfs(R);

        for (int i=1; i<=N; i++){
            bw.write(visited[i] + "\n");
        }
        bw.flush();
        bw.close();
    }

    static void dfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start); //노드 번호 추가
        int vO = 1; //방문 순서 1번부터
        visited[start] = vO;
        
        while (!q.isEmpty()){
            Integer dI = q.poll(); //poll data index
            
            for (int v : graph[dI]){
                if (visited[v] == 0){
                    visited[v] = ++vO; //순서 증가 후 대입
                    q.offer(v); //다음 노드 추가
                }
            }
        }
    }

}