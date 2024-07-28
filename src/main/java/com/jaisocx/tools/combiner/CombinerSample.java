package com.jaisocx.tools.combiner;

import java.util.Arrays;
import java.util.List;

public class CombinerSample {

  enum PathValue {
    fileInRootFolder,
    fileInSubolder,
    newFileInRootFolder,
    newFileInSubolder;
  }

  enum UrlsRequested {
    afterDomainRoot,
    afterAliasRoot,
    subfolderRoot,
    newSubfolderRoot;
  }

  public static void main(String[] args) {
    CombinerSample.combine();
  }
  public static void combine() {
        /*List<EnumType1> enum1Values = Arrays.asList(EnumType1.values());
        List<EnumType2> enum2Values = Arrays.asList(EnumType2.values());
        List<EnumType3> enum3Values = Arrays.asList(EnumType3.values());
        List<EnumType4> enum4Values = Arrays.asList(EnumType4.values());
        List<EnumType5> enum5Values = Arrays.asList(EnumType5.values());*/
        
        List<UrlsRequested> urlsRequesteds = Arrays.asList(UrlsRequested.values());
        List<PathValue> pathValue = Arrays.asList(PathValue.values());
        List<String> currencyValues = Arrays.asList("USD", "EUR", "CHF");
        List<Boolean> booleanValues = Arrays.asList(true, false);

        // Generate all combinations
        List<List<Object>> combinations = Combiner.combine (
            urlsRequesteds,
            pathValue,
            currencyValues,
            booleanValues
        );

        // use all combinations less dangerous in a one-level loop
        CombinerSample.combinationsUsageSample(combinations);
  }
  
  public static void combinationsUsageSample(List<List<Object>> combinations) {
    combinations.forEach(combinationItem -> CombinerSample.combinationItemUsageSample(
        combinationItem
      )
    );
  }
  public static void combinationItemUsageSample(List<Object> combinationItem) {
    CombinerSample.sampleMethod(
      (UrlsRequested)combinationItem.get(0), 
      (PathValue)combinationItem.get(1), 
      (String)combinationItem.get(2), 
      (boolean)combinationItem.get(3) 
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

