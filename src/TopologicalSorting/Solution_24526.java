package TopologicalSorting;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Solution_24526 {
    static int N, M;
    static ArrayList<Integer>[] relation;
    static int[] inDegree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        N = Integer.parseInt(st.nextToken()); //부원의 수
        M = Integer.parseInt(st.nextToken()); //관계의 수

        relation = new ArrayList[N+1];

        for (int i=1; i<=N; i++){
            relation[i] = new ArrayList<>();
        }

        inDegree = new int[N+1];

        for (int i=1; i<=M; i++){
            StringTokenizer stD = new StringTokenizer(br.readLine()," ");
            int s = Integer.parseInt(stD.nextToken());
            int e = Integer.parseInt(stD.nextToken());

            relation[e].add(s);
            inDegree[s]++;
        }

        bw.write(topologicalSort() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static int topologicalSort(){
        Queue<Integer> q = new LinkedList<>();
        for (int i=1; i<=N; i++){
            if (inDegree[i] == 0){
                q.offer(i);
            }
        }

        int ans = q.size();


        while (!q.isEmpty()){
            Integer cur = q.peek();
            q.poll();

            for (int next : relation[cur]){
                inDegree[next]--;

                if (inDegree[next] == 0){
                    q.offer(next);
                    ans++;
                }
            }
        }

        return ans;
    }
}