package com.jaisocx.tools.combiner;

import java.util.ArrayList;
import java.util.List;

public class Combiner {

  @SafeVarargs
  //public static <T> List<List<T>> combine(List<T>... lists) {
  public static List<List<Object>> combine(List<?>... lists) {
    List<List<Object>> combinations = new ArrayList<>();

    long iterationsCount = lists.length;
    
    for (int i = 0; i < lists.length; i++) {
      List<Object> list = (List<Object>)lists[i];
      iterationsCount = iterationsCount * list.size();
    }

    // since we have many lists items, we need the counter for this.
    int listItemIndex = 0;
    int listItemIndexLast = lists.length - 1;

    // for each list item, on the same position in the list, we keep the current list item inner position
    int[] listsInnerLoops = new int[lists.length];
    List<Object> oneCombination = new ArrayList<>();
    for (int i = 0; i < iterationsCount; i++) {

      // a loop inside all lists
      oneCombination.add(lists[listItemIndex].get(listsInnerLoops[listItemIndex]));

      // next arg
      listItemIndex += 1;

      // out of bounds of lists args set
      if (listItemIndex >= lists.length) {

        // start again for each lists args set
        listItemIndex = 0;

        // append the args values combination
        combinations.add(oneCombination);
        oneCombination = new ArrayList<>();

        // inner iteration inc to next index
        for (int j = listItemIndexLast; j >= 0; j--) {
          listsInnerLoops[j] += 1;
          if (listsInnerLoops[j] >= lists[j].size()) {
            listsInnerLoops[j] = 0;
          } else {
            break;
          }
        }
      }
    }

    return combinations;
  }
}

