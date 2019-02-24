package algorithms.sorts;

import static algorithms.sorts.SortUtils.*;

public class BubbleSort implements SortAlgorithm {

	@Override
	public <T extends Comparable<T>> T[] sort(T[] unsorted) {
		int last = unsorted.length;

		// sorting
		boolean swap;
		do {
			swap = false;
			for (int count = 0; count < last - 1; count++) {
				if (less(unsorted[count], unsorted[count + 1])) {
					swap = swap(unsorted, count, count + 1);
				}
			}
			last--;
		} while (swap);
		return unsorted;
	}

	public static void main(String[] args) {
		// Integer Input
        Integer[] integers = {4, 23, 6, 78, 1, 54, 231, 9, 12};
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(integers);

        // Output => 231, 78, 54, 23, 12, 9, 6, 4, 1
        print(integers);

        // String Input
        String[] strings = {"c", "a", "e", "b","d"};
        //Output => e, d, c, b, a
        print(bubbleSort.sort(strings));

	}

}
