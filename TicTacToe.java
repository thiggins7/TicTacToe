import java.util.Scanner;
class TicTacToe{

public static void main(String args[])
{
    String[][] Board = new String[3][3];
    String gameState = "continue"; 
    int Col;
    int Row;
    int gameType;
    Scanner scan = new Scanner(System.in);
   
    while(gameState.equals("continue"))
    {
        //Player 1's Turn.
        System.out.println("Player 1, place an X on the board.");
        System.out.println("Column:");
        Col = scan.nextInt();
        System.out.println("Row:");
        Row = scan.nextInt();
        while(Col < 1 || Col > 3 || Row < 1 || Row > 3 || Board[Row-1][Col-1] != null)
        {
            System.out.println("Please enter a different number.");
            System.out.println("Column:");
            Col = scan.nextInt();
            System.out.println("Row:");
            Row = scan.nextInt();
        } 
        
        Board[Row-1][Col-1] = "X";
        System.out.println(printBoard(Board));
        gameState = checkGameState(Board);
        System.out.println(checkGameState(Board));
        if(gameState != "continue")
        {
            break;
        }
        
        //Player 2's Turn
        System.out.println("Player 2, place an O on the board.");
        System.out.println("Column:");
        Col = scan.nextInt();
        System.out.println("Row:");
        Row = scan.nextInt();
        while(Col < 1 || Col > 3 || Row < 1 || Row > 3 || Board[Row-1][Col-1] != null)
        {
            System.out.println("Please enter a different number.");
            System.out.println("Column:");
            Col = scan.nextInt();
            System.out.println("Row:");
            Row = scan.nextInt();
        } 
        
        Board[Row-1][Col-1] = "O";
        System.out.println(printBoard(Board));
        System.out.println(checkGameState(Board));
        if(gameState != "continue")
        {
            break;
        }

        
    }

    if(gameState.equals("oWin"))
    {
        System.out.println("Player 2 wins!");
    }
    else
    if(gameState.equals("xWin"))
    {
        System.out.println("Player 1 wins!");
    }
    else
    {
        System.out.println("Both players have tied");
    }
    

}
public static String printBoard(String[][] board)
{
    String[][] Board = board;
    String result = "";
    for(int i = 0; i < 3; i++)
    {
        for(int j = 0; j < 3; j++)
        {
            if(Board[i][j] == null)
            {
                result += " ";
            }
            else
            {
                result += Board[i][j];
            }
        }
        result += "\n";
    }
    return result;
}
public static String checkGameState(String[][] board)
{
    String[][] Board = board;
    int xCount = 0;
    int oCount = 0;
    
    //Check Up-Down Wins
    for(int i = 0; i < 3; i++)
    {
        if ((Board[i][0] == "X" && Board[i][1] == "X" && Board[i][2] == "X") || (Board[0][i] == "X" && Board[1][i] == "X" && Board[2][i] == "X"))
        {
            return "xWin";
            
        }
        else
        if((Board[i][0] == "O" && Board[i][1] == "O" && Board[i][2] == "O") || (Board[0][i] == "O" && Board[1][i] == "O" && Board[2][i] == "O"))
        {
            return "oWin";
        }
        
    }
    
    //Check for Diagonals
    if(Board[1][1] == "X" && ((Board[0][0] == "X" && Board[2][2] == "X") || (Board[0][2] == "X" && Board[2][0] == "X")))
    {
        return "xWin";
    }
    else
    if(Board[1][1] == "O" && ((Board[0][0] == "O" && Board[2][2] == "O") || (Board[0][2] == "O" && Board[2][0] == "O")))
    {
        return "oWin";
    }
    //Check for Tie/Continiue
    for(int i = 0; i < 3; i++)
    {
        for(int j = 0; j < 3; j++)
        {
            if(Board[i][j] == "X")
            {
                xCount ++;
            }
            else
            if(Board[i][j] == "O")
            {
                oCount ++;
            }
        }
    }
    if(xCount + oCount == 9)
    {
        return "tied";
    }
    else
    {
        return "continue";
    
    }
    
} 

