import java.util.*;

interface WhoAmI {
    char whoAmI(); // here is the method that every class that implements this inteface is going to use.
} // Now the interfaces as far as i understand are used to create some methods and other classess can implement and use or overwrite,
 // i think that the most important thing its doing is holding/forcin the user to use all the method that he wrote in these interfaces,
// and if she/he impelement this interface in other classes they must follow some rules like having the same method name and return type.

class Pen implements WhoAmI{
    public char whoAmI(){
        return 'P'; // returning the first letter of the class name.
    }
}

class Hat implements WhoAmI{
    public char whoAmI(){
        return 'H';
    }
}

class Ball implements WhoAmI{
    public char whoAmI(){
        return 'B';
    }
}

class Cup implements WhoAmI{
    public char whoAmI(){
        return 'C';
    }
}

class Undifiend implements WhoAmI{
    public char whoAmI(){
        return 'U'; // here is the Undefined Character. 'U'
    }
}

public class Main {
	public static void main(String[] args) {

        char[][] grid = new char[3][3]; // create an empty 2D Array
        letterPlacer(grid, 'X', 3, 1); // Assigning 'X' through the grid ("for more explaination i wrote some guidline in the letterPlacer method")""
        
        char[][] grid2 = new char[3][3];
        String line = "CPCHPBXBH"; // This is the String that has the correct Order and will be used by the Replacement method to be added to the 2nd-D Array.
        // Calling the Repalcement method to place the new created objects that containes the first letter of the classess name and compare it with the "line" String.
        Repalcement(grid2, line);

        // callin the playGame Method to take the new D-Array that the Replacement method made and show the grid to the user one by one depending on his entered values.
        playGame(grid2,grid);
        
        // User entering yes to cover the Grid with X. so he can start the remembering game.
		Scanner sc = new Scanner(System.in);
		System.out.print("For covering write yes: ");
		String yes = sc.nextLine();
        //Covering the Grid.
        char[][] grid3 = new char[3][3];
		if (yes.contains("yes")) // i used contains to see if the user enters yes.
            letterPlacer(grid3, 'X', 3, 2);
		else
		    System.out.println("Error");
		
        //User Enter the characters they remember.
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the character in the remembered order: ");
        String input = scan.next();
        //changing the characters string to char to Compare them with the right order("line").
        char[] data = input.toCharArray(); // this char array will convert the String text that the user entered.

       int result = 0, a = 0;
       // comparing every letter in the grid with what the user entered.
       // if there is a match it increaments result.
       for(int i = 0; i < 3; i++){
           for(int j = 0; j < 3; j++){ // Here is a loop that compares between the original grid that has the right objects in the right order and the data char array that the user Entered.
               if(grid2[i][j] == data[a]){
                   result++; 
               }
               a++;
           }
       }
       // Status Printing ("Winning or Losing")
       if(result >= 4)
            System.out.println("You Won! You got " + result);
       else
            System.out.println("You Lose! You got " + result);
	} 

    public static void letterPlacer(char[][] grid, char u, int r, int o) {
            /*
            Guidlines:
            * This loop main reason to exist is to reduce code and 
            * give the coder more flexability without the need to design a new loop for everything
            * creating a loop to print the 3*3 table.
            * chose O = 3 when you want print only.
            * chose O = 2 when you want to apply the whole method. {"printing + assigning"}
            * chose O = 1 when you want to only assign a letter to a grid.
            */
            for(int i = 0; i < r; i++){
                for (int j = 0; j < r; j++) {
                    if(o == 1 || o == 2) grid[i][j] = u;
                    if(o == 2 || o == 3) System.out.print(grid[i][j] + " ");
                }
                if(o == 2 || o == 3) System.out.println(); // making a new line every new row
            }
    }   

    public static void playGame(char[][] grid2, char[][] grid) {
        Scanner sc = new Scanner(System.in);
        // This method all it does is taking row and coloums indices form te user and exposing it to him. then priting it out after every assingment.
        System.out.println("Enter the rows and colomns indices in order. ('Leave space between the numbers')");
        for(int i = 0; i < 9; i++){
    		System.out.print("rows - colomns:");
    		int rows = sc.nextInt();
    		int cols = sc.nextInt();
    		grid[rows][cols] = grid2[rows][cols];
            letterPlacer(grid, 'X', 3, 3);
            // the part down below i added it for more features as if you missed one of the grid's locations, and dont want to repeat the whole process over again.
            while(i == 8){
                System.out.println("Missed One?, press --> 1 or press --> 0 to Continue");
                int press = sc.nextInt();
                if(press == 1){
                    System.out.print("rows - colomns:");
        		    rows = sc.nextInt();
            		cols = sc.nextInt();
            		grid[rows][cols] = grid2[rows][cols];
                    letterPlacer(grid, 'X', 3, 3);
                    i = 8;
                }
                else{
                    break;
                }
            }
            
		}
		
    }

    public static void Repalcement(char[][] grid2, String line){
        // Creating the Objects based on the classes.
        Pen pen = new Pen();
		Ball ball = new Ball();
		Cup cup = new Cup();
		Hat hat = new Hat();
        Undifiend undifiend = new Undifiend();
        // Creating a variable for each method call, with the right type.
        char p = pen.whoAmI();
		char b = ball.whoAmI();
		char c = cup.whoAmI();
		char h = hat.whoAmI();
        char u = undifiend.whoAmI();


        int i = 0;
        // this part of the code is placing the right order of the "line" in grid2 which will contain all of the right letters in the correct order.
            for(int k = 0; k < 3; k++){
                for(int j = 0; j < 3; j++){
                    if(line.charAt(i) == c){
                        grid2[k][j] = c;
                    }else if(line.charAt(i) == b){
                        grid2[k][j] = b;
                    }else if(line.charAt(i) == h){
                        grid2[k][j] = h;
                    }else if(line.charAt(i) == p){
                        grid2[k][j] = p;
                    }else{
                        grid2[k][j] = u;
                    }
                    i++;
                }
            } 
    }
}

/*Note:
 * I have added so features to the code to make it more usefull. i had more ideas like exceptions and stuff like that to implement,
 * but i didnt want to make the code complex and long for no reason.
 * I will add this code with the improved code on my github repositories, at https://github.com/SeifElred.
 */
