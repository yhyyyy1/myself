package org.example.lab2;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class lab2Test {

    private static final String INPUT_FILE = "D:\\Project\\myself\\testClass\\TestClass\\src\\main\\java\\org\\example\\lab2\\testinput.txt";
    private int input;
    private int expectedOutput;

    public lab2Test(int input, int expectedOutput) {
        this.input = input;
        this.expectedOutput = expectedOutput;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> testData() throws Exception {
        List<Object[]> data = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(INPUT_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int input = Integer.parseInt(parts[0]);
                int output = Integer.parseInt(parts[1]);
                data.add(new Object[]{input, output});
            }
        }
        return data;
    }

    @BeforeClass
    public static void setUpClass() {
        System.out.println("BeforeClass: Initializing test cases.");
    }

    @Before
    public void setUp() {
        System.out.println("Before: Preparing test case for input: " + input);
    }

    @Test
    public void testMaxProduct() {
        System.out.println("Test: Testing with input: " + input);
        assertEquals(expectedOutput, Main.maxProduct(input));
    }

    @After
    public void tearDown() {
        System.out.println("After: Test completed for input: " + input);
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("AfterClass: All tests completed.");
    }
}
