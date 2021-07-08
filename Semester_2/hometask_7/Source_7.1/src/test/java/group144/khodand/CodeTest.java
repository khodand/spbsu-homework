package group144.khodand;

import static org.junit.Assert.*;
import org.junit.Test;

public class CodeTest {
    @Test
    public void testCreationCode() {
        Code code = new Code();
    }

    @Test
    public void testCodeClass() {
        Code code = new Code();
        String actual = code.describeClass(Code.class);
        String expected =
                "public class Code {\n" +
                        "    public Code();\n\n" +

                        "    private void checkBlock(StringBuilder arg0, boolean arg1, int arg2);\n" +
                        "    public String describeClass(Class arg0);\n" +
                        "    private void getClassSignature(StringBuilder arg0, Class arg1);\n" +
                        "    private void getClassSpecification(StringBuilder arg0, Class arg1, String arg2);\n" +
                        "    private void getConstructorSignature(StringBuilder arg0, Class arg1, Constructor arg2);\n" +
                        "    private void getFieldSignature(StringBuilder arg0, Class arg1, Field arg2);\n" +
                        "    private void getMethodSignature(StringBuilder arg0, Class arg1, Method arg2);\n" +
                        "    private void getParameters(StringBuilder arg0, Parameter[] arg1);\n" +
                        "    private boolean isNumber(String arg0);\n" +
                        "}\n";

        assertEquals("Incorrect description of Code()", expected, actual);
    }


    @Test
    public void testExampleSuperClass() {
        Code code = new Code();
        String actual = code.describeClass(ExampleSuperClass.class);
        String expected =
                "public class ExampleSuperClass {\n" +
                        "    public ExampleSuperClass();\n\n" +

                        "    private void privateVoid();\n" +
                        "    protected void protectedVoid();\n" +
                        "    public String publicString();\n" +
                        "}\n";

        assertEquals("Incorrect description of ExampleSuperClass()", expected, actual);
    }

    @Test
    public void testExampleClass() {
        Code code = new Code();
        String actual = code.describeClass(ExampleClass.class);
        String expected =
                "public abstract class ExampleClass extends ExampleSuperClass implements FirstExampleInterface, SecondExampleInterface {\n" +
                        "    private final String FINAL_STRING;\n" +
                        "    protected Float floatField;\n" +
                        "    public String stringField;\n\n" +

                        "    protected ExampleClass();\n" +
                        "    public ExampleClass(Float arg0);\n\n" +

                        "    public char charFunction();\n" +
                        "    protected abstract String toDoSomething(String arg0, int arg1);\n\n" +

                        "    private class Node {\n" +
                        "        public int intField;\n\n" +

                        "        public Node(ExampleClass arg0);\n\n" +

                        "        public void setIntField(int arg0);\n" +
                        "    }\n" +
                        "    private class OtherNode {\n" +
                        "        private final int FINAL_INT;\n" +
                        "        private int firstIntField;\n" +
                        "        private int secondIntField;\n\n" +

                        "        private OtherNode(ExampleClass arg0);\n\n" +

                        "        private class EnclosedClass {\n" +
                        "            private EnclosedClass(OtherNode arg0);\n" +
                        "        }\n" +
                        "    }\n" +
                        "}\n";

        assertEquals("Incorrect description of ExampleClass()", expected, actual);
    }

    @Test
    public void testFirstExampleInterface() {
        Code code = new Code();
        String actual = code.describeClass(FirstExampleInterface.class);
        String expected =
                "public interface FirstExampleInterface {\n" +
                        "    public final int INTERFACE_FINAL_INT;\n\n" +

                        "    public char charFunction();\n" +
                        "}\n";

        assertEquals("Incorrect description of FirstExampleInterface()", expected, actual);
    }

    @Test
    public void testSecondExampleInterface() {
        Code code = new Code();
        String actual = code.describeClass(SecondExampleInterface.class);
        String expected =
                "public interface SecondExampleInterface {\n" +
                        "    public int interfaceIntFunction(float arg0);\n" +
                        "}\n";

        assertEquals("Incorrect description of SecondExampleInterface()", expected, actual);
    }

    @Test
    public void testCodeTest() {
        Code code = new Code();
        String actual = code.describeClass(CodeTest.class);
        String expected =
                "public class CodeTest {\n" +
                        "    public CodeTest();\n\n" +

                        "    public void testCodeClass();\n" +
                        "    public void testCodeTest();\n" +
                        "    public void testCreationCode();\n" +
                        "    public void testExampleClass();\n" +
                        "    public void testExampleSuperClass();\n" +
                        "    public void testFirstExampleInterface();\n" +
                        "    public void testSecondExampleInterface();\n" +
                        "}\n";

        assertEquals("Incorrect description of CodeTest()", expected, actual);
    }
}