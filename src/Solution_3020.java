import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Solution_3020 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer stF = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(stF.nextToken()); //장애물 개수 , 동굴 길이
        int h = Integer.parseInt(stF.nextToken()); //동굴 높이, 장애물의 최대 높이
        
        int[] s = new int[h+1]; //석순 배열
        int[] j = new int[h+1]; //종유석 배열
        
        for (int i=1; i<=n; i++){
            int blockHeight = Integer.parseInt(br.readLine()); //장애물 높이
            
            if (i%2 == 0){ //짝수 => 종유석
                j[blockHeight]++;
            }
            else{ //홀수 => 석순
                s[blockHeight]++;
            }
        }

//        Arrays.sort(s);
//        Arrays.sort(j);

        int[] ss = new int[h+1]; //석순 합 배열
        int[] sj = new int[h+1]; //종유석 합배열

        for (int i=1; i<=h; i++){
            ss[i] = ss[i-1] + s[i];
            sj[i] = sj[i-1] + j[i];
        }

        int minBlock = n; //최소 장애물 개수 , 충돌 횟수
        int duplicateArea = 0; //동일한 충돌 횟수를 가진 영역
        
        for (int i=1; i<=h; i++){ //1구간 부터 높이 h 구간 까지 개똥벌레의 모든 비행의 수
            int crashS = ss[i];
            int crashJ = sj[h] - sj[i];

            if((crashS + crashJ) < minBlock){
                minBlock = crashS + crashJ;
                duplicateArea = 1;
            }
            else if((crashS + crashJ) == minBlock){
                duplicateArea++;
            }
        }

        bw.write(minBlock + " " + duplicateArea + "");
        bw.newLine();
        bw.flush();
        bw.close();
    }

}