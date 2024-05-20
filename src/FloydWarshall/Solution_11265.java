package FloydWarshall;

import java.io.*;
import java.util.StringTokenizer;


public class Solution_11265 {
    static int N, M;
    static int[][] distance;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken()); //파티장
        M = Integer.parseInt(st.nextToken()); //가능 여부 질의

        distance = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer stD = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                distance[i][j] = Integer.parseInt(stD.nextToken());
            }
        }

        floyd();

        for (int i=0; i<M; i++){
            StringTokenizer stQ = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(stQ.nextToken());
            int e = Integer.parseInt(stQ.nextToken());
            int cost = Integer.parseInt(stQ.nextToken());

            if (cost >= distance[s][e]){
                bw.write("Enjoy other party\n");
            }
            else{
                bw.write("Stay here\n");
            }
        }

        bw.flush();
        br.close();
        bw.close();
    }

    static void floyd() {
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (distance[i][j] > distance[i][k] + distance[k][j]) {
                        distance[i][j] = distance[i][k] + distance[k][j];
                    }
                }
            }
        }
    }

}