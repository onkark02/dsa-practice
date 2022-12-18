package practice.machinecoding.game;

public class BoardMover {
    public static void move(Board board, Move move) {
        switch (move) {
            case LEFT:
                for(int i=0;i<board.getSize(); i++){
                    shiftRowLeft(board.getBoard()[i]);
                }
                break;
            case RIGHT:

                for(int i=0;i<board.getSize(); i++){
                    int[] row = new int[board.getSize()];
                    for(int j=0; j<board.getSize(); j++){
                        row[j] = board.getBoard()[i][board.getSize()-1-j];
                    }
                    shiftRowLeft(row);
                    reverse(row);
                    board.getBoard()[i] = row;
                }
                break;
            case TOP:

                for(int i=0;i<board.getSize(); i++){
                    int[] row1 = new int[board.getSize()];
                    for(int j=0; j<board.getSize(); j++){
                        row1[j] = board.getBoard()[j][i];
                    }
                    shiftRowLeft(row1);
                    for(int j=0; j<board.getSize(); j++){
                         board.getBoard()[j][i]=row1[j];
                    }
                }
                break;
            case BOTTOM:

                for(int i=0;i<board.getSize(); i++){
                    int[] row2 = new int[board.getSize()];
                    for(int j=0; j<board.getSize(); j++){
                        row2[j] = board.getBoard()[board.getSize()-1-j][i];
                    }
                    shiftRowLeft(row2);
                    reverse(row2);
                    for(int j=0; j<board.getSize(); j++){
                        board.getBoard()[j][i]=row2[j];
                    }
                }
                break;
        }
        board.addTile();
    }


    public static void shiftRowLeft(int[] row) {
        //Move non-zero elements at left side
        int zeroIndex = 0;
        int nonZeroIndex;
        while (true) {
            while (zeroIndex < row.length && row[zeroIndex] != 0) {
                zeroIndex++;
            }
            nonZeroIndex = zeroIndex + 1;
            while (nonZeroIndex < row.length && row[nonZeroIndex] == 0)
                nonZeroIndex++;
            if (nonZeroIndex >= row.length)
                break;
            row[zeroIndex++] = row[nonZeroIndex];
            row[nonZeroIndex]=0;
        }

        //Add same values
        for(int i=1; i<row.length; i++){
            if(row[i]!=0 && row[i] == row[i-1]){
                row[i-1] = 2*row[i];
                row[i]=0;
                i++;
            }

        }

        //Move non-zero elements to left again
        zeroIndex=0;
        while (true) {
            while (zeroIndex < row.length && row[zeroIndex] != 0) {
                zeroIndex++;
            }
            nonZeroIndex = zeroIndex + 1;
            while (nonZeroIndex < row.length && row[nonZeroIndex] == 0)
                nonZeroIndex++;
            if (nonZeroIndex >= row.length)
                break;
            row[zeroIndex++] = row[nonZeroIndex];
            row[nonZeroIndex]=0;
        }
    }

    private static void reverse(int[] arr){
        int start = 0, end = arr.length-1;
        while(start < end){
            int temp = arr[start];
            arr[start++] = arr[end];
            arr[end--] = temp;
        }
    }
}
