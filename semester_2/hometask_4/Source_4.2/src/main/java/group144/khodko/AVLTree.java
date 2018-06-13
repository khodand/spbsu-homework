package group144.khodko;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * AVL tree custom implementation using {@link Collection} interface
 *
 * @param <T> the type of objects that can be stored in AVL tree
 * @author a1rick
 */
public class AVLTree<T extends Comparable<T>> implements Collection<T> {

    private Node<T> root;

    private int size = 0;

    private static String printNode(Node node) {
        return node == null ? "" : String.format("(%s left:%s right:%s)", node.key.toString(), printNode(node.left), printNode(node.right));
    }

    private static <K extends Comparable<K>> int height(Node<K> node) {
        return node != null ? node.height : 0;
    }

    private static <K extends Comparable<K>> int balanceFactor(Node<K> node) {
        return height(node.right) - height(node.left);
    }

    private static <K extends Comparable<K>> void fixHeight(Node<K> node) {
        node.height = Math.max(height(node.left), height(node.right)) + 1;
    }

    private static <K extends Comparable<K>> Node<K> rotateRight(Node<K> node) {
        Node<K> left = node.left;
        node.left = left.right;
        left.right = node;
        fixHeight(node);
        fixHeight(left);
        return left;
    }

    private static <K extends Comparable<K>> Node<K> inOrderSuccessor(Node<K> node, Node<K> root) {
        if (node.right != null) return findMin(node.right);
        Node<K> successor = null;
        while (root != null) {
            int compare = node.key.compareTo(root.key);
            if (compare < 0) {
                successor = root;
                root = root.left;
            } else if (compare > 0) root = root.right;
            else break;
        }
        return successor;
    }

    private static <K extends Comparable<K>> Node<K> rotateLeft(Node<K> node) {
        Node<K> right = node.right;
        node.right = right.left;
        right.left = node;
        fixHeight(node);
        fixHeight(right);
        return right;
    }

    private static <K extends Comparable<K>> Node<K> balance(Node<K> node) {
        fixHeight(node);
        int balanceFactor = balanceFactor(node);
        if (balanceFactor == 2) {
            if (balanceFactor(node.right) < 0) {
                node.right = rotateRight(node.right);
            }
            return rotateLeft(node);
        } else if (balanceFactor == -2) {
            if (balanceFactor(node.left) > 0) {
                node.left = rotateLeft(node.left);
            }
            return rotateRight(node);
        }
        return node;
    }

    private static <K extends Comparable<K>> Node<K> insert(Node<K> node, K key) {
        if (node == null)
            return new Node<>(key);
        else if (key.compareTo(node.key) < 0) {
            node.left = insert(node.left, key);
        } else {
            node.right = insert(node.right, key);
        }
        return balance(node);
    }

    private static <K extends Comparable<K>> Node<K> findMin(Node<K> node) {
        return node.left == null ? node : findMin(node.left);
    }

    private static <K extends Comparable<K>> Node<K> removeMin(Node<K> node) {
        if (node.left == null)
            return node.right;
        node.left = removeMin(node.left);
        return balance(node);
    }

    private static <K extends Comparable<K>> Node<K> remove(Node<K> node, Comparable<K> key) {
        if (node == null) return null;
        else {
            int compare = key.compareTo(node.key);
            if (compare < 0) {
                node.left = remove(node.left, key);
            } else if (compare > 0) {
                node.right = remove(node.right, key);
            } else {
                Node<K> left = node.left;
                Node<K> right = node.right;
                if (right == null)
                    return left;
                Node<K> min = findMin(right);
                min.right = removeMin(right);
                min.left = left;
                return balance(min);
            }
        }
        return balance(node);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean contains(Object o) {
        if (o == null || !(o instanceof Comparable)) return false;
        Comparable<T> comparable = (Comparable<T>) o;
        Node<T> temp = root;
        while (temp != null) {
            int compare = comparable.compareTo(temp.key);
            if (compare == 0) return true;
            temp = compare < 0 ? temp.left : temp.right;
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new AVLTreeIterator<>(root, root != null ? findMin(root) : null);
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        int i = 0;
        for (T t : this) {
            array[i++] = t;
        }
        return array;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T1> T1[] toArray(T1[] a) {
        if (a.length < size) return (T1[]) toArray();
        int i = 0;
        for (T t : this) {
            a[i++] = (T1) t;
        }
        for (int j = i; j < a.length; j++) {
            a[j] = null;
        }
        return a;
    }

    @Override
    public boolean add(T t) {
        size++;
        root = insert(root, t);
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (o == null || !contains(o)) return false;
        size--;
        root = remove(root, (Comparable<T>) o);
        return true;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object o : c) {
            if (!contains(o)) return false;
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        for (T t : c) {
            add(t);
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean removed = false;
        for (Object t : c) {
            removed |= remove(t);
        }
        return removed;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean removed = false;
        for (T t : this) {
            if (!c.contains(t)) removed |= remove(t);
        }
        return removed;
    }

    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    @Override
    public String toString() {
        return new ArrayList<>(this).toString();
    }

    String printTree() {
        return printNode(root);
    }

    private static final class Node<K> {
        private K key;
        private int height = 1;
        private Node<K> left = null;
        private Node<K> right = null;

        private Node(K key) {
            this.key = key;
        }
    }

    private static final class AVLTreeIterator<E extends Comparable<E>> implements Iterator<E> {

        private final Node<E> root;
        private Node<E> current;

        private AVLTreeIterator(Node<E> root, Node<E> min) {
            this.root = root;
            this.current = min;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            if (current == null) throw new NoSuchElementException("No elements found");
            Node<E> prev = this.current;
            current = inOrderSuccessor(this.current, root);
            return prev.key;
        }
    }
}