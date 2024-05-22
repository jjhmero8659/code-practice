package FloydWarshall;

import java.io.*;
import java.util.StringTokenizer;


public class Solution_11780 {
    static int N, M;
    static final int INF = 987654321;
    static int[][] distance;
    static int[][] prev;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        distance = new int[N+1][N+1];
        prev = new int[N+1][N+1];

        for (int i=1; i<=N; i++){
            for (int j=1; j<=N; j++){
                prev[i][j] = -1;
                if (i!=j){
                    distance[i][j] = INF;
                }
            }
        }

        for (int i=0; i<M; i++){
            StringTokenizer stD = new StringTokenizer(br.readLine()," ");

            int s = Integer.parseInt(stD.nextToken());
            int e = Integer.parseInt(stD.nextToken());
            int v = Integer.parseInt(stD.nextToken());

            if (distance[s][e] > v){
                distance[s][e] = v;
            }
            prev[s][e] = s;
        }

        floyd();

        print(); //전체 출력

        bw.flush();
        bw.close();
        br.close();
    }

    static void floyd(){
        for (int k=1; k<=N; k++){
            for (int i=1; i<=N; i++){
                for (int j=1; j<=N; j++){
                    if (distance[i][j] > distance[i][k] + distance[k][j]){
                        distance[i][j] = distance[i][k] + distance[k][j];
                        prev[i][j] = prev[k][j];
                    }
                }
            }
        }
    }

    static void print() throws IOException{
        for (int i=1; i<=N; i++){
            for (int j=1; j<=N; j++){
                if (distance[i][j] == INF){
                    bw.write("0 ");
                }
                else{
                    bw.write(distance[i][j] + " ");
                }
            }
        }
    }

}