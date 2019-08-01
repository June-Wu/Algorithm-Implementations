import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class MoreHeadsProbability {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the number of coins");
        int n = Integer.parseInt(br.readLine());
        System.out.println("Enter the probability of flipping heads on each coin");
        StringTokenizer st = new StringTokenizer(br.readLine());
        Double[] pHeads = new Double[n];

        for (int i = 0; i < n; i++) {
            pHeads[i] = Double.parseDouble(st.nextToken());
        }
        double pMoreHeads = moreHeadsProbability(n, pHeads);
        System.out.println("Probability of flipping more heads than tails: "+pMoreHeads);
    }

    // prints the probability of flipping strictly more heads than tails
    public static double moreHeadsProbability(int n, Double[] pHeads) {
        //if there is only 1 or 2 coins, the probability of more heads than tails
        // is the probability of flipping all heads
        if (n == 1) {
            return pHeads[0];
        }

        if (n == 2) {
            return pHeads[0]*pHeads[1];
        }

        //initialize 2 x (n-1)/2 +1 table for bottom up
        Double[][] soln = new Double[2][((n - 1)/ 2) + 1];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < ((n - 1) / 2) + 1; j++) {
                soln[i][j] = 0D;
            }
        }

        //base case
        soln[0][0] = pHeads[0];
        soln[0][1] = 1 - pHeads[0];

        //note we only need the results from n-1 coins, so we don't need to store results for all n coins
        for (int i = 1; i < n; i++) {
            soln[1][0] = soln[0][0] * pHeads[i];
            for (int j = 1; j <= Math.min(i + 1, (n - 1) / 2); j++) {
                soln[1][j] = soln[0][j] * pHeads[i] + soln[0][j - 1] * (1 - pHeads[i]);
            }
            soln[0] = soln[1].clone();
        }
        //add probability of 0 tail to (n-1)/2 tails for n coins
        double sum = 0;
        for (int i = 0; i <= (n - 1) / 2; i++) {
            sum += soln[1][i];
        }
        return sum;
    }
}