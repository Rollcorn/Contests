
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.*;

public class Solution {
    // В словаре хранятся списки строк, относящихся к одной группе,
    ArrayList<Group> groupsList;

    static final int elemsInRow = 3;

    /*******************************************************************************************
     * Принимает и обрабатывает файл
     */
    Solution() {
        groupsList = new ArrayList<>();
    }

    /*******************************groupCount************************************************************
     * Принимает и обрабатывает файл
     */
    void scanFile( String fileName ) {

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            // хранит входящие строки и индекс соответствующей группы группы
            HashSet<String> strSet = new HashSet<>();

            // Список словорей хранящий столбцы значений и соответствующий  номер группы
            ArrayList<HashMap<String, Group>> arrayOfKeysToGroupMap = new ArrayList<>();


            Integer groupNum = 0;
            while (reader.ready()) {
                // Новая строка из файла
                String curStr = reader.readLine();

                if ( strSet.add(curStr) ) {
                    // Парсинг входящей строки
                    String[] strarr = curStr.split(";");
                    for ( String s: strarr ){
                        s = s.replace('\"', ' ').trim();
                    }
                    if (Array.getLength(strarr) != elemsInRow) {
                        continue;
                    } else {
                        for (int i = 0; i < elemsInRow; ++i ){
                            arrayOfKeysToGroupMap.add(new HashMap<>());
                        }
                    }
                    // Проверка эллентов строки
                    Group findGroup = null;
                    System.out.println("Start parse group" + groupNum++);
                    for ( int i = 0; i < strarr.length; ++i ) {
                        // карта имеющихся значений соответствующего столбца i
                        HashMap<String, Group> keysToGroupMap = arrayOfKeysToGroupMap.get(i);
                        // совпадение значения со строкой в уже имеющейся группе
                        if ( findGroup == null ) {

                            findGroup = keysToGroupMap.get(strarr[i]);
                            if ( findGroup != null ){
                                findGroup.addStrToGroup(strarr);
                            }
                        } else {
                            Group otherFindGroup = keysToGroupMap.get(strarr[i]);
                            if ( otherFindGroup == null || findGroup.equals(otherFindGroup) ) {
                                continue;
                            }
                            findGroup.megreGroup(otherFindGroup);
                            for ( int colInd = 0; colInd < strarr.length; ++colInd ) {
                                // масив ключей принадлежащих соответствующему столбцу группы
                                ArrayList<String> keysOfOtherGroup = otherFindGroup.getColKeys(colInd);
                                HashMap<String, Group> column = arrayOfKeysToGroupMap.get(colInd);
                                for ( String str: keysOfOtherGroup ) {
                                    if (column.get(str) != null && column.get(str) == otherFindGroup ) {
                                        column.replace(str, findGroup);
                                    }
                                }
                            }
                            groupsList.remove(otherFindGroup);
                        }
                    }
                    if ( findGroup == null) {
                        groupsList.add(new Group(strarr));
                    } else {
                        for( int i = 0; i < strarr.length; ++i ) {
                            arrayOfKeysToGroupMap.get(i).put(strarr[i], findGroup);
                        }
                    }
                }
            }
            groupsList.sort((l1, l2) -> l2.size() - l1.size() );

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }


    /*******************************************************************************************
     * Создает файл и записывает в него обработанные данные
     */
    void printFile(){
        // "result-without-goup.csv"
        try(FileWriter writer = new FileWriter("newresult.csv", false))
        {
            int groupInd = 1;
            for(Group group : groupsList ){
                writer.write("Group " + groupInd++ );
                writer.append('\n');
                for ( String[] curStr : group.getListOfRows() ) {
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