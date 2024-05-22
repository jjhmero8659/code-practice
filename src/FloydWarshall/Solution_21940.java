package FloydWarshall;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Solution_21940 {
    static int N, M,F;
    static final int INF = 987654321;
    static int[][] distance;
    static int[] totalD = new int[F];
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

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
            int v = Integer.parseInt(stD.nextToken());

            if (distance[s][e] > v){
                distance[s][e] = v;
            }
        }

        floyd();

        F = Integer.parseInt(br.readLine());
        StringTokenizer stF = new StringTokenizer(br.readLine());

        int[] friendN = new int[F];
        totalD = new int[N+1];
        for (int i=0; i<F; i++){
            friendN[i] = Integer.parseInt(stF.nextToken());
        }


        for (int i=0; i<F; i++){
            for (int j=1; j<=N; j++){
                int friendL = friendN[i];
                //친구 위치

                if (distance[friendL][j] == INF || distance[j][friendL] == INF){
                    totalD[j] = INF;
                }
                else{
                    int rotate = distance[friendL][j] + distance[j][friendL];
                    //왕복 거리
                    totalD[j] += rotate;
                }
            }
        }

        checkMinDistance();

        bw.flush();
        bw.close();
        br.close();
    }

    static void checkMinDistance() throws IOException{
        int min = Integer.MAX_VALUE;

        for (int i=1; i<=N; i++){
            min = Math.min(totalD[i], min);
        }

        for (int i=1; i<=N; i++){
            if (totalD[i] == min){
                bw.write(i + " ");
            }
        }
    }

    static void floyd(){
        for (int k=1; k<=N; k++){
            for (int i=1; i<=N; i++){
                for (int j=1; j<=N; j++){
                    if (distance[i][j] > distance[i][k] + distance[k][j]){
                        distance[i][j] = distance[i][k] + distance[k][j];
                    }
                }
            }
        }
    }
}