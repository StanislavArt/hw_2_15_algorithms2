package pro.sky.java.course2.algorithms2;

import pro.sky.java.course2.algorithms2.exceptions.*;

public class StringListImp implements StringList {
    private int fullSize;
    private int size;
    private String[] array;

    public StringListImp(int fullSize) {
        if (fullSize <= 0) {
            throw new WrongSizeOfArray();
        }

        this.array = new String[fullSize];
        this.size = 0;
        this.fullSize = fullSize;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void clear() {
        for(int i=0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    public String get(int index) {
        if (index < 0 || index >= size) {
            throw new WrongIndex();
        }
        return array[index];
    }

    public String add(String item) {
        if (item == null) {
            throw new InvalidArgument();
        }
        if (size == fullSize) {
            throw new ArrayIsFull();
        }
        array[size] = item;
        size++;
        return item;
    }

    private void moveElementsRight(int index) {
        for (int i=size; i > index; i--) {
            array[i] = array[i-1];
        }
    }

    private void moveElementsLeft(int index) {
        for(int i = index; i < size-1; i++) {
            array[i] = array[i+1];
        }
        array[size-1] = null;
    }

    public String add(int index, String item) {
        if (item == null) {
            throw new InvalidArgument();
        }
        if (index < 0 || index > size) {
            throw new WrongIndex();
        }
        if (size == fullSize) {
            throw new ArrayIsFull();
        }
        if (index == size) {
            add(item);
        } else {
            moveElementsRight(index);
            array[index] = item;
            size++;
        }
        return item;
    }

    public String set(int index, String item) {
        if (item == null) {
            throw new InvalidArgument();
        }
        if (index < 0 || index >= size) {
            throw new WrongIndex();
        }
        array[index] = item;
        return item;
    }

    public String remove(String item) {
        if (item == null) {
            throw new InvalidArgument();
        }
        int index = indexOf(item);
        if (index == -1) {
            throw new ElementNotFound();
        }
        return remove(index);
    }

    public String remove(int index) {
        if (index < 0 || index >= size) {
            throw new WrongIndex();
        }
        String item = get(index);
        moveElementsLeft(index);
        size--;
        return item;
    }

    public boolean contains(String item) {
        if (item == null) {
            throw new InvalidArgument();
        }
        for(String element : array) {
            if (element == null) break;
            if (element.equals(item)) return true;
        }
        return false;
    }

    public int indexOf(String item) {
        if (item == null) {
            throw new InvalidArgument();
        }
        for (int i=0; i < size; i++) {
            if (item.equals(array[i])) return i;
        }
        return -1;
    }

    public int lastIndexOf(String item) {
        if (item == null) {
            throw new InvalidArgument();
        }
        for (int i=size-1; i >= 0; i--) {
            if (item.equals(array[i])) return i;
        }
        return -1;
    }

    public boolean equals(StringList otherList) {
        if (otherList == null) {
            throw new InvalidArgument();
        }
        if (size != otherList.size()) return false;
        for (int i=0; i<size; i++) {
            if (!array[i].equals(otherList.get(i))) return false;
        }
        return true;
    }

    public String[] toArray() {
        if (size == 0) return null;
        String[] result = new String[size];
        for (int i=0; i < size;  i++) {
            result[i] = array[i];
        }
        return result;
    }
}
