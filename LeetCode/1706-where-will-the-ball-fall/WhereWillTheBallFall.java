import java.util.*;

//Runtime 29 ms - Beats 6.25%
//Memory 54.8 MB - Beats 12.6%
public class WhereWillTheBallFall {
	class Ball {
		int currentColumn;
		int startColumn;
		
		public Ball(int startColumn) {
			this.startColumn = startColumn;
			this.currentColumn = startColumn;
		}
	}
	
	public int[] findBall(int[][] grid) {
		// текущий столбец (положение шара),
		Queue<Ball> ballsColumns = new LinkedList<>();
		for (int i = 0; i < grid[0].length; i++) {
			ballsColumns.add(new Ball(i ));
		}
		
		for (int[] columns : grid) {
			List<Ball> rowBalls = new ArrayList<>();
			while (!ballsColumns.isEmpty()) {
				Ball ball = ballsColumns.poll();
				int currentColumn = ball.currentColumn;
				int value = columns[currentColumn];
				if (currentColumn + value >= 0 && currentColumn + value < columns.length
						    && columns[currentColumn + value] == value) {
					ball.currentColumn = currentColumn + value;
					rowBalls.add(ball);
				}
			}
			ballsColumns.addAll(rowBalls);
		}
		
		int[] columns = new int[grid[0].length];
		Arrays.fill(columns, -1);
		while (!ballsColumns.isEmpty()) {
			Ball ball = ballsColumns.poll();
			columns[ball.startColumn] = ball.currentColumn;
		}
		return columns;
	}
	
	public static void main(String[] args) {
		int[][] g1 = {{1, 1, 1, -1, -1}, {1, 1, 1, -1, -1}, {-1, -1, -1, 1, 1}, {1, 1, 1, 1, -1}, {-1, -1, -1, -1, -1}};
		WhereWillTheBallFall theBallFall = new WhereWillTheBallFall();
		int[] b1 = theBallFall.findBall(g1);
		System.out.println(Arrays.toString(b1));
		int [][] g2 = {{-1}};
		int[] b2 = theBallFall.findBall(g2);
		System.out.println(Arrays.toString(b2));
		
		int[][] g3 = {{1,1,1,1,1,1},{-1,-1,-1,-1,-1,-1},{1,1,1,1,1,1},{-1,-1,-1,-1,-1,-1}};
		int[] b3 = theBallFall.findBall(g3);
		System.out.println(Arrays.toString(b3));
	}
}
