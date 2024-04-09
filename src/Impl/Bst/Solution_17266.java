package Impl.Bst;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Solution_17266 {
    static int N, M; //굴다리 길이 , 가로등 개수
    static int[] lamps;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine()); // 굴다리 길이
        M = Integer.parseInt(br.readLine()); // 가로등 개수

        lamps = new int[M];


        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < M; i++) {
            lamps[i] = Integer.parseInt(st.nextToken());
        }


        bw.write(bst() + "\n");

        bw.flush();
        bw.close();
    }

    static boolean possible(int lampD){
        int prev = 0; //처음 가로등 닿는 부분은 0

        for (int i=0; i<lamps.length; i++){
            
            int canLight = lamps[i] - lampD; //다음 램프가 전 램프 까지 닿는 빛 거리
            if (prev >= canLight){ //이전 가로등 까지 닿는다면
                prev = lamps[i] + lampD; 
            }
            else{ //현재 높이로는 가로등 끼리 연결이 불가능
                return false;
            }
        }

        return N - prev <= 0; //길 - 전체 가로등이 닿는 최종 거리
    }

    static int bst(){
        int start = 1; //굴다리 최소 길이 1
        int end = N;
        int answer = N;

        while (start <= end){
            int mid = (start + end) / 2; //가로등 높이

            if (possible(mid)){ //현재 높이로 가로등 끼리 연결 가능
                end = mid - 1; //최대 높이를 줄여 줌
                answer = Math.min(answer, mid); //가능 값 중 최소 가로등 높이 저장
            }
            else{
                //가로등 끼리 연결이 불가능 하므로 높이 증가
                start = mid + 1;
            }
        }
        return answer;
    }

}