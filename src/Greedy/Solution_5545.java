package Greedy;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Solution_5545 {
    static int N;
    static int A, B, C;
    static Integer[] toping;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        A = Integer.parseInt(st.nextToken()); //도우 가격
        B = Integer.parseInt(st.nextToken()); //토핑 가격

        C = Integer.parseInt(br.readLine());

        toping = new Integer[N]; //도우 열량 배열

        for (int i = 0; i < N; i++) {
            toping[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(toping, Collections.reverseOrder());

        long resultCal = C / A;

        long topingSum = 0;
        for (int i=0; i<N; i++){
            topingSum += toping[i];
            long cal = topingSum + C;
            int doughPay = A + ((i+1) * B);
            long result = cal / doughPay;

            if (resultCal > result){
                break;
            }
            else{
                resultCal = result;
            }
        }

        bw.write(resultCal + "\n");
        bw.flush();
        bw.close();
    }


}