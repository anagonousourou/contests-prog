import java.util.List;

public class BinarySearch {
    private final List<Integer> elements;

    public BinarySearch(List<Integer> elements) {
        this.elements = elements;
    }

    public int indexOf(int toFind) throws ValueNotFoundException {
        return binarySearch(elements, 0, elements.size(), toFind);
    }

    public static int binarySearch(List<Integer> elements, int fromIndex, int toIndex, int key) throws ValueNotFoundException {
        int low = fromIndex;
        int high = toIndex - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            long midVal = elements.get(mid);

            if (midVal < key)
                low = mid + 1;
            else if (midVal > key)
                high = mid - 1;
            else
                return mid; // key found
        }
        throw new ValueNotFoundException("Value not in array");
    }
}