package Impl;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Solution_2805 {
    static int N;
    static long M;
    static long[] m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stD = new StringTokenizer(br.readLine()," ");

        N = Integer.parseInt(stD.nextToken()); //나무 개수
        M = Integer.parseInt(stD.nextToken()); //필요한 나무 길이
        m = new long[N];

        StringTokenizer stW = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++){
            m[i] = Long.parseLong(stW.nextToken());
        }       
        
        Arrays.sort(m); //나무 오름차순 정렬
        
        bw.write(measure() + "\n");
        bw.flush();
        bw.close();
    }
    
    static long measure(){
        long start = 0;
        long end = m[m.length - 1]; //배열 마지막 값은 나무 최대 크기 값
        long result = 0;

        while (start <= end){
            long mid = (start + end) / 2; //중간 값
            long sum = 0;

            for (int i=0; i<m.length; i++){
                if (m[i] > mid){
                    //나무가 절단기 높이 보다 작다면 자를 수 없음
                    sum += m[i] - mid;
                }
            }
            
            if (sum < M){
                //만약 자른 나무의 총 합산이 필요 양 보다 작다면
                end = mid - 1;
            }
            else{
                start = mid + 1;
                result = Math.max(result,mid);
            }
        }

        return result;
    }

    

}