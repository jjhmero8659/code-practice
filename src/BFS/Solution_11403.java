
package BFS;

import java.io.*;
import java.util.*;


public class Solution_11403 {
    static int N; //정점 개수
    static ArrayList<Integer>[] graphs;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()); //정점 개수
        graphs = new ArrayList[N+1];
        
        for (int i=1; i<=N; i++){
            graphs[i] = new ArrayList<>();
        }

        for (int i=1; i<=N; i++){
            StringTokenizer stD = new StringTokenizer(br.readLine()," ");

            for (int j=1; j<=N; j++) {
                int stat = Integer.parseInt(stD.nextToken());
                if (stat == 1){
                    graphs[i].add(j);
                }
            }
        }

        for (int i=1; i<=N; i++){
            bfs(i);
            bw.newLine();
        }

        bw.flush();
        bw.close();
    }

    static void bfs(int start) throws IOException{
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[N+1]; //방문 배열
        q.offer(start);

        while (!q.isEmpty()){
            Integer cIdx = q.poll();
            
            for (int nIdx : graphs[cIdx]){
                if (visited[nIdx] == false){ //방문하지 않았다면
                    visited[nIdx] = true;
                    q.offer(nIdx);
                }
            }
        }

        for (int i=1; i<=N; i++){
            if (visited[i] == true){
                bw.write("1 ");
            }
            else{
                bw.write("0");
            }
        }
    }


}