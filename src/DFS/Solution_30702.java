package DFS;

import java.io.*;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;


public class Solution_30702 {
    static int N, M;
    static char[][] flagA; //
    static char[][] flagB; //
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1}; //동 남 서 북 x
    static int[] dy = {1, 0, -1, 0}; //동 남 서 북 y


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stL = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(stL.nextToken());
        M = Integer.parseInt(stL.nextToken());

        flagA = new char[N][M];
        flagB = new char[N][M];


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




//        for (int i = 0; i < N; i++) {
//            String line = br.readLine();
//            for (int j = 0; j < M; j++) {
//                char data = line.charAt(j);
//                flagBS.add(data);
//                flagB[i][j] = data;
//            }
//        }




        bw.write("\n");
        bw.flush();
        bw.close();
    }

    static void dfs(int x, int y, int t) {


    }


}