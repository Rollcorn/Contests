import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Runtime 0 ms - Beats 100%
// Memory 42 MB - Beats 48.79%
public class SpiralMatrix {
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> list = new ArrayList<>();
		int rowStart = 0;
		int columnStart = 0;
		int rowEnd = matrix.length - 1;
		int columnEnd = matrix[0].length - 1;
		cicleMatrix(matrix, list, rowStart, columnStart, rowEnd, columnEnd);
		return list;
	}
	
	private void cicleMatrix(int[][] matrix, List<Integer> list, int rowStart, int columnStart, int rowEnd, int columnEnd) {
		for (int i = columnStart; i <= columnEnd; i++) {
			list.add(matrix[rowStart][i]);
		}
		for (int j = rowStart + 1; j <= rowEnd; j++) {
			list.add(matrix[j][columnEnd]);
		}
		for (int i = columnEnd - 1; rowStart != rowEnd && i >= columnStart; i--) {
			list.add(matrix[rowEnd][i]);
		}
		for (int j = rowEnd - 1; columnStart != columnEnd && j > rowStart; j--) {
			list.add(matrix[j][columnStart]);
		}
		if ((matrix.length * matrix[0].length) != list.size()) {
			cicleMatrix(matrix, list, rowStart + 1, columnStart + 1, rowEnd - 1, columnEnd - 1);
		}
	}
	
	public static void main(String[] args) {
		int[][] m1 = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
		int[][] m2 = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
		SpiralMatrix spiralMatrix = new SpiralMatrix();
		List<Integer> list = spiralMatrix.spiralOrder(m1);
		System.out.println(Arrays.toString(list.toArray()));
		
		List<Integer> list2 = spiralMatrix.spiralOrder(m2);
		System.out.println(Arrays.toString(list2.toArray()));
	}
}
