package round__2_Cpaste.jan2024.svblog.the100;
//
//public class pixelMspaint {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}
//
//}
/*4. In MS-Paint, when we take the brush to a pixel and click, the color of the region of that pixel is replaced with a new selected color. Following is the problem statement to do this task.

Given a 2D screen, location of a pixel in the screen and a color, replace color of the given pixel and all adjacent same colored pixels with the given color.

Example:

Input:

       screen[M][N] = {{1, 1, 1, 1, 1, 1, 1, 1},

                      {1, 1, 1, 1, 1, 1, 0, 0},

                      {1, 0, 0, 1, 1, 0, 1, 1},

                      {1, 2, 2, 2, 2, 0, 1, 0},

                      {1, 1, 1, 2, 2, 0, 1, 0},

                      {1, 1, 1, 2, 2, 2, 2, 0},

                      {1, 1, 1, 1, 1, 2, 1, 1},

                      {1, 1, 1, 1, 1, 2, 2, 1},

                      };

    x = 4, y = 4, newColor = 3

The values in the given 2D screen indicate colors of the pixels.

x and y are coordinates of the brush, newColor is the color that

should replace the previous color on screen[x][y] and all surrounding

pixels with same color.



Output:

Screen should be changed to following.

       screen[M][N] = {{1, 1, 1, 1, 1, 1, 1, 1},

                      {1, 1, 1, 1, 1, 1, 0, 0},

                      {1, 0, 0, 1, 1, 0, 1, 1},

                      {1, 3, 3, 3, 3, 0, 1, 0},

                      {1, 1, 1, 3, 3, 0, 1, 0},

                      {1, 1, 1, 3, 3, 3, 3, 0},

                      {1, 1, 1, 1, 1, 3, 1, 1},

                      {1, 1, 1, 1, 1, 3, 3, 1},

                      };*/
public class pixelMspaint {
    public static void main(String[] args) {
        int[][] screen = {
        //   0, 1, 2, 3, 4, 5, 6, 7,	
            {1, 1, 1, 1, 1, 1, 1, 1},//0
            {1, 1, 1, 1, 1, 1, 0, 0},//1
            {1, 0, 0, 1, 1, 0, 1, 1},//2
            {1, 2, 2, 2, 2, 0, 1, 0},//3
            {1, 1, 1, 2, 2, 0, 1, 0},//4
            {1, 1, 1, 2, 2, 2, 2, 0},//5
            {1, 1, 1, 1, 1, 2, 1, 1},//6
            {1, 1, 1, 1, 1, 2, 2, 1}//7
        };
        int x = 4, y = 0, newColor = 3;
        int oldColor = screen[x][y];
        paint(screen, x, y, oldColor, newColor);
        printScreen(screen);
    }

    public static void paint(int[][] screen, int x, int y, int oldColor, int newColor) {
        if (x < 0 || x >= screen.length || y < 0 || y >= screen[0].length || screen[x][y] != oldColor) {
            return;
        }
        screen[x][y] = newColor;
        paint(screen, x + 1, y, oldColor, newColor); // right
        paint(screen, x - 1, y, oldColor, newColor); // left
        paint(screen, x, y + 1, oldColor, newColor); // down
        paint(screen, x, y - 1, oldColor, newColor); // up
    }

    public static void printScreen(int[][] screen) {
        for (int[] row : screen) {
            for (int pixel : row) {
                System.out.print(pixel + " ");
            }
            System.out.println();
        }
    }
}
