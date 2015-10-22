package com.intercom.interview.flattener;

import static org.junit.Assert.*;

import org.junit.Test;

class StandardImplementationTest {

	@Test
	public void testGroovyDefaultFlattenWorksOutOfTheBoxAsWeWantForLists() {
		assert [].flatten().isEmpty()
		assert [1].flatten() == [1]
		assert [1, 2, 3].flatten() == [1, 2, 3]
		assert [1, [2, 3], 4].flatten() == [1, 2, 3, 4]
		assert [1, [2, [3, 4, [5]], [6, 7, [8]], [9, 10]], [11, 12, 13]].flatten() == [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13]
	}

	@Test
	public void testGroovyDefaultFlattenDoesEvenMoreThanWhatWeDesire() {
		assert [1, [2, [3]], [4] as Set].flatten() == [1, 2, 3, 4]
		assert [1, [2, [3]], [4:5] as Map].flatten() == [1, 2, 3, [4:5]]
		assert [1, "2", 3.14, false].flatten() == [1, "2", 3.14, false]
		assert [1, "2", [3.14, false], 5].flatten() == [1, "2", 3.14, false, 5]
	}

}
