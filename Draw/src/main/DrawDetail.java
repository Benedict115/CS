package main;
import java.io.Console;

public class DrawDetail{
	private int canvasWidth;
	private int canvasHeight;
	//private String [][] drawingBoard;
	private String [] drawingBoard;

	private Console console;

	public DrawDetail(int w, int h, Console inConsole)
	{
		setConsole(inConsole);
		setCanvasWidth(w);
		setCanvasHeight(h);
		setCanvas();
	}
	
	public void printCanvas()
	{
		for (int i=0; i<(getCanvasWidth() * getCanvasHeight()); i++)
		{
			console.printf(drawingBoard[i]);
			if((i + 1) % getCanvasWidth() == 0)
			{
				console.printf(Constant.LINE_SEPARATOR);
			}
		}
		
	}
	
	public void setCanvas()
	{
		drawingBoard = null;
		drawingBoard = new String [getCanvasWidth() * getCanvasHeight()];
		setEmptySpace();
		//Draw the top horizontal line
		for (int i=0; i<getCanvasWidth(); i++)
		{
			drawingBoard[i] = Constant.CANVAS_OUTLINE_HORIZONTAL;
		}
		//Draw the left and right vertical line
		for (int j=1; j<getCanvasHeight() - 1; j++)
		{
			drawingBoard[getCanvasWidth() * j] = Constant.CANVAS_OUTLINE_VERTICAL;
			drawingBoard[getCanvasWidth() * (j + 1) - 1] = Constant.CANVAS_OUTLINE_VERTICAL;
		}
		//Draw the bottom horizontal line
		for (int i=0; i<getCanvasWidth(); i++)
		{
			drawingBoard[(getCanvasWidth() * (getCanvasHeight() - 1)) + i] =  Constant.CANVAS_OUTLINE_HORIZONTAL;
		}
	}
	
	public void setEmptySpace()
	{
		for (int i=0; i<(getCanvasWidth() * getCanvasHeight()); i++)
		{
			drawingBoard[i] = " ";			
		}
	}
	
	public void setRectangle(int x1, int y1, int x2, int y2)
	{
		if (!DrawRectangle.validateRectangle(x1, y1, x2, y2, getCanvasWidth(), getCanvasHeight()))
		{
			getConsole().printf("Rectangle parameter is invalid.\n");
			return;
		}
		else
		{
			DrawRectangle.drawRectangle(x1, y1, x2, y2, drawingBoard, getCanvasWidth(), getCanvasHeight());
		}
	}
	
	public void setLine(int x1, int y1, int x2, int y2)
	{
		if (!DrawLine.validateLine(x1, y1, x2, y2, getCanvasWidth(), getCanvasHeight()))
		{
			getConsole().printf("Line parameter is invalid.\n");
			return;
		}
		//Vertical line
		if (x1 == x2)
		{
			DrawLine.drawVerticalLine(x1, y1, x2, y2, drawingBoard, getCanvasWidth(), getCanvasHeight());
		}
		//Horizontal line
		else if (y1 == y2)
		{
			DrawLine.drawHorizontalLine(x1, y1, x2, y2, drawingBoard, getCanvasWidth(), getCanvasHeight());
		}
		//Drop into slope case
		else
		{
			DrawLine.drawSlope(x1, y1, x2, y2, drawingBoard, getCanvasWidth(), getCanvasHeight());
		}
	}	
	
	public void setBucketFill(int x, int y, String newColour)
	{
		if (!BucketFill.validateFillPoint(x, y, getCanvasWidth(), getCanvasHeight(), newColour))
		{
			getConsole().printf("Bucket fill parameter is invalid.\n");
			return;
		}
		
		String oldColour = drawingBoard[(y * canvasWidth - 1) + (x + 1)];
		if(newColour.equals(oldColour))
		{
			//Same colour no need to fill
			return;
		}
		else
		{
			//We need to change the existing x,y colour to new colour, old colour need to be recognized first			
			BucketFill.bucketFill(x, y, newColour, oldColour, drawingBoard, getCanvasWidth(), getCanvasHeight());
		}
	}
	
	public String[] getDrawingBoard() {
		return drawingBoard;
	}

	public void setDrawingBoard(String[] drawingBoard) {
		this.drawingBoard = drawingBoard;
	}
	
	public Console getConsole() {
		return console;
	}

	public void setConsole(Console console) {
		this.console = console;
	}
	
	public int getCanvasWidth() {
		return canvasWidth;
	}	
	
	public void setCanvasWidth(int canvasWidth) {
		this.canvasWidth = canvasWidth;
	}

	public int getCanvasHeight() {
		return canvasHeight;
	}

	public void setCanvasHeight(int canvasHeight) {
		this.canvasHeight = canvasHeight;
	}
}
