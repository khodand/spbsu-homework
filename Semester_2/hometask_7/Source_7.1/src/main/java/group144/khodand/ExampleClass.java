package group144.khodand;

public abstract class ExampleClass extends ExampleSuperClass implements FirstExampleInterface, SecondExampleInterface {
    public String stringField;
    protected Float floatField;
    private final String FINAL_STRING = "";

    public ExampleClass(Float f) {
    }

    protected ExampleClass() {
    }

    public char charFunction() {
        return 0;
    }

    protected abstract String toDoSomething(String str, int i);

    private class Node {
        public int intField;

        public Node() {
        }

        public void setIntField(int i) {
        }
    }

    private class OtherNode {
        private int firstIntField;
        private int secondIntField;
        private final int FINAL_INT = 0;

        private class EnclosedClass{
        }
    }
}