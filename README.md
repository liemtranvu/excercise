## Code environment:
- JDK 1.8
- maven

## How to run test
- use maven to generate testing report in $PROJECT_BASE/target/surefire/reports
```
mvn verify
```


## Time and memory complexity analysis
### Exercise 1:
- store: given n is number of Map element in array - first loop process Maps, p is number of key-value pair in Map - second loop process elements of Map , complexity :  O(n\*p)
- load: iterate through characters in string once and build up Array of Map eventually, complexity : 0(n)

### Exercise 3:
- break down discount rules into separated component to make it easy to add, maintain rules.
- centralize the behavior of passing over billing amount among discount rules in **DiscountRule** so that we can extend it later without modifying main class.
- **Counter** composes chain of discount rules, for separating concern, it should not hold the behavior of passing over billing amount among discount rules.
