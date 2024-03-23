package DFS;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


public class Solution_24482 {
    static int N,M,R;
    static ArrayList<Integer>[] node;
    static int[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stF = new StringTokenizer(br.readLine()," ");

        N = Integer.parseInt(stF.nextToken()); //노드 정점 개수
        M = Integer.parseInt(stF.nextToken()); //간선 개수
        R = Integer.parseInt(stF.nextToken()); //시작 정점

        node = new ArrayList[N+1];
        visited = new int[N+1];

        for (int i=1; i<=N; i++){
            node[i] = new ArrayList<>();
        }

        for (int i=0; i<M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");

            int pNode = Integer.parseInt(st.nextToken());
            int cNode = Integer.parseInt(st.nextToken());

            node[pNode].add(cNode); //양방향 연결
            node[cNode].add(pNode);
        }

        for (int i=1; i<=N; i++){
            Collections.sort(node[i],Collections.reverseOrder());
        }



        dfs(R,0);


        for (int i=1; i<=N; i++){
            bw.write(visited[i] - 1 + "\n"); //1부터 시작한 depth 이므로 0부터 시작하기 위해 -1
        }
        bw.flush();
        bw.close();
    }

    static void dfs(int nodeNum,int depth){
        depth++;
        visited[nodeNum] = depth; //depth 는 1부터

        for (int node : node[nodeNum]){
            if (visited[node] == 0){
                dfs(node,depth);
            }
        }
    }


}