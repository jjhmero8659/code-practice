package DFS;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Solution_15591 {
    static int N,Q;
    static ArrayList<Node>[] graph;
    static boolean[] visited;
    static long K;
    static ArrayList<Integer> possible;
    static class Node{
        int n;
        long d;

        public Node(int n, long d) {
            this.n = n;
            this.d = d;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine() , " ");

        N = Integer.parseInt(st.nextToken()); //동영상 정점 수
        Q = Integer.parseInt(st.nextToken()); //질문 수

        graph = new ArrayList[N+1];

        for (int i=1; i<=N; i++){
            graph[i] = new ArrayList<>();
        }

        for (int i=0; i<N-1; i++){
            StringTokenizer stD = new StringTokenizer(br.readLine()," ");

            int s = Integer.parseInt(stD.nextToken());
            int e = Integer.parseInt(stD.nextToken());
            long d = Long.parseLong(stD.nextToken());

            graph[s].add(new Node(e,d)); //양방향 연결
            graph[e].add(new Node(s,d));
        }

        for (int i=0; i<Q; i++){
            //질문 개수 만큼 반복
            StringTokenizer stD = new StringTokenizer(br.readLine()," ");

            K = Long.parseLong(stD.nextToken());

            int start = Integer.parseInt(stD.nextToken());

            possible = new ArrayList<>(); //초기화
            visited = new boolean[N+1];

            dfs(start,Integer.MAX_VALUE);

            bw.write(possible.size() + "\n");
        }

        bw.flush();
        bw.close();
    }
    
    static void dfs(int start, long depth){
        visited[start] = true;

        for (Node next : graph[start]){

            if (visited[next.n] == false){
                long updateD = Math.min(depth , next.d); //간선 최소 값으로 갱신
                if (updateD >= K){ //K 값 보다 작은 간선 최소 값을 가지면 추천 목록
                    possible.add(next.n);
                }
                dfs(next.n, updateD);
            }
        }
    }
}