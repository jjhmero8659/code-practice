
package DFS;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;


public class Solution_2210 {
    static int[][] map = new int[5][5];
    static Set<String> strings = new HashSet<>();
    static int[] dx = {0, 1, 0, -1}; //동 남 서 북 x좌표
    static int[] dy = {1, 0, -1, 0}; //동 남 서 북 y좌표


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (int i=0; i<5; i++){
            StringTokenizer stD = new StringTokenizer(br.readLine()," ");
            for (int j=0; j<5; j++){
                map[i][j] = Integer.parseInt(stD.nextToken());
            }
        }

        for (int i=0; i<5; i++){
            for (int j=0; j<5; j++){
                dfs(i,j,1, String.valueOf(map[i][j]));
            }
        }


        bw.write(strings.size() + "\n");

        bw.flush();
        bw.close();
    }

    static void dfs(int x, int y,int cnt, String s){

        if (cnt == 6){
            if (!strings.contains(s)){
                strings.add(s);
            }
            return;
        }

        for (int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (0<=nx && nx<5 && 0<=ny && ny<5){
                dfs(nx,ny,cnt + 1,s + map[nx][ny]);
            }
        }
    }


}