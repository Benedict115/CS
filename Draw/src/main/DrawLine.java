package main;

public class DrawLine {
	public static boolean validateLine(int x1, int y1, int x2, int y2, int canvasWidth, int canvasHeight)
	{
		if (x1 <= 0 || x1 >= (canvasWidth - 1) || x2 <= 0 || x2 >= (canvasWidth - 1)
				|| y1 <= 0 || y1 >= (canvasHeight - 1) || y2 <= 0 || y2 >= (canvasHeight - 1))
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	public static void drawVerticalLine(int x1, int y1, int x2, int y2, String[] drawingBoard, int canvasWidth, int canvasHeight)
	{
		if (y1 < y2)
		{
			for (int i=y1; i<=y2; i++)
			{
				drawingBoard[(i * canvasWidth - 1) + (x1 + 1)] =  Constant.DRAW_POINT;
			}
		}
		else
		{
			for (int i=y2; i<=y1; i++)
			{
				drawingBoard[(i * canvasWidth - 1) + (x1 + 1)] =  Constant.DRAW_POINT;
			}
		}
	}
	
	public static void drawHorizontalLine(int x1, int y1, int x2, int y2, String[] drawingBoard, int canvasWidth, int canvasHeight)
	{
		if (x1 < x2)
		{
			for (int i=x1; i<=x2; i++)
			{
				drawingBoard[(y1 * canvasWidth - 1) + (i + 1)] =  Constant.DRAW_POINT;
			}
		}
		else
		{
			for (int i=x2; i<=x1; i++)
			{
				drawingBoard[(y1 * canvasWidth - 1) + (i + 1)] =  Constant.DRAW_POINT;
			}
		}
	}
	
	public static void drawSlope(int x1, int y1, int x2, int y2, String[] drawingBoard, int canvasWidth, int canvasHeight)
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

		//Slope (m) = (y2-y1)/(x2-x1)
		//y=mx+b
		double m = (double)(y2 - y1) / (double)(x2 - x1);
		double b = (double)y1 - (double)(m * x1);
		
		//Put the x points to get the y points for the slope
		for (int i=x1; i<=x2; i++)
		{
			int yPos = (int) Math.round((m * i) + b);
			//Avoid points draw on frame of canvas
			if (yPos < canvasHeight)
			{
				drawingBoard[(yPos * canvasWidth - 1) + (i + 1)] =  Constant.DRAW_POINT;
			}
		}
	}

}
