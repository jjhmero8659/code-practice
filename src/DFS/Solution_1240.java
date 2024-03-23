package DFS;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


public class Solution_1240 {
    static int N,M;
    static ArrayList<Integer>[] node;
    static ArrayList<Integer>[] distance;
    static int resultD = 0;
    static boolean[] visited;
    static boolean find = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer stF = new StringTokenizer(br.readLine()," ");

        N = Integer.parseInt(stF.nextToken()); //노드 정점 개수
        M = Integer.parseInt(stF.nextToken()); //질문 개수

        node = new ArrayList[N+1];
        distance = new ArrayList[N+1]; //노드 간의 거리
        
        visited = new boolean[N+1];

        for (int i=1; i<=N; i++){
            node[i] = new ArrayList<>();
            distance[i] = new ArrayList<>();
        }

        for (int i=0; i<N-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");

            int pNode = Integer.parseInt(st.nextToken());
            int cNode = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            node[pNode].add(cNode); //양방향 연결
            node[cNode].add(pNode);

            distance[pNode].add(d); //양방향 연결
            distance[cNode].add(d); //거리
        }

        for (int i=0; i<M; i++){
            StringTokenizer stQ = new StringTokenizer(br.readLine()," ");

            int start = Integer.parseInt(stQ.nextToken());
            int target = Integer.parseInt(stQ.nextToken());

            if (start == target){
                bw.write(0+"\n");
                continue;
            }

            resultD = 0;
            find = false;
            dfs(start,target,0);

            if(find){
                bw.write(resultD + "\n");
            }

            for (int j=1; j<=N; j++){ //방문 기록 초기화 , 양방향 그래프 이기 때문
                visited[j] = false;
            }
        }




        bw.flush();
        bw.close();
    }

    static void dfs(int s , int t , int d){ //start node , target node , distance
        visited[s] = true;
        
        if (s == t){
            resultD = d;
            find = true;
            return;
        }
        
        for (int i=0; i<node[s].size(); i++){
            Integer nextN = node[s].get(i); //다음 노드 번호
            Integer nextND = distance[s].get(i); //다음 노드 까지의 거리
            if (visited[ nextN ] == false && find == false){ //다음 노드가 현재 방문하지 않은 상태 라면
                dfs(nextN,t,d + nextND);
            }
        }
    }


}