
package DFS;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Solution_13265 {
    static Integer T, N, M;
    static ArrayList<Integer>[] circleEdge;
    static boolean[] circleColor;
    static boolean[] visited;
    static boolean possible = true;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());

        for (int t=0; t<T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            possible = true;
            circleEdge = new ArrayList[N+1];
            visited = new boolean[N+1];
            circleColor = new boolean[N+1];

            for (int i=1; i<=N; i++){
                circleEdge[i] = new ArrayList<>();
            }

            for (int m=0; m<M; m++){
                StringTokenizer stD = new StringTokenizer(br.readLine(), " ");

                int sp = Integer.parseInt(stD.nextToken());
                int ep = Integer.parseInt(stD.nextToken());

                circleEdge[sp].add(ep);
                circleEdge[ep].add(sp);
            }

            for (int i=1; i<=N; i++){
                if (visited[i] == false){
                    dfs(i,true);
                }

                if (possible == false){
                    break;
                }
            }

            bw.write(possible ? "possible\n" : "impossible\n");
        }

        bw.flush();
        bw.close();
    }

    static void dfs(int num , boolean color) {
        visited[num] = true;
        circleColor[num] = color;

        boolean nextColor = !color;

        for (int nextN : circleEdge[num]){
            if (visited[nextN] == false){ //다음 동그라미로 이동
                dfs(nextN , nextColor);
            }
            else{
                if(circleColor[nextN] == color){ //다음 동그라미가 이미 방문한 상태이고
                    possible = false; //칠해져 있는 색이 같다면
                    //불가능
                }
            }
        }       
    }
}