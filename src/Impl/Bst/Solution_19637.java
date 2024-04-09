package Impl.Bst;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Solution_19637 {
    static int N, M;
    static Strength[] strengths;

    static class Strength{
        String title;
        long power;

        public Strength(String title, long power) {
            this.title = title;
            this.power = power;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken()); //칭호 개수
        M = Integer.parseInt(st.nextToken()); //캐릭터 개수

        strengths = new Strength[N];

        for (int i=0; i<N; i++){
            StringTokenizer stF = new StringTokenizer(br.readLine()," ");
            strengths[i] = new Strength(stF.nextToken(),Long.parseLong(stF.nextToken()));
        }

        Arrays.sort(strengths , (a,b) -> Long.compare(a.power , b.power));
        //power 값에 따른 정렬

        for (int i = 0; i < M; i++) {
            long inputPower = Long.parseLong(br.readLine()); //입력 받은 power

            int start = 0;
            int end = N-1;
            Strength answer = strengths[end];

            while (start <= end){
                int mid = (start + end) / 2;

                if (inputPower <= strengths[mid].power){ //중간 값보다 입력값이 작거나 같다면
                    if (answer.power >= strengths[mid].power){
                        answer = strengths[mid]; //작은 power 의 class 저장
                    }
                    end = mid - 1;
                }
                else{
                    start = mid + 1;
                }
            }

            bw.write(answer.title + "\n");
        }

        bw.flush();
        bw.close();
    }


}