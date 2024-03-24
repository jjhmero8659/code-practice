package BFS;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Solution_2178 {
    static int N, M;
    static int[] dx = {0, 1, 0, -1}; //동 남 서 북 x좌표
    static int[] dy = {1, 0, -1, 0}; //동 남 서 북 y좌표
    static int[][] maze;
    static boolean[][] visited;
    static int POSSIBLE = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stL = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(stL.nextToken()); // 세로
        M = Integer.parseInt(stL.nextToken()); // 가로

        maze = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                maze[i][j] = Integer.parseInt(line.substring(j,j+1));
            }
        }

        bfs(0,0); //시작점 0,0에서 N-1,M-1 까지 , 문제는  1,1 부터 N,M 까지

        bw.write(maze[N-1][M-1] + "\n");

        bw.flush();
        bw.close();
    }

    static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        maze[x][y] = 1; //처음 영역부터 1
        queue.offer(new int[] {x,y}); //시작점 0,0에서 N-1,M-1 까지 , 문제는  1,1 부터 N,M 까지

        
        while (!queue.isEmpty()){ //queue 빌때 까지 반복
            visited[x][y] = true; //현재 방문 true
            int[] pollData = queue.poll(); //Queue 에서 데이터 반환 , 좌표값을 가지고 있음

            for (int i=0; i<4; i++){
                int nx = pollData[0] + dx[i];
                int ny = pollData[1] + dy[i];

                if (0<=nx && 0<=ny && nx<N && ny<M){
                    if (visited[nx][ny] == false && maze[nx][ny] == POSSIBLE){ //다음 영역이 접근 가능하다면
                        maze[nx][ny] = maze[pollData[0]][pollData[1]] + 1; //depth 1 증가
                        queue.add(new int[] {nx,ny});
                    }
                }
            }
        }
    }

}