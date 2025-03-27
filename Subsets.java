import java.util.*;

public class Subsets {
    /**
     * The function below will compute and return all subsets of a given set A
     * -Step 1: convert the input Set A into an array to allow indexed access
     * -Step 2: calculate the number of subsets using 2^n
     * -Step 3: for each number from 0 to 2^n - 1 generate a subset,
     *          for each bit in the bitmask, if it is set, include the corresponding element
     * -Step 4: add each generated subset to the result set
     * -return a Set of all the subsets
     */
    public Set<Set<Integer>> getSubSets(Set<Integer> A) {
        Set<Set<Integer>> result = new HashSet<>();

        //Step 1: convert the input Set A into an array to allow indexed access
        Integer[] elements = new Integer[A.size()];
        Iterator<Integer> it = A.iterator();
        int index = 0;
        while (it.hasNext()) {
            elements[index++] = it.next();
        }

        //Step 2: calculate the number of subsets using 2^n
        int n = elements.length;
        int totalSubsets = 1 << n;

        //Step 3: for each number from 0 to 2^n - 1 generate a subset
        for (int i = 0; i < totalSubsets; i++) {
            Set<Integer> subset = new HashSet<>();
            for (int j = 0; j < n; j++){
                //if bit j is set in i, include elements[j]
                if ((i & (1 << j)) != 0) {
                    subset.add(elements[j]);
                }
            }
            //Step 4: add each generated subset to the result set
            result.add(subset);
        }

        return result;
    }
    

    /**
     * the main method below will:
     * - create a sample set A with elements {1, 2, 3}
     * - call the getSubSets method to compute all subsets of A
     * - print each subset
     */
    public static void main(String[] args) {
        Set<Integer> A = new HashSet<>();
        A.add(1);
        A.add(2);
        A.add(3);

        Subsets sub = new Subsets();
        Set<Set<Integer>> subsets = sub.getSubSets(A);

        for (Set<Integer> subset : subsets) {
            System.out.println(subset);
        }
    }
}