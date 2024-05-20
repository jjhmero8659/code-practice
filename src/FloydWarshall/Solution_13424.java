package FloydWarshall;

import java.io.*;
import java.util.StringTokenizer;


public class Solution_13424 {
    static int N, M, T, F;
    static int[][] distance;
    static int[] friend;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] minD;
    static final int INF = 987654321;

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine()); //테스트 케이스

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            N = Integer.parseInt(st.nextToken()); //방 개수
            M = Integer.parseInt(st.nextToken()); //비밀 통로 개수

            distance = new int[N + 1][N + 1];

            for (int i=1; i<=N; i++){
                for(int j=1; j<=N; j++){
                    if (i != j){
                        distance[i][j] = INF;
                    }
                }
            }
            for (int i = 0; i < M; i++) {
                StringTokenizer stD = new StringTokenizer(br.readLine());

                int s = Integer.parseInt(stD.nextToken());
                int e = Integer.parseInt(stD.nextToken());
                int v = Integer.parseInt(stD.nextToken());

                if (distance[s][e] > v) {
                    distance[s][e] = v;
                }

                if (distance[e][s] > v) {
                    distance[e][s] = v;
                }
            }

            F = Integer.parseInt(br.readLine());

            floyd();

            friend = new int[F];

            StringTokenizer stF = new StringTokenizer(br.readLine());
            for (int i = 0; i < F; i++) {
                friend[i] = Integer.parseInt(stF.nextToken());
            }

            minD = new int[N+1];

            for (int k=0; k<F; k++){
                for (int i=1; i<=N; i++){
                    minD[i] += distance[friend[k]][i];
                }
            }

            int minIdx = INF;
            int minDistance = INF;
            for (int i=1; i<=N; i++){
                if (minDistance > minD[i]){
                    minDistance = minD[i];
                    minIdx = i;
                }
            }

            bw.write(minIdx + "\n");
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