// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {

    private Iterator<Integer> iterator;
    private Integer next;

	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    this.iterator = iterator;
        next = null;
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        if (next == null) {
            next = iterator.next();
        }
        return next;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    if (next == null) {
            return iterator.next();
        } else {
            Integer tmp = next;
            next = null;
            return tmp;
        }
	}

	@Override
	public boolean hasNext() {
	    return iterator.hasNext() || next != null;
	}
}
