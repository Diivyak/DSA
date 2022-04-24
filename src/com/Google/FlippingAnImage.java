package com.Google;

public class FlippingAnImage {

	public static int[][] flipAndInvertImage(int[][] image) {
        int row = image.length, col = image[0].length;

        for(int i=0; i<row;i++) {
            for(int j=0; j<col/2;j++) {
                int temp = image[i][j];
                image[i][j] = image[i][col-1-j] == 1 ? 0 : 1;
                image[i][col-1-j] = temp == 1 ? 0 : 1;
            }
            if(col%2 !=0) {
                image[i][col/2] = image[i][col/2] == 1 ? 0 : 1;
            }

        }
        return image;

    }
	public static void main(String[] args) {
		int[][] image = {{1,1,0},{1,0,1},{0,0,0}};
		image = flipAndInvertImage(image);
		for(int i=0; i<image.length; i++) {
			for(int j=0; j<image[0].length;j++) 
				System.out.print(image[i][j]+" ");
			System.out.println();
		}
	}

}
