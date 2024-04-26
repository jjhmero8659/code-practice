package Greedy;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Solution_1026 {
    static int N;

    static PriorityQueue<Integer> ascA = new PriorityQueue<>((a,b) -> (Integer.compare(a,b)));
    static PriorityQueue<Integer> descB = new PriorityQueue<>((a,b) -> (Integer.compare(b,a)));


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine()); //원소 개수

        for (int i=0; i<2; i++){
            StringTokenizer st = new StringTokenizer(br.readLine() ," ");
            for (int j=0; j<N; j++){
                int data = Integer.parseInt(st.nextToken());
                if (i==0){
                    ascA.offer(data);
                }
                else{
                    descB.offer(data);
                }
            }
        }

        bw.write(solution() + "\n");
        bw.flush();
        bw.close();
    }

    static long solution(){
        long sum = 0;
        while (!ascA.isEmpty() && !descB.isEmpty()){
            Integer a = ascA.poll();
            Integer b = descB.poll();

            sum += ((long) a * b);
        }

        return sum;
    }
}