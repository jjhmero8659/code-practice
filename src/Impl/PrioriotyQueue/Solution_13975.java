package Impl.PrioriotyQueue;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Solution_13975 {
    static int N, T;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(br.readLine()); //파일의 개수

            PriorityQueue<Long> q = new PriorityQueue<>(
                    (a, b) -> Long.compare(a, b)
            );

            StringTokenizer stD = new StringTokenizer(br.readLine(), " ");
            for (int i = 0; i < N; i++) {

                q.offer(Long.parseLong(stD.nextToken()));
            }

            Long sum = 0L;

            while (!q.isEmpty()) {
                int size = q.size();
                if (size > 2) {
                    Long min1 = q.poll(); //가장 작은 값
                    Long min2 = q.poll(); //두번째로 작은 값

                    Long tempS = min1 + min2;

                    q.offer(tempS);
                    sum += tempS;
                }else if(size == 2){
                    Long min1 = q.poll(); //가장 작은 값
                    Long min2 = q.poll(); //두번째로 작은 값
                    Long tempS = min1 + min2;

                    q.offer(tempS);
                } else if (size == 1){
                    Long min = q.poll();
                    sum += min;
                }
            }

            bw.write(sum + "\n");
        }


        bw.flush();
        br.close();
        bw.close();
    }


}