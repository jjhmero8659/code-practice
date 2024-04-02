package BFS;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Solution_17471 {
    static int N;
    static int[] area;
    static int[] population;
    static boolean[] visited;
    static ArrayList<Integer>[] graphs;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        N = Integer.parseInt(br.readLine()); // 구역 개수

        population = new int[N+1];
        graphs = new ArrayList[N+1];
        visited = new boolean[N+1];
        area = new int[N+1];

        StringTokenizer stH = new StringTokenizer(br.readLine(), " ");

        for (int i=1; i<=N; i++){
            graphs[i] = new ArrayList<>();
            population[i] = Integer.parseInt(stH.nextToken());
        }

        for (int i=1; i<=N; i++){
            StringTokenizer stD = new StringTokenizer(br.readLine()," ");
            int M = Integer.parseInt(stD.nextToken()); //간선 개수

            for (int j=1; j<=M; j++){
                int e = Integer.parseInt(stD.nextToken());

                graphs[i].add(e); //양방향
                graphs[e].add(i);
            }
        }

        dfs(1);

        if (min == Integer.MAX_VALUE){
            //바뀌지 않았다면 2개의 구역으로 분할하지 못한다는 뜻
            bw.write("-1\n");
        }
        else{
            bw.write(min + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int areaN){ //구역 분리
        if (areaN == N+1){
            int pA1 = 0; //1구역 총 인구 수 
            int pA2 = 0; //2구역 총 인구 수

            for (int i=1; i<=N; i++){
                if (area[i] == 1){ //현재 구역이 1구역이라면
                    pA1 += population[i]; //1구역 인구 증가
                }
                else{
                    pA2 += population[i]; //2구역 인구 증가
                }
            }

            visited = new boolean[N+1]; //방문 배열
            int areaLink = 0; //현재 분할 된 구역 개수

            for (int i=1; i<=N; i++){
                if (visited[i] == false){
                    areaLink++;
                    bfs(i);
                }
            }

            if (areaLink == 2){
                min = Math.min(min,Math.abs(pA1 - pA2));
            }

            return;
        }
        
        //현재 구역을 1구역으로
        area[areaN] = 1;
        dfs(areaN+1); //다음 구역으로

        //현재 구역을 2구역으로
        area[areaN] = 2;
        dfs(areaN + 1);
    }

    static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true; //현재 구역 true
        int targetArea = area[start]; //현재 구역이 어디 소속인지 저장

        while (!q.isEmpty()){
            Integer poll = q.poll();

            for (int next : graphs[poll]){ //poll 구역 과 연결 되어 있는 구역 순회
                if (area[next] == targetArea && visited[next] == false){
                    //처음 시작한 구역 범위에 속해 있고, 첫 방문 이라면
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }
        
    }
}