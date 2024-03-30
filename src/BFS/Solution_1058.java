package BFS;

import java.io.*;
import java.util.*;


public class Solution_1058 {
    static int N;
    static ArrayList<Integer>[] friends;
    static long maxCnt = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        friends = new ArrayList[N+1];

        for (int i=1; i<=N; i++){
            friends[i] = new ArrayList<>();
        }

        for (int i=1; i<=N; i++){ //1번 친구부터
            String line = br.readLine();
            for (int j=1; j<=N; j++){
                char sC = line.charAt(j-1);
                if (sC == 'Y'){
                    friends[i].add(j);
                    friends[j].add(i);
                }
            }
        }

        for (int i=1; i<=N; i++){
            bfs(i);
        }

        bw.write(maxCnt +"\n");

        bw.flush();
        bw.close();
    }

    static void bfs(int s) { //상근
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
        
        maxCnt = Math.max(maxCnt, friendCnt);
    }
}