package Stack;

import java.io.*;
import java.util.Stack;


public class Solution_1874 {
    static int N;
    static int[] A;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuffer bf = new StringBuffer();

        N = Integer.parseInt(br.readLine());
        A = new int[N+1];

        for (int i=1; i<=N; i++){
            A[i] = Integer.parseInt(br.readLine());
        }

        Stack<Integer> stack = new Stack<>();
        int num = 1; //다음 들어올 값
        
        for (int i=1; i<=N; i++){
            if (A[i] >= num){ //stack 에 들어올 값 보다 출력해야하는 값이 같거나 크다면
                while (A[i] >= num){ //같거나 커질때 까지 반복 num 증가
                    stack.push(num++);
                    bf.append("+\n");
                }
                stack.pop();
                bf.append("-\n");
            }
            else{
                int n = stack.pop();
                if (n > A[i]){
                    bw.write("NO\n");
                    bw.flush();
                    bw.close();
                    return;
                }
                else{
                    bf.append("-\n");
                }
            }
        }

        bw.write(bf.toString()+"\n");
        bw.flush();
        bw.close();
    }

}