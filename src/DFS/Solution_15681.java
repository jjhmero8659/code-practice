package DFS;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Solution_15681 {
    static int N,R,Q;
    static ArrayList<Integer>[] tree;
    static long[] subtreeN;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken()); // 노드 , 정점 개수
        R = Integer.parseInt(st.nextToken()); // 트리의 root 노드 번호
        Q = Integer.parseInt(st.nextToken()); // 질문 개수

        tree = new ArrayList[N+1];
        subtreeN = new long[N+1];
        visited = new boolean[N+1];

        for (int i=1; i<=N; i++){
            tree[i] = new ArrayList<>();
        }

        for (int i=1; i<=N-1; i++){
            StringTokenizer stD = new StringTokenizer(br.readLine(), " ");

            int s = Integer.parseInt(stD.nextToken());
            int e = Integer.parseInt(stD.nextToken());
            
            tree[s].add(e); //양방향 연결
            tree[e].add(s);
        }

        dfs(R);
        
        for (int i=0; i<Q; i++){ //질문 개수 만큼 순회
            int qRoot = Integer.parseInt(br.readLine());


            bw.write(subtreeN[qRoot] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int start){ //각 서브트리의 정점 개수 기록
        visited[start] = true; //현재 정점 방문
        subtreeN[start] = 1;

        for (int next : tree[start]){
            if (visited[next] == false){
                visited[next] = true; //다음 정점 visited
                dfs(next);
                subtreeN[start] += subtreeN[next]; //현재 위치의 서브트리 개수에 하위 서브트리 정점 개수를 더해줌
            }
        }
    }


}