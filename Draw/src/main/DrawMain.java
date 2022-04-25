package main;
import java.io.Console;

public class DrawMain {
	
	private static Console console;
	private static DrawDetail drawing;
	
	public static void main(String args[])
	{
		
		try
		{
			console = System.console();			
			
			if (console == null)
			{
				//Error when creating console
				return;
			}
			console.printf("Welcome to Paint Program! Please enter your command ('H' can show help function):");
		
			String input = "";
			do
			{
				input = console.readLine();
				String[] inputArray = input.split(" ");
				chooseAction(inputArray);
			} while (true);
		} catch (Exception e)
		{
			System.out.println("Exception is found: " + e);
			System.exit(1);
			return;
		}	

	}
			
	private static void chooseAction(String [] input) throws Exception
	{
		String action = input[0];
	
		if (Constant.QUIT_ACTION.equals(action))
		{
			console.printf("Quit the program. Bye!");
			System.exit(0);
			return;
		}
		else if (Constant.CREATE_ACTION.equals(action))
		{
			if (input.length != 3)
			{
				console.printf("Wrong command! Please re-enter:");
				return;
			}
			drawing = new DrawDetail(checkInteger(input[1]), checkInteger(input[2]), console);
		}
		else if (Constant.LINE_ACTION.equals(action))
		{
			if (input.length != 5 || drawing == null)
			{
				console.printf("Wrong command or Canvas is not yet created! Please re-enter:");
				return;
			}
			drawing.setLine(checkInteger(input[1]),checkInteger(input[2]),checkInteger(input[3]),checkInteger(input[4]));
		}
		else if (Constant.RECTANGLE_ACTION.equals(action))
		{
			if (input.length != 5 || drawing == null)
			{
				console.printf("Wrong command or Canvas is not yet created! Please re-enter:");
				return;
			}
			drawing.setRectangle(checkInteger(input[1]),checkInteger(input[2]),checkInteger(input[3]),checkInteger(input[4]));
		}
		else if (Constant.BUCKET_ACTION.equals(action))
		{
			if (input.length != 4 || drawing == null)
			{
				console.printf("Wrong command or Canvas is not yet created! Please re-enter:");
				return;
			}
			drawing.setBucketFill(checkInteger(input[1]),checkInteger(input[2]),input[3]);
		}
		else if (Constant.HELP_ACTION.equals(action))
		{
			help();
			return;
		}
		else
		{
			console.printf("Wrong action \"" + action + "\". Please re-enter:");
			return;
		}
		
		//Everytime draws the current result
		drawing.printCanvas();
	}
	
	private static int checkInteger(String numberToConvert) throws Exception
	{
		int checkNumber;
		checkNumber = Integer.parseInt(numberToConvert);
		if(checkNumber <= 0)
			throw new Exception("Negative value is detected.");
		return checkNumber;
	}
	
	private static void help()
	{
		console.printf("----------------------------------------------------------------------\n"
				+ "This is the help function. You can enter the following command:\n"
				+ "1. \"Q\": Quit the program.\n"
				+ "2. \"C w h\": Create a canvas of size width w and height h.\n"
				+ "3. \"L x1 y1 x2 y2\": Draw a line from (x1,y1) to (x2,y2).\n"
				+ "4. \"R x1 y1 x2 y2\": Draw a rectangle from (x1,y1) to (x2,y2).\n"
				+ "5. \"B x y c\": Bucket fill the area from point (x,y) with colour c.\n"
				+ "----------------------------------------------------------------------\n"
				+ "Please enter your command: ");
	}

}
