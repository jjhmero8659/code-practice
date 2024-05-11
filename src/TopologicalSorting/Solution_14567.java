package TopologicalSorting;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Solution_14567 {
    static int N, M;
    static ArrayList<Integer>[] subject;
    static int[] parentSubject;
    static int[] time;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        N = Integer.parseInt(st.nextToken()); //과목의 수
        M = Integer.parseInt(st.nextToken()); //관계

        subject = new ArrayList[N+1];
        parentSubject = new int[N+1];
        time = new int[N+1];

        for (int i=1; i<=N; i++){
            subject[i] = new ArrayList<>();
        }

        for (int i=0; i<M; i++){
            StringTokenizer stD = new StringTokenizer(br.readLine()," ");
            int prev = Integer.parseInt(stD.nextToken()); //선수 과목
            int post = Integer.parseInt(stD.nextToken()); //후수 과목
            
            subject[prev].add(post); //선수 과목을 이수하기 위해 필요한 후수과목 add
            parentSubject[post]++; //후수과목 이수를 위한 선수과목 숫자 + 1
        }

        topologicalSort();

        for (int i=1; i<=N; i++){
            bw.write(time[i] + " ");
        }
        bw.flush();
        bw.close();
    }

    static void topologicalSort(){
        Queue<Integer> q = new LinkedList<>();

        for (int i=1; i<=N; i++){
            if (parentSubject[i] == 0){
                q.offer(i);
                time[i] = 1;
            }
        }

        while (!q.isEmpty()){
            Integer poll = q.poll();

            for (int next : subject[poll]){ //후수 과목

                parentSubject[next]--;
                time[next] = Math.max(time[next] , time[poll] + 1);

                if (parentSubject[next] == 0){
                    q.offer(next);
                }
            }
        }
    }
}