package group144.khodko;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

/**
 * Trie - data structure class
 */
public class Trie implements Serialize{
    /**
     * Vertex - vertex from trie
     * children - another vertex for every letter
     */
    public class Vertex {
        private final Vertex[] children = new Vertex[26];
        private boolean isTerminal = false;
        private int size = 0;

        /**
         * method to add string to vertex and children
         * @param element - input string or rest of string to add by char
         * @return true if there was no such string
         */
        private boolean add(String element) {
            if (element.isEmpty()) {
                if (!isTerminal) {
                    isTerminal = true;
                    size++;
                    return true;
                }
                return false;
            }

            char symbol = element.charAt(0);
            String next = element.substring(1);
            Vertex child = children[symbol - 'a'];
            if (child == null) {
                children[symbol - 'a'] = new Vertex();
                child = children[symbol - 'a'];
            }

            boolean newElementAdded = child.add(next);
            size += newElementAdded ? 1 : 0;

            return newElementAdded;
        }

        /**
         * method for removing string from children of this vertex
         * @param element - string to remove
         * @return if string was in tree
         */
        private boolean remove(String element) {
            if (element.isEmpty()) {
                if (isTerminal) {
                    isTerminal = false;
                    size--;

                    return true;
                }
                return false;
            }

            char symbol = element.charAt(0);
            String next = element.substring(1);
            Vertex child = children[symbol - 'a'];

            if (child == null)
                return false;

            boolean isRemoved = child.remove(next);
            size -= isRemoved ? 1 : 0;
            return isRemoved;
        }

        /**
         * methof for checking is string in vertex
         * @param element string to find
         * @return true if contains
         */
        private boolean contains(String element) {
            if (element.isEmpty()) {
                return isTerminal;
            }
            char symbol = element.charAt(0);
            Vertex child = children[symbol - 'a'];

            return child != null && child.contains(element.substring(1));
        }

        /**
         * Method for counting how many vertex goes after such prefix
         * @param element prefix
         * @return  how Many Start With Prefix
         */
        private int howManyStartWithPrefix(String element) {
            if (element.isEmpty())
                return size;

            char symbol = element.charAt(0);
            Vertex child = children[symbol - 'a'];
            if (child == null)
                return 0;

            return child.howManyStartWithPrefix(element.substring(1));
        }

        private void serialize(OutputStream out) throws IOException {
            out.write(size);
            out.write(isTerminal ? 1 : 0);
            for (Vertex child : children) {
                out.write(child != null ? 1 : 0);
                if (child != null) {
                    child.serialize(out);
                }
            }
        }

        private void deserialize(InputStream in) throws IOException {
            size = in.read();
            isTerminal = in.read() == 1;
            for (int i = 0; i < children.length; i++) {
                boolean exist = in.read() == 1;
                Vertex child = null;
                if (exist) {
                    child = new Vertex();
                    child.deserialize(in);
                }
                children[i] = child;
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass())
                return false;

            Vertex another = (Vertex) o;
            return isTerminal == another.isTerminal &&
                    size == another.size &&
                    Arrays.equals(children, another.children);
        }
    }

    // top vertex of tree
    public Vertex root = new Vertex();

    // method to adding element to trie
    public boolean add(String element){
        return root.add(element);
    }

    // get size of trie
    public int size(){
        return root.size;
    }

    // removes element from trie
    public boolean remove(String element){
        return root.remove(element);
    }

    // check is such element in trie
    public boolean contains(String element){
        return  root.contains(element);
    }


    public int howManyStartWithPrefix(String element){
        return root.howManyStartWithPrefix(element);
    }

    @Override
    public void serialize(OutputStream out) throws IOException {
        root.serialize(out);
    }

    @Override
    public void deserialize(InputStream in) throws IOException {
        root.deserialize(in);
    }

}