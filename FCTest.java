import org.junit.jupiter.api.Test;

public class FCTest {

    public void printCond(int n, int[] coins){
        System.out.println("Change amount: "+n);
        System.out.print("Coins available: ");
        for(int i=0; i<coins.length;i++){
            System.out.print(coins[i]+" ");
        }
        System.out.println("");
    }

    @Test
    public void FCTestNoCoins(){
        int n = 10;
        int[] coins = {};
        printCond(n, coins);
        int[] minChange = ForeignChange.ForeignChange(n, coins);
        ForeignChange.printChange(minChange,coins);
    }

    @Test
    public void FCTestExactChangeImpossible(){
        int n = 9;
        int[] coins = {5, 10, 25};
        printCond(n, coins);
        int[] minChange = ForeignChange.ForeignChange(n, coins);
        ForeignChange.printChange(minChange,coins);
    }

    @Test
    public void FCTestExactChangePossible0(){
        int n = 999;
        int[] coins = {1, 5, 10, 25};
        printCond(n, coins);
        int[] minChange = ForeignChange.ForeignChange(n, coins);
        ForeignChange.printChange(minChange,coins);
    }

    @Test
    public void FCTestExactChangePossible1(){
        int n = 30;
        int[] coins = {1, 10, 25};
        printCond(n, coins);
        int[] minChange = ForeignChange.ForeignChange(n, coins);
        ForeignChange.printChange(minChange,coins);
    }
}
