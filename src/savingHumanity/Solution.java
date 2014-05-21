package savingHumanity;

import java.io.*;
public class Solution {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        try {
            int tLines = Integer.parseInt(br.readLine());
            for (int i=0; i<tLines; i++) {
                String patientDNA = br.readLine();
                String virusDNA = br.readLine();
                saveHumanity(patientDNA, virusDNA);
                // Read blank line
                br.readLine();
                // Print new line
                System.out.println();
            }   
        } catch (IOException io) {
            io.printStackTrace();
        }
        
        
    }
                
    // Assuming length P >= V
    // Complexity: 
    // (m-n)*n = Max (m-n)*n
    // (m-m/2)*m/2 = m^2 / 4;   
    private static void saveHumanity(String p, String v) {

        int window = v.length(); 
        for (int i=0; i<=p.length()-window; i++) {
            int endIndex = i + window; 
            String temp = p.substring(i, endIndex); 
            if (endIndex == p.length()) {
                temp = p.substring(i);
            }
            
            if (isOneMismatch(temp, v)) {
                System.out.print(i + " "); 
            }
        }

    }
    
    // Assume length of one and two is the same
    private static boolean isOneMismatch(String one, String two) {
        int count = 0;

        for (int i = 0; i<one.length(); i++) {
            if (one.charAt(i) != two.charAt(i)) {
                count++; 

            if (count > 1) 
                return false; 
            }
        }
                
        return true; 
    }
}