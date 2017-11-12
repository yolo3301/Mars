// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {

    private Integer cached;
    private Iterator<Integer> iter;

	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    this.iter = iterator;
        this.cached = null;
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        if (this.cached == null) {
            this.cached = this.iter.next();
        }
        return this.cached;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    if (this.cached != null) {
            Integer ret = this.cached;
            this.cached = null;
            return ret;
        }

        return this.iter.next();
	}

	@Override
	public boolean hasNext() {
	    return (this.cached != null || this.iter.hasNext());
	}
}