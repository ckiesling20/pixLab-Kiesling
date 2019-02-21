//package com.gradescope.pixlab;

import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param height the height of the desired picture
   * @param width the width of the desired picture
   */
  public Picture(int height, int width)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   * @param copyPicture the picture to copy
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
  
  /** Method to set the blue to 0 */
  public void zeroBlue()
{
  Pixel[][] pixels = this.getPixels2D();
  for (Pixel[] rowArray : pixels)
  {
    for (Pixel pixelObj : rowArray)
    {
      pixelObj.setBlue(0);
    }
  }
}

  public void keepOnlyBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setRed(0);
        pixelObj.setGreen(0);
      }
    }
  }

  public void negate() {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setRed(255 - pixelObj.getRed());
        pixelObj.setGreen(255 -pixelObj.getGreen());
        pixelObj.setBlue(255 - pixelObj.getBlue());
      }
    }
  }


  public void grayscale() {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels) {
      for (Pixel pixelObj : rowArray) {
        int average = (pixelObj.getGreen() + pixelObj.getRed() + pixelObj.getBlue())/3;
        pixelObj.setRed(average);
        pixelObj.setGreen(average);
        pixelObj.setBlue(average);
      }
    }
  }
  
  /** Method that mirrors the picture around a 
    * vertical mirror in the center of the picture
    * from left to right */
  public void mirrorVertical()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        rightPixel.setColor(leftPixel.getColor());
      }
    } 
  }

  public void mirrorVerticalRightToLeft()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        leftPixel.setColor(rightPixel.getColor());
      }
    }
  }

  public void mirrorHorizontal() {
    Pixel[][] pixels = this.getPixels2D();
    Pixel topPixel = null;
    Pixel bottomPixel = null;
    int height = pixels.length;
    for (int row = 0; row < height; row++)
    {
      for (int col = 0; col < pixels[0].length; col++)
      {
        topPixel = pixels[row][col];
        bottomPixel = pixels[height - 1 - row][col];
        bottomPixel.setColor(topPixel.getColor());
      }
    }
  }

  public void mirrorHorizontalBotToTop() {
    Pixel[][] pixels = this.getPixels2D();
    Pixel topPixel = null;
    Pixel bottomPixel = null;
    int height = pixels.length;
    for (int row = 0; row < height; row++)
    {
      for (int col = 0; col < pixels[0].length; col++)
      {
        topPixel = pixels[row][col];
        bottomPixel = pixels[height - 1 - row][col];
        topPixel.setColor(bottomPixel.getColor());
      }
    }
  }

  public void mirrorDiagonal()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel topRightPixel = null;
    Pixel bottomLeftPixel = null;
    int maxLength;
    if (pixels.length < pixels[0].length) { maxLength = pixels.length; }
    else {maxLength = pixels[0].length; }

    for (int row = 0; row < maxLength; row++)
    {
      for (int col = row; col < maxLength; col++)
      {
        topRightPixel = pixels[row][col];
        bottomLeftPixel = pixels[col][row];
        bottomLeftPixel.setColor(topRightPixel.getColor());
      }
    }
  }
  
  /** Mirror just part of a picture of a temple */
  public void mirrorTemple()
  {
    int mirrorPoint = 276;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();
    
    // loop through the rows
    for (int row = 27; row < 97; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 13; col < mirrorPoint; col++)
      {
        count = count + 1;
        leftPixel = pixels[row][col];      
        rightPixel = pixels[row]                       
                         [mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
      }
    }
    System.out.println(count);
  }

  public void mirrorArms()
  {
    int mirrorPoint = 193;
    Pixel topPixel = null;
    Pixel bottomPixel = null;
    Pixel[][] pixels = this.getPixels2D();

    // Left arm
    for (int row = 158; row < mirrorPoint; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 103; col < 170; col++)
      {
        topPixel = pixels[row][col];
        bottomPixel = pixels[mirrorPoint - row + mirrorPoint][col];
        bottomPixel.setColor(topPixel.getColor());
      }
    }

    int mirrorPoint2 = 198;
    Pixel topPixel2 = null;
    Pixel bottomPixel2 = null;

    // Right arm
    for (int row = 171; row < mirrorPoint2; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 239; col < 294; col++)
      {
        topPixel2 = pixels[row][col];
        bottomPixel2 = pixels[mirrorPoint2 - row + mirrorPoint2][col];
        bottomPixel2.setColor(topPixel2.getColor());
      }
    }
  }

  public void copy(Picture fromPic, int startRow, int startCol)
{
  Pixel fromPixel = null;
  Pixel toPixel = null;
  Pixel[][] toPixels = this.getPixels2D();
  Pixel[][] fromPixels = fromPic.getPixels2D();
  for (int fromRow = 0, toRow = startRow;
       fromRow < fromPixels.length &&
               toRow < toPixels.length;
       fromRow++, toRow++)
  {
    for (int fromCol = 0, toCol = startCol;
         fromCol < fromPixels[0].length &&
                 toCol < toPixels[0].length;
         fromCol++, toCol++)
    {
      fromPixel = fromPixels[fromRow][fromCol];
      toPixel = toPixels[toRow][toCol];
      toPixel.setColor(fromPixel.getColor());
    }
  }
}

  public void copyPiece(Picture fromPic, int startRow, int startCol, int begCol, int begRow, int endCol, int endRow)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = begRow, toRow = startRow;
         fromRow < endRow &&
                 toRow < toPixels.length;
         fromRow++, toRow++)
    {

      for (int fromCol = begCol, toCol = startCol;  fromCol < endCol &&
              toCol < toPixels[0].length;
           fromCol++, toCol++)
      {

        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }
  }

  public void myCollage() {
    Picture nelly = new Picture("images/nelly.jpg");
    Picture beach = new Picture("images/beach.jpg");
    Picture butterfly = new Picture("images/butterfly1.jpg");
    Picture temple = new Picture("images/temple.jpg");
    Picture wall = new Picture("images/whiteflower.jpg");
    temple.zeroBlue();
    wall.negate();
    butterfly.mirrorHorizontalBotToTop();
    this.copyPiece(nelly, 0,0, 200, 350, 500,650);
    this.copyPiece(beach, 300,200,400,200,500,300 );
    this.copyPiece(butterfly, 300,300,100,100,200,200 );
    this.copyPiece(beach, 200,300,400,200,500,300 );
    this.copyPiece(temple,100,300,100,100,200,200);
    this.copyPiece(temple,300,100,100,100,200,200);
    this.copyPiece(wall,0,300,100,100,200,200);
    this.copyPiece(wall,300,0,100,100,200,200);
    this.write("images/myCollage.jpg");
  }

  public void mirrorGull()
  {
    int mirrorPoint = 345;
    Pixel rightPixel = null;
    Pixel leftPixel = null;
    Pixel[][] pixels = this.getPixels2D();

    // Seagull
    for (int row = 235; row < 323; row++)
    {
      for (int col = 238; col < mirrorPoint; col++)
      {
        rightPixel = pixels[row][col];
        leftPixel = pixels[row][mirrorPoint - col + mirrorPoint/3];
        leftPixel.setColor(rightPixel.getColor());
      }
    }
  }

  /** Method to create a collage of several pictures */
  public void createCollage()
  {
    Picture flower1 = new Picture("images/flower1.jpg");
    Picture flower2 = new Picture("images/flower2.jpg");
    this.copy(flower1,0,0);
    this.copy(flower2,100,0);
    this.copy(flower1,200,0);
    Picture flowerNoBlue = new Picture(flower2);
    flowerNoBlue.zeroBlue();
    this.copy(flowerNoBlue,300,0);
    this.copy(flower1,400,0);
    this.copy(flower2,500,0);
    this.mirrorVertical();
    this.write("images/collage.jpg");
  }
  

  /** Method to show large changes in color 
    * @param edgeDist the distance for finding edges
    */
  public void edgeDetection(int edgeDist)
  {
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel topPixel = null;
    Pixel bottomPixel = null;

    Pixel[][] pixels = this.getPixels2D();


    for (int row = 0; row < pixels.length - 1; row++)
    {
      for (int col = 0; 
           col < pixels[0].length-1; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][col+1];
        topPixel = pixels[row][col];
        bottomPixel = pixels[row + 1][col];


        if (leftPixel.colorDistance(rightPixel.getColor()) >
            edgeDist || topPixel.colorDistance(bottomPixel.getColor()) > edgeDist)
          leftPixel.setColor(Color.BLACK);
        else
          leftPixel.setColor(Color.WHITE);
      }
    }
  }

  public static void fixUnderwater() {
    //will i do? idk
  }
  
  
  /* Main method for testing - each class in Java can have a main 
   * method 
   */
  public static void main(String[] args) 
  {
//    Picture beach = new Picture("images/beach.jpg");
//    beach.explore();
//    beach.keepOnlyBlue();
//    beach.explore();

    Picture canvas = new Picture("images/640x480.jpg");
    canvas.myCollage();
    canvas.explore();
  }

  
  
} // this } is the end of class Picture, put all new methods before this
