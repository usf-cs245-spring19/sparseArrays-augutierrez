package sparseArray;

import java.io.*;

/** Implementation of the SparseArray Interface.  */
public class MySparseArray implements SparseArray {
    // Stores default value
    // Stores two heads (of type MyNode): rowHead and columnHead
    // FILL IN CODE

    /**
     * Sets the default value for the sparse array
     * @param defaultValue default value
     */
    public MySparseArray(Object defaultValue) {
        // FILL IN CODE
    }

    /**
     * Getter for the default value
     * @return Returns the default value
     */
    @Override
    public Object getDefaultValue() {
        // FILL IN CODE
        return null; // change
    }


    /**
     * Gets element at the given row and column
     * if the node does not exist return default value
     * @param row row
     * @param col column
     * @return
     */
    @Override
    public Object elementAt(int row, int col) {
        // FILL IN CODE

        return null; // change
    }

    /**
     * Modifies the value at a given row, column,
     * or inserts the node for this row, column in the sparse array
     * if it did not exist before.
     * If value is the default value, then the node should be deleted from
     * the sparse array
     * @param row row
     * @param col column
     * @param value value of the element
     */
    @Override
    public void setValue(int row, int col, Object value) {
        // FILL IN CODE


    }


    /** Read the sparse array from the file with the given filename
     *
     * @param filename name of the input file
     */
    @Override
    public void readFromFile(String filename) {
        // FILL IN CODE

    }


    /**
     * Outputs the sparse array to the file with the given filename.
     * Prints only row, col on each line.
     *
     */
    @Override
    public void printToFile(String filename) {
        // FILL IN CODE

    }


    // Add other methods as needed - like the method that counts neighbors of the cell etc.
}