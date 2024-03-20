package DFS;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


public class Solution_24480 {
    static int N,M,S;
    static int[] visited; //방문 순서 배열
    static int visitNum = 0;
    static ArrayList<Integer>[] vertex;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        N = Integer.parseInt(st.nextToken()); //정점 총 개수
        M = Integer.parseInt(st.nextToken()); //연결 선 개수 , edge
        S = Integer.parseInt(st.nextToken()); //시작 정점

        visited = new int[N+1];
        vertex = new ArrayList[N+1];

        for (int i=1; i<=N; i++){
            vertex[i] = new ArrayList<>();
        }
        
        for (int i=1; i<=M; i++){
            StringTokenizer stE = new StringTokenizer(br.readLine()," ");
            
            int s = Integer.parseInt(stE.nextToken()); //시작 연결 정점
            int e = Integer.parseInt(stE.nextToken()); //끝 연결 정점

            vertex[s].add(e);
            vertex[e].add(s);
        }

        for (int i=1; i<=N; i++){
            Collections.sort(vertex[i],Collections.reverseOrder()); //내림 차순 정렬
        }

        dfs(S);

        for (int i=1; i<=N; i++){
            bw.write(visited[i] + "\n");
        }

        bw.flush();
        bw.close();
    }

    static void dfs(int vNum){
        if (visited[vNum] != 0){
            return; //이미 방문한 정점
        }

        visited[vNum] = ++visitNum;

        for (int vertexNum : vertex[vNum]){
            if (visited[vertexNum] == 0){ //정점 index의 방문 기록이 없다면
                dfs(vertexNum);
            }
        }

    }


}