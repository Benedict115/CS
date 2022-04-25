package main;

public class DrawRectangle {
	
	
	public static boolean validateRectangle(int x1, int y1, int x2, int y2, int canvasWidth, int canvasHeight)
	{
		//Check if outside canvas
		if (x1 <= 0 || x1 >= (canvasWidth - 1) || x2 <= 0 || x2 >= (canvasWidth - 1)
				|| y1 <= 0 || y1 >= (canvasHeight - 1) || y2 <= 0 || y2 >= (canvasHeight - 1))
		{
			return false;
		}
		//Check if same point
		else if (x1 == x2 && y1 == y2)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	public static void drawRectangle(int x1, int y1, int x2, int y2 ,String[][] drawingBoard)
	{
		//Swap the point input value is not x1 < x2 or y1 < y2
		if(x1 > x2)
		{
			int temp = x1;
			x1 = x2;
			x2 = temp;
		}
		if(y1 > y2)
		{
			int temp = y1;
			y1 = y2;
			y2 = temp;
		}
		
		for (int i=x1; i<=x2; i++)
		{
			drawingBoard[i][y1] = Constant.DRAW_POINT;
		}
		
		for (int j=y1; j<=y2-1; j++)
		{
			drawingBoard[x1][j] = Constant.DRAW_POINT;
			drawingBoard[x2][j] = Constant.DRAW_POINT;
		}
		
		for (int i=x1; i<=x2; i++)
		{
			drawingBoard[i][y2] = Constant.DRAW_POINT;
		}
	}

}
