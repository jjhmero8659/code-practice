package Impl.PrioriotyQueue;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Solution_22252 {
    static int N, T;
    static Map<String, PriorityQueue<Integer>> gorilla = new HashMap<>();
    static long sum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int stat = Integer.parseInt(st.nextToken());
            String gName = st.nextToken(); //고릴라 이름
            int infoNum = Integer.parseInt(st.nextToken()); //정보 개수

            if (stat == 1) {
                if (gorilla.get(gName) == null) {

                    PriorityQueue<Integer> pq = new PriorityQueue<>(
                            (a, b) -> Integer.compare(b, a)
                    );

                    for (int j = 0; j < infoNum; j++) {
                        pq.offer(Integer.parseInt(st.nextToken())); //정보 큐 삽입
                    }

                    gorilla.put(gName, pq);
                } else {
                    for (int j = 0; j < infoNum; j++) {
                        gorilla.get(gName).offer(Integer.parseInt(st.nextToken()));
                    }
                }
            } else if (stat == 2) {
                if (gorilla.get(gName) == null) { //정보를 사려하는데 해당 이름을 가진 고릴라가 없다면
                    continue;
                } else {
                    int size = gorilla.get(gName).size();
                    if (size <= infoNum) {
                        while (!gorilla.get(gName).isEmpty()) {
                            sum += gorilla.get(gName).poll();
                        }
                    } else {
                        for (int s = 0; s < infoNum; s++) {
                            sum += gorilla.get(gName).poll();
                        }
                    }
                }
            }
        }

        bw.write(sum + "\n");
        bw.flush();
        br.close();
        bw.close();
    }


}