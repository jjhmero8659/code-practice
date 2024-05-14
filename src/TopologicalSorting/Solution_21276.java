package TopologicalSorting;

import java.io.*;
import java.util.*;


public class Solution_21276 {
    static int N, M;
    static HashMap<String , Integer> indegree = new HashMap<>();
    static HashMap<String , ArrayList<String>> child = new HashMap<>();
    static HashMap<String , ArrayList<String>> descendants = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        N = Integer.parseInt(st.nextToken()); //사람 수

        StringTokenizer stN = new StringTokenizer(br.readLine() ," ");

        for (int i=0; i<N; i++){
            String name = stN.nextToken();
            child.put(name , new ArrayList<>());
            indegree.put(name , 0);
        }

        M = Integer.parseInt(br.readLine()); //관계 정보 수

        for (int i=0; i<M; i++){
            StringTokenizer stD = new StringTokenizer(br.readLine(), " ");
            String childName = stD.nextToken();
            String parentName = stD.nextToken();

            if (descendants.get(parentName) == null){ //등록 되지 않은 조상 명 이라면
                descendants.put(parentName , new ArrayList<>()); //등록
            }

            descendants.get(parentName).add(childName); //자손 추가
            indegree.put(childName , indegree.get(childName) + 1); //조상 숫자 1 추가
        }

        List<String> list = new ArrayList<>(indegree.keySet());

        Collections.sort(list); //사전 순 정렬

        int rootCnt = 0;
        for (String name : list){
            if (indegree.get(name) == 0){
                rootCnt++;
                sb.append(name + " ");
            }
        }

        topologicalSort();

        bw.write(rootCnt + "\n");
        bw.write(sb.toString() + "\n");

        List<String> childList = new ArrayList<>(child.keySet());

        Collections.sort(childList); //사전 순 정렬
        
        for (String parent : childList){
            bw.write(parent + " ");
            ArrayList<String> childNum = child.get(parent);
            bw.write(childNum.size() + " ");
            if (childNum == null){
                continue;
            }
            Collections.sort(childNum);
            for (String cName : childNum){
                bw.write(cName + " ");
            }
            bw.write("\n");
        }


        bw.flush();
        bw.close();
        br.close();
    }

    static void topologicalSort(){
        Queue<String> q = new LinkedList<>();

        for (String name : indegree.keySet()){ // indegree 0 인 root 조상
            if (indegree.get(name) == 0){
                q.offer(name);
            }
        }
        
        while (!q.isEmpty()){
            String now = q.poll();
            ArrayList<String> dList = descendants.get(now); //자손 리스트

            if (dList == null){
                continue;
            }

            for (String dName : dList){
                indegree.put(dName, indegree.get(dName) - 1); //조상 차수  -1

                if (indegree.get(dName) == 0){ //차수가 0 이라면
                    q.offer(dName);
                    child.get(now).add(dName); //현재 조상의 자식이라는 뜻
                }
            }
        }

    }
}