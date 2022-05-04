import java.util.ArrayList;
import java.util.HashMap;

public class Group {
    // строки элементов принадлежащие группе
    private ArrayList<String[]> ListOfRows;
    // элементы принадлежащие группе с указанием столбца к которому они относятся

    private ArrayList<ArrayList<String> > ColKeys = new ArrayList<>();

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
    void megreGroup(Group other) {
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

    Integer size(){
        return ListOfRows.size();
    }

    ArrayList<String[]> getListOfRows() {
        return ListOfRows;
    }

    public int getId() {
        return id;
    }

    // Ожидаемое кол-во элементов в строке
    static final int elemsInRow = 3;
    static private int groupCount = 0;
    private final int id;

}
