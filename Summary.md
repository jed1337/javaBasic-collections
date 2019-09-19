# Summary
## ArrayTest
1. What is the knowledge point of the test? Where is the official document to the knowledge point?
	* How a Stack data structure is created
		* How it is internally represented via array
	* Documents
		* [How to increase the size of an array in Java?](https://stackoverflow.com/questions/12524318/how-to-increase-the-size-of-an-array-in-java)
		* [arraycopy](https://docs.oracle.com/javase/8/docs/api/java/lang/System.html#arraycopy-java.lang.Object-int-java.lang.Object-int-int-)
2. Why the test failed at first?
	* The correct value wasn't there
3. Why you corrected the test that way?
	* ensureCapacity
		* I used the existing function ```System#arraycopy``` instead of manually copying the elements.
	* pop
		* After popping the element, I changed the value of ```storage[count]``` to 0 to show that the element has been removed
4. Do you have further questions on this knowledge point?
	* Are there times wherein we should decrease the total capacity?

## CollectionsTest
1. What is the knowledge point of the test? Where is the official document to the knowledge point?
	* Iterators
		* How to loop through them
		* How to create custom iterators
		* Navigation using ```next``` and ```previous```
		* Removing elements
	* Creating a sublist from a list references the original list
	* Documents
		* [Iterator](https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html)
		* [How to use Iterator in Java?](https://www.geeksforgeeks.org/how-to-use-iterator-in-java/)
		* [Can we write our own iterator in Java?](https://stackoverflow.com/questions/5849154/can-we-write-our-own-iterator-in-java)
		* [List](https://docs.oracle.com/javase/8/docs/api/java/util/List.html)
		* [Set](https://docs.oracle.com/javase/7/docs/api/java/util/Set.html)
2. Why the test failed at first?
	* The correct value wasn't there
3. Why you corrected the test that way?
	* createList
		* I used the ```Iterator.hasNext``` and ```Iterator.next``` as per the test constraints
	* SequenceIterator
		* Fields
			* I just used the constructor parameters ```start``` and ```end```
		* next
			* I incremented the value of ```currentIndex``` to get the next element
			* As per the test description should_create_a_sequence_without_putting_all_items_into_memory, I didn't put the entire sequence in the memory
				* Instead, I created the next sequence only when I need it
	* DistinctIterator
		* Putting all of the elements in the memory will lead to an ```OutOfMemoryError```.
		* To avoid this, I used a ```Set``` to store the elements.
		* Trying to insert an element that already exists in the ```Set``` will not do anything
4. Do you have further questions on this knowledge point?
	* When would you need to use ```iterator.hasNext()``` instead of the for each loop?
