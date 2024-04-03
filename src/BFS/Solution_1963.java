package BFS;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Solution_1963 {
    static int T, S, E;
    static ArrayList<Integer> primeNum = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());

        for (int i = 1000; i <= 9999; i++) { //4자리 수 시작
            if (isPrime(i) == true) {
                primeNum.add(i);
            }
        }

        for (int t = 0; t < T; t++) {
            StringTokenizer stL = new StringTokenizer(br.readLine(), " ");

            S = Integer.parseInt(stL.nextToken()); // 시작 번호
            E = Integer.parseInt(stL.nextToken()); // 타겟 번호

            if (S == E){
                bw.write("0\n");
                continue;
            }
            int depth = bfs(S);

            bw.write(depth != -1 ? (depth + "\n") : "Impossible\n");
        }

        bw.flush();
        bw.close();
    }

    static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }

        for (int i = 2; i <= Math.sqrt(num); i++) { //제곱근 까지만 순회해도 소수 판별 가능
            if (num % i == 0) {
                return false;
            }
        }

        return true; //소수 임
    }

    static int bfs(int start) {
        //시작 숫자가 소수 배열 몇번째 index 를 가지는지 확인
        int findIdx = primeNum.indexOf(start);
        int depth = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(findIdx);

        boolean[] visited = new boolean[primeNum.size()];
        visited[findIdx] = true;

        while (!q.isEmpty()) {
            int size = q.size();

            for (int s = 0; s < size; s++) {
                Integer cIdx = q.poll(); //현재 비밀번호 index
                int nowP = primeNum.get(cIdx); //현재 비밀번호 값

                if (nowP == E) { //찾았다면
                    return depth;
                }

                //천의 자리수 변경
                for (int i = 1; i < 10; i++) { //1 ~ 9
                    int nextP = (i * 1000) + (nowP % 1000);

                    if (primeNum.contains(nextP) && nextP != nowP) {
                        //바뀐 숫자가 소수 여야함
                        //바뀌기 전 숫자와 달라야 함
                        int nextIdx = primeNum.indexOf(nextP); //바뀐 숫자 Index
                        if (visited[nextIdx] == false) {
                            q.offer(nextIdx);
                            visited[nextIdx] = true;
                        }
                    }

                }
                //백의 자리 수 변경
                for (int i = 0; i < 10; i++) { //0 ~ 9
                    int nextP = ((nowP / 1000) * 1000) + (i * 100) + (nowP % 100);

                    if (primeNum.contains(nextP) && nextP != nowP) {
                        //바뀐 숫자가 소수 여야함
                        //바뀌기 전 숫자와 달라야 함
                        int nextIdx = primeNum.indexOf(nextP); //바뀐 숫자 Index
                        if (visited[nextIdx] == false) {
                            q.offer(nextIdx);
                            visited[nextIdx] = true;
                        }
                    }

                }

                //십의 자리 수 변경
                for (int i = 0; i < 10; i++) { //0 ~ 9
                    int nextP = ((nowP / 100) * 100) + (i * 10) + (nowP % 10);

                    if (primeNum.contains(nextP) && nextP != nowP) {
                        //바뀐 숫자가 소수 여야함
                        //바뀌기 전 숫자와 달라야 함
                        int nextIdx = primeNum.indexOf(nextP); //바뀐 숫자 Index
                        if (visited[nextIdx] == false) {
                            q.offer(nextIdx);
                            visited[nextIdx] = true;
                        }
                    }

                }

                //일의 자리 수 변경
                for (int i = 0; i < 10; i++) { //0 ~ 9
                    int nextP = ((nowP / 10) * 10) + i;

                    if (primeNum.contains(nextP) && nextP != nowP) {
                        //바뀐 숫자가 소수 여야함
                        //바뀌기 전 숫자와 달라야 함
                        int nextIdx = primeNum.indexOf(nextP); //바뀐 숫자 Index
                        if (visited[nextIdx] == false) {
                            q.offer(nextIdx);
                            visited[nextIdx] = true;
                        }
                    }

                }
            }

            depth++;
        }

        return -1;
    }

}