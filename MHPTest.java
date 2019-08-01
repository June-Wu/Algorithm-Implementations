import org.junit.jupiter.api.Test;

public class MHPTest {

    public void printTestCase(Double[] pHeads, Double pMoreHeads){
        System.out.println("Number of coins: \n"+ pHeads.length);
        System.out.println("Probability of flipping heads for each coin: ");
        for(int i=0; i<pHeads.length-1; i++){
            System.out.print(pHeads[i]+", ");
        }
        System.out.print(pHeads[pHeads.length-1]);
        System.out.println("\nProbability of flipping more heads than tails: \n"+pMoreHeads+"\n");
    }
    @Test
    public void testOneCoin(){
        int n = 1;
        Double[] pHeads = {0.3};
        Double pMoreHeads = MoreHeadsProbability.moreHeadsProbability(n,pHeads);
        printTestCase(pHeads,pMoreHeads);
    }

    @Test
    public void testCantFlipMoreHeads(){
        int n = 4;
        Double[] pHeads = {0.0, 0.0, 0.3, 0.9};
        Double pMoreHeads = MoreHeadsProbability.moreHeadsProbability(n,pHeads);
        printTestCase(pHeads,pMoreHeads);
    }

    @Test
    public void testFewCoins(){
        int n = 3;
        Double[] pHeads = {0.30, 0.60, 0.80};
        Double pMoreHeads = MoreHeadsProbability.moreHeadsProbability(n,pHeads);
        printTestCase(pHeads,pMoreHeads);
    }

    @Test
    public void testManyCoins(){
        int n = 20;
        Double[] pHeads = new Double[n];
        for(int i=0;i<n;i++){
            pHeads[i]=(double)i/n;
        }
        Double pMoreHeads = MoreHeadsProbability.moreHeadsProbability(n,pHeads);
        printTestCase(pHeads,pMoreHeads);
    }
}
