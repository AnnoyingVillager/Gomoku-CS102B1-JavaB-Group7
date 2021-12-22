
import java.*;
import java.util.Arrays;

public class AI {
    public int chess=2;
    public int chesstype;//第几种设定好的棋形；
    static ChessBoard chessBoard;
    public static int size = Gomoku.getBroadSize();
    public static int x;
    public static int y;
    public AI(){};
    public AI(ChessBoard chessBoard) {
        AI.chessBoard = chessBoard;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    int[]  horizontal=new int[size],vertical=new int[size],tangle45=new int[size],tangle135=new int[size];
    public  void setHorizontal(int board[][],int i,int j){
        for (int k=0; k< size-j; k++,j++) {
            horizontal[k]= board[i][j];
            if(horizontal[k]!=0){
            }
        }


    }
    public void setVertical(int[][]board,int i,int j){
        for (int k = 0; k< size-i; k++,i++) {
            vertical[k]= board[i][j];
        }
    }
    public void setTangle45(int[][] board,int i,int j){
        for (int k = 0; k<Math.min(i+1,size-j); k++,i--,j++) {
           tangle45[k]= board[i][j];
        }
    }
    public void setTangle135(int[][] board,int i,int j){
        int gap=i-j;
        for (int k = 0; k<Math.min(size-i,size-j); k++,i++,j++) {
           tangle135[k]= board[i][j];
        }
    }
    private int[] getHorizontal(int[][] board,int i){
       return horizontal;
    }
    private int[] getVertical(int[][] board,int i){
       return vertical;
    }
    private int[] getTangle45(int[][] board,int i) {
       return tangle45;
    }
    private int[] getTangle135(int[][] board,int i) {
        return tangle135;
    }


       public static void compare(int[]temp1,int[]temp2,int[]temp3,int[][]board,int[][][][][]hs,int[][][][][]ss,int[][][][][]ha,int[][][][][]sa,int[]horizontal,int[]vertical,int[]tangle45,int[]tangle135){
           AI ai=new AI();
           int[] huosi0=new int[]{0, 1, 1, 1, 1};
           int[] huosi1=new int[]{1, 0, 1, 1, 1};
           int[] huosi2=new int[]{1, 1, 0, 1, 1};
           int[] huosi3=new int[]{1, 1, 1, 0, 1};
           int[] huosi4=new int[]{1, 1, 1, 1, 0};
           int[] huosi5=new int[]{0, 2, 2, 2, 2};
           int[] huosi6=new int[]{2, 0, 2, 2, 2};
           int[] huosi7=new int[]{2, 2, 0, 2, 2};
           int[] huosi8=new int[]{2, 2, 2, 0, 2};
           int[] huosi9=new int[]{2, 2, 2, 2, 0};

           int[] sisi0=new int[]{2, 1, 0, 1, 1, 1, 2};
           int[] sisi1=new int[]{2, 1, 1, 0, 1, 1, 2};
           int[] sisi2=new int[]{2, 1, 1, 1, 0, 1, 2};
           int[] sisi3=new int[]{2, 1, 1, 1, 1, 0};
           int[] sisi4=new int[]{1, 2, 0, 2, 2, 2, 1};
           int[] sisi5=new int[]{1, 2, 2, 0, 2, 2, 1};
           int[] sisi6=new int[]{1, 2, 2, 2, 0, 2, 1};
           int[] sisi7=new int[]{1, 2, 2, 2, 2, 0};

           int[] huosan0=new int[]{ 0, 1, 1, 1, 0};
           int[] huosan1=new int[]{ 1, 0, 1, 1, 0};
           int[] huosan2=new int[]{ 1, 1, 0, 1, 0};
           int[] huosan3=new int[]{ 0, 2, 2, 2, 0};
           int[] huosan4=new int[]{ 2, 0, 2, 2, 0};
           int[] huosan5=new int[]{ 2, 2, 0, 2, 0};

           int[] sisan0=new int[]{0, 1, 1, 1, 2};
           int[] sisan1=new int[]{2, 1, 1, 1, 0};
           int[] sisan2=new int[]{0, 2, 2, 2, 1};
           int[] sisan3=new int[]{1, 2, 2, 2, 0};
           for (int i = 0; i < ai.size; i++) {
               for (int j = 0; j < ai.size; j++) {
                  ai.setHorizontal( board, i,j);
                  ai.setHorizontal(board,i,j);
                  ai.setTangle45(board,i,j);
                  ai.setTangle135(board,i,j);
                   for (int k = 0; k < ai.size; k++) {
                       int trys=0;
                       do {
                           switch (trys) {
                               case 0:
                                   temp1 = Arrays.copyOfRange(horizontal, k, k + 5);
                                   break;
                               case 1:
                                   temp1 = Arrays.copyOfRange(vertical, k, k + 5);
                                   break;
                               case 2:
                                   temp1 = Arrays.copyOfRange(tangle45, k, k + 5);
                                   break;
                               case 3:
                                   temp1 = Arrays.copyOfRange(tangle135, k, k + 5);
                                   break;
                           }
                           if (Arrays.equals(temp1, huosi0)) {
                               hs[0][i][j][k][trys] = 5;
                           }
                           if (Arrays.equals(temp1, huosi1)) {
                               hs[1][i][j][k][trys] = 5;
                           }
                           if (Arrays.equals(temp1, huosi2)) {
                               hs[2][i][j][k][trys] = 5;
                           }
                           if (Arrays.equals(temp1, huosi3)) {
                               hs[3][i][j][k][trys] = 5;
                           }
                           if (Arrays.equals(temp1, huosi4)) {
                               hs[4][i][j][k][trys] = 5;
                           }
                           if (Arrays.equals(temp1, huosi5)) {
                               hs[5][i][j][k][trys] = 5;
                           }
                           if (Arrays.equals(temp1, huosi6)) {
                               hs[6][i][j][k][trys] = 5;
                           }
                           if (Arrays.equals(temp1, huosi7)) {
                               hs[7][i][j][k][trys] = 5;
                           }
                           if (Arrays.equals(temp1, huosi8)) {
                               hs[8][i][j][k][trys] = 5;}
                               if (Arrays.equals(temp1, huosi9)) {
                                   hs[9][i][j][k][trys] = 5;
                               }


                               if (Arrays.equals(temp1, huosan0)) {
                                   ha[0][i][j][k][trys] = 3;
                               }
                               if (Arrays.equals(temp1, huosan1)) {
                                   ha[1][i][j][k][trys] = 3;
                               }
                               if (Arrays.equals(temp1, huosan2)) {
                                   ha[2][i][j][k][trys] = 3;
                               }
                               if (Arrays.equals(temp1, huosan3)) {
                                   ha[3][i][j][k][trys] = 3;
                               }
                               if (Arrays.equals(temp1, huosan4)) {
                                   ha[4][i][j][k][trys] = 3;
                               }
                               if (Arrays.equals(temp1, huosan5)) {
                                   ha[5][i][j][k][trys] = 3;
                               }


                               if (Arrays.equals(temp1, sisan0)) {
                                   sa[0][i][j][k][trys] = 1;
                               }
                               if (Arrays.equals(temp1, sisan1)) {
                                   sa[1][i][j][k][trys] = 1;
                               }
                               if (Arrays.equals(temp1, sisan2)) {
                                   sa[2][i][j][k][trys] = 1;
                               }
                               if (Arrays.equals(temp1, sisan3)) {
                                   sa[3][i][j][k][trys] = 1;
                               }
                               trys += 1;
                           }
                           while (trys < 4) ;
                       }

                   for (int l = 0; l < ai.size; l++) {
                       int trys=0;
                       do{
                           switch (trys){
                           case 0: temp2 = Arrays.copyOfRange(horizontal, l, l + 6);break;
                           case 1: temp2 = Arrays.copyOfRange(vertical,l,l+6);break;
                           case 2: temp2 = Arrays.copyOfRange(tangle45,l,l+6);break;
                           case 3: temp2 = Arrays.copyOfRange(tangle135,l,l+6);break;
                           }
                           if(Arrays.equals(temp2,sisi3)) {
                               ss[3][i][j][l][trys] = 4;
                           }
                           if(Arrays.equals(temp2,sisi7)){
                               ss[7][i][j][l][trys] = 4;
                           }
                           trys+=1;
                   }while(trys<4);
               }
                   for (int m = 0; m < ai.size; m++) {
                       int trys=0;
                       do{
                           switch (trys){
                               case 0: temp3 = Arrays.copyOfRange(horizontal, m, m + 7);break;
                               case 1: temp3 = Arrays.copyOfRange(vertical,m,m+7);break;
                               case 2: temp3 = Arrays.copyOfRange(tangle45,m,m+7);break;
                               case 3: temp3 = Arrays.copyOfRange(tangle135,m,m+7);break;
                           }
                           if(Arrays.equals(temp3,sisi0)) {
                               ss[0][i][j][m][trys] = 4;
                           }
                           if(Arrays.equals(temp3,sisi1)){
                               ss[1][i][j][m][trys] = 4;
                           }
                           if(Arrays.equals(temp3,sisi2)){
                               ss[2][i][j][m][trys] = 4;
                           }
                           if(Arrays.equals(temp3,sisi4)){
                               ss[4][i][j][m][trys] = 4;
                           }

                           if(Arrays.equals(temp3,sisi5)){
                               ss[5][i][j][m][trys] = 4;
                           }
                           if(Arrays.equals(temp3,sisi6)){
                               ss[6][i][j][m][trys] = 4;
                           }
                           trys+=1;
                       }while(trys<4);
                   }
               }
           }

       }
       public static void action(int chess,int size,int[][]board,int[][][][][]hs,int[][][][][]ss,int[][][][][]ha,int[][][][][]sa) {
           int max = 0;
           for (int n = 0; n < 10; n++) {
               for (int i = 0; i <size; i++) {
                   for (int j = 0; j < size; j++) {
                       for (int k = 0; k < size; k++) {
                           for (int l = 0; l < 4; l++) {
                               max = Math.max(max, hs[n][i][j][k][l]);
                           }
                       }

                   }

               }
           }
           for (int n = 0; n < 8; n++) {
               for (int i = 0; i < size; i++) {
                   for (int j = 0; j < size; j++) {
                       for (int k = 0; k < size; k++) {
                           for (int l = 0; l < 4; l++) {
                               max = Math.max(max, ss[n][i][j][k][l]);
                           }
                       }
                   }
               }

           }
           for (int n = 0; n < 6; n++) {
               for (int i = 0; i < size; i++) {
                   for (int j = 0; j < size; j++) {
                       for (int k = 0; k < size; k++) {
                           for (int l = 0; l < 4; l++) {
                               max = Math.max(max, ha[n][i][j][k][l]);
                           }
                       }
                   }
               }

           }

           boolean isPlaced = false;
           for (int n = 0; n < 4; n++) {
               for (int i = 0; i < size; i++) {
                   for (int j = 0; j < size; j++) {
                       for (int k = 0; k < size; k++) {
                           for (int l = 0; l < 4; l++) {
                               max = Math.max(max, sa[n][i][j][k][l]);
                           }
                       }
                   }
               }
               }
           System.out.println(max);//--------------------------------------------------------------------------------------
               if (max != 0) {
                   for (int i = 0; i < size; i++) {
                       for (int j = 0; j < size; j++) {
                           for (int k = 0; k < size; k++) {
                               for (int l = 0; l < 5; l++) {
                                   if (max == hs[l][i][j][k][0]) {
                                       if (!chessBoard.isForbidden(i, k + l + j)) {
                                           x = i;
                                           y = k + l + j;
                                           isPlaced = true;
                                           break;
                                       }
                                   }
                                   if (max == hs[l][i][j][k][1]) {
                                       if (!chessBoard.isForbidden(k + l + i, j)) {
                                           x = k + l + i;
                                           y = j;
                                           isPlaced = true;
                                           break;
                                       }
                                   }
                                   if (max == hs[l][i][j][k][2]) {
                                       if (!chessBoard.isForbidden(k + l + i, k + l + j)) {
                                           x = k + l + i;
                                           y = k + l + j;
                                           isPlaced = true;
                                           break;
                                       }
                                   }
                                   if (max == hs[l][i][j][k][3]) {
                                       if (!chessBoard.isForbidden(-k - l + i, k + l + j)) {
                                           x = -k - l + i;
                                           y = k + l + j;
                                           isPlaced = true;
                                           break;
                                       }

                                   }
                               }

                               for (int l = 5; l < 10; l++) {
                                   if (max == hs[l][i][j][k][0]) {
                                       if (!chessBoard.isForbidden(i, j + k + l - 5)) {
                                           x = i;
                                           y = j + k + l - 5;
                                           isPlaced = true;
                                           break;
                                       }
                                   }
                                   if (max == hs[l][i][j][k][1]) {
                                       if (!chessBoard.isForbidden(i + k + l - 5, j)) {
                                           x = i + k + l - 5;
                                           y = j;
                                           isPlaced = true;
                                           break;
                                       }
                                   }
                                   if (max == hs[l][i][j][k][2]) {
                                       if (!chessBoard.isForbidden(i + k + l - 5, j + k + l - 5)) {
                                           x = i + k + l - 5;
                                           y = j + k + l - 5;
                                           isPlaced = true;
                                           break;
                                       }
                                   }
                                   if (max == hs[l][i][j][k][3]) {
                                       if (!chessBoard.isForbidden(i - k - l + 5, j + k + l - 5)) {
                                           x = i + k + l - 5;
                                           y = j;
                                           isPlaced = true;
                                           break;
                                       }
                                   }
                               }
                               for (int l = 0; l < 4; l++) {
                                   if (max == ss[l][i][j][k][0]) {
                                       if (!chessBoard.isForbidden(i, j + k + l + 2)) {
                                           x = i;
                                           y = j + k + l + 2;
                                           isPlaced = true;
                                           break;
                                       }
                                   }
                                   if (max == ss[l][i][j][k][1]) {
                                       if (!chessBoard.isForbidden(i + k + l + 2, j)) {
                                           x = i + k + l + 2;
                                           y = j;
                                           isPlaced = true;
                                           break;
                                       }
                                   }
                                   if (max == ss[l][i][j][k][2]) {
                                       if (!chessBoard.isForbidden(i + k + l + 2, j + k + l + 2)) {
                                           x = i + k + l + 2;
                                           y = j + k + l + 2;
                                           isPlaced = true;
                                           break;
                                       }
                                   }
                                   if (max == ss[l][i][j][k][3]) {
                                       if (!chessBoard.isForbidden(i - k - l - 2, j + k + l + 2)) {
                                           x = i - k - l - 2;
                                           y = j + k + l + 2;
                                           isPlaced = true;
                                           break;
                                       }
                                   }
                               }

                               for (int l = 4; l < 8; l++) {
                                   if (max == ss[l][i][j][k][0]) {
                                       if (!chessBoard.isForbidden(i, j + k + l - 2)) {
                                           x = i;
                                           y = j + k + l - 2;
                                           isPlaced = true;
                                           break;
                                       }
                                   }
                                   if (max == ss[l][i][j][k][1]) {
                                       if (!chessBoard.isForbidden(i + k + l - 2, j)) {
                                           x = i + k + l - 2;
                                           y = j;
                                           isPlaced = true;
                                           break;
                                       }
                                   }
                                   if (max == ss[l][i][j][k][2]) {
                                       if (!chessBoard.isForbidden(i + k + l - 2, j + k + l - 2)) {
                                           x = i + k + l - 2;
                                           y = j + k + l - 2;
                                           isPlaced = true;
                                           break;
                                       }
                                   }
                                   if (max == ss[l][i][j][k][3]) {
                                       if (!chessBoard.isForbidden(i - k - l + 2, j + k + l - 2)) {
                                           x = i - k - l + 2;
                                           y = j + k + l - 2;
                                           isPlaced = true;
                                           break;
                                       }
                                   }
                               }
                               for (int l = 0; l < 3; l++) {
                                   if (max == ha[l][i][j][k][0]) {
                                       if (!chessBoard.isForbidden(i, j + k + l)) {
                                           x = i;
                                           y = j + k + l;
                                           isPlaced = true;
                                           break;
                                       }
                                   }
                                   if (max == ha[l][i][j][k][1]) {
                                       if (!chessBoard.isForbidden(i + k + l, j)) {
                                           x = i + k + l;
                                           y = j;
                                           isPlaced = true;
                                           break;
                                       }
                                   }
                                   if (max == ha[l][i][j][k][2]) {
                                       if (!chessBoard.isForbidden(i + k + l, j + k + l)) {
                                           x = i + k + l;
                                           y = j + k + l;
                                           isPlaced = true;
                                           break;
                                       }
                                   }
                                   if (max == ha[l][i][j][k][3]) {
                                       if (!chessBoard.isForbidden(i - k - l, j + k + l)) {
                                           x = i - k - l;
                                           y = j + k + l;
                                           isPlaced = true;
                                           break;
                                       }
                                   }
                               }

                               for (int l = 3; l < 6; l++) {
                                   if (max == ha[l][i][j][k][0]) {
                                       if (!chessBoard.isForbidden(i, j + k + l - 3)) {
                                           x = i;
                                           y = j + k + l - 3;
                                           isPlaced = true;
                                           break;
                                       }
                                   }
                                   if (max == ha[l][i][j][k][1]) {
                                       if (!chessBoard.isForbidden(i + k + l - 3, j)) {
                                           x = i + k + l - 3;
                                           y = j;
                                           isPlaced = true;
                                           break;
                                       }
                                   }
                                   if (max == ha[l][i][j][k][2]) {
                                       if (!chessBoard.isForbidden(i + k + l - 3, j + k + l - 3)) {
                                           x = i + k + l - 3;
                                           y = j + k + l - 3;
                                           isPlaced = true;
                                           break;
                                       }
                                   }
                                   if (max == ha[l][i][j][k][3]) {
                                       if (!chessBoard.isForbidden(i - k - l + 3, j + k + l - 3)) {
                                           x = i - k - l + 3;
                                           y = j + k + l - 3;
                                           isPlaced = true;
                                           break;
                                       }
                                   }
                               }

                               for (int l = 0; l < 2; l++) {
                                   if (max == sa[l][i][j][k][0]) {
                                       if (!chessBoard.isForbidden(i, j + k + 4 * l)) {
                                           x = i;
                                           y = j + k + 4 * l;
                                           isPlaced = true;
                                           break;
                                       }
                                   }
                                   if (max == sa[l][i][j][k][1]) {
                                       if (!chessBoard.isForbidden(i + k + 4 * l, j)) {
                                           x = i + k + 4 * l;
                                           y = j;
                                           isPlaced = true;
                                           break;
                                       }
                                   }
                                   if (max == sa[l][i][j][k][2]) {
                                       if (!chessBoard.isForbidden(i + k + 4 * l, j + k + 4 * l)) {
                                           x = i + k + 4 * l;
                                           y = j + k + 4 * l;
                                           isPlaced = true;
                                           break;
                                       }
                                   }
                                   if (max == sa[l][i][j][k][3]) {
                                       if (!chessBoard.isForbidden(i - k - 4 * l, j + k + 4 * l)) {
                                           x = i - k - 4 * l;
                                           y = j + k + 4 * l;
                                           isPlaced = true;
                                           break;
                                       }
                                   }
                               }
                               for (int l = 2; l < 4; l++) {
                                   if (max == sa[l][i][j][k][0]) {
                                       if (!chessBoard.isForbidden(i, j + k + 4 * l - 8)) {
                                           x = i;
                                           y = j + k + 4 * l - 8;
                                           isPlaced = true;
                                           break;
                                       }
                                   }
                                   if (max == sa[l][i][j][k][1]) {
                                       if (!chessBoard.isForbidden(i + k + 4 * l - 8, j)) {
                                           x = i + k + 4 * l - 8;
                                           y = j;
                                           isPlaced = true;
                                           break;
                                       }
                                   }
                                   if (max == sa[l][i][j][k][2]) {
                                       if (!chessBoard.isForbidden(i + k + 4 * l - 8, j + k + 4 * l - 8)) {
                                           x = i + k + 4 * l - 8;
                                           y = j + k + 4 * l - 8;
                                           isPlaced = true;
                                           break;
                                       }
                                   }
                                   if (max == sa[l][i][j][k][3]) {
                                       if (!chessBoard.isForbidden(i - k - 4 * l + 8, j + k + 4 * l - 8)) {
                                           x = i - k - 4 * l + 8;
                                           y = j + k + 4 * l - 8;
                                           isPlaced = true;
                                           break;
                                       }
                                   }
                               }
                           }
                       }


                   }

           }
           if(!isPlaced||max==0) {boolean find=false;
               while (find==false){
               int i=(int)(Math.random()*(size-2)+1);
               int j=(int)(Math.random()*(size-2)+1);
               if(board[i][j]==0) {
                   if (board[i + 1][j + 1] == 1 || board[i + 1][j + 1] == 2 ||
                       board[i - 1][j + 1] == 1 || board[i - 1][j + 1] == 2 ||
                       board[i + 1][j - 1] == 1 || board[i + 1][j - 1] == 2 ||
                       board[i - 1][j - 1] == 1 || board[i - 1][j - 1] == 2) {

                       if (chess == 1) {
                           if(!chessBoard.isForbidden(i,j)) {
                           x = i;
                           y = j;
                           isPlaced = true;
                           find=true;
                         }

                       } else {
                           if(!chessBoard.isForbidden(i,j)) {
                               x = i;
                               y = j;
                               isPlaced = true;
                               find=true;
                           }
                       }
                   }else{continue;}
               }
               }
           }
           }

    public static void main(String[] args) {
           int[][] board = chessBoard.chessBoard;
           int size=chessBoard.chessBoard.length;
        int[]temp1=new int[5];
        int[]temp2=new int[6];
        int[]temp3=new int[7];
        int[][][][][]hs=new int[10][size][size][size][4];
        int[][][][][]ss=new int[8][size][size][size][4];
        int[][][][][]ha=new int[6][size][size][size][4];
        int[][][][][]sa=new int[4][size][size][size][4];
        int[]  horizontal=new int[size],vertical=new int[size],tangle45=new int[size],tangle135=new int[size];
        int chess=1;
        compare(temp1,temp2,temp3,board,hs,ss,ha,sa,horizontal,vertical,tangle45,tangle135);
        action( chess,size,board,hs,ss,ha,sa);

    }
       }














