package BFS;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Solution_27971 {
    static int D,M,A,B;
    static ArrayList<Integer> cArr = new ArrayList<>();
    static int[] dx;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        D = Integer.parseInt(st.nextToken()); // 타켓 강아지 개수
        M = Integer.parseInt(st.nextToken()); // 닫힌 구간
        A = Integer.parseInt(st.nextToken()); // A마법 생성 수
        B = Integer.parseInt(st.nextToken()); // B마법 생성 수

        dx = new int[] {A,B};
        visited = new boolean[100000+1];

        for (int i=1; i<=M; i++) {
            StringTokenizer stC = new StringTokenizer(br.readLine(), " ");

            int start = Integer.parseInt(stC.nextToken());
            int end = Integer.parseInt(stC.nextToken());
            
            for (int c=start; c<=end; c++){
                if (!cArr.contains(c)){ //새로운 닫힌 구간 숫자라면
                    cArr.add(c);
                }
            }
        }
        
        bw.write(bfs()+"\n");

        bw.flush();
        bw.close();
    }

    static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {0,0}); //시작 0 , depth = 0
        visited[0] = true;

        while (!q.isEmpty()){
            int[] pd = q.poll();
            int cIdx = pd[0];
            int cD = pd[1];

            if (cIdx == D){ //target 값을 찾았다면
                return cD;
            }

            for (int i=0; i<2; i++){
                int nIdx = cIdx + dx[i];

                if (nIdx <= D){ //타겟 강아지 보다 작거나 같을때
                    if (!cArr.contains(nIdx)){ //다음 값이 닫힌 구간에 포함되지 않으면
                        q.offer(new int[] {nIdx , cD + 1});
                    }
                    visited[nIdx] = true;
                }

            }
        }

        return -1;
    }

}