package Impl;

import java.io.*;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Solution_2512 {
    static int N;
    static long M;
    static long[] m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        m = new long[N];

        long sum = 0;
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        for (int i=0; i<N; i++){
            int inputM = Integer.parseInt(st.nextToken());
            m[i] = inputM;
            sum += inputM;
        }
        
        Arrays.sort(m); //정렬
        
        M = Long.parseLong(br.readLine()); //최대 예산
        
        if (sum <= M){
            //원하는 예산 합산이 총 예산 보다 적으면 return
            bw.write(m[m.length - 1] + "\n");
        }
        else{
            bw.write(reMeasure() + "\n");
        }

        //예산 합산이 총 예산을 초과 한다면
        bw.flush();
        bw.close();
    }

    static long reMeasure(){
        long start = 1; //최소 값
        long end = m[m.length - 1]; //최대 값
        long result = 0;

        while (start <= end){
            long mid = (start + end) / 2;

            long tempSum = 0;

            for (int i=0; i<N; i++){
                tempSum += Math.min(mid , m[i]);
            }
            
            if (tempSum <= M){
                //재 측정 합산 값이 총 예산 보다 작다면
                start = mid + 1;
                result = Math.max(result,mid);
            }
            else{
                end = mid - 1;
            }
        }

        return result;
    }

}