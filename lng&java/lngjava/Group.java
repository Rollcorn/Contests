import java.util.ArrayList;

public class Group {
    // строки элементов принадлежащие группе
    private ArrayList<String[]> ListOfRows;

    // массив столбцов элементов принадлежащих группе
    private ArrayList<ArrayList<String> > ColKeys = new ArrayList<>();

    // получить массив столбцов элементов принадлежащих группе
    public ArrayList<String> getColKeys(int i) {
        return ColKeys.get(i);
    }

    Group(){
        id = groupCount++;
        ListOfRows = new ArrayList<>();
        ColKeys = new ArrayList<>();
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj || this.getId() == ((Group) obj).getId();
    }

    Group(String[] strArr){
        ListOfRows = new ArrayList<>();
        id = groupCount++;
        ColKeys = new ArrayList<>();
        addStrToGroup(strArr);
    }

    // Объединить группы
    void mergeGroup(Group other) {
        for (String[] str : other.ListOfRows) {
            addStrToGroup(str);
        }
    }

    // Добавить к группе новую строку
    void addStrToGroup( String[] strArr ) {
        ListOfRows.add(strArr);
        for ( int colIndex = 0; colIndex < elemsInRow; ++colIndex ) {
            if (ColKeys.size() == colIndex){
                ColKeys.add(new ArrayList<>());
            }
            ColKeys.get(colIndex).add( strArr[colIndex] );
        }
    }

    // Количество строк в группе
    Integer size(){
        return ListOfRows.size();
    }

    // Получить массив строк принадлежащих группе
    ArrayList<String[]> getListOfRows() {
        return ListOfRows;
    }

    // Получить количество существующих групп
    public static int getGroupCount() {
        return groupCount;
    }

    // Получить идентификатор группы
    public int getId() {
        return id;
    }

    // Ожидаемое кол-во элементов в строке
    static final int elemsInRow = 3;

    static private int groupCount = 0;
    private final int id;

}
