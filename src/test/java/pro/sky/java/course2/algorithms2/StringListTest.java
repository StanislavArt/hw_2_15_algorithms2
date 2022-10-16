package pro.sky.java.course2.algorithms2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import pro.sky.java.course2.algorithms2.exceptions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class StringListTest {
    private final StringList out = new StringListImp(20);

    @BeforeAll
    public void initSetup() {
        out.add("картофель");
        out.add("помидор");
        out.add("арахис");
        out.add("манго");
        out.add("манго");
    }

    @Test
    public void add() {
        String expected = "груша";
        int beforeSize = out.size();
        String actual = out.add(expected);
        int afterSize = out.size();

        Assertions.assertEquals(1, afterSize-beforeSize);
        Assertions.assertEquals(expected, actual);
        actual = out.get(out.size()-1);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void addByIndex() {
        String expected = "яблоко";
        int beforeSize = out.size();
        String actual = out.add(0, expected);
        int afterSize = out.size();

        Assertions.assertEquals(1, afterSize-beforeSize);
        Assertions.assertEquals(expected, actual);
        actual = out.get(0);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void set() {
        String expected = "персик";
        int beforeSize = out.size();
        String actual = out.set(0, expected);
        int afterSize = out.size();

        Assertions.assertEquals(0, afterSize-beforeSize);
        Assertions.assertEquals(expected, actual);
        actual = out.get(0);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void removeByElement() {
        String expected = "картофель";
        int beforeSize = out.size();
        String actual = out.remove(expected);
        int afterSize = out.size();

        Assertions.assertEquals(-1, afterSize-beforeSize);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void removeByIndex() {
        String expected = out.get(0);
        int beforeSize = out.size();
        String actual = out.remove(0);
        int afterSize = out.size();

        Assertions.assertEquals(-1, afterSize-beforeSize);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void contains() {
        String element = "арахис";
        boolean result = out.contains(element);
        Assertions.assertTrue(result);

        element = "пончик";
        result = out.contains(element);
        Assertions.assertFalse(result);
    }

    @Test
    public void indexOf() {
        int expected = 1;
        String element = out.get(1);
        Assertions.assertNotNull(expected);

        int actual = out.indexOf(element);
        Assertions.assertEquals(expected, actual);

        actual = out.indexOf("пончик");
        Assertions.assertEquals(-1, actual);
    }

    @Test
    public void lastIndexOf() {
        String element = "манго";

        int actualIndex = out.indexOf(element);
        int actualLastIndex = out.lastIndexOf(element);
        Assertions.assertTrue(actualIndex>0);
        Assertions.assertTrue(actualLastIndex>0);
        Assertions.assertNotEquals(actualIndex, actualLastIndex);

        int actual = out.lastIndexOf("пончик");
        Assertions.assertEquals(-1, actual);
    }

    @Test
    public void equals() {
        StringList out1 = new StringListImp(10);
        out1.add("стол");
        out1.add("комод");

        StringList out2 = new StringListImp(10);
        out2.add("стол");

        boolean actual = out1.equals(out2);
        Assertions.assertFalse(actual);

        out2.add("комод");
        actual = out1.equals(out2);
        Assertions.assertTrue(actual);
    }

    @Test
    public void clear() {
        StringList out1 = new StringListImp(10);
        out1.add("стол");
        out1.add("комод");

        Assertions.assertTrue(out1.size()>0);
        out1.clear();
        Assertions.assertTrue(out1.size()==0);
    }

    @Test
    public void isEmpty() {
        StringList out1 = new StringListImp(10);
        Assertions.assertTrue(out1.isEmpty());

        out1.add("стол");
        out1.add("комод");
        Assertions.assertFalse(out1.isEmpty());
    }

    @Test
    public void toArray() {
        StringList out1 = new StringListImp(10);
        out1.add("стол");
        out1.add("комод");

        String[] expected = {"стол", "комод"};
        String[] actual = out1.toArray();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void createStringListException() {
        Assertions.assertThrows(WrongSizeOfArray.class, () -> new StringListImp(0));
    }

    @Test
    public void getException() {
        Assertions.assertThrows(WrongIndex.class, () -> out.get(-5));
    }

    @Test
    public void addSetException() {
        StringList out1 = new StringListImp(2);
        out1.add("стол");
        out1.add("комод");

        String element = null;
        Assertions.assertThrows(InvalidArgument.class, () -> out1.add(element));
        Assertions.assertThrows(WrongIndex.class, () -> out1.add(out1.size()+1, "стул"));
        Assertions.assertThrows(ArrayIsFull.class, () -> out1.add("стул"));

        Assertions.assertThrows(InvalidArgument.class, () -> out1.set(0, element));
        Assertions.assertThrows(WrongIndex.class, () -> out1.set(-1, "стул"));
    }

    @Test
    public void removeException() {
        StringList out1 = new StringListImp(2);
        out1.add("стол");
        out1.add("комод");

        String element = null;
        Assertions.assertThrows(InvalidArgument.class, () -> out1.remove(element));
        Assertions.assertThrows(WrongIndex.class, () -> out1.remove(-1));
        Assertions.assertThrows(ElementNotFound.class, () -> out1.remove("стул"));
    }

    @Test
    public void invalidArgumentException() {
        String element = null;
        StringList stringList = null;
        Assertions.assertThrows(InvalidArgument.class, () -> out.contains(element));
        Assertions.assertThrows(InvalidArgument.class, () -> out.indexOf(element));
        Assertions.assertThrows(InvalidArgument.class, () -> out.lastIndexOf(element));
        Assertions.assertThrows(InvalidArgument.class, () -> out.equals(stringList));
    }

}
