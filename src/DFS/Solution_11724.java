package DFS;

import java.io.*;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;


public class Solution_11724 {
    static int N,M;
    static boolean[] visited; //정점 방문 여부
    static ArrayList<Integer>[] point; //정점 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1];
        point = new ArrayList[N+1];

        for (int i=1; i<=N; i++){
            point[i] = new ArrayList<>();
        }

        for (int i=1; i<=M; i++){
            StringTokenizer stD = new StringTokenizer(br.readLine()," ");
            int sP = Integer.parseInt(stD.nextToken()); //시작 정점
            int eP = Integer.parseInt(stD.nextToken()); //다음 정점

            //양방향 연결 , edge 가 한쪽 방향으로만 연결 된다고 언급한적 없음
            point[sP].add(eP); 
            point[eP].add(sP);
        }

        int count = 0;

        for (int i=1; i<=N; i++){
            //만약 정점이 방문 되어 있지 않은 상태라면
            if (!visited[i]){
                count++; //dfs 횟수 증가
                dfs(i);
            }
        }

        bw.write(count+"\n");
        bw.flush();
        bw.close();
    }

    static void dfs(int index){
        if (visited[index]){ //현재 자신 방문여부가 true 라면
            return;
        }
        
        visited[index] = true; //현재 정점은 방문 상태로 변경

        for (int point : point[index]){
            if (!visited[point]){
                dfs(point);
            }
        }
    }
}