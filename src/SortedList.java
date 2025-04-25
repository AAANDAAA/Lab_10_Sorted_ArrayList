import java.util.ArrayList;

public class SortedList {
    private ArrayList<String> list;

    public SortedList() {
        list = new ArrayList<>();
    }

    public void add(String value) {
        int index = findInsertPosition(value);
        list.add(index, value);
    }

    // Binary search
    private int findInsertPosition(String value) {
        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            String midVal = list.get(mid);
            int cmp = value.compareTo(midVal);

            if (cmp < 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low; // Insertion point
    }

    // Search for the string using binary search
    public String search(String value) {
        int low = 0;
        int high = list.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            String midVal = list.get(mid);
            int cmp = value.compareTo(midVal);

            if (cmp == 0) {
                return "Element found at index " + mid + ": " + midVal;
            } else if (cmp < 0) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return "Element not found " + low;
    }

    public String getListString() {
        return String.join("\n", list);
    }
}
