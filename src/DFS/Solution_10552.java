
package DFS;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Solution_10552 {
    static int N,M,P; //노드 , 간선 , 채널시작
    static ArrayList<Integer>[] graph;
    static boolean visited[];
    static long cnt = 0;



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        graph = new ArrayList[M+1];
        visited = new boolean[M+1];

        for (int i = 1; i <= M; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer stD = new StringTokenizer(br.readLine(), " ");
            int sp = Integer.parseInt(stD.nextToken()); //좋아 하는 채널
            int ep = Integer.parseInt(stD.nextToken()); //싫어 하는 채널
            
            if (graph[ep].size() == 0){
                graph[ep].add(sp); //싫어 하는 채널이 발생하면 좋아하는 채널로 변경 한다.
                //무조건 막내가 채널을 변경 한다
            }
        }

        dfs(P,0);

        bw.write(cnt + "\n");

        bw.flush();
        bw.close();
    }

    static void dfs(int start, long cDepth) {
        visited[start] = true; //현재 노드

        for (int next : graph[start]) { //이어진 연결 노드
            if (visited[next] == false){
                visited[next] = true;
                cnt++;
                dfs(next,cDepth + 1);
            }
            else{
                cnt = -1;
                return;
            }
        }
    }


}