import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;


public class Solution_10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine()); //명령 개수

        Stack stack = new Stack(); //Stack

        for (int i=1; i<=n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");

            switch (st.nextToken()) {
                case "push":
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    try {
                        int popData = (int)stack.pop(); //stack 에서 pop 한 데이터
                        bw.write(popData+"\n");
                    }
                    catch (Exception e){
                        bw.write(-1+"\n");
                    }
                    break;
                case "size":
                    bw.write(stack.size()+"\n");
                    break;
                case "empty":
                    if (stack.isEmpty()){
                        bw.write(1+"\n");
                    }
                    else {
                        bw.write(0+"\n");
                    }
                    break;
                case "top":
                    try {
                        int topData = (int)stack.pop(); //stack 에서 pop 한 데이터
                        bw.write(topData+"\n");
                        stack.push(topData);
                    }
                    catch (Exception e){
                        bw.write(-1+"\n");
                    }
                    break;
            }
        }

        bw.flush();
        bw.close();
    }

}