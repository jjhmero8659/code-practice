package BFS;

import java.io.*;
import java.util.*;


public class Solution_28471 {
    static int N;
    static char[][] board;
    static boolean[][] visited;
    static int[] dx = {0,1,1,1,0,-1,-1}; //동 동남 남 남서 서 서북 북동  , 북 제외
    static int[] dy = {1,1,0,-1,-1,-1,1}; //동 동남 남 남서 서 서북 북동  , 북 제외
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        N = Integer.parseInt(st.nextToken()); // 보드 가로 세로

        board = new char[N][N];
        visited = new boolean[N][N];

        for (int i=0; i<N; i++) {
            String line = br.readLine();
            for (int j=0; j<N; j++) {
                char c = line.charAt(j);
                board[i][j] = c;
            }
        }

        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (board[i][j] == '.' && visited[i][j] == false){
                    bfs(i, j);
                    for (int v=0; v<N; v++){
                        Arrays.fill(visited[v], false);
                    }
                }
            }
        }
        bw.write(cnt + "\n");

        bw.flush();
        bw.close();
    }



    static void bfs(int x, int y){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {x,y});
        visited[x][y] = true;
        
        while (!q.isEmpty()){
            int[] pd = q.poll();
            int cx = pd[0];
            int cy = pd[1];
            
            if (board[cx][cy] == 'F'){
                cnt++; //도착 개수 1증가
                return;
            }

            for (int i=0; i<7; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (0<=nx && 0<=ny && nx<N && ny<N){
                    if (visited[nx][ny] == false && board[nx][ny] != '#'){
                        q.offer(new int[] {nx,ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }

}