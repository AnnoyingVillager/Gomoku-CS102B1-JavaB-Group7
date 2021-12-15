import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class ChessBoard {
    private int boardSize;
    int[][] chessBoard;
    private int color = 1;
    private int moveTimes = 0;
    private int timeLeft;
    private int timeSpent;
    private int undoX;
    private int undoY;
    Stack<String> steps = new Stack<>();

    //构造器
    public ChessBoard (){
        initializeBoard();
    }
    public ChessBoard (int boardSize){
        this.boardSize = boardSize;
        initializeBoard();
    }
    public ChessBoard (int[][] chessBoard){
        this.chessBoard = chessBoard;
        initializeBoard();
    }
    public void initializeBoard(){
        chessBoard = new int[boardSize][boardSize];
        moveTimes = 0;
        for (int i=0 ; i<chessBoard.length ; i++){
            for (int j=0 ; j<chessBoard[i].length ; j++){
                chessBoard[i][j] = 0;
            }
        }
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //棋盘设定代码段(参数传入)
    public void setBoardSize(int boardSize) {
        this.boardSize = boardSize;
        initializeBoard();
    }

    public void setTimeSpent(int timeSpent) {
        this.timeSpent = timeSpent;
    }

    public void setTimeLeft(int timeLeft) {
        this.timeLeft = timeLeft;
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //棋盘状态获取(参数传出)
    public int[][] getChessBoard() {
        return chessBoard;
    }

    public int getMoveTimes() {
        return moveTimes;
    }

    public int getBoardSize() {
        return boardSize;
    }

    public int getUndoX() {
        return undoX;
    }

    public int getUndoY() {
        return undoY;
    }

    public boolean canUndo(){
        return steps.size() > 0;
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //棋盘操作
    public void playChess(int x,int y){
        moveTimes++;
        if (moveTimes%2 != 0){
            color = 1;
        }else {
            color = 2;
        }
        chessBoard[x][y] = color;
    }
    //游戏存储
    public void save() throws FileNotFoundException {
        PrintWriter save = new PrintWriter("saves.txt");
        save.print(boardSize + "@" + moveTimes + "@");
        for (int i=0 ; i<chessBoard.length ; i++){
            for (int j=0 ; j<chessBoard[i].length ; j++){
                String temp = chessBoard[i][j] + "#";
                save.print(temp);
                save.flush();
            }
        }
    }
    //游戏载入
    public void load() throws FileNotFoundException{
        Scanner input = new Scanner(new File("saves.txt"));
        String[] input01 = input.nextLine().split("@");
        boardSize = Integer.parseInt(input01[0]);
        moveTimes = Integer.parseInt(input01[1]);
        String[] input02 = input01[2].split("#");
        int initialPos = 0;
        for (int i=0 ; i<boardSize ; i++){
            for (int j=0 ; j<boardSize ; j++){
                chessBoard[i][j] = Integer.parseInt(input02[initialPos]);
                initialPos++;
            }
        }
    }
    //落子记录
    public void stepRecord(int x, int y){
        String temp = moveTimes + "@" + x + "#" + y;
        steps.push(temp);
        System.out.println(steps);
    }
    //悔棋
    public void undo(){
        moveTimes--;
        if (moveTimes<2){ moveTimes = 0; }
        String temp = steps.pop();
        String[] moveInf = temp.split("@");
        System.out.println(Arrays.toString(moveInf));
        String[] moveCord = moveInf[1].split("#");
        System.out.println(Arrays.toString(moveCord));
        undoX = Integer.parseInt(moveCord[0]);
        undoY = Integer.parseInt(moveCord[1]);
        chessBoard[undoX][undoY] = 0;
    }
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //判断核心
    public boolean isBoardFull(){
    for (int i=0 ; i<boardSize ; i++){
        for (int j=0 ; j<boardSize ; j++){
            if (chessBoard[i][j] == 0) return false;
        }
    }
    return true;
}

    //输赢判断
    public boolean isWin (int x,int y){
        int row = x;
        int column = y;
        int count = 1;
        int pointerC = 0;//Column指针（横行移动）
        int pointerR = 0;//Row指针（纵列移动）

        //指针向左遍历当前棋子左侧各棋子判断并记录相同颜色棋子数量
        for (pointerC = column-1 ; pointerC>=0 ; pointerC--){
            if (chessBoard[row][pointerC] == color){
                count++;
                if (count>=5) return true;
            }
            if (chessBoard[row][pointerC] != color) break;
        }
        //指针向右遍历当前棋子右侧各棋子判断并记录相同颜色棋子数量
        for (pointerC = column+1 ; pointerC<boardSize ; pointerC++){
            if (chessBoard[row][pointerC] == color){
                count++;
                if (count>=5) return true;
            }
            if (chessBoard[row][pointerC] != color) break;
        }


        count = 1;
        //指针向上遍历当前棋子上方各棋子判断并记录相同颜色棋子数量
        for (pointerR = row-1 ; pointerR>=0 ; pointerR--){
            if (chessBoard[pointerR][column] == color){
                count++;
                if (count>=5) return true;
            }//else break;
            if (chessBoard[pointerR][column] != color) break;
        }
        //指针向下遍历当前棋子下方各棋子判断并记录相同颜色棋子数量
        for (pointerR = row+1 ; pointerR<boardSize ; pointerR++){
            if (chessBoard[pointerR][column] == color){
                count++;
                if (count>=5) return true;
            }//else break;
            if (chessBoard[pointerR][column] != color) break;
        }


        count = 1;
        //指针向左上遍历当前棋子左上方各棋子判断并记录相同颜色棋子数量
        for (pointerC = column-1 ,pointerR = row-1 ; pointerC>=0 && pointerR>=0 ; pointerC-- , pointerR--){
            if (chessBoard[pointerR][pointerC] == color){
                count++;
                if (count>=5) return true;
            }
            if (chessBoard[pointerR][pointerC] != color) break;
        }
        //指针向右下方遍历当前棋子右下方各棋子判断并记录相同颜色棋子数量
        for (pointerC = column+1 ,pointerR = row+1 ; pointerC<boardSize && pointerR<boardSize ; pointerC++ , pointerR++){
            if (chessBoard[pointerR][pointerC] == color){
                count++;
                if (count>=5) return true;
            }if (chessBoard[pointerR][pointerC] != color) break;
        }


        count = 1;
        //指针向右上方遍历当前棋子右上方各棋子判断并记录相同颜色棋子数量
        for (pointerR = row-1 ,pointerC = column+1 ; pointerR>=0 && pointerC<boardSize ; pointerR-- , pointerC++){
            if (chessBoard[pointerR][pointerC] == color){
                count++;
                if (count>=5) return true;
            }if (chessBoard[pointerR][pointerC] != color) break;
        }
        //指针向左下方遍历当前棋子左下方各棋子判断并记录相同颜色棋子数量
        for (pointerR = row+1 ,pointerC = column-1 ; pointerR<boardSize && pointerC>=0 ; pointerR++ , pointerC--){
            if (chessBoard[pointerR][pointerC] == color){
                count++;
                if (count>=5) return true;
            }if (chessBoard[pointerR][pointerC] != color) break;
        }

        return false;
    }
    //3-3禁手判断
    public boolean isForbidden (int x,int y){
        int row = x;
        int column = y;
        chessBoard[row][column] = 1;
        LinkedList<String> chessCoordinate = new LinkedList<>();
        boolean result = false;
        int pointerR;
        int pointerC;
        int[] temp = new int[5];

        //以垂直5个棋子一组遍历整个棋盘
        for (pointerR=0 ; pointerR<=boardSize-5 ; pointerR++){
            for (pointerC=0 ; pointerC<boardSize ; pointerC++){
                temp[0] = chessBoard[pointerR][pointerC];
                temp[1] = chessBoard[pointerR+1][pointerC];
                temp[2] = chessBoard[pointerR+2][pointerC];
                temp[3] = chessBoard[pointerR+3][pointerC];
                temp[4] = chessBoard[pointerR+4][pointerC];
                if (isThreeThreeContinuous(temp)){
                    for (int i=0 ; i<5 ; i++){
                        if (temp[i] == 1){
                            chessCoordinate.add((pointerR+i)+"#"+(pointerC)+"");// r#c|
                        }
                    }
                }
            }
        }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //以水平5个棋子一组遍历整个棋盘
        for (pointerC=0 ; pointerC<=boardSize-5 ; pointerC++){
            for (pointerR=0 ; pointerR<boardSize ; pointerR++){
                temp[0] = chessBoard[pointerR][pointerC];
                temp[1] = chessBoard[pointerR][pointerC+1];
                temp[2] = chessBoard[pointerR][pointerC+2];
                temp[3] = chessBoard[pointerR][pointerC+3];
                temp[4] = chessBoard[pointerR][pointerC+4];
                if (isThreeThreeContinuous(temp)){
                    for (int i=0 ; i<5 ; i++){
                        if (temp[i] == 1){
                            chessCoordinate.add((pointerR)+"#"+(pointerC+i)+"");// r#c|
                        }
                    }
                }

            }
        }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //以二四象限方向5个棋子一组遍历整个棋盘
        for (pointerR=0 ; pointerR<boardSize-4 ; pointerR++){
            for (pointerC=0 ; pointerC<boardSize-4 ; pointerC++){
                temp[0] = chessBoard[pointerR][pointerC];
                temp[1] = chessBoard[pointerR+1][pointerC+1];
                temp[2] = chessBoard[pointerR+2][pointerC+2];
                temp[3] = chessBoard[pointerR+3][pointerC+3];
                temp[4] = chessBoard[pointerR+4][pointerC+4];
                if (isThreeThreeContinuous(temp)){
                    for (int i=0 ; i<5 ; i++){
                        if (temp[i] == 1){
                            chessCoordinate.add((pointerR+i)+"#"+(pointerC+i)+"");// r#c|
                        }
                    }
                }
            }
        }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //以一三象限方向5个棋子一组遍历整个棋盘
        for (pointerR=0 ; pointerR<boardSize-4 ; pointerR++){
            for (pointerC=4 ; pointerC<boardSize ; pointerC++){
                temp[0] = chessBoard[pointerR][pointerC];
                temp[1] = chessBoard[pointerR+1][pointerC-1];
                temp[2] = chessBoard[pointerR+2][pointerC-2];
                temp[3] = chessBoard[pointerR+3][pointerC-3];
                temp[4] = chessBoard[pointerR+4][pointerC-4];
                if (isThreeThreeContinuous(temp)){
                    for (int i=0 ; i<5 ; i++){
                        if (temp[i] == 1){
                            chessCoordinate.add((pointerR+i)+"#"+(pointerC-i)+"");// r#c|
                        }
                    }
                }
            }
        }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //判断已知活三是否存在交点，并判断是否为禁手
        int commandPasser = 0;
        for (int i=0 ; i<chessCoordinate.size()-1 ; i++){
            for (int j=i+1 ; j<chessCoordinate.size() ; j++){
                if (chessCoordinate.get(i).equals(chessCoordinate.get(j))){
                    result = true;
                    commandPasser = 1;
                    break;
                }
            }
            if (commandPasser == 1) break;
        }
        chessBoard[row][column] = 0;
        return result;
    }
    //落子处是否有子判断
    public boolean isBlocked(int x,int y){
        int row = x;
        int column = y;
        if (chessBoard[row][column] == 0) return false;
        return true;
    }

    //3-3禁手传出数组判断是否符合 空黑黑黑空 类型
    public static boolean isThreeThreeContinuous(int[] line){
        return  (line[0] == 0 && line[1] == 1 && line[2] == 1 && line[3] == 1 && line[4] == 0);
    }

}
