package DFS;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


public class Solution_14675 {
    static int N,Q;
    static ArrayList<Integer>[] graphs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        graphs = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            graphs[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            graphs[s].add(e);
            graphs[e].add(s);
        }

        Q = Integer.parseInt(br.readLine());

        for (int i=0; i<Q; i++){
            StringTokenizer stQ = new StringTokenizer(br.readLine());

            int f = Integer.parseInt(stQ.nextToken());
            int s = Integer.parseInt(stQ.nextToken());

            if (f == 1){

            }
            else{

            }
        }

        Collections.sort(result);
        bw.write(result.size() + "\n");



        bw.flush();
        bw.close();
    }

    static void dfs(int start, int now) {
        tempArr.add(now);
        visited[now] = true;

        for (int next : graphs[now]) {
            if (next == start) { //연결된 노드가 cycle 이라면
                for (int n : tempArr) {
                    if (!result.contains(n)) { //이미 cycle로 판단된 Node 가 아니라면
                        result.add(n);
                    }
                }
                return;
            }

            if (!tempArr.contains(next)){ //거쳐오지 않은 숫자
                //시작 지점 에서 일정 진행 후 cycle 에 빠질 수 있음
                visited[next] = true;
                dfs(start, next);
            }
        }
    }


}