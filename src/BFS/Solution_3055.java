package BFS;

import java.io.*;
import java.util.*;


public class Solution_3055 {
    static int N, M;
    static Point D, S;
    static char[][] map;
    static int[] dx = {0, 0, 1, -1}; //동 서 남 북
    static int[] dy = {1, -1, 0, 0}; //동 서 남 북
    static boolean[][] visited;
    static ArrayList<Point> waters = new ArrayList<>();

    static class Point {
        int x;
        int y;
        int cnt; //depth
        int priority;
        //물 = 1
        //고슴도치 = 2

        public Point(int x, int y, int cnt, int priority) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.priority = priority;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new boolean[N][M];

        for (int x = 0; x < N; x++) {
            String line = br.readLine();
            for (int y = 0; y < M; y++) {
                char data = line.charAt(y);
                if (data == 'D') {
                    D = new Point(x, y, 0, 0);
                } else if (data == 'S') {
                    S = new Point(x, y, 0, 2);
                } else if (data == '*') {
                    waters.add(new Point(x,y,0,1)); //물의 개수는 여러개
                }
                map[x][y] = data;
            }
        }
        int result = bfs();

        bw.write(result != -1 ? result + "\n" : "KAKTUS\n");

        bw.flush();
        bw.close();
    }

    static int bfs() {
        PriorityQueue<Point> pq = new PriorityQueue<>(
                (a, b) ->
                        a.cnt == b.cnt ? Integer.compare(a.priority, b.priority) : Integer.compare(a.cnt, b.cnt)
                //depth,cnt(이동 횟수) 최우선
                //고슴도치 보다 물이 더 큰 우선순위를 가짐
        );

        for (Point water : waters){
            pq.offer(water);
            visited[water.x][water.y] = true; //초기 물 방문 True
        }

        pq.offer(S);
        visited[S.x][S.y] = true; //초기 고슴도치 방문 True

        while (!pq.isEmpty()) { //큐가 비어있지 않다면 반복

            Point now = pq.poll();

            if (now.x == D.x && now.y == D.y) { //도착지에 도착했다면
                return now.cnt;
            }

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];


                if (isRange(nx,ny)){
                    if (visited[nx][ny] == false && map[nx][ny] != 'X') {

                        if (now.priority == 1 && nx == D.x && ny == D.y) {
                            //현재 물의 이동이 진행중이며 다음 영역이 비버 영역이라면 Continue
                            continue;
                        }

                        visited[nx][ny] = true;
                        pq.offer(new Point(nx, ny, now.cnt + 1, now.priority));
                    }
                }
            }
        }

        return -1;
    }

    static boolean isRange(int x, int y) {
        return 0 <= x && 0 <= y && x < N && y < M;
    }


}