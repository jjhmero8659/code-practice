import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class Solution_2164 {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        N = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new LinkedList<>();

        for (int i=1; i<=N; i++){
            deque.addLast(i);
        }
        int pollCnt = 0;

        while (pollCnt < N-1){ //꺼낸 숫자의 개수가 N-1이라면 break
            deque.pollFirst();
            Integer replaceNum = deque.pollFirst();
            deque.addLast(replaceNum);
            pollCnt++;
        }

        bw.write(deque.peekFirst() + "\n");
        bw.flush();
        bw.close();
    }
}
