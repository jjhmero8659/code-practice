package Greedy;

import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;


public class Solution_2138 {
    static int N;
    static boolean[] init;
    static boolean[] target;

    static class Switch {
        long switchCnt;
        boolean[] nowStat;

        public Switch(long switchCnt, boolean[] nowStat) {
            this.switchCnt = switchCnt;
            this.nowStat = nowStat;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        init = new boolean[N];

        String initStr = br.readLine();
        for (int i = 0; i < N; i++) {
            if (initStr.charAt(i) == '1') {
                init[i] = true;
            } else {
                init[i] = false;
            }
        }

        target = new boolean[N];

        String targetStr = br.readLine();
        for (int i = 0; i < N; i++) {
            if (targetStr.charAt(i) == '1') {
                target[i] = true;
            } else {
                target[i] = false;
            }
        }

        Switch switchA = new Switch(0, init);

        boolean[] temp = init.clone();
        temp[0] = !temp[0];
        temp[1] = !temp[1];

        Switch switchB = new Switch(1, temp);

        long resultCnt = -1;

        for (int i = 1; i < N; i++) {
            changeSwitch(i, switchA); // A switch 상태 변경
            changeSwitch(i, switchB); // B switch 상태 변경


            if (Arrays.equals(target,switchA.nowStat)){
                if (Arrays.equals(switchA.nowStat , switchB.nowStat)){
                    resultCnt = Math.min(switchA.switchCnt,switchB.switchCnt);
                }
                resultCnt = switchA.switchCnt;
                break;
            }
            else if (Arrays.equals(target,switchB.nowStat)){
                resultCnt = switchB.switchCnt;
                break;
            }
        }

        bw.write(resultCnt + "\n");
        bw.flush();
        bw.close();
    }


    static void changeSwitch(int index, Switch switchClass) {
        if (target[index - 1] != switchClass.nowStat[index - 1]) {
            //현재 인덱스 이전의 스위치 값이 서로 다르다면
            //이전 스위치는 현재 스위치의 변경으로 최종 값이 변경 되기 때문에 일치한다면 변경 하지 않아야 한다.
            switchClass.nowStat[index - 1] = !switchClass.nowStat[index - 1];
            switchClass.nowStat[index] = !switchClass.nowStat[index];
            if (index < N - 1) {
                switchClass.nowStat[index + 1] = !switchClass.nowStat[index + 1];
            }

            switchClass.switchCnt++;
        }
    }
}