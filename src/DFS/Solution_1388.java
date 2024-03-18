package DFS;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Solution_1388 {
    static int N, M;
    static int cnt = 0;
    static ArrayList<Character>[] floor; //바닥

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken()); //바닥 세로 크기
        M = Integer.parseInt(st.nextToken()); //바닥 가로 크기

        floor = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            floor[i] = new ArrayList<>();
            String floorData = br.readLine(); //row data
            for (int j = 0; j < M; j++) {
                floor[i].add(floorData.charAt(j));
            }
        }

        for (int i = 1; i <= N; i++) { //1 ~ N 까지 순회
            findWoodByRow(i);
        }

        for (int i=0; i<M; i++){
            findWoodByCol(i);
        }


        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
    }

    static void findWoodByCol(int index) {
        if (N == 1){
            if (floor[1].get(index) == '|'){
                cnt++;
            }
            return;
        }

        for (int i=2; i<=N; i++){
            Character beforeWood = floor[i-1].get(index);
            Character currentWood = floor[i].get(index);

            if (currentWood == '|'){ //마지막 타일이 | 라면 증가
                if (i == N){
                    cnt++;
                }
            }
            else if(beforeWood == '|' && currentWood == '-'){
                cnt++;
            }
        }
    }

    static void findWoodByRow(int index) {
        if (M == 1){
            if (floor[index].get(0) == '-'){
                cnt++;
            }
            return;
        }

        for (int i = 1; i < M; i++) {
            Character beforeWood = floor[index].get(i-1);
            Character currentWood = floor[index].get(i);
            if (currentWood == '-') {
                if (i == M - 1) { //마지막 타일이 - 라면 증가
                    cnt++;
                }
            } else if (beforeWood == '-' && currentWood == '|'){
                cnt++;
            }
        }
    }


}