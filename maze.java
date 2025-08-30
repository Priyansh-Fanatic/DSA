import java.util.*;

class maze{
    private static boolean Solve(int r, int c, int[][] maze, List<String> path, List<List<String>> res){
        if(r==maze.length-1 && c==maze[0].length-1){
            path.add("("+r+","+c+")");
            res.add(new ArrayList<>(path));
            path.remove(path.size()-1);
            return true;
        }
        if(r<0 || c<0 || r>=maze.length || c>=maze[0].length || maze[r][c]==0){
            return false;
        }
        maze[r][c]=0;
        path.add("("+r+","+c+")");
        boolean found = false;
        // Move Down
        found = Solve(r+1, c, maze, path, res) || found;
        // Move Right
        found = Solve(r, c+1, maze, path, res) || found;
        // Move Upz
        found = Solve(r-1, c, maze, path, res) || found;
        // Move Left
        found = Solve(r, c-1, maze, path, res) || found;
        path.remove(path.size()-1);
        maze[r][c]=1;
        return found;
    }
    public static void main(String[] args){
        int[][] maze = {
            {1, 1, 0, 0},
            {0, 1, 0, 1},
            {1, 1, 0, 0},
            {1, 0, 1, 0},
            {1, 1, 1, 1}
        };
        List<List<String>> res = new ArrayList<>();
        Solve(0, 0, maze, new ArrayList<>(), res);
        if (res.isEmpty()) {
            System.out.println("No path found through the maze.");
        } else {
            System.out.println("Paths through the maze:");
            int count = 1;
            for (List<String> path : res) {
                System.out.print("Path " + count + ": ");
                for (int i = 0; i < path.size(); i++) {
                    System.out.print(path.get(i));
                    if (i != path.size() - 1) System.out.print(" -> ");
                }
                System.out.println();
                count++;
            }
        }
    }
}