import java.io.*;
import java.util.StringTokenizer;


public class Solution_2531 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stF = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(stF.nextToken()); //벨트의 초밥 총 개수
        int d = Integer.parseInt(stF.nextToken()); //초밥 종류
        int k = Integer.parseInt(stF.nextToken()); //window 길이
        int c = Integer.parseInt(stF.nextToken()); //쿠폰 초밥 번호
        
        int[] s = new int[n]; // 벨트 는 0 ~ n-1 까지

        for (int i=0; i<n; i++){
            s[i] = Integer.parseInt(br.readLine());
        }

        int[] es = new int[d+1]; //초밥의 종류 1~n 개 까지 , 먹은 스시 개수를 담는 배열
        
        int maxT = 0; //현재 까지 찾은 최대 초밥 가지 수
        int currentT = 0; //현재 윈도우의 최대 초밥 가지 수
        
        for(int i=0; i<k; i++){ //첫번째 벨트 접시 부터 윈도우 까지 순회
            int sushiIndex = s[i]; //해당 i번째 접시의 초밥 번호 find
            if (es[sushiIndex] == 0){ //초밥 번호의 cnt == 0 이라면 먹지 않은 초밥
                currentT++; //먹지 않은 초밥이니 현재 가지 수 추가
            }
            es[sushiIndex]++; //먹은 초밥 표시
        }
        
        maxT = currentT; //현재 최대 가지수 = 첫번째 윈도우 가지수
        //첫번째 윈도우 까지만 진행 했기 때문

        if (es[c] == 0) { //쿠폰 초밥이 현재 포함 되지 않은 상태 라면
            maxT = currentT + 1; //쿠폰 초밥을 추가 한 후 최대 가지수 저장
        }

        for (int i=0; i<n-1; i++){

            int delSushiIndex = s[i]; //해당 i번째 접시의 초밥 번호 find

            es[delSushiIndex]--; // find 한 index, window 에서 제외되는 초밥 -
            if (es[delSushiIndex] == 0){ //제외 되는 초밥이 window 에서 유일 했다면
                currentT--; //가지 수 에서도 감소
            }

            int addSushiIndex = s[(i+k) % n]; //해당 (i+k) % n 번째 접시의 초밥 번호 find
            //원형의 배열 , 처음 과 끝이 이어져 있기 때문, 벨트의 특성

            if (es[addSushiIndex] == 0){ //추가 되는 초밥이 window 에 존재 하지 않는 초밥이라면
                currentT++; //가지 수 에서도 증가
            }

            es[addSushiIndex]++; // find 한 index, window 에서 추가 되는 초밥 +

            if (currentT >= maxT){
                if (es[c] == 0){ //쿠폰 초밥이 현재 포함 되지 않은 상태 라면
                    maxT = currentT+1; //쿠폰 초밥을 추가 한 후 최대 가지수 저장
                }
                else {
                    maxT = currentT; //쿠폰 초밥이 포함 되어 있는 상태라면 그냥 저장
                }
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write(maxT + "\n");
        bw.flush();
        bw.close();

    }


}