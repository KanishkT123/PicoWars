package edu.hmc.cs.cs60;

import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Arrays;


public class ListTest {
    
    /*
     * Test the List constructor by creating a new List and checking for
     * consistency using toString(), isEmpty(), and size()
     */
    @Test
    public void test_Constructor() {
        // if this test fails try:
        // -- clicking on the test to see how your output wasn't correct
        // -- adding print statements to the broken method
        // -- putting a break-point in the broken method & using the debugger
        // -- running debugging code in the main method of List.java
        // -- adding print statements below and running this test by itself,
        // which you can do by highlighting the test name and then clicking run.
        List list1 = new List();
        assertEquals("( )", list1.toString());
        assertTrue(list1.isEmpty());
        assertEquals(list1.length(), 0);
        assertEquals(list1.length(), 0);
    }

    /*
     * Test addToFront by adding one element and checking for consistency using
     * toString(), isEmpty(), and size()
     */
    @Test
    public void test_AddToFront_callOnce() {
        // if this test fails try:
        // -- clicking on the test to see how your output wasn't correct
        // -- adding print statements to the broken method
        // -- putting a break-point in the broken method & using the debugger
        // -- running debugging code in the main method of List.java
        // -- adding print statements below and running this test by itself,
        // which you can do by highlighting the test name and then clicking run.
        List list1 = new List();
        list1.addToFront("b");
        assertEquals("( b )", list1.toString());
        assertFalse(list1.isEmpty());
        assertEquals(list1.length(), 1);
    }

    /*
     * Test addToFront by adding two elements and checking for consistency using
     * toString(), isEmpty(), and size()
     */
    @Test
    public void test_AddToFront_callTwice() {
        // if this test fails try:
        // -- clicking on the test to see how your output wasn't correct
        // -- adding print statements to the broken method
        // -- putting a break-point in the broken method & using the debugger
        // -- running debugging code in the main method of List.java
        // -- adding print statements below and running this test by itself,
        // which you can do by highlighting the test name and then clicking run.
        List list1 = new List();
        list1.addToFront("b");
        list1.addToFront("a");
        assertEquals("( a b )", list1.toString());
        assertFalse(list1.isEmpty());
        assertEquals(list1.length(), 2);
    }

    /*
     * Tests for Equals method. You can assume that equals works as intended
     */
    @Test
    public void test_Equals() {
        // if this test fails try:
        // -- clicking on the test to see how your output wasn't correct
        // -- adding print statements to the broken method
        // -- putting a break-point in the broken method & using the debugger
        // -- running debugging code in the main method of List.java
        // -- adding print statements below and running this test by itself,
        // which you can do by highlighting the test name and then clicking run.
        List list1 = new List();
        List list2 = new List();
        List list3 = new List();
        assertEquals(list1, list2);
        list1.addToFront("a");
        assertFalse(list1.equals(list2)); // arg empty, this not
        list2.addToFront("a");
        assertEquals(list1, list2);
        assertFalse(list3.equals(list1)); // this empty, arg not
        list2.addToFront("b");
        assertFalse(list1.equals(list2)); // this shorter than arg
        list1.addToFront("b");
        assertEquals(list1, list2);
        list1.addToFront("c");
        assertFalse(list1.equals(list2)); // this longer than arg
        list3.addToFront("a");
        list3.addToFront("a");
        assertFalse(list2.equals(list3)); // same length, different elements
    }

    /**********************************************************
     * Testing add(String s)
     **********************************************************/
    /*
     * Test add(String s), which adds to the end of a List. Adding a single
     * element to an empty List and checking for consistency using toString(),
     * isEmpty(), and size()
     */
    @Test
    public void test_Add_toEmptyList() {
        // if this test fails try:
        // -- clicking on the test to see how your output wasn't correct
        // -- adding print statements to the broken method
        // -- putting a break-point in the broken method & using the debugger
        // -- running debugging code in the main method of List.java
        // -- adding print statements below and running this test by itself,
        // which you can do by highlighting the test name and then clicking run.
        List list1 = new List();
        list1.add("z");
        assertEquals("( z )", list1.toString());
        assertFalse(list1.isEmpty());
        assertEquals(list1.length(), 1);
    }

    /*
     * Test add(String s), which adds to the end of a List. Adding a single
     * element to the end of a List with 3 elements and checking for consistency
     * using toString(), isEmpty(), and size()
     */
    @Test
    public void test_Add_to3elementList() {
        // if this test fails try:
        // -- clicking on the test to see how your output wasn't correct
        // -- adding print statements to the broken method
        // -- putting a break-point in the broken method & using the debugger
        // -- running debugging code in the main method of List.java
        // -- adding print statements below and running this test by itself,
        // which you can do by highlighting the test name and then clicking run.
        List list1 = new List();
        list1.addToFront("c");
        list1.addToFront("b");
        list1.addToFront("a");
        list1.add("d");
        assertEquals("( a b c d )", list1.toString());
        assertFalse(list1.isEmpty());
        assertEquals(list1.length(), 4);
    }

    /*
     * Test add(String s), which adds to the end of a List. Ensure that a List
     * created with addToFront can be equal to a List created with add
     */
    @Test
    public void test_Add_4elements() {
        // if this test fails try:
        // -- clicking on the test to see how your output wasn't correct
        // -- adding print statements to the broken method
        // -- putting a break-point in the broken method & using the debugger
        // -- running debugging code in the main method of List.java
        // -- adding print statements below and running this test by itself,
        // which you can do by highlighting the test name and then clicking run.
        List list1 = new List();
        list1.addToFront("d");
        list1.addToFront("c");
        list1.addToFront("b");
        list1.addToFront("a");

        List list2 = new List();
        list2.add("a");
        list2.add("b");
        list2.add("c");
        list2.add("d");
        assertTrue(list1.length() == list2.length());
        assertEquals(list1, list2);
    }
    /**********************************************************
     * Testing add()
     **********************************************************/
    /*
     * Test add(String s), which adds to the end of a List. Adding a single
     * element to an empty List and checking for consistency using toString(),
     * isEmpty(), and size()
     */
    @Test
    public void test_AddNode_toEmptyList() {
        // if this test fails try:
        // -- clicking on the test to see how your output wasn't correct
        // -- adding print statements to the broken method
        // -- putting a break-point in the broken method & using the debugger
        // -- running debugging code in the main method of List.java
        // -- adding print statements below and running this test by itself,
        // which you can do by highlighting the test name and then clicking run.
        List list1 = new List();
        list1.add("z");
        assertEquals("( z )", list1.toString());
        assertFalse(list1.isEmpty());
        assertEquals(list1.length(), 1);
    }

    /*
     * Test add(String s), which adds to the end of a List. Adding a single
     * element to the end of a List with 3 elements and checking for consistency
     * using toString(), isEmpty(), and size()
     */
    @Test
    public void test_AddNode_to3elementList() {
        // if this test fails try:
        // -- clicking on the test to see how your output wasn't correct
        // -- adding print statements to the broken method
        // -- putting a break-point in the broken method & using the debugger
        // -- running debugging code in the main method of List.java
        // -- adding print statements below and running this test by itself,
        // which you can do by highlighting the test name and then clicking run.
        List list1 = new List();
        list1.addToFront("c");
        list1.addToFront("b");
        list1.addToFront("a");
        list1.add("d");
        assertEquals("( a b c d )", list1.toString());
        assertFalse(list1.isEmpty());
        assertEquals(list1.length(), 4);
    }

    /*
     * Test add(String s), which adds to the end of a List. Ensure that a List
     * created with addToFront can be equal to a List created with add
     */
    @Test
    public void test_AddNode_4elements() {
        // if this test fails try:
        // -- clicking on the test to see how your output wasn't correct
        // -- adding print statements to the broken method
        // -- putting a break-point in the broken method & using the debugger
        // -- running debugging code in the main method of List.java
        // -- adding print statements below and running this test by itself,
        // which you can do by highlighting the test name and then clicking run.
        List list1 = new List();
        list1.addToFront("d");
        list1.addToFront("c");
        list1.addToFront("b");
        list1.addToFront("a");

        List list2 = new List();
        list2.add("a");
        list2.add("b");
        list2.add("c");
        list2.add("d");
        assertEquals(list1.length(), list2.length());
        assertEquals(list1, list2);
    }

    /**********************
     * Tests for reverse
     **********************/
    @Test
    public void test_Reverse_0elements() {
        // if this test fails try:
        // -- clicking on the test to see how your output wasn't correct
        // -- adding print statements to the broken method
        // -- putting a break-point in the broken method & using the debugger
        // -- running debugging code in the main method of List.java
        // -- adding print statements below and running this test by itself,
        // which you can do by highlighting the test name and then clicking run.
        List list1 = new List();

        List list2 = new List();

        list1.reverse();
        assertEquals(list1.length(), list2.length());
        assertEquals(list2, list1);
    }

    @Test
    public void test_Reverse_1element() {
        // if this test fails try:
        // -- clicking on the test to see how your output wasn't correct
        // -- adding print statements to the broken method
        // -- putting a break-point in the broken method & using the debugger
        // -- running debugging code in the main method of List.java
        // -- adding print statements below and running this test by itself,
        // which you can do by highlighting the test name and then clicking run.
        List list1 = new List();
        list1.addToFront("a");

        List list2 = new List();
        list2.addToFront("a");

        list1.reverse();
        assertEquals(list1.length(), list2.length());
        assertEquals(list2, list1);
    }

    @Test
    public void test_Reverse_4elements() {
        // if this test fails try:
        // -- clicking on the test to see how your output wasn't correct
        // -- adding print statements to the broken method
        // -- putting a break-point in the broken method & using the debugger
        // -- running debugging code in the main method of List.java
        // -- adding print statements below and running this test by itself,
        // which you can do by highlighting the test name and then clicking run.
        List list1 = new List();
        list1.addToFront("d");
        list1.addToFront("c");
        list1.addToFront("b");
        list1.addToFront("a");

        List list2 = new List();
        list2.addToFront("a");
        list2.addToFront("b");
        list2.addToFront("c");
        list2.addToFront("d");

        list1.reverse();
        assertEquals(list1.length(), list2.length());
        assertEquals(list2, list1);
    }

    /************************
     * Test makeFromArray
     ************************/
    @Test
    public void test_MakeFromArray_1element() {
        // if this test fails try:
        // -- clicking on the test to see how your output wasn't correct
        // -- adding print statements to the broken method
        // -- putting a break-point in the broken method & using the debugger
        // -- running debugging code in the main method of List.java
        // -- adding print statements below and running this test by itself,
        // which you can do by highlighting the test name and then clicking run.
        String[] input = { "a" };
        List list1 = List.makeFromArray(input);

        List list2 = new List();
        list2.addToFront("a");
        assertEquals(list1.length(),list2.length());
        assertEquals(list2, list1);
    }

    @Test
    public void test_MakeFromArray_2element() {
        // if this test fails try:
        // -- clicking on the test to see how your output wasn't correct
        // -- adding print statements to the broken method
        // -- putting a break-point in the broken method & using the debugger
        // -- running debugging code in the main method of List.java
        // -- adding print statements below and running this test by itself,
        // which you can do by highlighting the test name and then clicking run.
        String[] input = { "a", "b" };
        List list1 = List.makeFromArray(input);

        List list2 = new List();
        list2.addToFront("b");
        list2.addToFront("a");
        assertEquals(list1.length(), list2.length());
        assertEquals(list2, list1);
    }

    @Test
    public void test_MakeFromArray_5element() {
        // if this test fails try:
        // -- clicking on the test to see how your output wasn't correct
        // -- adding print statements to the broken method
        // -- putting a break-point in the broken method & using the debugger
        // -- running debugging code in the main method of List.java
        // -- adding print statements below and running this test by itself,
        // which you can do by highlighting the test name and then clicking run.
        String[] input = { "a", "b", "c", "d", "e" };
        List list1 = List.makeFromArray(input);

        List list2 = new List();
        list2.addToFront("e");
        list2.addToFront("d");
        list2.addToFront("c");
        list2.addToFront("b");
        list2.addToFront("a");
        assertEquals(list2, list1);
    }

    /**************************
     * makeEquivalentArray
     **************************/
    @Test
    public void test_MakeEquivalentArray_1() {
        // if this test fails try:
        // -- clicking on the test to see how your output wasn't correct
        // -- adding print statements to the broken method
        // -- putting a break-point in the broken method & using the debugger
        // -- running debugging code in the main method of List.java
        // -- adding print statements below and running this test by itself,
        // which you can do by highlighting the test name and then clicking run.
        List list1 = new List();
        list1.addToFront("a");
        String[] output = list1.makeEquivalentArray();
        String[] correct = { "a" };
        assertEquals(Arrays.toString(correct), Arrays.toString(output));
    }

    @Test
    public void test_MakeEquivalentArray_2() {
        // if this test fails try:
        // -- clicking on the test to see how your output wasn't correct
        // -- adding print statements to the broken method
        // -- putting a break-point in the broken method & using the debugger
        // -- running debugging code in the main method of List.java
        // -- adding print statements below and running this test by itself,
        // which you can do by highlighting the test name and then clicking run.
        List list1 = new List();
        list1.addToFront("b");
        list1.addToFront("a");
        String[] output = list1.makeEquivalentArray();
        String[] correct = { "a", "b" };
        assertEquals(Arrays.toString(correct), Arrays.toString(output));
    }

    @Test
    public void test_MakeEquivalentArray_5() {
        // if this test fails try:
        // -- clicking on the test to see how your output wasn't correct
        // -- adding print statements to the broken method
        // -- putting a break-point in the broken method & using the debugger
        // -- running debugging code in the main method of List.java
        // -- adding print statements below and running this test by itself,
        // which you can do by highlighting the test name and then clicking run.
        List list1 = new List();
        list1.addToFront("e");
        list1.addToFront("d");
        list1.addToFront("c");
        list1.addToFront("b");
        list1.addToFront("a");
        String[] output = list1.makeEquivalentArray();
        String[] correct = { "a", "b", "c", "d", "e" };
        assertEquals(Arrays.toString(correct), Arrays.toString(output));
    }

    /********************
     * appendInPlace
     ********************/
    @Test
    public void test_AppendInPlace_1_0() {
        // if this test fails try:
        // -- clicking on the test to see how your output wasn't correct
        // -- adding print statements to the broken method
        // -- putting a break-point in the broken method & using the debugger
        // -- running debugging code in the main method of List.java
        // -- adding print statements below and running this test by itself,
        // which you can do by highlighting the test name and then clicking run.
        List list1 = new List();
        list1.addToFront("a");
        List list2 = new List();

        List list2copy = new List();

        list1.appendInPlace(list2);

        List correct = new List();
        correct.addToFront("a");
        
        assertEquals(correct.length(),list1.length());
        assertEquals(correct, list1); // correct output
        assertEquals(list2copy.length(), list2.length());
        assertEquals(list2copy, list2); // list2 not modified
    }

    @Test
    public void test_AppendInPlace_0_1() {
        // if this test fails try:
        // -- clicking on the test to see how your output wasn't correct
        // -- adding print statements to the broken method
        // -- putting a break-point in the broken method & using the debugger
        // -- running debugging code in the main method of List.java
        // -- adding print statements below and running this test by itself,
        // which you can do by highlighting the test name and then clicking run.
        List list1 = new List();
        List list2 = new List();
        list2.addToFront("a");

        List list2copy = new List();
        list2copy.addToFront("a");

        list1.appendInPlace(list2);

        List correct = new List();
        correct.addToFront("a");
        assertEquals(correct.length(), list1.length());
        assertEquals(correct, list1); // correct output
        assertEquals(list2copy.length(), list2.length());
        assertEquals(list2copy, list2); // list2 not modified
    }

    @Test
    public void test_AppendInPlace_1_1() {
        // if this test fails try:
        // -- clicking on the test to see how your output wasn't correct
        // -- adding print statements to the broken method
        // -- putting a break-point in the broken method & using the debugger
        // -- running debugging code in the main method of List.java
        // -- adding print statements below and running this test by itself,
        // which you can do by highlighting the test name and then clicking run.
        List list1 = new List();
        list1.addToFront("a");
        List list2 = new List();
        list2.addToFront("b");

        List list2copy = new List();
        list2copy.addToFront("b");

        list1.appendInPlace(list2);

        List correct = new List();
        correct.addToFront("b");
        correct.addToFront("a");
        assertEquals(correct.length(), list1.length());
        assertEquals(correct, list1); // correct output
        assertEquals(list2copy.length(), list2.length());
        assertEquals(list2copy, list2); // list2 not modified
    }

    @Test
    public void test_AppendInPlace_3_3() {
        // if this test fails try:
        // -- clicking on the test to see how your output wasn't correct
        // -- adding print statements to the broken method
        // -- putting a break-point in the broken method & using the debugger
        // -- running debugging code in the main method of List.java
        // -- adding print statements below and running this test by itself,
        // which you can do by highlighting the test name and then clicking run.
        List list1 = new List();
        list1.addToFront("c");
        list1.addToFront("b");
        list1.addToFront("a");
        List list2 = new List();
        list2.addToFront("f");
        list2.addToFront("e");
        list2.addToFront("d");

        List list2copy = new List();
        list2copy.addToFront("f");
        list2copy.addToFront("e");
        list2copy.addToFront("d");

        list1.appendInPlace(list2);

        List correct = new List();
        correct.addToFront("f");
        correct.addToFront("e");
        correct.addToFront("d");
        correct.addToFront("c");
        correct.addToFront("b");
        correct.addToFront("a");
        assertEquals(correct.length(), list1.length());
        assertEquals(correct, list1); // correct output
        assertEquals(list2copy.length(), list2.length());
        assertEquals(list2copy, list2); // list2 not modified
    }

    /**************
     * split
     **************/
    @Test
    public void test_Split_1() {
        // if this test fails try:
        // -- clicking on the test to see how your output wasn't correct
        // -- adding print statements to the broken method
        // -- putting a break-point in the broken method & using the debugger
        // -- running debugging code in the main method of List.java
        // -- adding print statements below and running this test by itself,
        // which you can do by highlighting the test name and then clicking run.
        List list1 = new List();
        list1.addToFront("a");

        List correctOutput = new List();
 
        List correct = new List();
        correct.addToFront("a");

        List output = list1.split();
        
        assertEquals(correct.length(), list1.length());
        assertEquals(correct, list1); // correct output
        assertEquals(correctOutput.length(), output.length());
        assertEquals(correctOutput, output); // list2 not modified
    }

    @Test
    public void test_Split_5() {
        // if this test fails try:
        // -- clicking on the test to see how your output wasn't correct
        // -- adding print statements to the broken method
        // -- putting a break-point in the broken method & using the debugger
        // -- running debugging code in the main method of List.java
        // -- adding print statements below and running this test by itself,
        // which you can do by highlighting the test name and then clicking run.
        List list1 = new List();
        list1.addToFront("e");
        list1.addToFront("d");
        list1.addToFront("c");
        list1.addToFront("b");
        list1.addToFront("a");

        List correctOutput = new List();
        correctOutput.addToFront("e");
        correctOutput.addToFront("d");

        List correct = new List();
        correct.addToFront("c");
        correct.addToFront("b");
        correct.addToFront("a");
        List output = list1.split();
        assertEquals(correct.length(), list1.length());
        assertEquals(correct, list1); // correct output
        assertEquals(correctOutput.length(), output.length());
        assertEquals(correctOutput, output); // list2 not modified
    }

    @Test
    public void test_Split_6() {
        // if this test fails try:
        // -- clicking on the test to see how your output wasn't correct
        // -- adding print statements to the broken method
        // -- putting a break-point in the broken method & using the debugger
        // -- running debugging code in the main method of List.java
        // -- adding print statements below and running this test by itself,
        // which you can do by highlighting the test name and then clicking run.
        List list1 = new List();
        list1.addToFront("f");
        list1.addToFront("e");
        list1.addToFront("d");
        list1.addToFront("c");
        list1.addToFront("b");
        list1.addToFront("a");

        List correctOutput = new List();
        correctOutput.addToFront("f");
        correctOutput.addToFront("e");
        correctOutput.addToFront("d");

        List correct = new List();
        correct.addToFront("c");
        correct.addToFront("b");
        correct.addToFront("a");

        List output = list1.split();
        assertEquals(correct.length(), list1.length());
        assertEquals(correct, list1); // correct output
        assertEquals(correctOutput.length(), output.length());
        assertEquals(correctOutput, output); // list2 not modified
    }

    /********************
     * removeFirst
     ********************/
    
    @Test
    public void test_RemoveFirst_1(){
        // if this test fails try:
        // -- clicking on the test to see how your output wasn't correct
        // -- adding print statements to the broken method
        // -- putting a break-point in the broken method & using the debugger
        // -- running debugging code in the main method of List.java
        // -- adding print statements below and running this test by itself,
        // which you can do by highlighting the test name and then clicking run.
        List list1 = new List();
        list1.addToFront("a");

        List correct = new List();

        String removed = list1.removeFirst();
        assertTrue(removed.equals("a"));
        assertEquals(correct.length(), list1.length());
        assertEquals(correct, list1); // correct output
    }
    
    
    @Test
    public void test_RemoveFirst_2(){
        // if this test fails try:
        // -- clicking on the test to see how your output wasn't correct
        // -- adding print statements to the broken method
        // -- putting a break-point in the broken method & using the debugger
        // -- running debugging code in the main method of List.java
        // -- adding print statements below and running this test by itself,
        // which you can do by highlighting the test name and then clicking run.
        List list1 = new List();
        list1.addToFront("b");
        list1.addToFront("a");

        List correct = new List();
        correct.addToFront("b");

        String removed = list1.removeFirst();

        assertTrue(removed.equals("a"));
        assertEquals(correct.length(), list1.length());
        assertEquals(correct, list1); // correct output
    }
    
    @Test
    public void test_RemoveFirst_4(){
        // if this test fails try:
        // -- clicking on the test to see how your output wasn't correct
        // -- adding print statements to the broken method
        // -- putting a break-point in the broken method & using the debugger
        // -- running debugging code in the main method of List.java
        // -- adding print statements below and running this test by itself,
        // which you can do by highlighting the test name and then clicking run.
        List list1 = new List();
        list1.addToFront("d");
        list1.addToFront("c");
        list1.addToFront("b");
        list1.addToFront("a");

        List correct = new List();
        correct.addToFront("d");
        correct.addToFront("c");
        correct.addToFront("b");

        String removed = list1.removeFirst();

        assertTrue(removed.equals("a"));
        assertEquals(correct.length(), list1.length());
        assertEquals(correct, list1); // correct output
    }
    
    
    /******************
     * merge
     ******************/
    @Test
    public void test_Merge_list1_firstAndLast() {
        // if this test fails try:
        // -- clicking on the test to see how your output wasn't correct
        // -- adding print statements to the broken method
        // -- putting a break-point in the broken method & using the debugger
        // -- running debugging code in the main method of List.java
        // -- adding print statements below and running this test by itself,
        // which you can do by highlighting the test name and then clicking run.
        String[] input1 = { "a", "d" };
        String[] input2 = { "b", "c" };
        String[] correct = { "a", "b", "c", "d" };
        List list1 = List.makeFromArray(input1);
        List list2 = List.makeFromArray(input2);
        List list3Correct = List.makeFromArray(correct);
        list1.merge(list2);
        assertEquals(list3Correct.length(), list1.length());
        assertEquals(list3Correct, list1);
        assertEquals(list2.length(), 0);
        assertEquals(new List(), list2);
    }

    @Test
    public void test_Merge_list2_firstAndLast() {
        // if this test fails try:
        // -- clicking on the test to see how your output wasn't correct
        // -- adding print statements to the broken method
        // -- putting a break-point in the broken method & using the debugger
        // -- running debugging code in the main method of List.java
        // -- adding print statements below and running this test by itself,
        // which you can do by highlighting the test name and then clicking run.
        String[] input1 = { "b", "c" };
        String[] input2 = { "a", "d" };
        String[] correct = { "a", "b", "c", "d" };
        List list1 = List.makeFromArray(input1);
        List list2 = List.makeFromArray(input2);
        List list3Correct = List.makeFromArray(correct);
        list1.merge(list2);
        assertEquals(list3Correct.length(), list1.length());
        assertEquals(list3Correct, list1);
        assertEquals(0, list2.length());
        assertEquals(new List(), list2);
    }

    @Test
    public void test_Merge_interleave() {
        // if this test fails try:
        // -- clicking on the test to see how your output wasn't correct
        // -- adding print statements to the broken method
        // -- putting a break-point in the broken method & using the debugger
        // -- running debugging code in the main method of List.java
        // -- adding print statements below and running this test by itself,
        // which you can do by highlighting the test name and then clicking run.
        String[] input1 = { "a", "b", "c"};
        String[] input2 = { "d", "e" };
        String[] correct = { "a", "b", "c","d","e"};
        List list1 = List.makeFromArray(input1);
        List list2 = List.makeFromArray(input2);
        List list3Correct = List.makeFromArray(correct);

        list1.merge(list2);
        System.out.println(list1);
        assertEquals(list3Correct.length(), list1.length());
        assertEquals(list3Correct, list1);
        assertEquals(list2.length(), 0);
        assertEquals(new List(), list2);
    }

    /********************
     * mergeSort
     ********************/
    @Test
    public void test_MergeSort_1(){
        // if this test fails try:
        // -- clicking on the test to see how your output wasn't correct
        // -- adding print statements to the broken method
        // -- putting a break-point in the broken method & using the debugger
        // -- running debugging code in the main method of List.java
        // -- adding print statements below and running this test by itself,
        // which you can do by highlighting the test name and then clicking run.
        List list1 = new List();
        list1.addToFront("a");

        List correct = new List();
        correct.addToFront("a");

        list1.mergeSort();

        assertEquals(correct.length(), list1.length());
        assertEquals(correct, list1);
    }

    @Test
    public void test_MergeSort_2ab(){
        // if this test fails try:
        // -- clicking on the test to see how your output wasn't correct
        // -- adding print statements to the broken method
        // -- putting a break-point in the broken method & using the debugger
        // -- running debugging code in the main method of List.java
        // -- adding print statements below and running this test by itself,
        // which you can do by highlighting the test name and then clicking run.
        List list1 = new List();
        list1.addToFront("b");
        list1.addToFront("a");

        List correct = new List();
        correct.addToFront("b");
        correct.addToFront("a");

        list1.mergeSort();

        assertEquals(correct.length(), list1.length());
        assertEquals(correct, list1);
    }
    
    @Test
    public void tes_tMergeSort_2ba(){
        // if this test fails try:
        // -- clicking on the test to see how your output wasn't correct
        // -- adding print statements to the broken method
        // -- putting a break-point in the broken method & using the debugger
        // -- running debugging code in the main method of List.java
        // -- adding print statements below and running this test by itself,
        // which you can do by highlighting the test name and then clicking run.
        List list1 = new List();
        list1.addToFront("a");
        list1.addToFront("b");

        List correct = new List();
        correct.addToFront("b");
        correct.addToFront("a");

        list1.mergeSort();

        assertEquals(correct.length(), list1.length());
        assertEquals(correct, list1);
    }

    @Test
    public void test_MergeSort_5abcde(){
        // if this test fails try:
        // -- clicking on the test to see how your output wasn't correct
        // -- adding print statements to the broken method
        // -- putting a break-point in the broken method & using the debugger
        // -- running debugging code in the main method of List.java
        // -- adding print statements below and running this test by itself,
        // which you can do by highlighting the test name and then clicking run.
        List list1 = new List();
        list1.addToFront("e");
        list1.addToFront("d");
        list1.addToFront("c");
        list1.addToFront("b");
        list1.addToFront("a");

        List correct = new List();
        correct.addToFront("e");
        correct.addToFront("d");
        correct.addToFront("c");
        correct.addToFront("b");
        correct.addToFront("a");

        list1.mergeSort();

        assertEquals(correct.length(), list1.length());
        assertEquals(correct, list1);
    }

    @Test
    public void tes_tMergeSort_5eadbc(){
        // if this test fails try:
        // -- clicking on the test to see how your output wasn't correct
        // -- adding print statements to the broken method
        // -- putting a break-point in the broken method & using the debugger
        // -- running debugging code in the main method of List.java
        // -- adding print statements below and running this test by itself,
        // which you can do by highlighting the test name and then clicking run.
        List list1 = new List();
        list1.addToFront("c");
        list1.addToFront("b");
        list1.addToFront("d");
        list1.addToFront("a");
        list1.addToFront("e");

        List correct = new List();
        correct.addToFront("e");
        correct.addToFront("d");
        correct.addToFront("c");
        correct.addToFront("b");
        correct.addToFront("a");

        list1.mergeSort();
        assertEquals(correct.length(), list1.length());
        assertEquals(correct, list1);
    }

}