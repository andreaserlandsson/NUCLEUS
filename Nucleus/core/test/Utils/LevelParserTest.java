package Utils;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;


public class LevelParserTest {

    //test for reading a file, in this case level_1. Maybe will need to test all seperate levels?

   /* @Test
    public void testReadFromFile(){
        String level = LevelParser.readFromFile(1);
        assertNotNull(level);
        assertTrue(level.length()%2 == 0);
        String mockLevel1 = "1\n3\n3\n4\n5\n1\n6\n61\n62\n63\n7\n71, 72, 73, 8, 81, 82, 83]";
        assertTrue(level.equals(mockLevel1));
    }



    //Testing for levelparser, and if the methods return what we want them to. NOT test for reading
    // a certain level file!
    //Test if correctly removes spaces and returns a new row instead.
    @Test
    public void testReplaceCharacters() {
        String str1 = "1\n2\n3\n4\n5\n6 7";
        String str2 = " 1\n2\n3\n4\n5";
        String str3 = "1 2 3 4 5 6 ";
        assertTrue(LevelParser.replaceCharacters(str1).equals("1\n2\n3\n4\n5\n6\n7"));
        assertTrue(LevelParser.replaceCharacters(str2).equals("1\n2\n3\n4\n5"));

        assertFalse(LevelParser.replaceCharacters(str3).equals("1\n2\n3\n4\n5\n6"));
    }

    //test if correctly makes field out of the text.
    @Test
    public void testSplitLevelString(){
        String str1 = "1\n2\n3\n4\n5";
        String str2 = "12\n3\n4\n5";
        assertTrue(Arrays.toString(LevelParser.splitLevelString(str1)).equals("[1, 2, 3, 4, 5]"));
        assertFalse(Arrays.toString(LevelParser.splitLevelString(str2)).equals("[1, 2, 3, 4, 5]"));
    }

    // test for method a working with method b.
    @Test
    public void testLevelParser() {
        String level1 = "1 2 3 4 5 6";
        String level2 = "1 2 3 45 6";
        Arrays.toString(LevelParser.levelParse(1));
        assertTrue(Arrays.toString(LevelParser.splitLevelString(LevelParser.(level1)).equals("[1, 2, 3, 4, 5, 6]"));
        assertTrue(Arrays.toString(LevelParser.splitLevelString(LevelParser.(level2)).equals("[1, 2, 3, 45, 6]"));

    }
    */







}
