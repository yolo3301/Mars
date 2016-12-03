public class Twitter {

    private Map<Integer, Set<Integer>> followers;

    private Map<Integer, List<Integer>> tweets;

    private Map<Integer, Integer> order;

    private volatile int orderId;

    /** Initialize your data structure here. */
    public Twitter() {
        followers = new HashMap<>();
        tweets = new HashMap<>();
        order = new HashMap<>();
        orderId = 0;
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if (!tweets.containsKey(userId)) {
            tweets.put(userId, new ArrayList<>());
        }
        tweets.get(userId).add(tweetId);
        order.put(tweetId, orderId++);
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(10, new Comparator<Integer>() {
            public int compare(Integer v1, Integer v2) {
                return order.get(v2) - order.get(v1);
            }
        });

        addToHeap(userId, heap);
        if (followers.containsKey(userId)) {
            for (Integer fe : followers.get(userId)) {
                addToHeap(fe, heap);
            }
        }

        List<Integer> res = new ArrayList<>();
        int c = 0;
        while (!heap.isEmpty() && c++ < 10) res.add(heap.remove());
        return res;
    }

    private void addToHeap(int userId, PriorityQueue<Integer> heap) {
        if (tweets.containsKey(userId)) {
            List<Integer> ts = tweets.get(userId);
            for (int i = ts.size() - 1, j = 0; i >= 0 && j < 10; i--, j++) {
                heap.add(ts.get(i));
            }
        }
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
        if (!followers.containsKey(followerId)) {
            followers.put(followerId, new HashSet<>());
        }
        followers.get(followerId).add(followeeId);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
        if (!followers.containsKey(followerId)) return;
        followers.get(followerId).remove(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
