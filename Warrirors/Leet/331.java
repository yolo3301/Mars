public class Solution {
    int index = 0;
    public boolean isValidSerialization(String preorder) {
        String[] elems = preorder.split(",");
        // also need to check length!!!
        return isValid(elems) && index == elems.length;
    }

    private boolean isValid(String[] elems) {
        if (index >= elems.length) return false;
        if (elems[index] == null || elems[index].isEmpty()) return false;

        String curr = elems[index++];
        if (curr.equals("#")) return true;

        return isValid(elems) && isValid(elems);
    }
}
