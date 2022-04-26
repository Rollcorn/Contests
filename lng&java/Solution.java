import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Solution {

    private List<String[]> numList;

    Solution(){
        numList = new ArrayList<>();
    }

    void scanFile( String fileName ) {

        try ( BufferedReader reader = new BufferedReader( new FileReader(fileName) ) )  {
            HashSet<String> strSet = new HashSet<>();
            String[] prevStrArr = null;
            int grInd = 1;

            while ( reader.ready() ) {
                String curStr = reader.readLine();
                if ( !strSet.contains(curStr) ){
                    strSet.add(curStr);
                    String[] strarr = curStr.split(";") ;
                    // если количество элементов в строке не равно трем значит строка не корректна
                    if ( Array.getLength(strarr) != 3 ){
                        continue;
                    }
                    if ( prevStrArr == null ) {
                        prevStrArr = strarr;
                    } else if ( hasMatch(prevStrArr, strarr) ) {
                        numList.add(prevStrArr);
                    } else {
                        numList.add(prevStrArr); 
                        numList.add( new String[]{"Group " + grInd} );
                        ++grInd;
                    }
                    prevStrArr = strarr;
                }
            }
        }
        catch(IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    boolean hasMatch( String[] str1, String[] str2 ) {
        for (int i = 0; i < 3; ++i ){
            if ( !str1[i].replace('\"', ' ').trim().isEmpty() &&
                    !str2[i].replace('\"', ' ').trim().isEmpty() &&
                    str1[i].replace('\"', ' ').trim().equals(str2[i].replace('\"', ' ').trim()) ){
                System.out.println(i + " MATCH [" + str1[i] + "] AND ["+ str2[i] + "]");
                return true;
            }
        }
        return false;
    }

    void printFile(){
        // "result-without-goup.csv"
        try(FileWriter writer = new FileWriter("result.csv", false))
        {
            for (String[] curStrArr : numList) {
                for (String curStr : curStrArr) {
                    if ( curStr.contains("Group") ){
                        writer.write(curStr);
                    } else {
                        writer.write(curStr);
                        writer.write(";");
                    }
                }
                writer.append('\n');

            }
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String defaultFileName = "lng.csv";
        s.scanFile(defaultFileName);
        s.printFile();
    }
}