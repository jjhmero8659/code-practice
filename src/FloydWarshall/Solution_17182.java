package FloydWarshall;

import java.io.*;
import java.util.StringTokenizer;


public class Solution_17182 {
    static int N, M;
    static final int INF = 987654321;
    static int[][] distance;
    static int answer = Integer.MAX_VALUE;
    static boolean[] visited;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken()); //행성 수
        M = Integer.parseInt(st.nextToken()); //관계 선

        distance = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i != j) {
                    distance[i][j] = INF;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer stD = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                distance[i][j] = Integer.parseInt(stD.nextToken());
            }
        }

        floyd();

        visited[M] = true;
        dfs(0,M,0);

        bw.write(answer + "\n");

        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int level , int start , int sum){
        if (level == N-1){
            answer = Math.min(answer, sum);
            return;
        }

        for (int i=0; i<N; i++){
            if (visited[i] == false){
                visited[i] = true;
                dfs(level + 1, i, sum + distance[start][i]);
                visited[i] = false;
            }
        }
    }


    static void floyd() {
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {

                    if (distance[i][j] > distance[i][k] + distance[k][j]) {
                        distance[i][j] = distance[i][k] + distance[k][j];
                    }
                }
            }
        }
    }
}