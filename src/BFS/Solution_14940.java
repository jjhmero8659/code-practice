package BFS;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Solution_14940 {
    static int N, M;
    static int[] dx = {0, 1, 0, -1}; //동 남 서 북 x
    static int[] dy = {1, 0, -1, 0}; //동 남 서 북 y
    static int[] startP;
    static int[][] map;
    static boolean[][] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stL = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(stL.nextToken()); // 세로
        M = Integer.parseInt(stL.nextToken()); // 가로

        map = new int[N][M];
        visited = new boolean[N][M];


        for (int i = 0; i < N; i++) {
            StringTokenizer stD = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {
                int area = Integer.parseInt(stD.nextToken());

                if (area == 2) {
                    startP = new int[]{i, j};
                }
                map[i][j] = area;
            }
        }

        bfs(startP[0], startP[1]);

        for (int i = 0; i < N; i++) { //갈수 있는 땅이지만 도달할 수 없는 경우
            for (int j = 0; j < M; j++) {
                if (visited[i][j] == false && map[i][j] == 1){
                    map[i][j] = -1;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                bw.write(map[i][j] + " ");
            }
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }

    static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y}); //초기 시작 값 큐 추가
        map[x][y] = 0;
        visited[x][y] = true; //초기 영역 방문


        while (!q.isEmpty()) {
            int[] pollData = q.poll();
            int cx = pollData[0]; //현재 x 좌표
            int cy = pollData[1]; //현재 y 좌표


            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (0 <= nx && 0 <= ny && nx < N && ny < M) { //다음 영역
                    if (visited[nx][ny] == false && map[nx][ny] == 1) { //방문하지 않음 , 갈 수 있는 땅
                        visited[nx][ny] = true; //방문
                        map[nx][ny] = map[cx][cy] + 1; //지도 거리 1증가
                        q.offer(new int[]{nx, ny}); //다음 좌표 값 큐 삽입

                    }
                }
            }
        }


    }

}