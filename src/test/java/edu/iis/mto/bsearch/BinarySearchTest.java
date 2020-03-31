package edu.iis.mto.bsearch;

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
}
