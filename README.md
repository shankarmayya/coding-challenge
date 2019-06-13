# Williams-Sonoma, Inc. Coding Challenge

Version: 1.0.0-SNAPSHOT

Author: Shankar Mayya

Date: 06/122019


#### Background
Sometimes items cannot be shipped to certain zip codes, and the rules for these restrictions are stored as a series of ranges of 5 digit codes. For example if the ranges are:

[94133,94133] [94200,94299] [94600,94699]

Then the item can be shipped to zip code 94199, 94300, and 65532, but cannot be shipped to 94133, 94650, 94230, 94600, or 94299.

Any item might be restricted based on multiple sets of these ranges obtained from multiple sources.

#### Problem
Given a collection of 5-digit ZIP code ranges (each range includes both their upper and lower bounds), provide an algorithm that produces the minimum number of ranges required to represent the same restrictions as the input.

##### Notes
The ranges above are just examples, your implementation should work for any set of arbitrary ranges
Ranges may be provided in arbitrary order
Ranges may or may not overlap
Your solution will be evaluated on the correctness and the approach taken, and adherence to coding standards and best practices

App developed using Java 1.8 and built using Gradle.

### Running the app

1. Running inside IDE
   - import as existing Gradle project, before running Main application go to Run Configuration -> under Program Arguments specify inputs.
1. Running through Gradle command [Gradle distribution is part of codebase]
```
gradle clean run -PrunArgs="[94133,94133] [94200,94299] [94600,94699]"
```

####Running all tests
```
gradle test
```

test results can be found that this location `${project dir}/build/test-results/` and reports can be found at `${project dir}/build/reports/tests/test/`
