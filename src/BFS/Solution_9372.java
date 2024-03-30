package BFS;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Solution_9372 {
    static int T,N,M;
    static ArrayList<Integer>[] countries;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());

        for (int t=0; t<T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            countries = new ArrayList[N+1];

            for (int i=1; i<=N; i++){
                countries[i] = new ArrayList<>();
            }


            for (int i = 1; i <= M; i++) {
                StringTokenizer stD = new StringTokenizer(br.readLine(), " ");

                int s = Integer.parseInt(stD.nextToken());
                int e = Integer.parseInt(stD.nextToken());

                countries[s].add(e); //양방향 연결
                countries[e].add(s);
            }
            
            bw.write(bfs(1)+"\n");
        }

        bw.flush();
        bw.close();
    }

    static int bfs(int sCountry) { //시작 국가
        int airplane = 0;
        boolean[] visited = new boolean[N+1]; //방문 1 ~ N까지
        Queue<Integer> q = new LinkedList<>();
        q.offer(sCountry);
        visited[sCountry] = true; //시작 국가 방문 true

        while (!q.isEmpty()){
            int size = q.size();

            for (int i=0; i<size; i++){
                Integer cIdx = q.poll(); //현재 국가 index

                for (int n : countries[cIdx]){ //현재 국가에서 연결된 국가 순회
                    if (visited[n] == false){
                        visited[n] = true; //다음 국가 방문 true
                        airplane++;
                        q.offer(n); //다음 국가
                    }
                }
            }
        }

        return airplane;
    }
}