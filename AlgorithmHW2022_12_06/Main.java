package AlgorithmHW2022_12_06;

public class Main {

    public static void main(String[] args) {

        ArrayListHW arrayListHW = new ArrayListHW();
        arrayListHW.add(1);
        arrayListHW.add(2);
        arrayListHW.add(3);

        arrayListHW.addAt(2, 1);
        System.out.println("-----------");

        System.out.println(arrayListHW.get(3));

        arrayListHW.removeAt(2);

        arrayListHW.set(2, 4);

        System.out.println(arrayListHW.contains(0));
        System.out.println("-----------");

        arrayListHW.shrinkSize();

        arrayListHW.add(5);
        arrayListHW.add(6);

        System.out.println(arrayListHW.getSize());
        System.out.println("-----------");
        
        arrayListHW.print();


    }
}
