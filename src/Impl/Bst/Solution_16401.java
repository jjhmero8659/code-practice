package Impl.Bst;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Solution_16401 {
    static int N, M;

    static int[] snacks;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        
        M = Integer.parseInt(st.nextToken()); //조카 인원
        N = Integer.parseInt(st.nextToken()); //과자 개수

        snacks = new int[N];

        StringTokenizer stD = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            snacks[i] = Integer.parseInt(stD.nextToken());
        }

        Arrays.sort(snacks);

        bw.write(bst()+"\n");

        bw.flush();
        bw.close();
    }

    static int bst(){
        int start = 1;
        int end = snacks[N-1]; // 마지막 값이 가장 큰 과자 임
        int answer = 0;

        while (start <= end){
            int mid = (start + end) / 2; //과자 절단 길이
            int cnt = 0;
            for (int i=0; i<snacks.length; i++){
                if (snacks[i] >= mid){ //절단 길이보다 과자가 같거나 크다면 cnt 추가
                    int snackCnt = snacks[i] / mid;
                    
                    for (int j=0; j<snackCnt; j++){ //분할 해서 나온 과자 개수만큼 cnt 증가
                        cnt++;
                    }
                }
            }
            
            if (cnt >= M){
                //자른 과자의 절단 길이가 조카 수보다 많으면 공통 배분 가능
                start = mid + 1;
                answer = Math.max(answer,mid); //큰 과자 절단 길이로 저장
            }
            else{ //조카 수 대로 과자 배분이 불가능
                end = mid - 1;
            }
        }

        return answer;
    }

}