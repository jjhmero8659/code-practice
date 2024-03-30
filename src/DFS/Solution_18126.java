
package DFS;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;


public class Solution_18126 {
    static int N; //노드,  정점 개수
    static ArrayList<Node>[] graph;
    static boolean visited[];
    static long maxD = 0;

    static class Node {
        int v;
        long distance;

        Node(int v, long distance) {
            this.v = v;
            this.distance = distance;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N+1];
        visited = new boolean[N+1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int sp = Integer.parseInt(st.nextToken());
            int ep = Integer.parseInt(st.nextToken());
            long distance = Long.parseLong(st.nextToken());

            Node sNode = new Node(sp, distance); //시작 노드
            Node eNode = new Node(ep, distance); //연결 노드

            graph[sp].add(eNode); //양방향 연결
            graph[ep].add(sNode);
        }

        dfs(1,0);

        bw.write(maxD + "\n");

        bw.flush();
        bw.close();
    }

    static void dfs(int start, long cDepth) {
        visited[start] = true; //현재 노드

        for (Node node : graph[start]) { //이어진 연결 노드
            int nextN = node.v; //node num , 다음 연결 노드
            long nextD = node.distance; // 다음 연결 노드 까지의 거리

            if (visited[nextN] == false){
                maxD = Math.max(maxD, cDepth + nextD); // 현재 노드와 다음 노드 까지의 거리 합 , 전체 최대 거리 비교
                visited[nextN] = true;
                dfs(nextN,cDepth + nextD);
            }
        }
    }


}