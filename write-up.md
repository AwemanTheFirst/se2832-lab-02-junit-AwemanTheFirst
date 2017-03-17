## Ryan Weise
#### weiserd@msoe.edu

To come up with my test cases, I looked over each method in the provided code and, using online documentation, thought
about a few ways that could be used to test the functionality for said method. In this way, I ensured as much code
coverage as possible. I looked through each method as I wrote code for it and then devised test cases for each of the
expected behaviors and code branches for the method. Then, I decided that once I had devised test cases for each provided method,
I could move forward into correcting the defects in the code, possibly going back to add more tests if I deemed it necessary.
Ultimately, ensuring I had tests to cover each code path was the first checkpoint for finishing writing tests, and then
executing tests and rewriting the code to accomodate the results until all tests were passed was the second and final checkpoint.

Original Line Number | Fault Description | Bug Description
--- | --- | ---
48* | in constructor, capacity is never set | Without having a defined capacity, the capacity defaults to 0 and the queue always believes itself to be full.
50 | in constructor, maxQueueSize had to be 0 or greater | The comparison for the maxQueueSize allowed for a queue of zero capacity, which is incorrect according to the comments of the class.
62 | in add, return value not initialized to true | The add method only ever returned false on a successful addition. Add should return true if successful and throw an exception if not, so the code is structured to return true upon reaching the end of the method.
81 | in element, returns data at tail, not head | Element would return data from the tail position, not the head position as per normal queue behavior.
102 | in peek, returns data at tail, not head | Peek would return data from the tail position, not the head position as per normal queue behavior.
112 | in poll, returns data at tail, not head | Poll would return data from the tail position, not the head position as per normal queue behavior.
147** | in clear, tail initialized to 1 | Tail location was initialized to 1 when an array was cleared instead of 0 for a system using a 0-based index. Changing this was a personal preference.
148** | in clear, head initialized to 1 | Head location was initialized to 1 when an array was cleared instead of 0 for a system using a 0-based index. Changing this was a personal preference.
172 | in iterator, does not throw an exception | The method should throw an UnsupportedOperationException, as stated by its comments, but it simply returned null.
209 | in toArray, calculates offset using tail, not head | The method added elements to the return array starting at the tail and moving forwards, not the head.

*This line number points to the start of the method as the corresponding defect had no "exact" spot where the fault was found. This applies to situations where a value was not set in a method that required it, and as such, pinpointing the exact line for the fault is impossible.
**While not technically a fault, I changed this out of my own volition, believing the code made more sense in the corrected version despite working fine either way.