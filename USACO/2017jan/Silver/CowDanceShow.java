// USACO 2017 January Contest, Silver
// Problem 1. Cow Dance Show
// link: http://www.usaco.org/index.php?page=viewproblem2&cpid=690
// status: ac
// tag:

import java.util.*;
import java.io.*;

public class CowDanceShow {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("cowdance.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cowdance.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int[] danceTimes = new int[N];
        for (int i = 0; i < N; i++) {
            danceTimes[i] = Integer.parseInt(br.readLine());
        }

        int low = 1;
        int high = N;
        while (low < high) {
            int mid = (low + high) / 2;
            if (works(danceTimes, T, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        pw.println(low);
        pw.close();
    }

    public static boolean works(int[] danceTimes, int T, int K) {
        int[] stage = new int[K];
        int i = 0;
        while (i < danceTimes.length) {
            int min = 0;
            for (int j = 0; j < K; j++) {
                if (stage[j] < stage[min]) {
                    min = j;
                }
            }
            if (stage[min] + danceTimes[i] > T) {
                return false;
            }
            stage[min] += danceTimes[i];
            i++;
        }
        return true;
    }
}

