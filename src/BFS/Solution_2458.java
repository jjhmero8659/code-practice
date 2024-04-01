
package BFS;

import java.io.*;
import java.util.*;


public class Solution_2458 {
    static int N,M; //정점 개수 , 간선 개수
    static ArrayList<Integer>[] graphs;
    static ArrayList<Integer>[] rGraphs; //역방향 그래프
    static ArrayList<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        N = Integer.parseInt(st.nextToken()); //정점 개수
        M = Integer.parseInt(st.nextToken()); //간선 개수

        graphs = new ArrayList[N+1];
        rGraphs = new ArrayList[N+1];
        
        for (int i=1; i<=N; i++){
            graphs[i] = new ArrayList<>();
            rGraphs[i] = new ArrayList<>();
        }

        for (int i=1; i<=M; i++){
            StringTokenizer stD = new StringTokenizer(br.readLine()," ");

            int sp = Integer.parseInt(stD.nextToken());
            int ep = Integer.parseInt(stD.nextToken());
            
            graphs[sp].add(ep); //단 방향 , 정방향 그래프
            
            rGraphs[ep].add(sp); //역 방향 그래프 , 자신보다 작은 학생 확인 하기 위함
        }

        for (int i=1; i<=N; i++){
            bfs(i); //자신보다 큰 학생 sVisited true
        }

        bw.write(result.size() + "\n");
        bw.flush();
        bw.close();
    }
    


    static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        boolean visited[] = new boolean[N+1];
        visited[start] = true;
        
        //큰 학생 계산
        while (!q.isEmpty()){
            Integer cIdx = q.poll();
            
            for (int nIdx : graphs[cIdx]){
                if (visited[nIdx] == false){ //방문하지 않았다면
                    visited[nIdx] = true;
                    q.offer(nIdx);
                }
            }
        }

        q.offer(start);
        //작은 학생 계산 , 역방향 그래프 사용
        while (!q.isEmpty()){
            Integer cIdx = q.poll();

            for (int nIdx : rGraphs[cIdx]){ // 자신보다 작은 학생을 가리키는 역방향 그래프 순회
                if (visited[nIdx] == false){ //방문하지 않았다면
                    visited[nIdx] = true;
                    q.offer(nIdx);
                }
            }
        }

        boolean pass = true;

        for (int i=1; i<=N; i++){ //모든 학생의 키를 탐색 했는지 확인
            if (visited[i] == false){
                pass = false;
                break;
            }
        }    

        if (pass){ //정확한 키순서를 확인 할 수 있음
            result.add(start);
        }
    }


}