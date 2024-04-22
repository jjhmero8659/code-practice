package Greedy;

import java.io.*;
import java.util.PriorityQueue;


public class Solution_1744 {
    static int N;
    static PriorityQueue<Long> negativeQ = new PriorityQueue<>(
            (c1,c2) -> (Long.compare(c1,c2)) //오름 차순 정렬
            // -100 * -90 => 9000 , -20 * -10 => 200
            // 9000 > 200
    );
    static PriorityQueue<Long> positiveQ = new PriorityQueue<>(
            (c1,c2) -> (Long.compare(c2,c1)) //내림차순 정렬
    );
    static long sum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        for (int i=0; i<N; i++){
            long num = Long.parseLong(br.readLine());

            if (num <= 0){
                negativeQ.offer(num); //음수 라면 음수 q에 대입 , 0도 포함 음수 제거 목적
            }
            else{
                if (num == 1){
                    sum += 1;
                    continue;
                }
                positiveQ.offer(num); //양수 라면 양수 q에 대입
            }
        }

        negativeCal();
        positiveQ();

        bw.write(sum + "\n");

        bw.flush();
        bw.close();
    }

    static void negativeCal(){
        //작은 수 부터 정렬해서 poll
        while (!negativeQ.isEmpty()){
            if (negativeQ.size() >= 2){
                long nN1 = negativeQ.poll(); //음수 첫번째 값
                long nN2 = negativeQ.poll(); //음수 두번째 값
                
                sum += (nN1 * nN2); //음수 * 음수 = 양수
            }
            else{
                sum += negativeQ.poll();
                // 짝이 없는 값은 더해주기
            }
        }
    }
    
    static void positiveQ(){
        //큰 수 부터 정렬해서 poll
        while (!positiveQ.isEmpty()){
            if (positiveQ.size() >= 2){
                long pN1 = positiveQ.poll(); //양수 첫번째 값
                long pN2 = positiveQ.poll(); //양수 두번째 값

                sum += (pN1 * pN2); //양수 * 양수
            }
            else{
                sum += positiveQ.poll();
                // 짝이 없는 값은 더해주기
            }
        }
    }

}