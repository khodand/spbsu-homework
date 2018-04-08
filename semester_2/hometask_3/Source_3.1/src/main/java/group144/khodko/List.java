package group144.khodko;

public class List {
    private class ListElement {
        String text;
        int frequency = 1;
        ListElement next;

        ListElement(String text) {
            this.text = text;
        }
    }

    private ListElement first;
    private ListElement last;
    private int size = 0;


    public void add(String word) {
        int i = 0;
        ListElement current = first;
        while (i < size) {
            if (current.text.equals(word)) {
                current.frequency++;
                return;
            }
            current = current.next;
            i++;
        }

        if (isEmpty()) {
            first = new ListElement(word);
            last = first;
        }
        else {
            last.next = new ListElement(word);
            last = last.next;
        }
        size++;
    }

    public void remove(int i) {
        if (i >= size || i < 0)
            return;

        ListElement current = first;
        ListElement previous = first;
        while (i != 0) {
            previous = current;
            current = current.next;
            i--;
        }
        previous.next = current.next;
        size--;
    }

    public String get(int i) {
        if (i >= size || i < 0)
            throw new IndexOutOfBoundsException();

        ListElement current = first;
        while (i != 0) {
            current = current.next;
            i--;
        }
       return current.text;
    }

    public int getFrequencyOfWord(String word) {
        ListElement current = first;

        int i = 0;
        while (i < size) {
            if (current.text.equals(word))
                return current.frequency;
            current = current.next;
            i++;
        }
        return 0;
    }

    public int numberOfWords() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
