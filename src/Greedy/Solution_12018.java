package Greedy;

import java.io.*;
import java.util.*;


public class Solution_12018 {
    static int T, M;
    static int P, L;
    static ArrayList<Integer> subject = new ArrayList<>();
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer stF = new StringTokenizer(br.readLine(), " ");
        T = Integer.parseInt(stF.nextToken()); //과목의 수
        M = Integer.parseInt(stF.nextToken()); //보유 마일리지

        for (int t = 0; t < T; t++) {
            StringTokenizer stD = new StringTokenizer(br.readLine(), " ");

            P = Integer.parseInt(stD.nextToken()); //지원 사람 수
            L = Integer.parseInt(stD.nextToken()); //수강 제한

            PriorityQueue<Integer> pq = new PriorityQueue<>();
            StringTokenizer stI = new StringTokenizer(br.readLine(), " ");

            for (int i = 0; i < P; i++) {
                pq.offer(Integer.parseInt(stI.nextToken()));
            }

            if (P >= L) {
                for (int i = 0; i < (P - L); i++) {
                    pq.poll();
                }

                subject.add(pq.poll());
            } else {
                subject.add(1);
            }

        }

        Collections.sort(subject); //오름 차순 정렬

        for (int deadLine : subject){
            if (M >= deadLine){
                M -= deadLine;
                cnt++;
            }
        }

        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
    }
}