package Greedy;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Solution_1417 {
    static Integer N;
    static PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a,b) -> Integer.compare(b,a)
    );
    //내림 차순 정렬

    static int dasom;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken()); //후보의 수

        if (N == 1){
            bw.write("0" + "\n");
        }
        else{
            for (int i=0; i<N; i++){
                int num = Integer.parseInt(br.readLine());
                if (i==0){
                    dasom = num;
                }
                else{
                    pq.offer(num);
                }
            }

            long cnt = 0;

            while (true){
                Integer poll = pq.poll();

                if (poll >= dasom){
                    dasom++;
                    pq.offer(poll - 1);
                    cnt++;
                }
                else{
                    break;
                }
            }

            bw.write(cnt + "\n");
        }

        bw.flush();
        bw.close();
    }

}