package PrefixSum;

import java.io.*;
import java.util.StringTokenizer;


public class Solution_5549 {
    static int N, M, K;
    static int MAP[][];
    static int SJ[][], SO[][], SI[][]; //정글 바다 얼음 합 배열

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {


        StringTokenizer stF = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(stF.nextToken());
        M = Integer.parseInt(stF.nextToken());

        K = Integer.parseInt(br.readLine());

        MAP = new int[N + 1][M + 1]; // 행성 지도
        SJ = new int[N + 1][M + 1]; //정글 합 
        SO = new int[N + 1][M + 1]; //바다 합
        SI = new int[N + 1][M + 1]; //얼음 합
        
        for (int i = 1; i <= N; i++) {
            String area = br.readLine();
            for (int j = 1; j <= M; j++) {
                char c = area.charAt(j - 1); 
                switch (c) { //영역 분류
                    case 'J':
                        MAP[i][j] = 1;
                        break;
                    case 'O':
                        MAP[i][j] = 2;
                        break;
                    case 'I':
                        MAP[i][j] = 3;
                        break;
                }
            }
        }

        sumArrSet();

        for (int i=1; i<=K; i++){
            StringTokenizer stS = new StringTokenizer(br.readLine(), " ");
            int x1 = Integer.parseInt(stS.nextToken());
            int y1 = Integer.parseInt(stS.nextToken());
            int x2 = Integer.parseInt(stS.nextToken());
            int y2 = Integer.parseInt(stS.nextToken());

            search(x1,y1,x2,y2);
        }


        bw.flush();
        bw.close();
    }

    static void search(int x1,int y1,int x2,int y2) throws IOException {
        //정글 합
        int jResult = SJ[x2][y2] - SJ[x2][y1-1] - SJ[x1-1][y2] + SJ[x1-1][y1-1];
        int oResult = SO[x2][y2] - SO[x2][y1-1] - SO[x1-1][y2] + SO[x1-1][y1-1];
        int iResult = SI[x2][y2] - SI[x2][y1-1] - SI[x1-1][y2] + SI[x1-1][y1-1];

        bw.write(jResult + " " + oResult + " " + iResult + "\n");
    }

    static void sumArrSet(){
        for (int i=1; i<=N; i++){
            int area = MAP[i][1];
            if (area == 1){ // 정글
                SJ[i][1] = SJ[i-1][1] + 1;
                SO[i][1] = SO[i-1][1];
                SI[i][1] = SI[i-1][1];
            }
            else if(area == 2){
                SJ[i][1] = SJ[i-1][1];
                SO[i][1] = SO[i-1][1] + 1;
                SI[i][1] = SI[i-1][1];
            }
            else if(area == 3){
                SJ[i][1] = SJ[i-1][1];
                SO[i][1] = SO[i-1][1];
                SI[i][1] = SI[i-1][1] + 1;
            }
        }

        for (int i=1; i<=M; i++){
            int area = MAP[1][i];
            if (area == 1){ // 정글
                SJ[1][i] = SJ[1][i-1] + 1;
                SO[1][i] = SO[1][i-1];
                SI[1][i] = SI[1][i-1];

            }
            else if(area == 2){
                SJ[1][i] = SJ[1][i-1];
                SO[1][i] = SO[1][i-1] + 1;
                SI[1][i] = SI[1][i-1];
            }
            else if(area == 3){
                SJ[1][i] = SJ[1][i-1];
                SO[1][i] = SO[1][i-1];
                SI[1][i] = SI[1][i-1] + 1;
            }
        }

        for (int i=2; i<=N; i++){
            for (int j=2; j<=M; j++){
                int area = MAP[i][j];

                if (area == 1){ // 정글
                    SJ[i][j] = SJ[i][j-1] + SJ[i-1][j] - SJ[i-1][j-1] + 1;
                    SO[i][j] = SO[i][j-1] + SO[i-1][j] - SO[i-1][j-1];
                    SI[i][j] = SI[i][j-1] + SI[i-1][j] - SI[i-1][j-1];
                }
                else if(area == 2){
                    SJ[i][j] = SJ[i][j-1] + SJ[i-1][j] - SJ[i-1][j-1];
                    SO[i][j] = SO[i][j-1] + SO[i-1][j] - SO[i-1][j-1] + 1;
                    SI[i][j] = SI[i][j-1] + SI[i-1][j] - SI[i-1][j-1];
                }
                else if(area == 3){
                    SJ[i][j] = SJ[i][j-1] + SJ[i-1][j] - SJ[i-1][j-1];
                    SO[i][j] = SO[i][j-1] + SO[i-1][j] - SO[i-1][j-1];
                    SI[i][j] = SI[i][j-1] + SI[i-1][j] - SI[i-1][j-1] + 1;
                }
            }
        }
    }

}