package BFS;

import java.io.*;
import java.util.*;


public class Solution_2638 {
    static int N, M;
    static int[][] map;
    static int cheeseCnt = 0;
    static int time = 0;
    static int[] dx = {0, 1, 0, -1}; //동 남 서 북
    static int[] dy = {1, 0, -1, 0}; //동 남 서 북

    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            StringTokenizer stD = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                int data = Integer.parseInt(stD.nextToken());

                if (data == 1) { //치즈 개수 계산
                    cheeseCnt++;
                }

                map[i][j] = data;
            }
        }

        while (cheeseCnt != 0) {
            //맵에 치즈가 존재 하지 않을 때 까지 반복
            bfs();
            time++;
        }


        bw.write(time + "\n");
        bw.flush();
        bw.close();
        br.close();
    }


    static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});

        boolean visited[][] = new boolean[N][M];
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int nowX = now[0];
            int nowY = now[1];

            for (int i = 0; i < 4; i++) {
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];

                if (0 <= nx && nx < N && 0 <= ny && ny < M){
                    if (map[nx][ny] == 1 && visited[nx][ny] == true){
                        //현재 방문이 두번째 방문 이라면 , 공기에 두번 닿는 상태
                        map[nx][ny] = 0;
                        cheeseCnt--;
                    }
                    
                    if (visited[nx][ny] == false){
                        if (map[nx][ny] == 1){
                            visited[nx][ny] = true; //공기에 1번 닿은 상태 
                        }
                        else if (map[nx][ny] == 0){
                            visited[nx][ny] = true;
                            q.offer(new int[] {nx,ny});
                        }
                    }
                }
            }
        }
    }

}