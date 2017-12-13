package top.treegrowth.common.p13;

class snakePrint {
    static int length = 8;   
    static int value = 1;   
    static int[][] snake = new int[length][length];   
    static Direction lastDirection = Direction.Right;   
  
    static enum Direction {   
        Right, Down, Left, Up;   
    }   
  
    public static void initialArray() {   
        int row = 0, col = 0;   
        for (int c = 0; c < length * length; c++) {   
            snake[row][col] = value;   
            lastDirection = findDirection(row, col);   
            switch (lastDirection) {   
                case Right:   
                    col++;   
                    break;   
                case Down:   
                    row++;   
                    break;   
                case Left:   
                    col--;   
                    break;   
                case Up:   
                    row--;   
                    break;   
                default:   
                    System.out.println("error");   
            }   
            value++;   
        }   
    }   
  
    static Direction findDirection(int row, int col) {   
        Direction direction = lastDirection;   
        switch (direction) {   
            case Right: {   
                if ((col == length - 1) || (snake[row][col + 1] != 0))   
                    direction = direction.Down;   
                break;   
            }   
            case Down: {   
                if ((row == length - 1) || (snake[row + 1][col] != 0))   
                    direction = direction.Left;   
                break;   
            }   
            case Left: {   
                if ((col == 0) || (snake[row][col - 1] != 0))   
                    direction = direction.Up;   
                break;   
            }   
            case Up: {   
                if (snake[row - 1][col] != 0)   
                    direction = direction.Right;   
                break;   
            }   
        }   
        return direction;   
    }   
  
    public static void main(String[] args) {   
        initialArray();   
  
        // display.....   
        for (int i = 0; i < length; i++) {   
            for (int j = 0; j < length; j++) {   
//                System.out.print(snake[i][j] + "  ");   
            	 System.out.printf(" %2d",snake[i][j]); 
            }   
            System.out.println();   
        }   
    }   
}  
