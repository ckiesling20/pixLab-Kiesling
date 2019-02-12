/**
 * This class contains class (static) methods
 * that will help you test the Picture class 
 * methods.  Uncomment the methods and the code
 * in the main to test.
 * 
 * @author Barbara Ericson 
 */
public class PictureTester
{
  /** Method to test zeroBlue */
  public static void testZeroBlue()
  {
    Picture beach = new Picture("images/beach.jpg");
    beach.explore(); // comment these out in repl.it
    beach.zeroBlue();
    beach.explore(); // comment these out in repl.it

    // uncomment this in repl.it to test your code!!
    // beach.write("imagesOutput/beach.jpg");
  }
  
  /** Method to test mirrorVertical */
  public static void testMirrorVertical()
  {
    Picture caterpillar = new Picture("images/nelly.jpg");
    caterpillar.explore();
    caterpillar.mirrorVertical();
    caterpillar.explore();
  }

  public static void testMirrorVerticalRightToLeft()
  {
    Picture caterpillar = new Picture("images/nelly.jpg");
    caterpillar.explore();
    caterpillar.mirrorVerticalRightToLeft();
    caterpillar.explore();
  }
  
  /** Method to test mirrorTemple */
  public static void testMirrorTemple()
  {
    Picture temple = new Picture("images/temple.jpg");
    temple.explore();
    temple.mirrorTemple();
    temple.explore();
  }

  public static void testMirrorArms()
  {
    Picture snowman = new Picture("images/snowman.jpg");
    snowman.explore();
    snowman.mirrorArms();
    snowman.explore();
  }
  
  /** Method to test the collage method */
  public static void testCollage()
  {
    Picture canvas = new Picture("640x480.jpg");
    canvas.createCollage();
    canvas.explore();
  }
  
  /** Method to test edgeDetection */
  public static void testEdgeDetection()
  {
    Picture swan = new Picture("swan.jpg");
    swan.edgeDetection(10);
    swan.explore();
  }

  public static void testKeepOnlyBlue() {
    Picture nelly = new Picture ("images/nelly.jpg");
    nelly.keepOnlyBlue();
    nelly.explore();
  }

  public static void testNegate() {
    Picture nelly = new Picture ("images/nelly.jpg");
    nelly.negate();
    nelly.explore();
  }

  public static void testGrayscale() {
    Picture nelly = new Picture ("images/nelly.jpg");
    nelly.grayscale();
    nelly.explore();
  }

  public static void testMirrorHorizontal() {
    Picture nelly = new Picture ("images/nelly.jpg");
    nelly.mirrorHorizontal();
    nelly.explore();
  }

  public static void testMirrorHorizontalBotToTop() {
    Picture nelly = new Picture ("images/nelly.jpg");
    nelly.mirrorHorizontalBotToTop();
    nelly.explore();
  }

  public static void testMirrorDiagonal() {
    Picture nelly = new Picture ("images/nelly.jpg");
    nelly.mirrorDiagonal();
    nelly.explore();
  }

  public static void testMirrorGull() {
    Picture nelly = new Picture ("images/seagull.jpg");
    nelly.mirrorGull();
    nelly.explore();
  }

  /** Main method for testing.  Every class can have a main
    * method in Java */
  public static void main(String[] args)
  {
    // uncomment a call here to run a test
    // and comment out the ones you don't want
    // to run
    //testZeroBlue();
    //testKeepOnlyBlue();
    //testKeepOnlyRed();
    //testKeepOnlyGreen();
    //testNegate();
    //testGrayscale();
    //testFixUnderwater();
    //testMirrorVertical();
    //testMirrorTemple();
    //testMirrorArms();
    testMirrorGull();
    //testMirrorDiagonal();
    //testCollage();
    //testCopy();
    //testEdgeDetection();
    //testEdgeDetection2();
    //testChromakey();
    //testEncodeAndDecode();
    //testGetCountRedOverValue(250);
    //testSetRedToHalfValueInTopHalf();
    //testClearBlueOverValue(200);
    //testGetAverageForColumn(0);
    //testMirrorVerticalRightToLeft();
    //testMirrorHorizontal();
    //testMirrorHorizontalBotToTop();
    //testMirrorDiagonal();
  }
}