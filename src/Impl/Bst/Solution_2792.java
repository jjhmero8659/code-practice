package Impl.Bst;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Solution_2792 {
    static int N, M;
    static int[] gems;
    static int minJealousy = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer stF = new StringTokenizer(br.readLine(), " ");
        
        N = Integer.parseInt(stF.nextToken()); //아이들 수
        M = Integer.parseInt(stF.nextToken()); //보석 색상의 수

        gems = new int[M];

        for (int i = 0; i < M; i++) {
            gems[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(gems); //보석 값 정렬

        bst();

        bw.write(minJealousy + "\n"); //최소 질투심 출력

        bw.flush();
        bw.close();
    }

    static void bst(){
        int start = 1;
        int end = gems[gems.length - 1];

        while (start <= end){
            int mid = (start + end) / 2; //질투심
            int possible = 0; //배분 가능 한 아이 수

            for (int gem : gems){
                possible += (gem / mid);
                if (gem % mid != 0){
                    possible++;
                }
            }
            
            if (possible > N){
                //아낌없이 주지 않았다.
                start = mid + 1;
            }
            else{
                //못받는 학생이여도 상관 없음
                //최대 값을 줄여서 진행
                end = mid - 1;
                minJealousy = Math.min(minJealousy,mid);
            }
            
        }
    }

}