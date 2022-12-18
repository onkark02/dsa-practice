package practice.leetcode;

public class FloodFill {
    public static void main(String[] args) {
        FloodFill floodFill = new FloodFill();
        int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
        floodFill.floodFill(image, 1,1,2);
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(sr > 0 && sr <= image.length && sc > 0 && sc <= image[0].length){
            int prevColor = image[sr][sc];
            if(prevColor != newColor){
                fill(image, sr, sc, newColor, prevColor);
            }
        }
        return image;
    }

    private void fill(int[][] image, int sr, int sc, int newColor, int prevColor){
        if(sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != prevColor)
            return;

        image[sr][sc] = newColor;
        fill(image, sr-1, sc, newColor, prevColor);
        fill(image, sr+1, sc, newColor, prevColor);
        fill(image, sr, sc-1, newColor, prevColor);
        fill(image, sr, sc+1, newColor, prevColor);
    }
}
