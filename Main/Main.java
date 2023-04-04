import java.util.*;

interface WhoAmI {
    char whoAmI();
}

public class Main {
	public static void main(String[] args) {

        char[][] grid = new char[3][3];
        letterPlacer(grid, 'X', 3, 1);
        
        char[][] grid2 = new char[3][3];
        String line = "CPCHPBXBH";
        // Method Repalcement
        Repalcement(grid2, line);

        // playGame Method
        playGame(grid2,grid);
        
        // User entering yes for Convering the Grid with X.
		Scanner sc = new Scanner(System.in);
		System.out.print("For covering write yes: ");
		String yes = sc.nextLine();
        //Covering the Grid.
        char[][] grid3 = new char[3][3];
		if (yes.contains("yes"))
            letterPlacer(grid3, 'X', 3, 2);
		else
		    System.out.println("Error");
		
        //User Enter the characters they remember.
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the character in the remembered order: ");
        String input = scan.next();
        //changing the characters string to char to Compare them with the right order("line").
        char[] data = input.toCharArray();

       int result = 0, a = 0;
       // comparing every letter in the grid with what the user entered.
       // if there is a match it increaments result.
       for(int i = 0; i < 3; i++){
           for(int j = 0; j < 3; j++){
               if(grid2[i][j] == data[a]){
                   result++; 
               }
               a++;
           }
       }
       // Status Printing
       if(result >= 4)
            System.out.println("You Won! You got " + result);
       else
            System.out.println("You Lose! You got " + result);
       
       
	} 

    public static void letterPlacer(char[][] grid, char u, int r, int o) {
            /*
            * This loop main reason to exist is to reduce code and 
            * give the coder more flexability without the need to design a new loop for everything
             //creating a loop to print the 3*3 table.
            // chose O = 3 when you want print only.
           // chose O = 2 when you want to apply the whole method. {"printing + assigning"}
          // chose O = 1 when you want to only assign a letter to a grid.*/
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
            // the part down below i added it for more features as if you missed one of the grid's locations. 
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
        
        Pen pen = new Pen();
		Ball ball = new Ball();
		Cup cup = new Cup();
		Hat hat = new Hat();

        char p = pen.whoAmI();
		char b = ball.whoAmI();
		char c = cup.whoAmI();
		char h = hat.whoAmI();

        int i = 0;
        // replacing the 
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
                        grid2[k][j] = 'U';
                    }
                    i++;
                }
            }
        
    }
}