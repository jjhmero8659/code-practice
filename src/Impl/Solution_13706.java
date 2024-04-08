package Impl;

import java.io.*;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Solution_13706 {
    static BigInteger N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = new BigInteger(br.readLine());
        
        BigInteger start = new BigInteger("1");
        BigInteger end = N;
        
        while (true){
            BigInteger mid = start.add(end); //시작과 끝 합산
            mid = mid.divide(new BigInteger("2")); //2로 나누기
            
            int result = (mid.multiply(mid)).compareTo(N); //중간 값 제곱하여 N과 같은지 확인
            if (result == 0){ //같을 때
                bw.write( mid + "\n");
                break;
            }
            else if (result == 1){
                end = mid.subtract(new BigInteger("1")); //end = mid - 1
            }
            else{
                start = mid.add(new BigInteger("1"));
            }
        }

        bw.flush();
        bw.close();
    }

}