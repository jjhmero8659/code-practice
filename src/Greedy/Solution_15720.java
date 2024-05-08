package Greedy;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;


public class Solution_15720 {
    static int B, S, D;
    static Integer[] bugger;
    static Integer[] side;
    static Integer[] drink;
    static long original = 0;
    static long sale = 0;
    static int setCnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        B = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        bugger = new Integer[B];
        side = new Integer[S];
        drink = new Integer[D];

        setCnt = Math.min(B, S);
        setCnt = Math.min(setCnt, D);

        StringTokenizer stB = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<B; i++){
            bugger[i] = Integer.parseInt(stB.nextToken());
            original += bugger[i];
        }

        StringTokenizer stS = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<S; i++){
            side[i] = Integer.parseInt(stS.nextToken());
            original += side[i];
        }

        StringTokenizer stD = new StringTokenizer(br.readLine(), " ");
        for (int i=0; i<D; i++){
            drink[i] = Integer.parseInt(stD.nextToken());
            original += drink[i];
        }

        Arrays.sort(bugger, Collections.reverseOrder());
        Arrays.sort(side, Collections.reverseOrder());
        Arrays.sort(drink, Collections.reverseOrder());

        pay();

        bw.write(original + "\n");
        bw.write(sale + "\n");

        bw.flush();
        bw.close();
    }

    static void pay(){
        for (int i=0; i<bugger.length; i++){
            if (i < setCnt){
                sale += (bugger[i] * 0.9);
            }
            else{
                sale += bugger[i];
            }
        }

        for (int i=0; i<side.length; i++){
            if (i < setCnt){
                sale += (side[i] * 0.9);
            }
            else{
                sale += side[i];
            }
        }

        for (int i=0; i<drink.length; i++){
            if (i < setCnt){
                sale += (drink[i] * 0.9);
            }
            else{
                sale += drink[i];
            }
        }
    }
}