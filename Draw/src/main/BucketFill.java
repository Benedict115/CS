package main;

public class BucketFill {
	public static boolean validateFillPoint(int x, int y, int canvasWidth, int canvasHeight, String colour)
	{
		if (x <= 0 || x >= (canvasWidth - 1) || y <= 0 || y >= (canvasHeight - 1))
		{
			return false;
		}
		else if (colour.length() != 1)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	public static void bucketFill(int x, int y, String colour, String oldColour, String[] drawingBoard, int canvasWidth, int canvasHeight)
	{
		if(oldColour.equals(drawingBoard[(y * canvasWidth - 1) + (x + 1)]))
		{
			drawingBoard[(y * canvasWidth - 1) + (x + 1)] = colour;
			//Think of the x,y is the center point, we need to test the next point of four direction recursively
			bucketFill(x+1, y, colour, oldColour, drawingBoard, canvasWidth, canvasHeight);
			bucketFill(x-1, y, colour, oldColour, drawingBoard, canvasWidth, canvasHeight);
			bucketFill(x, y+1, colour, oldColour, drawingBoard, canvasWidth, canvasHeight);
			bucketFill(x, y-1, colour, oldColour, drawingBoard, canvasWidth, canvasHeight);
		}
		else
		{
			/*If existing point is not matched with the old colour, that means it's the boundary and no need to fill,
			 and no need for testing the next point*/			 
			return;
		}
	}

}
