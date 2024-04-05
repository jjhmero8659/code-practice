package Dijkstra;

import java.io.*;
import java.util.*;


public class Solution_2665 {
    static int N;
    static int[][] board;
    static int[][] distance;
    static int[] dx = {0, 1, 0, -1};//동남서북
    static int[] dy = {1, 0, -1, 0};//동남서북

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

        N = Integer.parseInt(br.readLine()); //가로 세로 개수
        board = new int[N][N];
        distance = new int[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = line.charAt(j) - '0';
            }
        }
        for (int i = 0; i < N; i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }

        dijkstra();

        bw.write(board[N-1][N-1] == Integer.MAX_VALUE ? "0\n" : distance[N-1][N-1] + "\n");

        bw.flush();
        bw.close();
    }

    static void dijkstra() {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(0, 0));
        distance[0][0] = 0; //시작 점은 항상 흰색 영역

        while (!q.isEmpty()) {
            Point now = q.poll();

            for (int i=0; i<4; i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                if (0<=nx && nx<N && 0<=ny && ny<N){
                    if (distance[nx][ny] > distance[now.x][now.y]){
                        //다음 영역이 현재 영역보다 큰 변환 값을 가지기 때문에 갱신이 필요하다면
                        //현재 영역 값보다 다음 영역 값이 크다는 것은 다음 영역이 먼거리를 돌아왔다는 의심이 가능
                        //영역 값은 검은 방이 흰방으로 변환 된 개수 임                        
                        if (board[nx][ny] == 1){
                            //다음 영역이 흰 공간 이라면
                            //개수를 증가 시킬 필요 없음
                            distance[nx][ny] = distance[now.x][now.y];
                            q.offer(new Point(nx,ny));
                        }
                        else if (board[nx][ny] == 0){
                            //다음 영역이 검은 공간 이라면
                            //흰방으로 접근하여 진행 해야하기 때문에 개수 증가
                            distance[nx][ny] = distance[now.x][now.y] + 1;
                            q.offer(new Point(nx,ny));
                        }
                    }
                }
            }
        }
    }

}