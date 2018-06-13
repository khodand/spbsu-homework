package group144.khodko;

/**
 * Class realizing List without equals elements
 *
 * @param <T> Type parameter
 */
public class UniqueList<T> extends List<T> {

    /**
     * Adds element to list
     *
     * @param value added value
     * @throws ElementAlreadyAddedException if element is already added
     */
    @Override
    public void add(T value) throws ElementAlreadyAddedException {
        if (super.find(value) != -1) {
            throw new ElementAlreadyAddedException();
        }
        super.add(value);
    }

    /**
     * Add new element to list with position index
     *
     * @param value added value
     * @param index index of element ( element_i -> newElement ->...)
     * @throws IndexOutOfBoundsException if index out of range
     * @throws ElementAlreadyAddedException if element is already exist
     */
    public void add(T value, int index) throws IndexOutOfBoundsException, ElementAlreadyAddedException{
        if (super.find(value) != -1) {
            throw new ElementAlreadyAddedException();
        }
        super.add(value, index);
    }

}
