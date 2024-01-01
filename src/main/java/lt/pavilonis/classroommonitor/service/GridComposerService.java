package lt.pavilonis.classroommonitor.service;

import java.util.ArrayList;
import java.util.List;

import static java.util.Comparator.comparingInt;

public class GridComposerService {

   private static final double HEIGHT_FACTOR = 1.5;

   public static List<List<Integer>> createGrid(double screenWidth, double screenHeight, int numberOfItems) {

      double aspectRatio = screenWidth / screenHeight;

      List<List<Integer>> grid = new ArrayList<>();
      grid.add(new ArrayList<>());

      for (int i = 0; i < numberOfItems; i++) {
         double numberOfRows = grid.size();

         List<List<Integer>> sortedRows = grid.stream()
               .sorted(comparingInt(List::size))
               .toList();

         List<Integer> shortestRow = sortedRows.get(0);
         List<Integer> longestRow = sortedRows.get(sortedRows.size() - 1);

         if (shortestRow.size() < longestRow.size()) {
            shortestRow.add(i);

         } else if (shortestRow.size() == longestRow.size()) {

            if (longestRow.size() / (numberOfRows * HEIGHT_FACTOR) > aspectRatio) {
               var row = new ArrayList<Integer>();
               row.add(i);
               grid.add(row);
            } else {
               shortestRow.add(i);
            }

         } else {
            throw new IllegalStateException();
         }
      }

      return grid.stream()
            .sorted((a, b) -> Integer.compare(b.size(), a.size()))
            .toList();
   }
}
