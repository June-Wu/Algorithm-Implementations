import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ForeignChange {

    //given a list of coin values and the amount to make change for,
    // prints the minimum number of coins required to give exact change
    // or print "impossible" if it is impossible to give exact change
    public static void main(String[]args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter change value");
        int n = Integer.parseInt(br.readLine());
        System.out.println("Enter space separated list of coins");
        StringTokenizer st = new StringTokenizer(br.readLine());
        int numDiffCoins = st.countTokens();
        int[] coins = new int[numDiffCoins];
        for(int i=0;i<numDiffCoins;i++){
            coins[i]=Integer.parseInt(st.nextToken());
        }

        int[] minChange = ForeignChange(n, coins);
        printChange(minChange, coins);
    }

    public static void printChange(int[] minChange, int[] coins) {
        if(minChange[0]!=Integer.MAX_VALUE){
            System.out.println("Total number of coins: "+minChange[0]);
            for(int i=0; i<coins.length;i++){
                System.out.println("Number of "+coins[i]+" cent(s) coins: "+minChange[i+1]);
            }
        } else {
            System.out.println("Impossible to make exact change!");
        }
        System.out.println("");
    }


    public static int[] ForeignChange(int n, int[] coins){
        //count[0] is the total number of coins,
        //  the rest of count corresponds to number of each type of coin
        if (n==0) {return  new int[coins.length+1];}
        if (coins.length==0) return new int[] {Integer.MAX_VALUE};

        int maxCoinValue = findMax(coins);

        //soln element has key of current sum and value of count
        ArrayList<int[]> soln = new ArrayList<>();
        soln.add(new int[coins.length+1]);

        for(int i=1; i<=n;i++){
            int[] min = new int[coins.length+1];
            min[0]=Integer.MAX_VALUE;
            for (int j=0;j<coins.length;j++) {
                int[] check = solnCheck(soln, i- coins[j], coins[j], j);
                if(min[0]>check[0]){
                    min = check;
                }
            }
            soln.add(min);

            if(soln.size()>maxCoinValue*2){
                soln.subList(soln.size()-maxCoinValue, soln.size()-1);
            }
        }
        return soln.get(soln.size()-1);
    }

    private static int[] solnCheck(ArrayList<int[]> soln, int n, int v, int c) {
        int[] arr;
        if (soln.size()<v || n<0 || soln.get(soln.size()-v)[0]==Integer.MAX_VALUE){
          arr= new int[1];
          arr[0]=Integer.MAX_VALUE;
        } else {
            arr = soln.get(soln.size()-v).clone();
            //number of coins increases by 1
            arr[0]++;
            //number of coins of value at index c in coins increases by 1
            arr[c + 1]++;
        }
        return arr;
    }

    private static int findMax(int[] coins) {
        int max=Integer.MIN_VALUE;
        for(int i=0; i<coins.length;i++){
            max=Math.max(max,coins[i]);
        }
        return max;
    }
}
