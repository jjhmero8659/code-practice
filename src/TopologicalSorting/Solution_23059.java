package TopologicalSorting;

import java.io.*;
import java.util.*;


public class Solution_23059 {
    static int N;
    static Map<String, ArrayList<String>> relation = new HashMap<>();
    static Map<String, Integer> inDegree = new HashMap<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        N = Integer.parseInt(br.readLine()); //아이템 수

        for (int i = 0; i < N; i++) {
            StringTokenizer stD = new StringTokenizer(br.readLine(), " ");

            String prev = stD.nextToken();
            String next = stD.nextToken();

            if (relation.get(prev) == null) {
                relation.put(prev, new ArrayList<>());
                inDegree.put(prev, 0);
            }

            if (inDegree.get(next) == null) {
                relation.put(next, new ArrayList<>());
                inDegree.put(next, 0);
            }

            relation.get(prev).add(next);
            inDegree.put(next, inDegree.get(next) + 1);
        }

        solution();

        boolean flag = true;
        for (String key : inDegree.keySet()){
            if (inDegree.get(key) != 0){
                flag = false;
                break;
            }
        }

        bw.write(flag == true ? sb.toString() + " " : "-1\n");
        bw.flush();
        bw.close();
    }

    static void solution() {
        Queue<String> q = new LinkedList<>();

        ArrayList<String> inDegreeZero = new ArrayList<>();

        for (String key : inDegree.keySet()) {
            if (inDegree.get(key) == 0) { //차수가 0
                inDegreeZero.add(key);
            }
        }

        Collections.sort(inDegreeZero); //사전 정렬

        for (String key : inDegreeZero){ //사전 정렬 된 단어 삽입
            q.offer(key);
        }

        while (!q.isEmpty()){
            int size = q.size();

            ArrayList<String> sortStr = new ArrayList<>();
            for (int i=0; i<size; i++){
                String now = q.poll();
                sb.append(now + "\n");

                for (String next : relation.get(now)){
                    inDegree.put(next , inDegree.get(next) - 1); //차수 감소

                    if (inDegree.get(next) == 0){
                        sortStr.add(next);
                    }
                }
            }

            Collections.sort(sortStr);

            for (String data : sortStr){
                q.offer(data);
            }
        }
    }
}