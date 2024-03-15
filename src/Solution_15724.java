import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Solution_15724 {
    static int N,M;
    static int B[][] ,SB[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        B = new int[N+1][M+1];
        SB = new int[N+1][M+1];


        for (int i=1; i<=N; i++){
            StringTokenizer stD = new StringTokenizer(br.readLine()," ");
            for (int j=1; j<=M; j++){
                SB[i][j] = SB[i-1][j] + SB[i][j-1] + Integer.parseInt(stD.nextToken()) - SB[i-1][j-1];
            }
        }

        int K = Integer.parseInt(br.readLine());

        for (int i=1; i<=K; i++){
            StringTokenizer stP = new StringTokenizer(br.readLine()," ");

            int x1 = Integer.parseInt(stP.nextToken());
            int y1 = Integer.parseInt(stP.nextToken());
            int x2 = Integer.parseInt(stP.nextToken());
            int y2 = Integer.parseInt(stP.nextToken());

            int result = SB[x2][y2] - SB[x1-1][y2] - SB[x2][y1-1] + SB[x1-1][y1-1];
            bw.write(result + "\n");
        }




        bw.flush();
        bw.close();
    }



}