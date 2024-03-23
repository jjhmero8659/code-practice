package PrefixSum;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


public class Solution_16472 {
    static int maxLen;
    static int[] alpha = new int[26]; // A=0 , ... Z=25 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        maxLen = Integer.parseInt(br.readLine());
        
        String catS = br.readLine(); //주어진 문자열
        int length = catS.length()-1; //주어진 문자열 길이

        int begin = 0;
        int end = 0;
        int diff = 1; //다른 알파벳의 수
        int result = 0;
        
        alpha[catS.charAt(end) - 'a']++; //첫번째 index count 증가 , 초기값 세팅

        while (end < length){
            end++;
            int charIndex = catS.charAt(end) - 'a'; // A=0 , ... Z=25
            if (alpha[charIndex] == 0){ //현재 존재하지 않은 문자 추가
                diff++; //다른 문자 개수 증가
            }
            alpha[charIndex]++; //count 증가

            while (diff > maxLen && begin < end){ //현재 문자의 종류가 최대치를 넘었다면 시작포인터 증가
                alpha[catS.charAt(begin) - 'a']--; //시작 포인터 문자 제외
                if (alpha[catS.charAt(begin) - 'a'] == 0){
                    diff--;
                }
                begin++;
            }
            result = Math.max(result , end - begin + 1); //현재 포인터 간격 최대값 비교
        }

        bw.write(result+"\n");
        bw.flush();
        bw.close();
    }

}