package com.jaisocx.tools.combiner;

import java.util.Arrays;
import java.util.List;

public class CombinerSample {

  enum UrlsRequested {
    afterDomainRoot,
    afterAliasRoot,
    subfolderRoot,
    newSubfolderRoot;
  }

  enum PathValue {
    fileInRootFolder,
    fileInSubolder,
    newFileInRootFolder,
    newFileInSubolder;
  }

  public static void main(String[] args) {
    List<UrlsRequested> urlsRequested = Arrays.asList(UrlsRequested.values());
    List<PathValue> pathValues = Arrays.asList(PathValue.values());
    List<String> currencyValues = Arrays.asList("USD", "EUR", "CHF");
    List<Boolean> booleanValues = Arrays.asList(true, false);

    // Generate all combinations in one-level loop
    List<List<Object>> combinations = Combiner.combine (
        urlsRequested,
        pathValues,
        currencyValues,
        booleanValues
    );

    // use all combinations less dangerous in a one-level loop
    CombinerSample.combinationsUsageSample(combinations);
  }
  
  public static void combinationsUsageSample(List<List<Object>> combinations) {
    combinations.forEach(combinationItem -> CombinerSample.sampleMethod(
        (UrlsRequested)combinationItem.get(0), 
        (PathValue)combinationItem.get(1), 
        (String)combinationItem.get(2), 
        (boolean)combinationItem.get(3) 
      )
    );
  }

  public static void sampleMethod(
    UrlsRequested urlsRequested,
    PathValue pathValue,
    String currency,
    boolean isSuggestionValid
  ) {
    System.out.print(urlsRequested.name() + ", ");
    System.out.print(pathValue.name() + ", ");
    System.out.print(currency + ", ");
    System.out.print(isSuggestionValid);
    System.out.println();
  }

  public static void printCombinations(List<List<Object>> combinations) {
    combinations.forEach(combinationItem -> CombinerSample.printCombinationsItem(combinationItem));
  }
  public static void printCombinationsItem(List<Object> combinationItem) {
    combinationItem.forEach(object -> System.out.print(object.toString() + " "));
    System.out.println();
  }
}

