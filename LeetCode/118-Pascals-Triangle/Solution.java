import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pasTrian = new ArrayList<>();

        for ( int i = 0; i < numRows; ++i ) {
            pasTrian.add( new ArrayList<Integer>() );
            for (int j = 0; j < i; ++j ){
                if ( j == 0 ){
                    pasTrian.get(i).add(1);
                } else 
                if ( i - 1 >= 0 && j - 1 >= 0 ){
                    pasTrian.get(i).add( pasTrian.get(i - 1).get(j) + pasTrian.get(i - 1).get(j - 1) );
                } 
            }
            pasTrian.get(i).add(1);
        } 

        return pasTrian;
    }

    public static void main(String[] args) {
        
        Solution s = new Solution();
        List<List<Integer>> pasTrian = s.generate(5) ;



            for (List<Integer> list2 : pasTrian) {
                System.out.print("[");
                for (Integer num : list2) {
                    System.out.print(num + " ");
                }
                System.out.println("]");
            }

    }
}