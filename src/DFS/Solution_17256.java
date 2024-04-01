package DFS;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Solution_17256 {
    static int N;
    static int[] dx = {0, 1}; //동 남 x좌표
    static int[] dy = {1, 0}; //동 남 y좌표
    static char[][] map;
    static boolean visited[][];
    static int minN = Integer.MAX_VALUE;
    static int maxN = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        map = new char[N][N];
        visited = new boolean[N][N];


        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for (int j = 0; j < N; j++) {
                map[i][j] = st.nextToken().charAt(0);
            }
        }

        dfs(0,0, map[0][0] - '0'); //시작 지점은 1,1
        //배열이 0부터 시작 하기때문에 0,0

        bw.write(maxN + " " + minN + "\n");

        bw.write("\n");
        bw.flush();
        bw.close();
    }



    static void dfs(int x, int y , int sum) { //숫자 DFS
        if (x == N-1 && y ==N-1){
            maxN = Math.max(maxN , sum);
            minN = Math.min(minN , sum);
            return;
        }

        char cValue = map[x][y];//현재 좌표 영역의 값 , 연산자 또는 숫자
        visited[x][y] = true; //방문 true

        for (int i=0; i<2; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (0<=nx && nx<N && 0<=ny && ny<N){
                if (visited[nx][ny] == false){
                    if (cValue == '+'){ //현재 가지고 있는 값이 + 연산자
                        dfs(nx,ny,sum + (map[nx][ny] - '0'));
                        //다음 영역의 값은 숫자 일 것임
                        //다음 값 까지 미리 계산
                    }
                    else if (cValue == '-'){
                        dfs(nx,ny,sum - (map[nx][ny] - '0'));
                        //다음 영역의 값은 숫자 일 것임
                        //다음 값 까지 미리 계산
                    }
                    else if (cValue == '*'){
                        dfs(nx,ny,sum * (map[nx][ny] - '0'));
                        //다음 영역의 값은 숫자 일 것임
                        //다음 값 까지 미리 계산
                    }
                    else{
                        //연산자가 아니라면
                        dfs(nx,ny,sum);
                    }
                }
            }
        }

        visited[x][y] = false;
    }
    



}