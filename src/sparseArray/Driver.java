package sparseArray;

public class Driver {
    public static void main(String[] args) {
        MySparseArray first = new MySparseArray(0);
        first.readFromFile("files/inputFile");
        //first.printToFile("temp1");
//        first.setValue(100,5,111);
//        first.setValue(1,3,10);
//        first.printSparseArray();
//        first.setValue(1,3,0);
//        first.printSparseArray();
//        first.setValue(100,5,0);
        first.printSparseArray();
    }

}
