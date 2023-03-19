//  Реализация волнового алгоритма

package seminar_6;

import java.util.LinkedList;
import java.util.Queue;

public class program {

    public static int[][] doit(int[][] maze, Queue queue, int[] endpoint) {
        int[] point;
        int shift = maze[0].length/2;
        int wave =0;
        int[][] mazewave = new int[maze.length][maze[0].length/2];
        while (queue.size() != 0) {
            point = (int[])queue.poll();
            if (point[0] >= 0 && point[1] >= 0 && mazewave[point[0]] [point[1]] == 0) {
                mazewave[point[0]] [point[1]] = ++wave;
            print.printline(point);
            if (point[0] == endpoint[0] && point[1] == endpoint[1]) {
                mazewave[point[0]] [point[1]] = ++wave;
                break;}
            
                if (maze[point[0]][point[1]] !=1) {
                    int[] newpoint = {point[0], point[1] - 1};
                    queue.add(newpoint);
                }
                if (maze[point[0]][point[1] + shift] !=1) {
                    int[] newpoint = {point[0] - 1, point[1]};
                    queue.add(newpoint);
                }
                if (maze[point[0]][point[1] + shift] !=1) {
                    int[] newpoint = {point[0] + 1, point[1]};
                    queue.add(newpoint);
                }
                if (maze[point[0]][point[1]] !=1) {
                    int[] newpoint = {point[0], point[1] + 1};
                    queue.add(newpoint);
                }
            }
        }
        return mazewave;
    }
    public static void main(String[] args) {
        Queue<Object> queue = new LinkedList<>();
        int[] startpoint = {0, 0};
        int[] endpoint = {10, 10};
        queue.add(startpoint);
        int[][] maze = mazeGen.main(10, 10);
        print.printMaze(maze);
        print.printarr(doit(maze, queue, endpoint));
    }
}
