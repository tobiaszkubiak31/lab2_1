package edu.iis.mto.bsearch;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class BinarySearchTest {

  static private BinarySearch binarySearch;
  static int key;
  static int[] seq;

  @BeforeAll
  static void setUpVariables() {
    binarySearch = new BinarySearch();
  }

  @Test
  void elementIsInSequence_SequenceLengthOne() {
    //given
    key = 3;
    seq = new int[]{3};

    //when
    var searchResult = binarySearch.search(key, seq);

    //then
    assertTrue(searchResult.isFound());
  }

  @Test
  void elementIsNotInSequence_SequenceLengthOne() {
    key = 1;
    seq = new int[] {2};

    SearchResult searchResult = binarySearch.search(key,seq);

    assertFalse(searchResult.isFound());
  }

  @Test
  void elementIsInSequenceAsFirstInOrder_SequenceLengthMoreThanOne() {
    key = 3;
    seq = new int[] {3,4,5,6,7,8,22};

    SearchResult searchResult = binarySearch.search(key,seq);

    assertTrue(searchResult.isFound());
    assertEquals(1, searchResult.getPosition());
  }


}
