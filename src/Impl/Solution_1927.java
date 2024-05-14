package Impl;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Solution_1927 {
    static int N;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st  = new StringTokenizer(br.readLine()," ");

        N = Integer.parseInt(st.nextToken()); //연산의 개수

        for (int i=0; i<N; i++){
            int data = Integer.parseInt(br.readLine());

            if (data == 0){
                if (pq.size() == 0){
                    bw.write("0\n");
                }
                else{
                    Integer now = pq.poll();
                    bw.write(now + "\n");
                }
            }
            else{
                pq.offer(data);
            }

        }
        
        bw.flush();
        br.close();
        bw.close();
    }


}