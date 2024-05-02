package Greedy;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Solution_1758 {
    static int N;
    static PriorityQueue<Integer> waitingLine = new PriorityQueue<>(
            (a,b) -> Integer.compare(b,a)
    );
    static long tip = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine()); //손님 수

        for (int i=0; i<N; i++){
            waitingLine.offer(Integer.parseInt(br.readLine()));
        }

        solution();
        bw.write( tip + "\n");
        bw.flush();
        br.close();
        bw.close();
    }


    static void solution() {
        int size = waitingLine.size();
        for (int i=0; i<size; i++){
            int calTip = waitingLine.poll() - i;

            if (calTip <= 0){
                calTip = 0;
            }
            else{
                tip += calTip;
            }
        }
    }
}