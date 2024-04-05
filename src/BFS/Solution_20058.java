package BFS;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Solution_20058 {
    static int L,Q;
    static int pow;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        L = Integer.parseInt(st.nextToken()); //단계 횟수
        Q = Integer.parseInt(st.nextToken()); //시전 횟수

        pow = (int)Math.pow(2,L);

        map = new int[pow][pow];

        for (int i=0; i<pow; i++){
            StringTokenizer stD = new StringTokenizer(br.readLine()," ");
            for (int j=0; j<pow; j++){
                map[i][j] = Integer.parseInt(stD.nextToken());
            }
        }





        bw.flush();
        bw.close();
    }

    static void areaDivide(){
        int[][] replaceArea = new int[pow][pow];

    }
    static void bfs(int start) {

    }

}