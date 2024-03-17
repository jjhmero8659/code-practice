import java.io.*;
import java.util.StringTokenizer;


public class Solution_22857 {
    static int[] a;
    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        a = new int[N + 1]; //들어오는 정수

        StringTokenizer stD = new StringTokenizer(br.readLine(), " ");

        for (int i = 1; i <= N; i++) {
            a[i] = Integer.parseInt(stD.nextToken());
        }

        int begin = 1;
        int end = 1;
        int oddNum = a[1] % 2 == 0 ? 0 : 1; // 홀수면 개수 1증가

        int maxLen = 1;

        while (end < N) {
            end++; //마지막 포인터 값 증가
            if (a[end] % 2 == 0) { //들어온 값이 짝수라면

            } else { //들어온 값이 홀수라면
                oddNum++; //전체 홀수 개수 증가
                while (oddNum > K) { //전체 홀수 개수가 최대 개수보다 크면 반복
                    if (a[begin++] % 2 == 1) { //제외될 숫자가 홀수 라면
                        oddNum--;
                    }
                }
            }
            maxLen = Math.max(maxLen, end - begin + 1);
        }

        bw.write(maxLen - oddNum + "\n");
        bw.flush();
        bw.close();
    }
}
