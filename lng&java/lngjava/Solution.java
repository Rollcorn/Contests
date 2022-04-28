
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

class Solution {
    // В словаре хранятся списки строк, относящихся к одной группе,
    ArrayList<List<String[]>> numList;
    static final int elemsInRow = 3;

    Solution(){
        numList = new ArrayList<>();
    }

    void scanFile( String fileName ) {

        try ( BufferedReader reader = new BufferedReader( new FileReader(fileName) ) )  {
            HashSet<String> strSet = new HashSet<>();

            // Список словорей хранящий значения столбцов и номер группы к которой они относятся
            ArrayList<HashMap<String, Integer>> elemsRows = new ArrayList<>(elemsInRow);
            elemsRows.add(new HashMap<>());
            elemsRows.add(new HashMap<>());
            elemsRows.add(new HashMap<>());

            List<String[]> strList = new ArrayList<>();

            int groupNum = 0;
            while ( reader.ready() ) {
                // Новая строка из файла
                String curStr = reader.readLine();

                if ( strSet.add(curStr) ){
                    String[] strarr = curStr.split(";") ;
                    // проверка корректности строки
                    if ( Array.getLength(strarr) != elemsInRow ){
                        continue;
                    }

                    int groupInd = hasMatch(elemsRows, strarr);
                    if ( groupInd != -1 ) {
                        numList.get(groupInd).add(strarr);
                        elemsRows.get(0).put(strarr[0],groupInd);

                    } else {
                        strList.add(prevStrArr);
                        numList.add(strList);
                        strList = new ArrayList<>();
                    }

                    if ( !reader.ready() ) {
                        strList.add(prevStrArr);
                        numList.add(strList);
                    } else {
                        prevStrArr = strarr;
                    }
                }
            }
            numList.sort( (l1, l2) -> l2.size() - l1.size());
        }
        catch(IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    Integer hasMatch( ArrayList<HashMap<String, Integer>> aHm, String[] aStr ) {
        int groupNum = -1;
        for (int i = 0; i < 3; ++i ){
            if ( aHm.get(i).containsKey( aStr[i].replace('\"', ' ').trim()) ){
                System.out.println(i + " MATCH [" + aStr[i] + "]");
                // Возвращаю номер группы к которой относится совпавший ключ
                if ( groupNum == -1 ){
                    groupNum = aHm.get(i).get(aStr[i]);
                } else {

                }
            }
        }
        return -1;
    }

    void printFile(){
        // "result-without-goup.csv"
        try(FileWriter writer = new FileWriter("newresult.csv", false))
        {
            int groupInd = 1;
            for(List<String[]> strList : numList ){
                writer.write("Group " + groupInd++ );
                if (strList.size() > 1 ){
                    System.out.println(groupInd + " strList.size() " + strList.size());
                }
                writer.append('\n');
                for (String[] curStr : strList) {
                    for ( String str : curStr ){
                        writer.write(str);
                        writer.write(";");
                    }
                    writer. append('\n');
                }
            }
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String defaultFileName = "resources/lng.csv";
        s.scanFile(defaultFileName);
        s.printFile();
    }
}