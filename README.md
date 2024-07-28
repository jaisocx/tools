# Jaisocx Java Tools

## Combiner Utility
```
src/main/java/com/jaisocx/tools/combiner/Combiner.java
```

### Overview

The Combiner Utility is a Java library that generates all possible combinations of given input values. This is particularly useful for testing scenarios where you need to test all possible permutations of inputs.

### Features

- Generate combinations of values from multiple lists
- Support for different data types
- Not-fixed amount of input arguments
- Less dangerous one-level loop, instead of multilevel included sub-loops
- Easy to use

### Usage Sample
```
src/main/java/com/jaisocx/tools/combiner/CombinerSample.java

List<String> currencyValues = Arrays.asList("USD", "EUR", "CHF");
List<Boolean> booleanValues = Arrays.asList(true, false);

// Generate all combinations
List<List<Object>> combinations = Combiner.combine (
    currencyValues,
    booleanValues
);

// iterate over combinations to use as input args in some subcall
combinations.forEach(combinationItem -> combinationItemUsageSample (
    // here convert the combination item value to it's original data type
    (String) combinationItem.get(0),
    (boolean) combinationItem.get(1)
  )
);

/* sample method call to use in a one-level loop, using combinations */
public static void combinationItemUsageSample(String currency, boolean isSuggestionValid) {
  System.out.println(currnecy + " " + isSuggestionValid);
}

```