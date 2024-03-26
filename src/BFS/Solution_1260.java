package BFS;

import java.io.*;
import java.util.*;


public class Solution_1260 {
    static int N,M,V;
    static ArrayList<Integer>[] graph;
    static boolean visitedBFS[]; //bfs 방문 배열
    static boolean visitedDFS[]; //dfs 방문 배열
    static ArrayList<Integer> visitedDN;
    static ArrayList<Integer> visitedBN;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); //정점 개수
        M = Integer.parseInt(st.nextToken()); //간선 개수
        V = Integer.parseInt(st.nextToken()); //시작 정점
        
        graph = new ArrayList[N+1];
        visitedDFS = new boolean[N+1];
        visitedDN = new ArrayList<>();
        visitedBN = new ArrayList<>();

        for (int i=1; i<=N; i++){
            graph[i] = new ArrayList<>();
        }
        
        for (int i=0; i<M; i++){
            StringTokenizer stD = new StringTokenizer(br.readLine(), " ");

            int pN = Integer.parseInt(stD.nextToken());
            int cN = Integer.parseInt(stD.nextToken());
            
            graph[pN].add(cN); //양방향
            graph[cN].add(pN); 
        }

        for (int i=1; i<=N; i++){
            Collections.sort(graph[i]);
        }

        dfs(V);
        for (int v : visitedDN){
            bw.write(v + " ");
        }
        bw.newLine();

        bfs(V);
        
        for (int v : visitedBN){
            bw.write(v + " ");
        }

        bw.flush();
        br.close();
        bw.close();
    }

    static void dfs(int start){
        visitedDN.add(start);
        visitedDFS[start] = true;

        for (int v : graph[start]){
            if (visitedDFS[v] == false){ //방문 기록이 없으면
                dfs(v);
            }
        }
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        visitedBFS = new boolean[N+1];

        q.add(start); //시작 정점 큐 삽입 , 1 = depth
        visitedBFS[start] = true;
        visitedBN.add(start);

        while (!q.isEmpty()){
            int pD = q.poll(); //poll data vertex

            for (int v : graph[pD]){
                if (visitedBFS[v] == false){
                    visitedBN.add(v);
                    q.offer(v);
                    visitedBFS[v] = true;
                }
            }
        }
    }
}