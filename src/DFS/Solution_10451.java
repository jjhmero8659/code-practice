package DFS;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Solution_10451 {
    static int T,N;
    static ArrayList<Integer>[] graphs;
    static boolean[] visited;

    static ArrayList<Integer> duplicate;
    static long cycleCnt;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        T = Integer.parseInt(br.readLine()); //테스트 케이스
        
        
        for (int i=0; i<T; i++){
            
            N = Integer.parseInt(br.readLine()); //node 개수

            graphs = new ArrayList[N+1]; //1 ~ N
            visited = new boolean[N+1]; //1 ~ N

            for (int j=1; j<=N; j++) {
                graphs[j] = new ArrayList<>();
            }

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j=1; j<=N; j++) {

                int sp = j;
                int ep = Integer.parseInt(st.nextToken());

                graphs[sp].add(ep);
            }

            duplicate = new ArrayList<>(); //초기화
            cycleCnt = 0;

            for (int j=1; j<=N; j++){
                if (visited[j] == false){
                    dfs(j);
                }
            }

            bw.write(cycleCnt + "\n");
        }

        bw.flush();
        bw.close();
    }

    static void dfs(int now) {
        visited[now] = true;
        duplicate.add(now);

        for (int n : graphs[now]){ //연결 노드 탐색
            if (duplicate.contains(n)){ //연결된 노드가 이미 중복 배열에 들어있다면
                cycleCnt++; //사이클 추가
                return;
            }
            else{
                dfs(n);
            }
        }

    }
}