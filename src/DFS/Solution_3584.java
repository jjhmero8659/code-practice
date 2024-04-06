package DFS;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Solution_3584 {
    static int T,N;
    static ArrayList<Integer>[] tree;
    static boolean[] visited;
    static long result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine()); //테스트 케이스

        for (int t=0; t<T; t++){
            N = Integer.parseInt(br.readLine());

            tree = new ArrayList[N+1];
            visited = new boolean[N+1];

            for (int i=1; i<=N; i++){
                tree[i] = new ArrayList<>();
            }

            for (int i=0; i<N-1; i++){
                StringTokenizer st = new StringTokenizer(br.readLine() ," ");

                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());

                tree[e].add(s);
            }

            StringTokenizer stD = new StringTokenizer(br.readLine() ," ");

            int targetF = Integer.parseInt(stD.nextToken());
            int targetS = Integer.parseInt(stD.nextToken());
            
            dfs(targetF); //첫 탐색 , 결과 없음
            dfs(targetS);
            bw.write( result + "\n"); //두번째 탐색 막히는 순간 공통 조산
            
        }

        bw.flush();
        bw.close();
    }

    static void dfs(int start) {
        visited[start] = true;

        for (int parent : tree[start]){
            //연결된 간선 탐색

            if (visited[parent] == false){
                dfs(parent);
            }
            else{
                result = parent;
                return;
            }
        }
    }

}