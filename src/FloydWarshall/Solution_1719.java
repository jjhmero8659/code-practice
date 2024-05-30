package FloydWarshall;

import java.io.*;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;


public class Solution_1719 {
    static int N, M;
    static final int INF = 987654321;
    static int[][] distance;
    static int[][] firstVisited;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        distance = new int[N + 1][N + 1];
        firstVisited = new int[N + 1][N + 1]; //첫 방문 배열

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                firstVisited[i][j] = j;
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i != j) {
                    distance[i][j] = INF;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer stD = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(stD.nextToken());
            int e = Integer.parseInt(stD.nextToken());
            int v = Integer.parseInt(stD.nextToken());

            if (distance[s][e] > v) {
                distance[s][e] = v;
                distance[e][s] = v;
            }
        }

        floyd();

        bw.write(print() + " ");

        bw.flush();
        bw.close();
        br.close();
    }

    static void floyd() {
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (distance[i][j] > distance[i][k] + distance[k][j]) {
                        distance[i][j] = distance[i][k] + distance[k][j];
                        firstVisited[i][j] = firstVisited[i][k];
                    }
                }
            }
        }
    }

    static String print() {
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) {
                    sb.append("- ");
                } else {
                    sb.append(firstVisited[i][j] + " ");
                }
            }
            sb.append("\n");
        }

        return sb.toString();
    }

}