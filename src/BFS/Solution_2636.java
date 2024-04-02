package BFS;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Solution_2636 {
    static int N, M;
    static int[][] map;
    static int cheeseCnt = 0;
    static int[] dx = {0, 1, 0, -1}; //동 남 서 북
    static int[] dy = {1, 0, -1, 0}; //동 남 서 북
    static ArrayList<Integer> cTransferTime = new ArrayList<>(); //치즈 변화 시간

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

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

            cTransferTime.add(cheeseCnt); //치즈 개수 저장 , 0번 index 는 0시간 , 1번은 1시간...
            bfs();
        }

        int time = cTransferTime.size();

        bw.write(time + "\n");
        bw.write(cTransferTime.get(time - 1) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }


    static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        boolean[][] visited = new boolean[N][M];
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int cx = poll[0]; //poll x좌표
            int cy = poll[1]; //poll y좌표

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (0 <= nx && nx < N && 0 <= ny && ny < M) {
                    if (visited[nx][ny] == false) {
                        //방문 하지 않은 영역
                        visited[nx][ny] = true;

                        if (map[nx][ny] == 1) {
                            //cheese 영역 이라면
                            map[nx][ny] = 0; //빈 공간으로 변환
                            cheeseCnt--;
                        } else {
                            q.offer(new int[]{nx, ny});
                        }
                    }
                }
            }
        }
    }

}