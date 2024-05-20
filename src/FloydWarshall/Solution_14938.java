package FloydWarshall;

import java.io.*;
import java.util.StringTokenizer;


public class Solution_14938 {
    static int N, M , R;
    static int[][] distance;
    static int[] item;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int[] possibleItem;

    public static void main(String[] args) throws IOException {
        
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        N = Integer.parseInt(st.nextToken()); //지역 수
        M = Integer.parseInt(st.nextToken()); //수색 범위
        R = Integer.parseInt(st.nextToken()); //길의 개수


        item = new int[N+1];
        distance = new int[N + 1][N + 1];

        StringTokenizer stD = new StringTokenizer(br.readLine()," ");
        for (int i=1; i<=N; i++){
            item[i] = Integer.parseInt(stD.nextToken());
        }

        possibleItem = item.clone();

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) {
                    distance[i][j] = 0;
                } else {
                    distance[i][j] = 100;
                }
            }
        }

        for (int i = 0; i < R; i++) {
            StringTokenizer stV = new StringTokenizer(br.readLine(), " ");

            int s = Integer.parseInt(stV.nextToken());
            int e = Integer.parseInt(stV.nextToken());
            int v = Integer.parseInt(stV.nextToken());
            if (distance[s][e] > v){
                distance[s][e] = v;
            }
            if (distance[e][s] > v){
                distance[e][s] = v;
            }
        }


        bw.write(solution() + "\n");
        bw.flush();
        br.close();
        bw.close();
    }

    static int solution() {
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (distance[i][j] > distance[i][k] + distance[k][j]){
                        distance[i][j] = distance[i][k] + distance[k][j];
                    }
                }
            }
        }

        int result = 0;
        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            cnt=0;
            for (int j = 1; j <= N; j++) {
                if(distance[i][j]<=M){
                    cnt += item[j];
                }
            }
            result = Math.max(result, cnt);
        }

        return result;
    }


}