package Impl.Bst;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;


public class Solution_1590 {
    static int N, T;
    static ArrayList<Long> bus = new ArrayList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken()); //버스 개수
        T = Integer.parseInt(st.nextToken()); //영식의 도착 시간

        for (int i=0; i<N; i++){
            StringTokenizer stD = new StringTokenizer(br.readLine() , " ");
            long arrive = Long.parseLong(stD.nextToken()); //도착 시간
            long interval = Long.parseLong(stD.nextToken()); //버스 간격
            long num = Long.parseLong(stD.nextToken()); //버스 대수

            for (int j=0; j<num; j++){ //버스 대수 만큼 반복
                long nextBus = arrive + (interval * j); //다음 버스 시간
                if (nextBus >= T){ //영식의 도착 시간보다 같거나 늦게 도착하는 버스만 추가
                    bus.add(nextBus); //다음 버스를 배열에 추가
                }
            }
        }

        Collections.sort(bus);

        long result = bst();

        bw.write(result == Integer.MAX_VALUE ? "-1\n" : (result - T) + "\n");

        bw.flush();
        bw.close();
    }

    static long bst(){
        int start = 0;
        int end = bus.size()-1;
        long answer = Integer.MAX_VALUE;

        while (start<=end){
            int mid = (start + end) / 2;
            if (bus.get(mid) >= T){
                //버스 도착 시간이 영식 도착 시간보다 같거나 크다면
                answer = Math.min(answer,bus.get(mid)); //작은 값을 넣어줌 , 빨리 도착하는 버스
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }

        return answer;
    }
}