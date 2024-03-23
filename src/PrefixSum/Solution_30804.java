package PrefixSum;

import java.io.*;
import java.util.StringTokenizer;


public class Solution_30804 {
    static int N;
    static int[] fruitCnt = new int[9+1]; //과일 종류는 1 ~ 9
    static int[] fruit; //과일
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        StringTokenizer stD = new StringTokenizer(br.readLine()," ");

        fruit = new int[N+1];

        for (int i=1; i<=N; i++){
            fruit[i] = Integer.parseInt(stD.nextToken());
        }
        
        int begin = 1;
        int end = 1;

        int type = 1; //과일 종류 , 처음은 begin , end 위치가 동일 하므로 type = 1
        int maxValue = 1;

        fruitCnt[fruit[end]]++; //1 index 에 있는 과일 count 추가

        while (end < N){
            if (type <= 2){ //꼬지의 과일 종류가 2이하 라면
                end++; // 길이 증가
                if (fruitCnt[fruit[end]]++ == 0){ //현재 처음 들어온 과일
                    type++;
                }

                if (type <= 2){
                    maxValue = Math.max(maxValue , end - begin + 1); //현재 길이 최대 값 비교
                }
            }
            else { //꼬지의 과일 종류가 3이상 이라면
                while (type > 2){ //과일 종류가 2보다 크면 길이, 종류 줄이기 시도
                    if (--fruitCnt[fruit[begin]] == 0){ //꼬지에서 삭제될 첫번째 과일 개수 감소
                        type--;
                    }
                    begin++;
                }
            }
        }


        bw.write(maxValue+"\n");
        bw.flush();
        bw.close();
    }


}