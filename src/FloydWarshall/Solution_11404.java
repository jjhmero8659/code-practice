package FloydWarshall;

import java.io.*;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;


public class Solution_11404 {
    static int N, M;
    static int[][] distance;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {



        N = Integer.parseInt(br.readLine()); //도시 수
        M = Integer.parseInt(br.readLine()); //버스 수(간선 수)

        distance = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) {
                    distance[i][j] = 0;
                } else {
                    distance[i][j] = 10000001;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer stD = new StringTokenizer(br.readLine(), " ");

            int s = Integer.parseInt(stD.nextToken());
            int e = Integer.parseInt(stD.nextToken());
            int v = Integer.parseInt(stD.nextToken());
            if (distance[s][e] > v){
                distance[s][e] = v;
            }
        }

        solution();
        print();

        bw.flush();
        br.close();
        bw.close();
    }

    static void solution() {
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (distance[i][j] > distance[i][k] + distance[k][j]){
                        distance[i][j] = distance[i][k] + distance[k][j];
                    }
                }
            }
        }

        for (int i=1; i<=N; i++){
            for (int j=1; j<=N; j++){
                if(distance[i][j] == 10000001){
                    distance[i][j] = 0;
                }
            }
        }
    }

    static void print() throws IOException {
        for (int i=1; i<=N; i++){
            for (int j=1; j<=N; j++){
                bw.write(distance[i][j] + " ");
            }
            bw.write("\n");
        }
    }

}