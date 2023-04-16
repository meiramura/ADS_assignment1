public class MyArrayList<T extends Comparable<T>> implements MyList<T>{
    private Object[] elements;
    private int size;
    public MyArrayList() {
        this.elements = new Object[10];
        this.size = 0;
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o)>=0;
    }

    @Override
    public void add(T item) {
        if (size <= elements.length) {
            Object[] newArray = new Object[2*elements.length];
            System.arraycopy(elements, 0, newArray, 0, elements.length);
            elements = newArray;
        }
        elements[size++] = item;

    }

    @Override
    public void add(T item, int index) {
        if (index < 0 || index > size)

            throw new IndexOutOfBoundsException();
        
        for (int i = size; i > index; i--)
        {
            elements[i] = elements[i - 1];
        }
        
        elements[index] = item;
        
        size++;
    }

    @Override
    public boolean remove(T item) {
        int index = indexOf(item);
        if (index>=0){
            remove(index);
            return true;
        }
        return false;
    }

    @Override
    public T remove(int index) {
        if (index >= size) throw new IndexOutOfBoundsException();
        T elementRemoved = (T) elements[index];
        for (int i = index; i< size - 1; i++){
            elements[i] = elements[i+1];
        }
        elements[size-1] = null;
        size--;
        return elementRemoved;
    }

    @Override
    public void clear() {
        for (int i = 0; i<size; i++){
            elements[i] = null;
        }
        size = 0;
    }

    @Override
    public T get(int index) {
        if (index >= size) throw new IndexOutOfBoundsException();

        return (T) elements[index];
    }

    @Override
    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i <size; i++) {
                if (elements[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i <size; i++) {
                if (o.equals(elements[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        if (o == null) {
            for (int i = size-1; i >=0; i--) {
                if (elements[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = size-1; i >=0; i--) {
                if (o.equals(elements[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public void sort() {
        for (int i = 0; i < size() - 1; i++) {
            for (int j = 0; j < size() - i - 1; j++) {
                if (((Comparable<T>) elements[j]).compareTo((T) elements[j + 1]) > 0) {
                    T temp = (T) elements[j];
                    elements[j] = elements[j+1];
                    elements[j+1] = temp;
                }
            }
        }
    }


}
