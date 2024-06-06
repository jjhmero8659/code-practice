package BackTracking;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;


public class Solution_14888 {
    static int N;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] number;
    static int[] operator = new int[4];
    static int maxValue = Integer.MIN_VALUE;
    static int minValue = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken()); //숫자 N

        number = new int[N + 1];

        StringTokenizer stD = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            number[i] = Integer.parseInt(stD.nextToken());
        }

        StringTokenizer stC = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(stC.nextToken());
        }


        backTracking(number[0], 1);

        bw.write(maxValue + "\n");
        bw.write(minValue + "\n");
        bw.flush();
        br.close();
        bw.close();
    }

    static void backTracking(int num, int index) {
        if (index == N) {
            maxValue = Math.max(maxValue, num);
            minValue = Math.min(minValue, num);
            return;
        }

        for (int i = 0; i < 4; i++) {

            //연산자 개수가 1개 이상인 경우
            if (operator[i] > 0) {

                //연산자 감소
                operator[i]--;

                switch (i) {
                    case 0: //더하기일 경우
                        backTracking(num + number[index], index + 1);
                        break;
                    case 1: //빼기일 경우
                        backTracking(num - number[index], index + 1);
                        break;
                    case 2: //곱하기일 경우
                        backTracking(num * number[index], index + 1);
                        break;
                    case 3: //나누기일 경우
                        backTracking(num / number[index], index + 1);
                        break;
                }

                operator[i]++;
            }
        }
    }

}

