package BFS;

import java.io.*;
import java.util.*;


public class Solution_1389 {
    static int N,M; //인물 수 ,  관계 수
    static ArrayList<Integer>[] human;
    static int min = Integer.MAX_VALUE;
    static int answer = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); //인물 수
        M = Integer.parseInt(st.nextToken()); //관계 수

        human = new ArrayList[N+1]; //사람의 번호는 1부터 N까지


        for (int i=1; i<=N; i++){
            human[i] = new ArrayList<>();
        }

        for (int i=0; i<M; i++){
            StringTokenizer stL = new StringTokenizer(br.readLine(), " ");

            int sp = Integer.parseInt(stL.nextToken());
            int ep = Integer.parseInt(stL.nextToken());
            
            human[sp].add(ep); //양방향 연결
            human[ep].add(sp);
        }
        
        for (int i=1; i<=N; i++){
            bfs(i);
        }



        bw.write(answer + "\n");
        bw.flush();
        br.close();
        bw.close();
    }

    static void bfs(int sIndex) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {sIndex, 0}); //시작 index , depth 
        //시작점은 0부터 depth 가짐
        boolean[] visited = new boolean[N+1];
        visited[sIndex] = true;

        int result = 0;
        
        while (!q.isEmpty()){
            int[] pollData = q.poll(); //큐 Data
            int index = pollData[0]; //index
            int depth = pollData[1]; //depth

            for (int friends : human[index]){ //직접 연결 되어있는 친구 수만큼 반복
                if (visited[friends] == false){
                    result += depth + 1;
                    visited[friends] = true; //다음 데이터에 depth값 대입
                    q.offer(new int[] {friends , depth + 1});
                }
            }
        }

        if(result < min){
            min = result;
            answer = sIndex;
        }
    }
}