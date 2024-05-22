package FloydWarshall;

import java.io.*;
import java.util.StringTokenizer;


public class Solution_11562 {
    static int N, M,Q;
    static final int INF = 987654321;
    static int[][] distance;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        N = Integer.parseInt(st.nextToken()); //건물 수
        M = Integer.parseInt(st.nextToken()); //관계 선

        distance = new int[N+1][N+1];

        for (int i=1; i<=N; i++){
            for (int j=1; j<=N; j++){
                if (i != j){
                    distance[i][j] = INF;
                }
            }
        }

        for (int i=0; i<M; i++){
            StringTokenizer stD = new StringTokenizer(br.readLine()," ");

            int s = Integer.parseInt(stD.nextToken());
            int e = Integer.parseInt(stD.nextToken());
            int rotate = Integer.parseInt(stD.nextToken());


            if (distance[s][e] > 1){
                distance[s][e] = 0;
            }

            distance[e][s] = (rotate == 0) ? 1 : 0;
        }

        floyd();

        Q = Integer.parseInt(br.readLine());

        for (int i=0; i<Q; i++){
            StringTokenizer stD = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(stD.nextToken());
            int e = Integer.parseInt(stD.nextToken());

            bw.write(distance[s][e] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }



    static void floyd(){
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {

                    if (distance[i][j] > distance[i][k] + distance[k][j]){
                        distance[i][j] = distance[i][k] + distance[k][j];
                    }
                }
            }
        }
    }
}