package others;

import java.util.*;

/**
 * Created by cenumah on 2020-01-11
 */
public class ShareFilesAmongServers {

    public static void main(String[] args) {

//        System.out.println(new ShareFilesAmongServers().minimumHours(5, 4, Arrays.asList(
//                Arrays.asList(0,1,1,0,1),
//                Arrays.asList(0,1,0,1,0),
//                Arrays.asList(0,0,0,0,1),
//                Arrays.asList(0,1,0,0,0)
//
//        )));
//
//        System.out.println(new ShareFilesAmongServers().minimumHours(5, 5, Arrays.asList(
//                Arrays.asList(1,0,0,0,0),
//                Arrays.asList(0,1,0,0,0),
//                Arrays.asList(0,0,1,0,1),
//                Arrays.asList(0,0,0,1,0),
//                Arrays.asList(0,0,0,0,1)
//
//        )));

        System.out.println(new ShareFilesAmongServers().minimumHours(5, 4, Arrays.asList(
                Arrays.asList(1,1,1,1,1),
                Arrays.asList(1,1,1,1,1),
                Arrays.asList(1,1,1,1,1),
                Arrays.asList(1,1,1,1,1)

        )));

        System.out.println(new ShareFilesAmongServers().minimumHours(5, 4, Arrays.asList(
                Arrays.asList(1,0,0,0,0),
                Arrays.asList(0,0,0,0,0),
                Arrays.asList(0,0,0,0,0),
                Arrays.asList(0,0,0,0,0)
        )));

        System.out.println(new ShareFilesAmongServers().minimumHours(5, 4, Arrays.asList(
                Arrays.asList(1,0,0),
                Arrays.asList(0,0,0),
                Arrays.asList(0,0,0)
        )));
    }

    int minimumHours(int rows, int cols, List<List<Integer> > grid) {
        // WRITE YOUR CODE HERE
        if(rows <= 0 || cols <= 0 || grid == null || grid.isEmpty()) {
            return 0;
        }

        Set<Integer> serversWithFile = new HashSet<>();
        int hours = 0;
        while(true) {
            Set<Integer> newlyVisited = share(grid, serversWithFile);
            if(newlyVisited.isEmpty()) {
                break;
            }
            serversWithFile.addAll(newlyVisited);
            hours++;
        }

        return hours;
    }

    private Set<Integer> share(List<List<Integer>> grid, Set<Integer> visited) {

        Set<Integer> newlyVisited = new HashSet<>();
        for(int i=0; i<grid.size(); i++) {
            for(int j=0; j<grid.get(i).size(); j++) {

                int serverId = i*10 + j;
                if(get(grid, i, j) == 0 || newlyVisited.contains(serverId)) {
                    continue;
                }

                //share file with neighbouring servers
                //up wards
                if(get(grid, i-1, j) == 0 && !visited.contains(serverId-10)) {
                    newlyVisited.add(serverId-10);
                    shareFile(grid, i-1, j);
                }

                //down wards
                if(get(grid, i+1, j) == 0 && !visited.contains(serverId+10)) {
                    newlyVisited.add(serverId+10);
                    shareFile(grid, i+1, j);
                }
Map<String, Integer> m = new TreeMap<>((Comparator.reverseOrder()));
                //left wards
                if(get(grid, i, j-1) == 0 && !visited.contains(serverId-1)) {
                    newlyVisited.add(serverId-1);
                    shareFile(grid, i, j-1);
                }

                //right wards
                if(get(grid, i, j+1) == 0 && !visited.contains(serverId+1)) {
                    newlyVisited.add(serverId+1);
                    shareFile(grid, i, j+1);
                }
            }
        }

        return newlyVisited;

    }

    private void shareFile(List<List<Integer>> grid, int i, int j) {
        grid.get(i).set(j, 1);
    }

    private int get(List<List<Integer>> grid, int i, int j) {
        if(i < 0 || j < 0 || i>=grid.size() || j>=grid.get(i).size()) {
            return -1;
        }

        return grid.get(i).get(j);
    }

//    private static int getMinHours(int rows, int cols, int[][] grid) {
//
//        if(rows < 1 || cols < 1 || grid == null || grid.length == 0 || grid[0].length == 0) {
//            return -1;
//        }
//
//        int hours = 0;
//        Set<Integer> visited = new HashSet<>();
//        while(visited.size() < rows*cols) {
//            shareFiles(grid, visited);
//            hours++;
//        }
//
//
//        return hours;
//    }
//
//    private static void shareFiles(int[][] grid, Set<Integer> visited) {
//
//        Set<Integer> justAdded = new HashSet<>();
//
//        for(int i=0; i<grid.length; i++) {
//            for (int j=0; j<grid[i].length; j++) {
//
//                int id = i*10 + j;"".contains("");
//
//                if(grid[i][j] == 1 && justAdded.contains(id) || grid[i][j] == 0) {
//                    continue;
//                }
//
//                if(i>0 && !visited.contains(id-10)) {
//                    grid[i-1][j] = 1;
//                    justAdded.add(id-10);
//                }
//
//                if(j>0 && !visited.contains(id-1)) {
//                    grid[i][j-1] = 1;
//                    justAdded.add(id-1);
//                }
//
//                if(i<grid.length-1 && !visited.contains(id+10)) {
//                    grid[i+1][j] = 1;
//                    justAdded.add(id+10);
//                }
//
//                if(j<grid[i].length-1 && !visited.contains(id+1)) {
//                    grid[i][j+1] = 1;
//                    justAdded.add(id+1);
//                }
//            }
//        }
//
//        visited.addAll(justAdded);
//    }
}
