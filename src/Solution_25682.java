import java.io.*;
import java.util.StringTokenizer;


public class Solution_25682 {
    static int N, M, K;

    static long SB[][], SW[][], B[][];
    //SW 는 왼쪽 최상단이 White 라는 가정 row,col 이 모두 짝수 또는 홀수면 동일한 white
    //SB 는 왼쪽 최상단이 Black 이라는 가정 row,col 이 모두 짝수 또는 홀수면 동일한 black


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        B = new long[N + 1][M + 1]; //보드 배열


        for (int i = 1; i <= N; i++) {
            String stD = br.readLine();
            for (int j = 1; j <= M; j++) {
                if (stD.charAt(j - 1) == 'W') {
                    B[i][j] = 1; //흰 = 1
                } else {
                    B[i][j] = 2; //검 = 2
                }

            }
        }

        setSumArr();

        long maxValue = Integer.MAX_VALUE;

        for (int i = K; i <= N; i++) {
            for (int j = K; j <= M; j++) {
                maxValue = Math.min(maxValue, (
                        Math.min(
                                SW[i][j] - SW[i - K][j] - SW[i][j - K] + SW[i - K][j - K],
                                SB[i][j] - SB[i - K][j] - SB[i][j - K] + SB[i - K][j - K]
                        )
                ));
            }
        }

        bw.write(maxValue + "\n");
        bw.flush();
        bw.close();

    }

    static boolean isSameColor(int row, int col) {
        return row % 2 == 1 && col % 2 == 1 || col % 2 == 0 && row % 2 == 0;
    }

    static void sumWhite(int i, int j) {
        SW[i][j] = SW[i - 1][j] + SW[i][j - 1] - SW[i - 1][j - 1] + 1;
        SB[i][j] = SB[i - 1][j] + SB[i][j - 1] - SB[i - 1][j - 1];
    }

    static void sumBlack(int i, int j) {
        SW[i][j] = SW[i - 1][j] + SW[i][j - 1] - SW[i - 1][j - 1];
        SB[i][j] = SB[i - 1][j] + SB[i][j - 1] - SB[i - 1][j - 1] + 1;
    }

    static void setSumArr() {
        SW = new long[N + 1][M + 1]; //흰 합배열
        SB = new long[N + 1][M + 1]; //검 합배열

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (B[i][j] == 1) {
                    if (isSameColor(i, j)) {// 홀수와 짝수가 전부 짝수 or 전부 홀수면 동일한 색 이어야함
                        sumBlack(i, j);
                        //검은색, 왼쪽 최상단이 검은색 이라는 가정
                        //변경 되어야 한다.
                    } else { // 동일하지 않은 색으로 칠해져야함
                        sumWhite(i, j);
                        //흰색 , 왼쪽 최상단이 흰색 이라는 가정
                        //변경 되어야 한다.

                        //그림으로 그려봐야 이해 쉬움
                    }
                } else if (B[i][j] == 2) {
                    if (isSameColor(i, j)) {
                        sumWhite(i, j);
                    } else {
                        sumBlack(i, j);
                    }
                }
            }
        }
    }

}