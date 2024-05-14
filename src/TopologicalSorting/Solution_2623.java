package TopologicalSorting;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Solution_2623 {
    static int N, M;
    static ArrayList<Integer>[] relation;
    static ArrayList<Integer>[] order;
    static int[] inDegree;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        N = Integer.parseInt(st.nextToken()); //가수 수
        M = Integer.parseInt(st.nextToken()); //보조 피디 수

        relation = new ArrayList[N+1];
        order = new ArrayList[M];
        inDegree = new int[N+1];

        for (int i=1; i<=N; i++){
            relation[i] = new ArrayList<>();
        }

        for (int i=0; i<M; i++){
            order[i] = new ArrayList<>();
        }

        for (int i=0; i<M; i++){ //순서도 입력 받기
            StringTokenizer stD = new StringTokenizer(br.readLine()," ");

            int range = Integer.parseInt(stD.nextToken());
            for (int r=0; r<range; r++){
                order[i].add(Integer.parseInt(stD.nextToken()));
            }
        }

        for (int i=0; i<M; i++){ //관계 그래프 저장
            for (int j=0; j<order[i].size()-1; j++){
                Integer prev = order[i].get(j);
                Integer post = order[i].get(j + 1);

                relation[prev].add(post); //선행 , 후행 정리
                inDegree[post]++; //차수 정리 , index 는 후행 가수의 번호 , index 값은 선행 가수의 개수
            }
        }

        topologicalSort();

        boolean flag = true;
        for (int i=1; i<=N; i++){
            if (inDegree[i] != 0){
                flag = false;
            }
        }

        bw.write(flag == true ? sb.toString() + " " : "0\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static void topologicalSort(){
        Queue<Integer> q = new LinkedList<>();

        for (int i=1; i<=N; i++){
            if (inDegree[i] == 0){ //선행 가수 가 존재하지 않는다면
                q.offer(i); //offer
            }
        }

        while (!q.isEmpty()){
            Integer now = q.poll();
            sb.append(now + "\n");

            for (int next : relation[now]){
                inDegree[next]--;

                if (inDegree[next] == 0){
                    q.offer(next);
                }
            }
        }
    }
}