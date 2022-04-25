package main;
import java.io.Console;

public class DrawDetail{
	private int canvasWidth;
	private int canvasHeight;
	private String [][] drawingBoard;	
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
		for(int j=0; j<getCanvasHeight(); j++)
		{
			for(int i=0; i<getCanvasWidth(); i++)
			{
				console.printf(drawingBoard[i][j]);
			}
			console.printf(Constant.LINE_SEPARATOR);
		}
		
	}
	
	public void setCanvas()
	{
		drawingBoard = new String[getCanvasWidth()][getCanvasHeight()];
		setEmptySpace();
		//Draw the top horizontal line
		for (int i=0; i<getCanvasWidth(); i++)
		{
			drawingBoard[i][0] = Constant.CANVAS_OUTLINE_HORIZONTAL;
		}
		//Draw the left and right vertical line
		for (int j=1; j<getCanvasHeight() - 1; j++)
		{
			drawingBoard[0][j] = Constant.CANVAS_OUTLINE_VERTICAL;
			drawingBoard[getCanvasWidth() - 1][j] = Constant.CANVAS_OUTLINE_VERTICAL;
		}
		//Draw the bottom horizontal line
		for (int i=0; i<getCanvasWidth(); i++)
		{
			drawingBoard[i][getCanvasHeight() - 1] = Constant.CANVAS_OUTLINE_HORIZONTAL;
		}
	}
	
	public void setEmptySpace()
	{
		for(int j=0; j<getCanvasHeight(); j++)
		{
			for(int i=0; i<getCanvasWidth(); i++)
			{				
				drawingBoard[i][j] = " ";
			}
			
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
			DrawRectangle.drawRectangle(x1, y1, x2, y2, drawingBoard);
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
			DrawLine.drawVerticalLine(x1, y1, x2, y2, drawingBoard);
		}
		//Horizontal line
		else if (y1 == y2)
		{
			DrawLine.drawHorizontalLine(x1, y1, x2, y2, drawingBoard);
		}
		//Drop into slope case
		else
		{
			DrawLine.drawSlope(x1, y1, x2, y2, getCanvasHeight(), drawingBoard);
		}
	}	
	
	public void setBucketFill(int x, int y, String newColour)
	{
		if (!BucketFill.validateFillPoint(x, y, getCanvasWidth(), getCanvasHeight(), newColour))
		{
			getConsole().printf("Bucket fill parameter is invalid.\n");
			return;
		}
		
		String oldColour = drawingBoard[x][y];
		if(newColour.equals(oldColour))
		{
			//Same colour no need to fill
			return;
		}
		else
		{
			//We need to change the existing x,y colour to new colour, old colour need to be recognized first			
			BucketFill.bucketFill(x, y, newColour, oldColour, drawingBoard);
		}
	}
	
	
	public String[][] getDrawingBoard() {
		return drawingBoard;
	}

	public void setDrawingBoard(String[][] drawingBoard) {
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
