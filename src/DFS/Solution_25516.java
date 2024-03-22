package DFS;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Solution_25516 {
    static int N, K;
    static boolean visited[];
    static ArrayList<Integer>[] tree;
    static int[] apple;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken()); //세로
        K = Integer.parseInt(st.nextToken()); //타겟 깊이

        visited = new boolean[N];
        tree = new ArrayList[N];
        apple = new int[N];

        for (int i=0; i<N; i++){
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N-1; i++) {
            StringTokenizer stD = new StringTokenizer(br.readLine(), " ");

            int start = Integer.parseInt(stD.nextToken());
            int end = Integer.parseInt(stD.nextToken());

            tree[start].add(end); //부모 노드에 자식 노드를 이어 주기
        }

        StringTokenizer stA = new StringTokenizer(br.readLine(), " ");

        for (int i=0; i<N; i++){
            apple[i] = Integer.parseInt(stA.nextToken());
        }

        dfs(0,0);

        int appleCnt = 0;
        for (int i=0; i<N; i++){
            if (visited[i] == true){
                appleCnt += apple[i];
            }
        }
        bw.write(appleCnt+"\n");
        bw.flush();
        bw.close();
    }

    static void dfs(int nodeN ,int depth) {
        if (depth > K){
            return;
        }
        depth++;
        visited[nodeN] = true; //현재 노드 방문 true

        for (int vertex : tree[nodeN]){ //자식 노드 순회
            if (visited[vertex] == false){
                dfs(vertex , depth); //자식 노드로 dfs 재귀
            }
        }

    }
}