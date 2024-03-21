package DFS;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


public class Solution_24481 {
    static int N, M, R;
    static ArrayList<Integer>[] tree;
    static int visited[];


    public static void main(String[] args) throws IOException {
        
        //오름차순으로 정렬해서 연결된 노드끼리는 계속 깊게 파고 들어간다.
        //파고 들어가는 노드들은 자식 노드로 취급
        //한번 방문 했다면 depth 갱신은 더이상 없음
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken()); //노드 수
        M = Integer.parseInt(st.nextToken()); //연결 선 수
        R = Integer.parseInt(st.nextToken()); //시작 점

        visited = new int[N+1];
        tree = new ArrayList[N+1];

        for (int i=1; i<=N; i++){
            tree[i] = new ArrayList<Integer>();
            visited[i] = -1;
        }

        for (int i=0; i<M; i++){
            StringTokenizer stD = new StringTokenizer(br.readLine(), " ");

            int start = Integer.parseInt(stD.nextToken());
            int end = Integer.parseInt(stD.nextToken());

            tree[start].add(end);
            tree[end].add(start);
        }

        for (int i=1; i<=N; i++){
            Collections.sort(tree[i]);
        }

        dfs(R , 0);

        for(int i=1; i<=N; i++){
            bw.write(visited[i] + "\n");
        }

        bw.flush();
        bw.close();
    }

    static void dfs(int start , int depth) {
        visited[start] = depth; //현재 지점 방문 true
        depth++;

        for (int vertex : tree[start]){ //순회
            if (visited[vertex] == -1){ //방문하지 않았다면
                dfs(vertex,depth);
            }
        }
    }
}