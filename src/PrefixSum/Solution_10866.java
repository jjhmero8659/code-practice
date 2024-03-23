package PrefixSum;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;
import java.util.StringTokenizer;


public class Solution_10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine()); //명령 개수

        Deque dequeue = new LinkedList();

        for (int i=1; i<=n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");

            switch (st.nextToken()) {
                case "push_front":
                    dequeue.addFirst(Integer.parseInt(st.nextToken()));
                    break;
                case "push_back":
                    dequeue.addLast(Integer.parseInt(st.nextToken()));
                    break;
                case "pop_front":
                    try {
                        int frontData = (int)dequeue.pollFirst();
                        bw.write(frontData+"\n");
                    }
                    catch (Exception e){
                        bw.write(-1+"\n");
                    }
                    break;
                case "pop_back":
                    try {
                        int backData = (int)dequeue.pollLast();
                        bw.write(backData+"\n");
                    }
                    catch (Exception e){
                        bw.write(-1+"\n");
                    }
                    break;
                case "size":
                    bw.write(dequeue.size()+"\n");
                    break;
                case "empty":
                    if (dequeue.isEmpty()){
                        bw.write(1+"\n");
                    }
                    else {
                        bw.write(0+"\n");
                    }
                    break;
                case "front":
                    try {
                        int getFrontData = (int)dequeue.getFirst();
                        bw.write(getFrontData+"\n");
                    }
                    catch (Exception e){
                        bw.write(-1+"\n");
                    }
                    break;
                case "back":
                    try {
                        int getLastData = (int)dequeue.getLast();
                        bw.write(+getLastData+"\n");
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