package Stack;

import java.io.*;
import java.util.PriorityQueue;
import java.util.Stack;


public class Solution_11286 {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(
                (o1, o2) -> {
                    int first_abs = Math.abs(o1);
                    int second_abs = Math.abs(o2);

                    //절대값이 같은 경우 음수 우선
                    if (first_abs == second_abs){
                        return o1 > o2 ? 1 : -1;
                    }

                    //절대값 작은 데이터 우선
                    return first_abs - second_abs;

                }
        ); //우선 순위 큐

        for (int i=0; i<N; i++){
            int req = Integer.parseInt(br.readLine());
            if (req == 0){
                if (priorityQueue.isEmpty()){
                    bw.write("0\n");
                }
                else{
                    bw.write(priorityQueue.poll()+"\n");
                }
            }
            else{
                priorityQueue.add(req);
            }
        }

        bw.flush();
        bw.close();
    }

}