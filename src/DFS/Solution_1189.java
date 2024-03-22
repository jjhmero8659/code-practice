package DFS;

import java.io.*;
import java.util.StringTokenizer;


public class Solution_1189 {
    static int N, M, K;
    static boolean visited[][];
    static char map[][];
    static int[] dx = {0, 1, 0, -1}; //동 남 서 북 x좌표
    static int[] dy = {1, 0, -1, 0}; //동 남 서 북 x좌표
    static int cnt = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken()); //세로
        M = Integer.parseInt(st.nextToken()); //가로
        K = Integer.parseInt(st.nextToken()); //타겟 거리

        visited = new boolean[N][M];
        map = new char[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        dfs(N - 1, 0, 0); //시작 점 , target = (0, M-1)

        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
    }

    static void dfs(int x, int y, int distance) {
        visited[x][y] = true;
        distance++; //거리 증가

        if (x == 0 && y == M - 1) { //우측 최상단 집에 타겟 거리로 이동한다면
            if (distance == K){
                cnt++;
            }
            return;
        }

        for (int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (0<=nx && nx<N && 0<=ny && ny<M){
                if (visited[nx][ny] == false && map[nx][ny] != 'T'){
                    dfs(nx, ny, distance);
                    visited[nx][ny] = false; //최종 목적지 까지 여러가지 탐색경로를 발견 해야함
                    //false 로 변경
                }
            }
        }


    }
}