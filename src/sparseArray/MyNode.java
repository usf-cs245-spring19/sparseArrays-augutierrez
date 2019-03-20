package sparseArray;

/** The node of the sparse array -- implements Node interface. */
public class MyNode implements Node {
    // Add instance variables:
    // index of the row, index of the column, and value
    // pointer to the next node in the row and
    // pointer to the next node in the column
    // FILL IN CODE

    /**
     * MatrixNode constructor
     * @param rowIndex row
     * @param columnIndex column
     * @param value value
     */
    public MyNode(int rowIndex, int columnIndex, Object value) {
        // FILL IN CODE


    }

    /**
     * RowNext setter.
     * @param node
     */
    public void setRowNext(Node node){
        // FILL IN CODE
    }

    /**
     * ColNext setter.
     * @param node
     */
    public void setColNext(Node node){
        // FILL IN CODE

    }

    /**
     * Value setter.
     * @param value
     */
    public void setValue(Object value){
        // FILL IN CODE

    }

    /**
     * RowNext getter.
     * @return
     */
    public Node rowNext(){
        // FILL IN CODE

        return null; // change it
    }

    /**
     * ColNext getter.
     * @return
     */
    public Node colNext() {
        // FILL IN CODE

        return null; // change it
    }

    /**
     * Return row Index.
     * @return
     */
    @Override
    public int rowIndex(){
        // FILL IN CODE

        return 0; // change
    }

    /**
     * Return column index.
     * @return
     */
    @Override
    public int columnIndex(){
        // FILL IN CODE

        return 0; // change
    }

    /**
     * Return node value.
     * @return
     */
    @Override
    public Object value(){
        // FILL IN CODE

        return null; // change
    }
}
