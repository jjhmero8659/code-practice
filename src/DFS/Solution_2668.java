package DFS;

import java.io.*;
import java.util.*;


public class Solution_2668 {
    static int N;
    static ArrayList<Integer>[] graphs;
    static boolean[] visited;
    static ArrayList<Integer> result = new ArrayList<>();
    static ArrayList<Integer> tempArr = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        graphs = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            graphs[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            int chainN = Integer.parseInt(br.readLine());

            if (i == chainN) { //자기 자신을 가리키는 경우
                result.add(chainN);
            } else {
                graphs[i].add(chainN);
            }
        }

        for (int i = 1; i <= N; i++) {
            tempArr.clear(); //임시 배열 지우기
            dfs(i, i);
        }

        Collections.sort(result);
        bw.write(result.size() + "\n");

        for (int n : result) {
            bw.write(n + "\n");
        }

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