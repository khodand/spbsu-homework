package group144.khodko;

    /**
     * Class realizing Linked List
     * @param <T> Type parameter
     */
    public class List<T> {

        /**
         * Class realizing list element
         *
         * @param <T> type parameter
         */
        private class ListElement<T> {
            private T value;
            private ListElement<T> next;

            ListElement(T value, ListElement<T> next) {
                this.value = value;
                this.next = next;
            }

            public T getValue() {
                return value;
            }

            public ListElement<T> getNext() {
                return next;
            }

            public void setNext(ListElement<T> next) {
                this.next = next;
            }

        }

        private ListElement<T> head = null;
        private int length = 0;

        /**
         * @return is list empty
         */
        public boolean isEmpty() {
            return length == 0;
        }

        /**
         * @return the length
         */
        public int getLength() {
            return length;
        }

        /**
         * Add new element to head
         *
         * @param value added value
         */
        public void add(T value) throws ElementAlreadyAddedException{
            head = new ListElement<>(value, head);
            length++;
        }

        /**
         * Add new element to list with certain index
         *
         * @param value added value
         * @param index index of element ( element_i -> newElement ->...)
         * @throws IndexOutOfBoundsException if index out of range
         */
        public void add(T value, int index) throws IndexOutOfBoundsException, ElementAlreadyAddedException{
            if (index >= length || index < 0) {
                throw new IndexOutOfBoundsException();
            }
			
            ListElement<T> temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.getNext();
            }
			
            ListElement<T> newElement = new ListElement<>(value, temp.getNext());
            temp.setNext(newElement);
            length++;
        }

        /**
         * Removes element from the list's head
         *
         * @return  head value
         * @throws NullElementException if list is empty
         */
        public T pop() throws NullElementException {
            if (isEmpty()) {
                throw new NullElementException();
            }
			
            T result = head.getValue();
            head = head.getNext();
            length--;
            return result;
        }

        /**
         * Removes element with index
         *
         * @param index index of element to be deleted
         * @return the value of element to be deleted
         * @throws NullElementException if index out of range
         */
        public T remove(int index) throws NullElementException {
            if (index == 0) {
                return pop();
            }
			
            if (index >= getLength()) {
                throw new NullElementException();
            }
			
            ListElement<T> temp = head;
            for (int i = 0; i < index - 1; i++) {
                temp = temp.getNext();
            }
			
            T result = temp.getNext().getValue();
            temp.setNext(temp.getNext().getNext());
            length--;
            return result;
        }

        /**
         * Returns the index of element or -1
         *
         * @param value the value to be found
         * @return the first index or -1
         */
        public int find(T value) {
            ListElement temp = head;
            for (int i = 0; i < getLength(); i++) {
                if (temp.getValue() == value) {
                    return i;
                }
                temp = temp.getNext();
            }
            return -1;
        }
    }
