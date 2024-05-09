package DFS;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Solution_25195 {
    static int N, M;
    static int gomCnt = 0;
    static int[] gomNodes;
    static boolean[] visited; //정점 방문 여부
    static ArrayList<Integer>[] graph; //정점 배열
    static ArrayList<Boolean> findStat = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken()); //정점 개수
        M = Integer.parseInt(st.nextToken()); //Edge 개수

        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer stD = new StringTokenizer(br.readLine(), " ");

            int sp = Integer.parseInt(stD.nextToken());
            int ep = Integer.parseInt(stD.nextToken());

            graph[sp].add(ep);
        }

        gomCnt = Integer.parseInt(br.readLine());
        gomNodes = new int[gomCnt + 1];

        StringTokenizer stG = new StringTokenizer(br.readLine(), " ");
        for (int i = 1; i <= gomCnt; i++) {
            gomNodes[i] = Integer.parseInt(stG.nextToken());
        }

        dfs(1);

        boolean result = true;

        for (boolean stat : findStat){
            if (stat == false){
                result = false;
            }
        }

        bw.write(result == false ? "yes\n" : "Yes\n");
        bw.flush();
        bw.close();
    }

    static void dfs(int num) {
        for (int i=1; i<=gomCnt; i++){
            if (gomNodes[i] == num){
                findStat.add(true);
                return;
            }
        }

        if (graph[num].size() == 0){ //마지막 노드
            findStat.add(false);
            return;
        }

        for (int next : graph[num]) {
            dfs(next);
        }
    }

}