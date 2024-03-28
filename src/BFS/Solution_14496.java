package BFS;

import java.io.*;
import java.util.*;


public class Solution_14496 {
    static int S,E,N,M;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        S = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        StringTokenizer stS = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(stS.nextToken()); //문자 수 , 정점 수
        M = Integer.parseInt(stS.nextToken()); //간선 수

        graph = new ArrayList[N+1];
        visited = new boolean[N+1];

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

        if (S==E){
            bw.write("0\n");
        }
        else{
            bw.write(bfs()+"\n");
        }

        bw.flush();
        bw.close();
    }

    static long bfs() {
        int depth = 0;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {S, depth});
        visited[S] = true;

        while(!q.isEmpty()){
            int size = q.size();
            for(int s = 0 ; s < size ; s++){
                int[] now = q.poll();
                int idx = now[0];
                int d = now[1];

                if(idx == E){
                    return d;
                }
                for(int next : graph[idx]){
                    if(visited[next]  == false){
                        visited[next] = true;
                        q.offer(new int[] {next, d+1});
                    }
                }

            }
        }
        return -1;
    }

}