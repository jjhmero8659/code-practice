package DFS;

import java.io.*;
import java.util.*;


public class Solution_5021 {
    static int N,M;
    static String K;
    static HashMap<String, ArrayList<String>> familyTree;
    static HashMap<String, Double> bloodTree;

    static PriorityQueue<Successor> successor = new PriorityQueue<>(
            (a,b) -> Double.compare(b.blood,a.blood)
    );

    static class Successor{
        String name;
        Double blood;

        public Successor(String name, Double blood) {
            this.name = name;
            this.blood = blood;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); //관계 수
        M = Integer.parseInt(st.nextToken()); //지원자 수

        K = br.readLine(); //건국 왕

        familyTree = new HashMap<>();
        bloodTree = new HashMap<>();

        for (int i=1; i<=N; i++){
            StringTokenizer stD = new StringTokenizer(br.readLine()," ");

            String son = stD.nextToken();

            if (familyTree.get(son) == null) {
                familyTree.put(son, new ArrayList<>());
            }

            String father = stD.nextToken();
            familyTree.get(son).add(father);
            String mother = stD.nextToken();
            familyTree.get(son).add(mother);

            bloodTree.put(son, -1d);
            bloodTree.put(father, -1d);
            bloodTree.put(mother, -1d);
        }

        bloodTree.put(K, 1d);

        for (String name : bloodTree.keySet()){
            dfs(name);
        }
        
        
        //이 부분이 이해 되지 않아 입력 null error
        for (int i=0; i<M; i++){
            String name = br.readLine();
            Double blood = bloodTree.get(name);

            if (blood == null){
                continue;
            }

            successor.offer(new Successor(name , blood));
        }

        Successor nextKing = successor.poll();

        bw.write(nextKing.name + "\n");
        bw.flush();
        bw.close();
    }

    static double dfs(String name) {
        // 이미 저장된 값이 있으면 추가로 처리 안함
        if (bloodTree.get(name) != -1) {
            return bloodTree.get(name);
        }

        // 내가 가장 위면,
        // 왕족이 아니여서 0 이거나,
        // 초대 왕이여서 1인 경우
        if (familyTree.get(name) == null) {
            bloodTree.put(name, 0d);
            return bloodTree.get(name);
        }

        double fatherBlood = dfs(familyTree.get(name).get(0));
        double motherBlood = dfs(familyTree.get(name).get(1));

        // (부+모)/2
        bloodTree.put(name, (fatherBlood + motherBlood) / 2);

        return bloodTree.get(name);
    }

}