package FloydWarshall;

import java.io.*;
import java.util.Stack;
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

        distance = new int[N + 1][N + 1];
        prev = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                prev[i][j] = -1;
                if (i != j) {
                    distance[i][j] = INF;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer stD = new StringTokenizer(br.readLine(), " ");

            int s = Integer.parseInt(stD.nextToken());
            int e = Integer.parseInt(stD.nextToken());
            int v = Integer.parseInt(stD.nextToken());

            if (distance[s][e] > v) {
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

    static void floyd() {
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (distance[i][j] > distance[i][k] + distance[k][j]) {
                        distance[i][j] = distance[i][k] + distance[k][j];
                        prev[i][j] = prev[k][j];
                    }
                }
            }
        }
    }

    static void print() throws IOException {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (distance[i][j] == INF) {
                    bw.write("0 ");
                } else {
                    bw.write(distance[i][j] + " ");
                }
            }
            bw.write("\n");
        }


        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) {
                    bw.write("0\n");
                } else {
                    // 자기 자신 or INF 가 아닌 경로가 있는 경우
                    Stack<Integer> stack = new Stack<>();
                    //j 는 최종 도착 점임
                    //역순으로 탐색 하기 위해 최종 점 부터 push 후 진입
                    int prevN = j;

                    stack.push(prevN); //마지막에 꺼낼 데이터는 최종 도착 점 j

                    boolean isPossible = true;
                    while (i != prev[i][prevN]) { //i는 역순으로 탐색할 시작점 즉 stack 에서 가장 마지막에 push 해야할 정점
                        if (prev[i][prevN] == -1){
                            isPossible = false;
                            break;
                        }
                        prevN = prev[i][prevN]; //이전 노드, 정점 갱신
                        //prevN 은 시작점에 도착하기 전까지 매번 이전 값으로 갱신 될 것임
                        stack.push(prevN); //이전 정점 번호 push
                        //시작점 i는 반복문에 해당하지 않음
                        //시작점 이전까지
                    }

                    if (isPossible == false){
                        bw.write("0\n");
                        continue;
                    }

                    stack.push(i); // 시작점 push

                    bw.write(stack.size() + " ");
                    int size = stack.size();
                    for (int s = 0; s < size; s++) {
                        bw.write(stack.pop() + " ");
                    }

                    bw.write("\n");
                }
            }
        }
    }

}