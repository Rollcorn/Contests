
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Solution {
    // В словаре хранятся списки строк, относящихся к одной группе,
    ArrayList<Group> groupsList;

    static final int elemsInRow = 3;

    /*******************************************************************************************
     * Конструктор
     */
    Solution() {
        groupsList = new ArrayList<>();
    }

    /*******************************************************************************************
     * Принимает и обрабатывает данные из файла
     */
    void scanFile( String fileName ) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            // хранит входящие строки
            HashSet<String> strSet = new HashSet<>();
            // Список словорей хранящий столбцы значений и соответствующий  номер группы
            ArrayList<HashMap<String, Group>> arrayOfKeysToGroupMap = new ArrayList<>();

            while (reader.ready()) {
                String curStr = reader.readLine();

                if ( strSet.add(curStr) ) {
                    // Обработка входящей строки
                    String[] strarr = curStr.split(";");

                    for (int i = 0; i < strarr.length; ++i ){
                        strarr[i] = strarr[i].replace('\"', ' ').trim();
                    }
                    if ( strarr.length != elemsInRow) {
                        continue;
                    } else {
                        for (int i = 0; i < elemsInRow; ++i ){
                            arrayOfKeysToGroupMap.add(new HashMap<>());
                        }
                    }

                    // Поиск группы с совпадением по значению
                    Group findGroup = findMatchGroup(arrayOfKeysToGroupMap, strarr);

                    // групп с такими элементами ещё нет в списке
                    if ( findGroup == null) {
                        findGroup = new Group(strarr);
                        groupsList.add(findGroup);
                    }
                    for( int i = 0; i < strarr.length; ++i ) {
                        arrayOfKeysToGroupMap.get(i).put(strarr[i], findGroup);
                    }
                }
            }
            groupsList.sort( (l1, l2) -> l2.size() - l1.size() );

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /*********************************************************************************************
     * Поиск группы с совпадением элементов из keysArr среди уже обработанных строк столбцов
     * arrayOfKeysToGroupMap
     */
    private Group findMatchGroup(ArrayList<HashMap<String, Group>> arrayOfKeysToGroupMap,
                                 String[] keysArr)
    {
        Group findGroup = null;

        for (int i = 0; i < keysArr.length; ++i ) {
            // карта имеющихся значений соответствующего столбца i
            HashMap<String, Group> keysToGroupMap = arrayOfKeysToGroupMap.get(i);
            // совпадение значения со строкой в уже имеющейся группе
            if( keysArr[i].length() == 0 ){
                continue;
            }
            if ( findGroup == null ) {
                findGroup = keysToGroupMap.get(keysArr[i]);
                if ( findGroup != null ) {
                    findGroup.addStrToGroup(keysArr);
                }
            } else {
                Group otherFindGroup = keysToGroupMap.get(keysArr[i]);
                // нет совпадений или найдена
                if ( otherFindGroup == null || findGroup.equals(otherFindGroup) ) {
                    continue;
                }
                findGroup.mergeGroup(otherFindGroup);
                for (int colInd = 0; colInd < keysArr.length; ++colInd ) {
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
        return findGroup;
    }

    /*******************************************************************************************
     * Подсчет количества групп с более чем 1 строкой
     */
    public static int countGroup(ArrayList<Group> groupsList) {
        int res = 0;
        for(Group gr : groupsList ) {
            if (gr.size() > 1 ){
                res++;
            } else {
                break;
            }
        }
        return res;
    }


    /*******************************************************************************************
     * Создание файла и вывод списка групп в него
     */
    void printFile(String outputName){
        try(FileWriter writer = new FileWriter(outputName, false))
        {
            System.out.println();
            writer.write("Количество групп c более чем одним элементом: " + countGroup(groupsList) + '\n');
            writer.write("Общее число групп: " + groupsList.size() + '\n');

            int groupInd = 1;
            for(Group group : groupsList ){
                writer.write("Группа " + groupInd++ + '\n');
                for ( String[] curStr : group.getListOfRows() ) {
                    for ( String str : curStr ){
                        writer.write(str + ";");
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
        String inputFileName = "resources/lng.csv";
        String outputFileName = "result.csv";

        s.scanFile(inputFileName);
        s.printFile(outputFileName);

    }
}