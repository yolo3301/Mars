public class ZigzagIterator {

    private List<Iterator<Integer>> iters;
    private int iterIndex;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        iters = new ArrayList<>();
        iters.add(v1.iterator());
        iters.add(v2.iterator());
        iterIndex = 0;
    }

    public int next() {
        int res = iters.get(iterIndex).next();
        iterIndex = (iterIndex+1) % iters.size();
        return res;
    }

    public boolean hasNext() {
        int end = iterIndex;
        do {
            if (iters.get(iterIndex).hasNext()) break;
            else iterIndex = (iterIndex+1) % iters.size();
        } while (iterIndex != end);

        return iters.get(iterIndex).hasNext();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */