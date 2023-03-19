//  Реализация волнового алгоритма

package seminar_6;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

// public class ObjectQueue {
//     public void add(Object obj) {
        
//     }
    
// }

public class program {

    public static int[][] doit(int[][] maze, Queue queue) {
        int[] point;
        int shift = maze[0].length/2;
        int wave =0;
        int[][] mazewave = new int[maze.length][maze[0].length/2];
        while (queue.size() != 0) {
            point = (int[])queue.poll();
            System.out.println((point) instanceof int[]);
            print.printline(point);
            if (maze[point[0]][point[1]] !=1) {
                int[] newpoint = {point[0], point[1] - 1};
                if (point[0] >= 0 && point[1] >= 0) {
                    queue.add(newpoint);
                }
                    mazewave[point[0]] [point[1]] = ++wave;
            } else {
                mazewave[point[0]] [point[1]] = ++wave;
            }
            if (maze[point[0]][point[1] + shift] !=1) {
                int[] newpoint = {point[0] - 1, point[1]};
                if (point[0] >= 0 && point[1] >= 0) {
                    queue.add(newpoint);
                }
                    mazewave[point[0]] [point[1]] = ++wave;
            } else {
                mazewave[point[0]] [point[1]] = ++wave;
            }
            if (maze[point[0]][point[1] + shift] !=1) {
                int[] newpoint = {point[0] + 1, point[1]};
                if (point[0] >= 0 && point[1] >= 0) {
                    queue.add(newpoint);
                }
                    mazewave[point[0]] [point[1]] = ++wave;
            } else {
                mazewave[point[0]] [point[1]] = ++wave;
            }
            if (maze[point[0]][point[1]] !=1) {
                int[] newpoint = {point[0], point[1] + 1};
                if (point[0] >= 0 && point[1] >= 0) {
                    queue.add(newpoint);
                }
                    mazewave[point[0]] [point[1]] = ++wave;
            } else {
                mazewave[point[0]] [point[1]] = ++wave;
            }
        }
        return mazewave;
    }
    public static void main(String[] args) {
        Queue<Object> queue = new LinkedList<>();
        // ObjectQueue queue = new ObjectQueue();
        int[] startpoint = {0, 0};
        queue.add(startpoint);
        int[][] maze = mazeGen.main(10, 10);
        print.printMaze(maze);
        print.printarr(doit(maze, queue));
    }
}
