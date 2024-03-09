import java.io.*;
import java.util.StringTokenizer;


public class test {
    static int N, D, K, C;
    static int[] sushiTable;
    static int[] sushi;
    static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        sushiTable = new int[N];
        for (int i = 0; i < N; i++) {
            sushiTable[i] = Integer.parseInt(br.readLine());
        }
        sushi = new int[D+1];
        System.out.println(check());
    }
    private static int check() {
        int count = 0;
        int max = 0;
        for (int i = 0; i < K; i++) {
            int a = sushiTable[i];

            if(sushi[a]==0) {
                count++;
            }
            sushi[a]++;
        }
        max = count;


        for(int i=0;i<N-1;i++) {
            // 최댓값 판별
            if(count >= max) {
                // 추가로 먹은 초밥이 현재까지 먹은 초밥에 포함되어 있지 않은 경우
                if(sushi[C]==0) {
                    max = count+1;
                }
                // 추가로 먹은 초밥이 이미 포함되어 있는 경우
                else {
                    max = count;
                }
            }

            // 첫 번째 요소 빼기
            sushi[sushiTable[i]]--;
            // 첫 번째 요소와 중복되는 요소가 없다면 count-1
            if(sushi[sushiTable[i]]==0)
                count--;

            // 마지막 요소 추가 전 중복되는 요소가 있는지 확인(중복x -> count+1)
            if(sushi[sushiTable[(i+K)%N]]==0)
                count++;
            //  마지막 요소 추가
            sushi[sushiTable[(i+K)%N]]++;

        }

        return max;

    }

}