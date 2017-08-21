class Solution {
    public boolean judgeCircle(String moves) {
        int x = 0, y = 0;
        for (char ch : moves.toCharArray()) {
            switch(ch) {
                case 'R':
                    x++;
                    break;

                case 'L':
                    x--;
                    break;

                case 'U':
                    y++;
                    break;

                case 'D':
                    y--;
                    break;

                default:
                    continue;
            }
        }

        return (x == 0 && y == 0);
    }
}