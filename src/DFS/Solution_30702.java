package DFS;

import java.io.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;


public class Solution_30702 {
    static int N, M;
    static char[][] flagA; // 깃 A
    static char[][] flagB; // 깃 B
    static boolean[][] visitedA; // A 방문 기록
    static boolean[][] visitedB; // B 방문 기록
    static int[] dx = {0, 1, 0, -1}; //동 남 서 북 x
    static int[] dy = {1, 0, -1, 0}; //동 남 서 북 y
    static char drawA = 'A';
    static boolean equal = true;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stL = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(stL.nextToken());
        M = Integer.parseInt(stL.nextToken());

        flagA = new char[N][M];
        flagB = new char[N][M];

        visitedA = new boolean[N][M];
        visitedB = new boolean[N][M];


        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                flagA[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                flagB[i][j] = line.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visitedA[i][j] == false){ //현재 방문 영역이 false 라면
                    char targetAC = flagA[i][j]; //바꿔야 할 문자
                    char changeC = flagB[i][j]; //해당 영역의 B flag 문자를 가져옴

                    dfsA(i,j,targetAC, changeC);
                }

            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (flagA[i][j] != flagB[i][j]){
                    equal = false;
                }
            }
        }

        if (equal){
            bw.write("YES\n");
        }
        else{
            bw.write("NO\n");
        }
        bw.flush();
        bw.close();
    }

    static void dfsA(int x, int y, char tc , char cc) {
        // x 좌표 , y 좌표 , 바꿔야 할 flag 의 문자 tc , flagB 에서 얻은 cc로 변경 change char
        // tc -> cc
        visitedA[x][y] = true; //방문 완료
        flagA[x][y] = cc;

        for (int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (0<=nx && nx<N && 0<=ny && ny<M){
                if (visitedA[nx][ny] == false && flagA[nx][ny] == tc){
                    dfsA(nx,ny,tc,cc);
                }
            }
        }

    }

}