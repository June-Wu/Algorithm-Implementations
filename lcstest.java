import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Random;
import java.util.UUID;

public class lcstest {

    @Test
    void testLCSEmptyInput() throws IOException {
        String inputS = "coffee";
        String inputT = "";
        LCS.lcs(inputS,inputT);
    }
    @Test
    void testLCSNoSubstring() throws IOException {
        String inputS = "coffee";
        String inputT = "milk";
        LCS.lcs(inputS,inputT);
    }

    @Test
    void testLCSPartial() throws IOException {
        String inputS = "coffee";
        String inputT = "chocolate";
        LCS.lcs(inputS,inputT);
    }

    @Test
    void testLCSCompleteMatch() throws IOException {
        String inputS = "coffee";
        String inputT = "coffee";
        LCS.lcs(inputS,inputT);
    }

    @Test
    void testLCSRandom(){
        for (int i=0;i<10;i++){
            String inputS = UUID.randomUUID().toString().replaceAll("-", "").substring(new Random().nextInt(31));
            String inputT = UUID.randomUUID().toString().replaceAll("-", "").substring(new Random().nextInt(31));;
            LCS.lcs(inputS,inputT);
        }
    }
}
