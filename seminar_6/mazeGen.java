package seminar_6;

import java.util.Random;

public class mazeGen {

    public static int[][] fillLine(int[][] line, int row, int step) {
        for (int j = 0; j < line[row].length; j++) {
            if (line[row][j] == 0) {
                line[row][j] = step;
                step +=1;
            }
        }
        return line;
    }
    public static int[][] copyLine(int[][] line, int row) {
        for (int j = 0; j < line[row].length; j++) {
           line[row+1][j] = line[row][j];
        }
        return line;
    }
    public static int stepNumb(int[] line, int x) {
        int count = 0;
        for (int j = 0; j < line.length; j++) {
            if (line[j] == x) {
                count +=1;
            }
        }
        return count;
    }
    public static int numbWalls(int[] mazerow, int[] walls, int x) {
        int count = 0;
        for (int j = 0; j < walls.length; j++) {
            if (mazerow[j] == x && walls[j] == 1 ) {count +=1;} 
        }
        return count;
    }

    public static int[][] getMaze(int[][] mv, int[][] mh) {
        int[][] maze = new int[mv.length][mv[0].length * 2];
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                if (j < mv[i].length) {maze[i][j] = mv[i][j];}
                else {maze[i][j] = mh[i][j - mv[i].length];}
            }
        }
        int[][] maze1 = {{0, 0, 0, 0, 1, 0, 1, 0, 1, 0},
                        {1, 0, 1, 1, 1, 0, 1, 0, 0, 0},
                        {0, 1, 0, 1, 1, 0, 1, 1, 0, 1},
                        {0, 0, 1, 0, 1, 0, 0, 0, 1, 1},
                        {0, 0, 0, 0, 1, 1, 1, 1, 1, 1}};
        return maze;
    }

    public static int[][] main(int m, int n) {
    
    Random random = new Random();
    int[][] mazevert = new int[m][n];
    int[][] mazehoriz = new int[m][n];
    int[][] maze = new int[m][n];
    int step = 1;
    maze = fillLine(maze, 0, step);
    step = maze[0][maze[0].length-1];
    for (int i = 0; i < maze.length; i++) {
        for (int j = 0; j < maze[i].length -1; j++) {
            if (random.nextInt(10) <= 5) {
                if (maze[i][j] == maze[i][j+1]) {
                    mazevert[i][j] = 1;
                } else {
                    mazevert[i][j] = 0;
                    maze[i][j+1] = maze[i][j];
                }
            } else {
                mazevert[i][j] = 1;
            }
        }
        mazevert[i][mazevert[i].length-1] = 1;
        for (int j = 0; j < maze[i].length; j++) {
            int setline = stepNumb(maze[i], maze[i][j]);
            if (setline == 1) {
                mazehoriz[i][j] = 0;
            } else {
                if (random.nextInt(10) <= 7) {
                    if (setline -1 > numbWalls(maze[i], mazehoriz[i], maze[i][j])) {
                        mazehoriz[i][j] = 1;
                    }
                }
            }
        }
        if (i < maze.length - 1) {
            maze = copyLine(maze, i);
            for (int j = 0; j < maze[i+1].length; j++) {
                if (mazehoriz[i][j] == 1) {
                    maze[i+1][j] = 0;
                }
            }
        int maxline = step;
        for (int j = 0; j < maze.length; j++) {
            if (maxline < maze[i][j]) {
                maxline = maze[i][j];
            }
        }
        maze = fillLine(maze, i+1, maxline + 1);
        }
    }
    for (int j = 0; j < maze[maze.length-1].length -1; j++) {
        mazehoriz[maze.length-1][j] = 1;
        if (maze[maze.length-1][j] != maze[maze.length-1][j+1]) {
            mazevert[maze.length-1][j] = 0;
            maze[maze.length-1][j+1] = maze[maze.length-1][j];
        }
    }
    mazehoriz[maze.length-1][maze[maze.length-1].length -1] = 1;
    return getMaze(mazevert, mazehoriz);
    }
}

