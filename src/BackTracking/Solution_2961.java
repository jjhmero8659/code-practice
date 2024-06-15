package BackTracking;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Solution_2961 {
    static int N, M;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static Ingredient[] ingredients;
    static int min = Integer.MAX_VALUE;
    static class Ingredient{
        int sour;
        int bitter;

        public Ingredient(int sour, int bitter) {
            this.sour = sour;
            this.bitter = bitter;
        }
    }


    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine()); //재료의 개수

        ingredients = new Ingredient[N];

        for (int i=0; i<N; i++){
            StringTokenizer stD = new StringTokenizer(br.readLine()," ");
            int sour = Integer.parseInt(stD.nextToken());
            int bitter = Integer.parseInt(stD.nextToken());

            ingredients[i] = new Ingredient(sour, bitter);
        }

        int input_cnt = 0; //재료의 개수
        int s_mul = 1; //신맛 곱
        int b_hap = 0; //쓴맛 합
        int idx = 0; //재료 인덱스

        backTracking(input_cnt , idx , s_mul , b_hap);

        bw.write(min + "\n");
        bw.flush();
        br.close();
        bw.close();
    }

    static void backTracking(int input_cnt, int idx, int s_mul, int b_hap) {
        if (idx == N){
            if (input_cnt != 0){
                min = Math.min(min , Math.abs(s_mul - b_hap));
            }
            return;
        }

        backTracking(input_cnt, idx + 1,
                s_mul, b_hap);
        backTracking(input_cnt + 1, idx + 1,
                s_mul * ingredients[idx].sour , b_hap + ingredients[idx].bitter);
    }

}
