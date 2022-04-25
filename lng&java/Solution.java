import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

class Solution {

    private List<String> numList;

    Solution(){
        numList = new ArrayList<>();
    }

    void scanFile(){
        try ( BufferedReader reader = new BufferedReader( new FileReader("lng.csv") ) )  {
            HashSet<String> strSet = new HashSet<>();

            while (reader.ready()) {
                String curStr = reader.readLine();
                if ( !strSet.contains(curStr) ){
                    strSet.add(curStr);
                    numList.add(curStr);
                }
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        } 
    }

    void printFile(){
        Iterator itb = numList.iterator();

        try(FileWriter writer = new FileWriter("notes3.csv", false))
        {
            for (String string : numList) {
                writer.write(string);
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

        s.scanFile();
        s.printFile();
    }
}