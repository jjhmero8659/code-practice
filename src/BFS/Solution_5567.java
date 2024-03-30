package BFS;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Solution_5567 {
    static int N,M;
    static ArrayList<Integer>[] friends;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        friends = new ArrayList[N+1];

        for (int i=1; i<=N; i++){
            friends[i] = new ArrayList<>();
        }

        for (int i=1; i<=M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            friends[s].add(e);
            friends[e].add(s);
        }

        bw.write(bfs(1)+"\n");

        bw.flush();
        bw.close();
    }

    static int bfs(int s) { //상근
        int depth = 0;
        int friendCnt = 0;
        Queue<int[]> q = new LinkedList<>();
        boolean[] visited = new boolean[N+1];
        
        q.offer(new int[] {s,depth});
        visited[s] = true;
        
        while (!q.isEmpty()){
            int size = q.size();
            
            for (int i=0; i<size; i++){
                int[] pd = q.poll();
                int cN = pd[0]; //번호
                int d = pd[1]; //depth

                for (int n : friends[cN]){ //연결된 친구들 확인
                    if (visited[n] == false && d < 2){ //친구의 친구 까지만 , depth == 2까지
                        visited[n] = true;
                        friendCnt++; // 친구 수 증가
                        q.offer(new int[] {n , d+1});
                    }
                }
            }
        }
        
        return friendCnt;
    }
}