package Greedy;

import java.io.*;


public class Solution_1439 {
    static String N;
    static char[] charArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = br.readLine();

        charArr = N.toCharArray();

        boolean stat;
        long zeroCnt = 0;
        long oneCnt = 0;

        if (charArr[0] == '0'){
            stat = false;
            zeroCnt++;
        }
        else{
            stat = true;
            oneCnt++;
        }



        for (int i=0; i<charArr.length; i++){
            if (charArr[i] == '0'){ //0 일때
                if (stat){ // 연속된 0 처음 발견
                    stat = false;
                    zeroCnt++;
                }
            }
            else{
                if (!stat){
                    stat = true;
                    oneCnt++;
                }
            }
        }

        bw.write(Math.min(oneCnt, zeroCnt) + "\n");
        bw.flush();
        br.close();
        bw.close();
    }

}