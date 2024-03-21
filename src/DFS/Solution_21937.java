package DFS;

import java.io.*;
import java.util.*;


public class Solution_21937 {
    static int N, M, X;
    static ArrayList<Integer>[] graph;
    static boolean visited[];
    static Set<Integer> set = new HashSet<>();
    static ArrayList<Integer> node = new ArrayList<>();
    static boolean find = false;


    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken()); //노드 수
        M = Integer.parseInt(st.nextToken()); //연결 선 수

        visited = new boolean[N+1];
        graph = new ArrayList[N+1];

        for (int i=1; i<=N; i++){
            graph[i] = new ArrayList<Integer>();
        }

        for (int i=0; i<M; i++){
            StringTokenizer stD = new StringTokenizer(br.readLine(), " ");

            int start = Integer.parseInt(stD.nextToken());
            int end = Integer.parseInt(stD.nextToken());

            graph[start].add(end);
        }

        X = Integer.parseInt(br.readLine()); //타겟

        for (int i=1; i<=N; i++){
            node.add(i);
            for (int vertex : graph[i]){ //단방향 그래프 탐색
                find = false;
                dfs(vertex);

                if (find == true){
                    set.addAll(node); //현재 노드들 전부 집합에 추가
                }
                node.clear(); //현재 노드 객체 배열 비우기
            }
        }

        bw.write(set.size() + "\n");

        bw.flush();
        bw.close();
    }

    static void dfs(int start) {
        if (start == X){
            find = true;
            return;
        }

        node.add(start);
        visited[start] = true;

        for (int vertex : graph[start]){
            if (visited[vertex] == false){
                dfs(vertex);
            }
        }
    }
}