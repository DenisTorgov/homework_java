// Генератор лабиринта для волнового алгоритма

package seminar_5;

import java.util.Random;

public class mazeGen {
    public static void printarr (int[][] xa) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < xa.length; i++) {
            for (int j = 0; j < xa[i].length; j++) {
                sb.append(xa[i][j] + ", ");
            }
            System.out.println(sb);
        sb.setLength(0);
        }
    }
    public static void printMaze(int[][] vert, int[][] horiz) {
        StringBuilder sb = new StringBuilder();
        System.out.print(" ");
        for (int i = 0; i < horiz[0].length; i++) {
            System.out.print("_ ");
        }
        System.out.println();
        for (int i = 0; i < horiz.length; i++) {
            sb.append("|");
            for (int j = 0; j < horiz[i].length; j++) {
                if (horiz[i][j] == 1) {
                    sb.append("_ ");
                } else {
                    sb.append("  ");
                }
                if (vert[i][j] == 1) {
                    sb.setLength(sb.length() - 1);
                    sb.append("|");
                }
            }
            System.out.println(sb);
            sb.setLength(0);
        }
    }

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
    public static void main(String[] arg) {
    
    Random random = new Random();
    int[][] mazevert = new int[10][10];
    int[][] mazehoriz = new int[10][10];
    int[][] maze = new int[10][10];
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
    printMaze(mazevert, mazehoriz);
    }
}
