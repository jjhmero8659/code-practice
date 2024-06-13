package DFS;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Solution_16947 {
    static int N;
    static boolean[] isCycle;
    static ArrayList<Integer>[] graphs;
    static boolean[] visited;
    static int[] distFromCycle;

    static class Node{
        int num;
        int distance;

        public Node(int num, int distance) {
            this.num = num;
            this.distance = distance;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken()); //세로

        isCycle = new boolean[N + 1];
        graphs = new ArrayList[N + 1];
        distFromCycle = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            graphs[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer stD = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(stD.nextToken());
            int e = Integer.parseInt(stD.nextToken());

            graphs[s].add(e);
            graphs[e].add(s);
        }

        for (int i=1; i<=N; i++){
            if (checkCycle_dfs(i,i,i) == true){
                //Cycle 찾기
                break;
            }
        }

        for (int i=1; i<=N; i++){
            if (isCycle[i] == false){
                distFromCycle[i] = checkDistance_bfs(i);
            }
        }

        for (int i=1; i<=N; i++){
            bw.write(distFromCycle[i] + " ");
        }
        bw.write("\n");

        bw.flush();
        bw.close();
    }

    static int checkDistance_bfs(int start){
        visited = new boolean[N + 1];
        Queue<Node> q= new LinkedList<>();
        q.offer(new Node(start,0));
        visited[start] = true;

        while (!q.isEmpty()){
            Node now = q.poll();

            if (isCycle[now.num] == true){
                return now.distance;
            }
            for (int next : graphs[now.num]){
                if (visited[next] == false){
                    visited[next] = true;
                    q.offer(new Node(next,now.distance + 1));
                }
            }
        }

        return -1;
    }

    static boolean checkCycle_dfs(int start, int prev, int now) {
        isCycle[now] = true; //현재 노드 Cycle 포함

        for (int next : graphs[now]) {
            //현재 노드와 연결된 인접 노드 탐색

            if (isCycle[next] == false) {
                //인접 노드가 현재 Cycle 탐색에 포함되지 않은 새로운 노드 라면

                if (checkCycle_dfs(start,now,next)) {
                    return true;
                }
            } else if (prev != next && next == start) {
                //이전 노드가 다음 노드가 되는 무한 반복 방지
                //다음 노드가 시작 노드 라면 Cycle을 의미
                return true;
            }
        }

        isCycle[now] = false;
        //현재 노드는 cycle가 형성되지 않고 탐색이 종료 되었음
        return false;
    }
}