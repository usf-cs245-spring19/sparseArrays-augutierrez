package sparseArray;

import java.io.*;
import java.util.Scanner;

/** Implementation of the SparseArray Interface.  */
public class MySparseArray implements SparseArray {
    // Stores default value
    // Stores two heads (of type MyNode): rowHead and columnHead
    // FILL IN CODE
    Object Default;
    MyNode rowHead;
    MyNode columnHead;
    /**
     * Sets the default value for the sparse array
     * @param defaultValue default value
     */
    public MySparseArray(Object defaultValue) {
        // FILL IN CODE
        Default = defaultValue;
    }

    /**
     * Getter for the default value
     * @return Returns the default value
     */
    @Override
    public Object getDefaultValue() {
        // FILL IN CODE
        return Default; // change
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
        Node curr = rowHead; // myNode or just regular??
        while(curr != null){ // get to the right row
            //if it's the right row, start checking columns
            if(curr.rowIndex() == row){
                while(curr != null){ // get to the right column
                    //if it's the right column
                    if(curr.columnIndex() == col)
                        return curr.value(); //return the that Node
                    curr = curr.colNext();
                }
            }
            // if it's not the right row, continue going down
            if (curr != null)
                curr = curr.rowNext();
        }
//        rowHead.nextRow can delete
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
        // LEFT TO DO: ERASE DUMMY IF YOU DELETE THE ONLY MYNODE THAT IT WAS HOLDING
        // AFTER I DELETE CHECK IF ROW AND COLUMN NEXT ARE NULL, IF THEY ARE DELETE, IF NOT THAT MEANS THAT SOMETHING IS STILL THERE.
        //FOCUS ON FINDING DUMMY HEADS, STAY ONE ABOVE

        //DELETION
        if(value == getDefaultValue()){
            if(rowHead != null){ // if it's empty there's nothing to do, so this assumes it's not
                Node prevRow = rowHead;
                while (prevRow.rowNext() != null && prevRow.rowNext().rowIndex() < row)
                    prevRow = prevRow.rowNext();
                //prevRow is an option if the row we want is the head
                if(prevRow.rowIndex() == row || prevRow.rowNext().rowIndex() == row){ //if the row doesn't exist there is nothing to delete, so we are assuming it exists
                    Node prevCol = columnHead;
                    while (prevCol.colNext() != null && prevCol.colNext().columnIndex() < col)
                        prevCol = prevCol.colNext();
                    //prevCol is an option if the column we want is the head
                    if(prevCol.columnIndex() == col || prevCol.colNext().columnIndex() == col){//if the column doesn't exist there's nothing to do
                        Node tempR;
                        if(prevRow.rowIndex() == row)
                            tempR = prevRow; // if the row we want is the head
                        else
                            tempR = prevRow.rowNext(); // going to delete form row to col first, then col to row
                        while(tempR.colNext() != null && tempR.colNext().columnIndex() < col) // gets me right before the column we want
                            tempR = tempR.colNext();
                            if(tempR.colNext()!= null && tempR.colNext().columnIndex() == col){ // if the col doesn't exist, there's nothing to do
                                tempR.setColNext(tempR.colNext().colNext()); //deletes the node from row to column
                        }

                        Node tempC;
                        if(prevCol.columnIndex() == col)
                            tempC = prevCol; // if the column we want is the head
                        else
                            tempC = prevCol.colNext();
                        while(tempC.rowNext() != null && tempC.rowNext().rowIndex() < row) // gets me right before the row we want
                            tempC = tempC.rowNext();
                        if(tempC.rowNext()!= null && tempC.rowNext().rowIndex() == row){ // if the row doesn't exist, there's nothing to do
                            tempC.setRowNext(tempC.rowNext().rowNext()); //deletes the node from column to row
                        }

                        //Checks if we need to delete a row dummyNode
                        if(prevRow.rowIndex() == row && prevRow.colNext() == null) { // if the one we want to delete is currently the head
                            if(prevRow.rowNext() == null){ // if list is completely empty now
                                rowHead = null;
//                                columnHead = null;
                            }
                            else{
                                MyNode node = new MyNode(prevRow.rowNext().rowIndex(), -1, -1);
                                node.setColNext(prevRow.rowNext().colNext()); // HOW DO WE CHANGE ROWHEAD
                                node.setRowNext(prevRow.rowNext().rowNext()); // rowHead no longer points to
                                rowHead = node;
                            }
                        }
                        if(prevRow != null && prevRow.rowNext() != null && prevRow.rowNext().rowIndex() == row && prevRow.rowNext().colNext() == null)
                            prevRow.setRowNext(prevRow.rowNext().rowNext());

                        //Checks if we need to delete a column dummyNode
                        if(prevCol.columnIndex() == col && prevCol.rowNext() == null) // if the one we want to delete is currently the head
                            if(prevCol.colNext() == null){ // if list is completely empty now
                                columnHead = null;
//                                columnHead = null;
                            }
                            else{
                                MyNode node = new MyNode(-1, prevCol.colNext().columnIndex(), -1);
                                node.setRowNext(prevCol.colNext().rowNext()); // HOW DO WE CHANGE ROWHEAD
                                node.setColNext(prevCol.colNext().colNext()); // rowHead no longer points to
                                columnHead = node;
                            }
                        if(prevCol != null && prevCol.colNext() != null && prevCol.colNext().columnIndex() == col && prevCol.colNext().rowNext() == null)
                            prevCol.setColNext(prevCol.colNext().colNext());
                    }
                }
            }
        }

        //INSERTION
        else {
            if (rowHead != null && rowHead.rowIndex() > row) { // we have to create a new head
                MyNode dummyRow = new MyNode(row, -1, -1);
                dummyRow.setRowNext(rowHead);
                rowHead = dummyRow;
            }
            if (columnHead != null && columnHead.columnIndex() > col) { // we have to create a new head
                MyNode dummyCol = new MyNode(-1, col, -1);
                dummyCol.setColNext(columnHead);
                columnHead = dummyCol;
            }

            if (rowHead == null) { // makes sure the array isn't empty
                MyNode newRow = new MyNode(row, -1, -1);
                rowHead = newRow;
                MyNode newCol = new MyNode(-1, col, -1);
                columnHead = newCol;
            }

            Node prevRow = rowHead;
            Node prevCol = columnHead;

            // check if rowhead is where they want to insert.  We also have to deal with the case if it should be before rowhead

            //gets to the one before the actual row, or to one before the end of the list
            while (prevRow.rowNext() != null && prevRow.rowNext().rowIndex() < row)
                prevRow = prevRow.rowNext();
            //we have to create a dummy node
            if ((prevRow.rowNext() == null || prevRow.rowNext().rowIndex() != row) && prevRow.rowIndex() != row) {
                MyNode dummyRow = new MyNode(row, -1, -1);
                dummyRow.setRowNext(prevRow.rowNext());
                prevRow.setRowNext(dummyRow);
            }

            //Now for the columns
            while (prevCol.colNext() != null && prevCol.colNext().columnIndex() < row)
                prevCol = prevCol.colNext();
            //we have to create a dummy node
            if ((prevCol.colNext() == null || prevCol.colNext().columnIndex() != col) && prevCol.columnIndex() != col) {
                MyNode dummyCol = new MyNode(-1, col, -1);
                dummyCol.setColNext(prevCol.colNext());
                prevCol.setColNext(dummyCol);
            }
            Node tempR;
            Node tempC;
            if (prevRow.rowIndex() == row) // this would be true if we reassigned rowHead.
                tempR = prevRow;
            else
                tempR = prevRow.rowNext();
            if (prevCol.columnIndex() == col) // this would be true if we reassigned colHead.
                tempC = prevCol;
            else
                tempC = prevCol.colNext();

            while (tempR.colNext() != null && tempR.colNext().columnIndex() < col) { //get right before where we want to be
                tempR = tempR.colNext();
            }

            if (tempR.colNext() != null && tempR.colNext().columnIndex() == col) { // if it exists, simply write the new object

                tempR.colNext().setValue(value);
            } else { // if we create a new one, we must go back and connect it through the columns as well
                MyNode node = new MyNode(row, col, value);
                node.setColNext(tempR.colNext());
                tempR.setColNext(node);

                while (tempC.rowNext() != null && tempC.rowNext().rowIndex() < row) {
                    tempC = tempC.rowNext();
                }
                node.setRowNext(tempC.rowNext());
                tempC.setRowNext(node);
            }
        }
    }



    /** Read the sparse array from the file with the given filename
     *
     * @param filename name of the input file
     */
    @Override
    public void readFromFile(String filename){
        // FILL IN CODE
        File file = new File(filename);
        try {
            Scanner input = new Scanner(file);
            while(input.hasNextLine()) {
                String list[] = input.nextLine().split(",");
                setValue(Integer.parseInt(list[0]), Integer.parseInt(list[1]), Integer.parseInt(list[2]));
            }
            input.close();
        }
        catch (Exception e){
            System.out.println("File not found!");
        }
    }


    /**
     * Outputs the sparse array to the file with the given filename.
     * Prints only row, col on each line.
     *
     */
    @Override
    public void printToFile(String filename) {
        // FILL IN CODE
        try (PrintWriter pw = new PrintWriter(filename)) {
            Node node = rowHead;
            while(node != null){
                Node tempN = node.colNext();
                while(tempN != null) {
                    pw.println(tempN.rowIndex() + "," + tempN.columnIndex() + "," + tempN.value());
                    tempN = tempN.colNext();
                }
                node = node.rowNext();
            }
        } catch (IOException e) {
            System.out.println("Error writing to a file " + filename);
        }

    }

    public void printSparseArray(){
        System.out.println(columnHead.colNext().columnIndex());
       // System.out.println(rowHead.rowNext().rowIndex());
      //  System.out.println(columnHead.colNext());
//        System.out.println(columnHead.colNext().columnIndex());
//        System.out.println(columnHead.colNext().colNext().columnIndex());
    }


    // Add other methods as needed - like the method that counts neighbors of the cell etc.
}