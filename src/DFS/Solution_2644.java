package DFS;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Solution_2644 {
    static int resultDegree = 0;
    static int N,M,startNum,targetNum;
    static boolean[] visited;
    static ArrayList<Integer>[] kinship;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine()); //사람 수

        StringTokenizer st = new StringTokenizer(br.readLine() , " ");
        startNum = Integer.parseInt(st.nextToken()); //시작 지점
        targetNum = Integer.parseInt(st.nextToken()); //타겟 지점 , end point

        M = Integer.parseInt(br.readLine()); //edge 수, 관계 연결 선 수

        visited = new boolean[N+1];
        kinship = new ArrayList[N+1];

        for (int i=1; i<=N; i++){
            kinship[i] = new ArrayList<Integer>();
        }


        for (int i=1; i<=M; i++){
            StringTokenizer stD = new StringTokenizer(br.readLine() , " ");
            int startPoint = Integer.parseInt(stD.nextToken()); //시작 지점
            int endPoint = Integer.parseInt(stD.nextToken()); //타겟 지점 , end point

            kinship[startPoint].add(endPoint);
            kinship[endPoint].add(startPoint);
        }

        dfs(startNum, 0); //시작 point 와 차수 전달(시작은 0)

        if (resultDegree == 0){
            bw.write(-1 + "\n");

        }
        else {
            bw.write(resultDegree + "\n");
        }
        bw.flush();
        bw.close();
    }
    
    static void dfs(int index , int currentDegree){
        if (visited[index]){
            return;
        }

        visited[index] = true;

        if (index == targetNum){ //현재 가지고 있는 번호와 target 할 번호가 같다면
            resultDegree = currentDegree; //최종 차수 에 현재 차수 값 대입
            return;
        }

        currentDegree++;

        for (int children : kinship[index]){
            dfs(children, currentDegree);
        }
    }
}