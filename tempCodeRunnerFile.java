    private static boolean Solve(int r, int c, int[][] maze, List<String> path, List<List<String>> res){
        if(r==maze.length-1 && c==maze[0].length-1){
            res.add(new ArrayList<>(path));
            return true;
        }
        if(r<0 || c<0 || r>=maze.length || c>=maze[0].length || maze[r][c]==0){
            return false;
        }
        maze[r][c]=0;
        path.add("("+r+","+c+")");
        boolean found = Solve(r+1,c,maze,path,res) || Solve(r,c+1,maze,path,res);
        path.remove(path.size()-1);
        maze[r][c]=1;
        return found;
    }