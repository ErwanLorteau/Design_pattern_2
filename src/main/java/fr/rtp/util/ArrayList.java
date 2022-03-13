package fr.rtp.util;

public class ArrayList {
    public static final int GROWTH_INCREMENT = 10;
    private Object[] elements = new Object[10];
    private boolean readOnly;
    private int size = 0;

    public void add(Object child) {
        // <1>
        if (readOnly) {
            return ;
        }

        // <2>
        if (atCapatity()) {
            Object[] newElements = new Object[elements.length + GROWTH_INCREMENT];
            for (int i = 0; i < size; i++) {
                newElements[i] = elements[i];
            }
            elements = newElements;
        }
        // <3>
        addElement(child);
    }

    private boolean atCapatity() {
        return size + 1 > elements.length;
    }

    private void addElement(Object child) {
        elements[size] = child;
        size++;
    }

    public void setReadOnly(boolean readOnly) {
        this.readOnly = readOnly;
    }

    public boolean isReadOnly() {
        return readOnly;
    }

    public boolean contains(Object child) {
        for (int i = 0; i < size; i++) {
            if (child.equals(elements[i])) return true;
        }
        return false;
    }
}
