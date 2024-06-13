package BFS;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Solution_2468 {
    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1}; //동 서 남 북
    static int[] dy = {1, -1, 0, 0}; //동 서 남 북
    static ArrayList<Integer> safeArea = new ArrayList<>();
    static ArrayList<Integer> height = new ArrayList<>();

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer stD = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                int data = Integer.parseInt(stD.nextToken());
                map[i][j] = data;
                if (!height.contains(data)) {
                    height.add(data);
                }
            }
        }

        safeArea.add(0); //최대 높이의 강수량이 온다면 안전지역은 존재하지 않는다.
        safeArea.add(1); //비가 오지 않는다면 모든 영역이 통합되어 안전 영역이다.

        for (int h : height) {
            visited = new boolean[N][N];
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] > h) { //현재 쏟아지는 강수 높이 보다 지역 높이가 크다면
                        if (visited[i][j] == false) {
                            //방문하지 않은 지역 이라면?
                            bfs(h, i, j);
                            cnt++;
                        }
                    }
                }
            }
            safeArea.add(cnt);
        }

        int answer = 0;
        for (int safeCnt : safeArea){
            answer = Math.max(safeCnt , answer);
        }

        bw.write(answer + "\n");
        bw.flush();
        bw.close();
    }

    static void bfs(int height, int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(x, y));
        visited[x][y] = true;

        while (!q.isEmpty()) {
            Point now = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (isRange(nx,ny)){
                    if (visited[nx][ny] == false && map[nx][ny] > height){
                        //연결된 영역이 방문하지 않은 상태
                        //강수 높이 보다 지역 높이가 큰 상태
                        visited[nx][ny] = true;
                        q.offer(new Point(nx,ny));
                    }
                }
            }
        }
    }


    static boolean isRange(int nx, int ny) {
        return 0 <= nx && 0 <= ny && nx < N && ny < N;
    }
}