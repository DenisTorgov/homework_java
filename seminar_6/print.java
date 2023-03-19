package seminar_6;

public class print {

    public static void printarr (int[][] xa) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < xa.length; i++) {
            for (int j = 0; j < xa[i].length; j++) {
                sb.append(xa[i][j] + "| ");
            }
            System.out.println(sb);
        sb.setLength(0);
        }
    }
    public static void printline (int[] xa) {
        StringBuilder sb = new StringBuilder();
        if (xa == null) {
            System.out.println("null_");
        } else {
            for (int i = 0; i < xa.length; i++) {
            sb.append(xa[i] + "| ");
            }
        }
        System.out.println(sb);
    }

    

    public static void printMaze(int[][] maze) {
                                        // vert, int[][] horiz
        
        StringBuilder sb = new StringBuilder();
        System.out.print(" ");
        for (int i = 0; i < maze[0].length / 2; i++) {
            System.out.print("_ ");
        }
        System.out.println();
        for (int i = 0; i < maze.length; i++) {
            sb.append("|");
            for (int j = 0; j < maze[i].length/2; j++) {
                if (maze[i][j + maze[i].length/2] == 1) {
                    sb.append("_ ");
                } else {
                    sb.append("  ");
                }
                if (maze[i][j] == 1) {
                    sb.setLength(sb.length() - 1);
                    sb.append("|");
                }
            }
            System.out.println(sb);
            sb.setLength(0);
        }
    } 
}
