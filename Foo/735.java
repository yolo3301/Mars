class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        if (asteroids.length <= 1) return asteroids;

        int len = asteroids.length;

        for (int i = 0; i < asteroids.length; i++) {
            if (asteroids[i] < 0) {
                for (int j = i-1; j >= 0 && asteroids[j] >= 0; j--) {
                    if (asteroids[j] == 0) continue;
                    if (asteroids[i] + asteroids[j] < 0) {
                        asteroids[j] = 0;
                        len--;
                    } else {
                        asteroids[i] = 0;
                        len--;
                        if (asteroids[i] + asteroids[j] == 0) {
                            asteroids[j] = 0;
                            len--;
                        }
                        break;
                    }
                }
            }
        }

        int[] ret = new int[len];
        if (len == 0) return ret;

        for (int i = 0, j = 0; i < asteroids.length; i++) {
            if (asteroids[i] != 0) ret[j++] = asteroids[i];
        }

        return ret;
    }
}

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < asteroids.length; i++) {
            if (asteroids[i] > 0 || list.isEmpty() || list.getLast() < 0)
                list.addLast(asteroids[i]);
            else {
                while (!list.isEmpty() && list.getLast() > 0 && list.getLast() + asteroids[i] <= 0) {
                    if (list.getLast() + asteroids[i] == 0) {
                        asteroids[i] = 0;
                    }
                    list.removeLast();
                }

                if ((list.isEmpty() || list.getLast() < 0) && asteroids[i] < 0) list.add(asteroids[i]);
            }
        }

        return list.stream().mapToInt(i->i).toArray();
    }
}