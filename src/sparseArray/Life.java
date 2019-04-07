package sparseArray;

public class Life {
    public static void main(String[] args) {
        if(args.length < 3) {
            System.out.println("Not enough command line arguments (inputfile, outputfile, #ofgenerations)");
            return;
        }

        MySparseArray firstGen = new MySparseArray(0);
        firstGen.readFromFile(args[0]);
        for(int i = 0; i < Integer.parseInt(args[2]); i++){
            MySparseArray secondGen = new MySparseArray(0);
            firstGen.newGeneration(secondGen);
            firstGen = secondGen;
        }
       firstGen.printToFile(args[1]);
    }

}
