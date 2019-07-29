import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LCS {
    public static void main(String[] args) throws IOException {
        //Takes two lines of standard input, one string on each line
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input first string: ");
        String s = br.readLine();
        System.out.println("Input second string: ");
        String t = br.readLine();
        br.close();
        lcs(s,t);
    }
    
    // takes parameter strings s and t, and prints LCS
    public static void lcs(String s, String t) {

        int[][] arr = new int[s.length()+1][t.length()+1];
        //creating table that counts LCS
        for(int i=1;i<=s.length();i++){
            for (int j=1; j<=t.length();j++){
                arr[i][j]=Math.max(arr[i][j-1],arr[i-1][j]);
                if (s.charAt(i-1)==t.charAt(j-1)){
                    arr[i][j]=arr[i-1][j-1]+1;
                }
            }
        }
        //generates the LCS string from 2d array
        StringBuilder sb = new StringBuilder();
        int r=s.length();
        int c=t.length();
        while(c>0){
            int temp=r;
            while(r-1>0 && arr[r-1][c]==arr[r][c]){
                r--;
            }
            if(r-1==0){
                if((c==1||arr[r][c-1]==0) && arr[r][c]==1){
                    sb.append(t.charAt(c-1));
                    break;
                }
                r=temp;
            } else {
                if(arr[r][c]>arr[r][c-1]) sb.append(t.charAt(c-1));
            }
            c--;
        }
        System.out.println("LCS of \""+s+"\" and \""+t+"\": "+sb.reverse().toString());
        System.out.println("Length of LCS: "+sb.length()+"\n");
    }
}
