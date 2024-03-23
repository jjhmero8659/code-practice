package PrefixSum;

import java.io.*;
import java.util.Arrays;


public class Solution_1337_x {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine()); // 배열의 길이

        int[] A = new int[n + 1];

        int size = 5;

        int begin = 1;
        int end = 1;

        for (int i = 1; i <= n; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(A); //배열 정렬
        int result = 4; //default 값은 최대 값인 4개 , 4개의 숫자를 추가해서 연속적이게 만들어야함


        for (int i = begin; i <= n; i++) {
            if (A[end] - A[begin] >= size){ //end index 배열 값 - begin index 배열 값 이 5보다 크다면
                begin++; //begin 증가
            }
            else if(A[end] - A[begin] < size){ //begin 포인터와 end 포인터 값의 차가 5보다 작다면
                result = Math.min(result , size -1 - (end - begin)); //
                end++;
            }

        }

        bw.write(result + "");
        bw.flush();
        bw.close();

    }

}