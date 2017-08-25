package com.anglll.pink;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void test() throws Exception {
        String temp = "{\n" +
                "  \"zhinengjiaoba_liliang_0\" : {\n" +
                "    \"0\" : [\n" +
                "      [\n" +
                "        \"137\",\n" +
                "        \"178\",\n" +
                "        \"181\"\n" +
                "      ],\n" +
                "      [\n" +
                "        \"3.209\",\n" +
                "        \"3.950\",\n" +
                "        \"6.514\"\n" +
                "      ]\n" +
                "    ]\n" +
                "  }\n" +
                "}\n";
        String t = temp.replaceAll("\\n", "")
                .replaceAll("\\r", "")
                .replaceAll(" ", "");
        System.out.print(t);
    }
}