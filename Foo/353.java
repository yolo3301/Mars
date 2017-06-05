public class SnakeGame {

    private Deque<int[]> body;
    private Set<String> inBody;
    private int w, h, index;
    private int[][] food;

    /** Initialize your data structure here.
        @param width - screen width
        @param height - screen height 
        @param food - A list of food positions
        E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    public SnakeGame(int width, int height, int[][] food) {
        body = new LinkedList<>();
        inBody = new HashSet<>();
        this.w = width;
        this.h = height;
        this.food = food;
        index = 0;

        body.addFirst(new int[]{0, 0});
        inBody.add(getKey(0, 0));
    }
    
    /** Moves the snake.
        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
        @return The game's score after the move. Return -1 if game over. 
        Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        int[] d = getDir(direction);
        int[] head = body.peekFirst();
        
        // print();

        int x = head[0] + d[0];
        int y = head[1] + d[1];
        
        // System.out.println(x + "," + y);

        if (x < 0 || x >= h || y < 0 || y >= w) return -1;

        int[] tail = body.removeLast();
        inBody.remove(getKey(tail[0], tail[1]));

        if (inBody.contains(getKey(x, y))) return -1;

        body.addFirst(new int[]{x, y});
        inBody.add(getKey(x, y));

        if (index < food.length && food[index][0] == x && food[index][1] == y) {
            index++;
            body.addLast(tail);
            inBody.add(getKey(tail[0], tail[1]));
        }
        
        // print();

        return body.size()-1;
    }

    private int[] getDir(String direction) {
        if (direction.equals("U")) return new int[]{-1, 0};
        if (direction.equals("D")) return new int[]{1, 0};
        if (direction.equals("L")) return new int[]{0, -1};
        if (direction.equals("R")) return new int[]{0, 1};
        return new int[]{0, 0};
    }

    private String getKey(int x, int y) {
        return x + ";" + y;
    }
    
    private void print() {
        Iterator<int[]> it = body.iterator();
        while (it.hasNext()) {
            int[] tmp = it.next();
            System.out.print("[" + tmp[0] + "," + tmp[1] + "]->");
        }
        System.out.println();
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */