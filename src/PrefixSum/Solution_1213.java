package PrefixSum;

import java.io.*;
import java.util.StringTokenizer;


public class Solution_1213 {
    static int[] alpha = new int[26 + 1]; // A to Z , A = 65 , Z = 90
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String name = br.readLine();

        for (int i=1; i<=name.length(); i++){ //알파벳 count
            alpha[name.charAt(i-1) - 64]++;
        }

        if(validate() == false){
            bw.write("I'm Sorry Hansoo" + "\n");
            bw.flush();
            bw.close();
            return;
        };


        printReplaceName();

    }

    static boolean validate(){
        int failCnt = 0;

        for (int i=1; i<alpha.length; i++){
            if (alpha[i] % 2 == 1){ //홀수 라면
                if (failCnt == 1){
                    return false;
                }
                else {
                    failCnt++;
                }
            }
        }
        return true;
    }

    static void printReplaceName() throws IOException {
        int middleIndex = 0;
        for (int i=1; i<alpha.length; i++){ //알파벳
            if(alpha[i] % 2 == 1){
                alpha[i]--;
                for (int j=0; j<alpha[i]/2; j++){
                    bw.write((char)(i + 64) + "");
                }
                middleIndex = i;
            }
            else if (alpha[i] % 2 == 0){
                for (int j=0; j<alpha[i]/2; j++){
                    bw.write((char)(i + 64) + "");
                }
            }
        }

        if (middleIndex != 0){
            bw.write((char)(middleIndex+64) + "");
        }

        for (int i=alpha.length-1; i>=1; i--){
            if (alpha[i] % 2 == 0){
                for (int j=0; j<alpha[i]/2; j++){
                    bw.write((char)(i + 64) + "");
                }
            }
        }

        bw.flush();
    }
}