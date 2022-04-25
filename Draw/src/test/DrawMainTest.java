package test;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import main.DrawDetail;

public class DrawMainTest {
	
	@Test
	public void testMainProcedure()
	{
		DrawDetail drawingTest = new DrawDetail(10, 10, System.console());
		
		drawingTest.setLine(1, 3, 8, 4);
		drawingTest.setRectangle(1, 6, 3, 8);
		drawingTest.setBucketFill(5, 5, ".");
		
		/*
		 	Expected print out canvas
		 	----------
			|        |
			|        |
			|xxxx    |
			|....xxxx|
			|........|
			|xxx.....|
			|x x.....|
			|xxx.....|
			----------
		 */
		
		//Expected Result is transposed, due to defining 2D array with initial values is transposed from [x][y] to [y][x]
		String[][] expectedResult = {{"-","|","|","|","|","|","|","|","|","-"},
				{"-"," "," ","x",".",".","x","x","x","-"},
				{"-"," "," ","x",".",".","x"," ","x","-"},
				{"-"," "," ","x",".",".","x","x","x","-"},
				{"-"," "," ","x",".",".",".",".",".","-"},
				{"-"," "," "," ","x",".",".",".",".","-"},
				{"-"," "," "," ","x",".",".",".",".","-"},
				{"-"," "," "," ","x",".",".",".",".","-"},
				{"-"," "," "," ","x",".",".",".",".","-"},
				{"-","|","|","|","|","|","|","|","|","-"}};

		
		
		assertTrue(drawingTest.getCanvasWidth() == 10);
		assertTrue(drawingTest.getCanvasHeight() == 10);
		assertTrue(testEqualArray(drawingTest.getDrawingBoard(), expectedResult, drawingTest.getCanvasWidth(), drawingTest.getCanvasHeight()));
	}
	
	@Test
	public void testMainReversePoint()
	{
		DrawDetail drawingTest = new DrawDetail(10, 10, System.console());
		//Reversely enter the point1 and point2. Expect the final image is same as above
		drawingTest.setLine(8, 4, 1, 3);
		drawingTest.setRectangle(3, 8, 1, 6);
		drawingTest.setBucketFill(5, 5, ".");
		
		/*
		 	Expected print out canvas
		 	----------
			|        |
			|        |
			|xxxx    |
			|....xxxx|
			|........|
			|xxx.....|
			|x x.....|
			|xxx.....|
			----------
		 */
		
		//Expected Result is transposed, due to defining 2D array with initial values is transposed from [x][y] to [y][x]
		String[][] expectedResult = {{"-","|","|","|","|","|","|","|","|","-"},
				{"-"," "," ","x",".",".","x","x","x","-"},
				{"-"," "," ","x",".",".","x"," ","x","-"},
				{"-"," "," ","x",".",".","x","x","x","-"},
				{"-"," "," ","x",".",".",".",".",".","-"},
				{"-"," "," "," ","x",".",".",".",".","-"},
				{"-"," "," "," ","x",".",".",".",".","-"},
				{"-"," "," "," ","x",".",".",".",".","-"},
				{"-"," "," "," ","x",".",".",".",".","-"},
				{"-","|","|","|","|","|","|","|","|","-"}};

		
		
		assertTrue(drawingTest.getCanvasWidth() == 10);
		assertTrue(drawingTest.getCanvasHeight() == 10);
		assertTrue(testEqualArray(drawingTest.getDrawingBoard(), expectedResult, drawingTest.getCanvasWidth(), drawingTest.getCanvasHeight()));
	}
	
	public boolean testEqualArray(String[][] a, String[][] b, int width, int height)
	{
		if(a.length != b.length)
		{
			return false;
		}
		else
		{
			for(int j=0; j < height; j++)
			{
				for (int i=0; i < width; i++)
				{
					if(!a[i][j].equals(b[i][j]))
					{
						return false;
					}					
				}
			}
			return true;
		}
	}
	

}
