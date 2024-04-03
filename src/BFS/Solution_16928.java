package BFS;

import java.io.*;
import java.util.*;


public class Solution_16928 {
    static int N,M;
    static ArrayList<Integer>[] graphs = new ArrayList[100 + 1];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        N = Integer.parseInt(st.nextToken()); //사다리 개수
        M = Integer.parseInt(st.nextToken()); //뱀의 수

        for (int i=0; i<100 + 1; i++){
            graphs[i] = new ArrayList<>();
        }

        for (int i=0; i<N+M; i++){
            StringTokenizer stD = new StringTokenizer(br.readLine()," ");

            int s = Integer.parseInt(stD.nextToken());
            int e = Integer.parseInt(stD.nextToken());

            graphs[s].add(e);
        }

        bw.write(bfs()+"\n");

        bw.flush();
        bw.close();
    }

    static int bfs(){
        int depth = 0;
        PriorityQueue<int[]> q = new PriorityQueue<>(
                (a,b) -> (a[1] - b[1])
        );
        q.offer(new int[] {1,0});

        boolean[] visited = new boolean[100 + 1];
        visited[1] = true;

        while (!q.isEmpty()){
            int[] poll = q.poll();
            int now = poll[0];
            int cd = poll[1]; //현재 depth

            if (now == 100){
                return cd;
            }

            for (int i=1; i<=6; i++){ //주사위를 굴림
                int next = now + i; // 1 ~ 6 증가
                if (0<next && next<=100){ //범위 안에 있어야 함
                    if (visited[next] == false){ //첫 방문 이라면
                        visited[next] = true;
                        if (graphs[next].size() > 0){ //주사위를 굴린 번호에 사다리 또는 뱀
                            for (int nextNum : graphs[next]){ //사다리 또는 뱀으로 이동한 숫자로 Q Offer
                                q.offer(new int[] {nextNum,cd + 1});
                                visited[nextNum] = true;
                            }
                        }
                        else{
                            q.offer(new int[] {next,cd + 1});
                        }
                    }
                }
            }
        }

        return -1;
    }

}