### Book shop daily order book

Given an input of line items from an order book, parse them to ensure they
meet the following criteria
- Date is not in the future
- Quantity is not less than 0
- Code are all alphanumeric

Order line items should then be written as output grouped by the 
surname of the line items and ordered by quantity, they should also 
have the following amendments if necessary
- Surnames must be camel cased
- Codes should be uppercased

Therefore given the following messages:

```
Bloggs AB32 1 2012-01-10T12:02:14.113Z
Smith xx98 1 2012-01-10T13:02:14.113Z
Jones QA12 1 2012-01-10T14:02:14.113Z
Bloggs ot31 9 2012-01-10T15:02:14.113Z
```

This would be returned as follows:

```
Bloggs OT31 9 2012-01-10T15:02:14.113Z
Bloggs AB32 1 2012-01-10T12:02:14.113Z
Smith XX98 1 2012-01-10T13:02:14.113Z
Jones QA12 1 2012-01-10T14:02:14.113Z
```

There should be the ability to extend the solution for new inputs 
and outputs, the first implementation should be File

Any line items that do not meet the criteria will be discarded.
Any line items that do not contain the 4 bits of the order will also be discarded