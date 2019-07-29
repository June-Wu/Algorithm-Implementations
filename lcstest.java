import org.junit.jupiter.api.Test;

import java.io.IOException;

public class lcstest {

    @Test
    void testLCSEmptyInput() throws IOException {
        String inputS = "coffee";
        String inputT = "";
        LCS.lcs(inputS,inputT);
    }
    @Test
    void testLCSNoCommon() throws IOException {
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
    void testLCSAllCommon() throws IOException {
        String inputS = "coffee";
        String inputT = "coffee";
        LCS.lcs(inputS,inputT);
    }
}
