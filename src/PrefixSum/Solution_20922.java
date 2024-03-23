package PrefixSum;

import java.io.*;
import java.util.StringTokenizer;


public class Solution_20922 {
    static int[] a, aCnt;
    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        a = new int[N + 1]; //들어오는 정수
        aCnt = new int[100000+1]; //정수의 개수

        StringTokenizer stD = new StringTokenizer(br.readLine(), " ");

        for (int i = 1; i <= N; i++) {
            a[i] = Integer.parseInt(stD.nextToken());
        }

        int begin = 1;
        int end = 1;

        int maxLen = 1;

        aCnt[ a[end] ]++;
        
        while(end < N){
            ++end;
            if (++aCnt[ a[end] ] <= K){ //해당 정수의 개수가 2이하 라면 정상 범위
            }
            else{ //2 초과 , 즉 3 이상 이라면
                while (aCnt[ a[end] ] > K){
                    aCnt[ a[begin] ]--; //제외 될 시작 포인터 정수 개수 감소
                    begin++; //시작 포인터 증가
                }
            }
            maxLen = Math.max(maxLen , end - begin + 1);
            
        }

        bw.write(maxLen+"\n");
        bw.flush();
        bw.close();
    }
}
