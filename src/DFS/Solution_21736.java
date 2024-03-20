package DFS;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


public class Solution_21736 {
    static int N,M;
    static int[] dx = {0,1,0,-1}; //동 남 서 북
    static int[] dy = {1,0,-1,0}; //동 남 서 북
    static int x,y;
    static int count = 0;
    static char[][] campus; //캠퍼스

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        N = Integer.parseInt(st.nextToken()); //세로 길이
        M = Integer.parseInt(st.nextToken()); //가로 길이

        campus = new char[N][M];


        for (int i=0; i<N; i++){
            String line = br.readLine();
            for (int j=0; j<M; j++){
                if (line.charAt(j) == 'I'){ //도연이 좌표 확인
                    x = i;
                    y = j;
                }
                campus[i][j] = line.charAt(j);
            }
        }

        dfs(x,y);

        if (count == 0){
            bw.write("TT\n");
        }
        else{
            bw.write(count + "\n");
        }

        bw.flush();
        bw.close();
    }

    static void dfs(int x , int y){
        if (campus[x][y] == 'P'){
            count++;
        }
        campus[x][y] = 'X';

        for (int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (0<=nx && nx<N && 0<=ny && ny<M){
                if (campus[nx][ny] != 'X'){
                    dfs(nx,ny);
                }
            }
        }
    }


}