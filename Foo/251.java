public class Vector2D implements Iterator<Integer> {

    private List<List<Integer>> vec2d;
    private int index, size;
    private Iterator<Integer> curr;

    public Vector2D(List<List<Integer>> vec2d) {
        this.vec2d = vec2d;
        index = -1;
        size = vec2d.size();
        curr = null;
    }

    @Override
    public Integer next() {
        return curr.next();
    }

    @Override
    public boolean hasNext() {
        if (curr != null && curr.hasNext()) {
            return true;
        } else {
            while (++index < size) {
                curr = vec2d.get(index).iterator();
                if (curr.hasNext()) return true;
            }
        }

        return false;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */