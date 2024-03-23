package PrefixSum;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Solution_1966 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int questionN = Integer.parseInt(br.readLine()); // 질문 개수
        for (int qn=1; qn<=questionN; qn++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken()); //문서 개수
            int m = Integer.parseInt(st.nextToken()) + 1; //찾아야 할 문서

            Queue<int[]> queue = new LinkedList<int[]>();
            int[] priorityCnt = new int[9+1]; // 1 ~ 9의 중요도

            StringTokenizer stD = new StringTokenizer(br.readLine() , " ");
            for (int i=1; i<=n; i++){

                int prior = Integer.parseInt(stD.nextToken()); //우선순위

                priorityCnt[prior]++; //문서 개수 증가 , 해당 배열 index 는 우선순위를 뜻하며 index 의 값은 문서 개수를 뜻 함
                
                if (i == m){
                    queue.add(new int[]{prior, 1}); //찾아야 할 target 문서
                }
                else{
                    queue.add(new int[]{prior, 0}); //일반 문서
                };
            }

            int result = findNotice(n,queue, priorityCnt);

            bw.write(result+"\n");//문서 출력 순서 찾기
        }

        bw.flush();
        bw.close();
    }
    
    static int findNotice(int n,Queue<int[]> queue , int[] priorityCnt) throws IOException{ //문서 찾기
        int printedPrior = 9; //9번 우선순위 부터 출력 되야 함
        int printCnt = 1; //몇번째로 인쇄 되는지 출력 count

        printedPrior = nextPriority(printedPrior, priorityCnt);

        while(true){
            int[] printData = queue.poll(); // 제일 앞에 있는 Queue 문서 출력
            
            if (printData[0] == printedPrior){ //현재 출력 되어야 하는 우선순위 값일때

                if (printData[1] == 1){ //타겟 문서 라면?
                    return printCnt;
                }
                else{
                    priorityCnt[printedPrior]--; //해당 우선 순위의 문서 개수 감소
                    if (priorityCnt[printedPrior] == 0){ //만약 해당 우선순위 값의 문서가 더이상 존재하지 않는다면
                        printedPrior = nextPriority(printedPrior, priorityCnt); //다음 우선 순위, 9 -> 1 까지 내림 차순
                    }
                    printCnt++;
                }
            }
            else {
                queue.add(printData); //우선 순위에서 밀린다면 맨 뒤에 추가
            }

        }
    }

    static int nextPriority(int printedPrior , int[] priorityCnt){ //다음 우선순위 반환

        int returnPrior = printedPrior;

        for (int i=printedPrior; i>=1; i--){
            if(priorityCnt[i] == 0){
                returnPrior--;
            }
            else{
                return returnPrior;
            }
        }
        return -1;
    }

}