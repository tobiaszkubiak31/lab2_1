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
    assertThat(searchResult.isFound(), is(true));
  }

  @Test
  void elementIsNotInSequence_SequenceLengthOne() {
    key = 1;
    seq = new int[] {2};

    SearchResult searchResult = binarySearch.search(key,seq);

    assertThat(searchResult.isFound(), is(false));
  }

  @Test
  void elementIsInSequenceAsFirstInOrder_SequenceLengthMoreThanOne() {
    key = 3;
    seq = new int[] {3,4,5,6,7,8,22};

    SearchResult searchResult = binarySearch.search(key,seq);

    assertThat(searchResult.isFound(), is(true));
    assertThat(searchResult.getPosition(), is(1));
  }

  @Test
  void elementIsInSequenceAsLastInOrder_SequenceLengthMoreThanOne() {
    key = 22;
    seq = new int[] {1,4,6,12,15,21,22};

    SearchResult searchResult = binarySearch.search(key,seq);

    assertThat(searchResult.isFound(), is(true));
    assertThat(searchResult.getPosition(), is(seq.length));
  }

  @Test
  void elementIsInSequenceAsMiddleInOrder_SequenceLengthMoreThanOne() {
    key = 6;
    seq = new int[] {3,4,5,6,7,8,22,31};

    SearchResult searchResult = binarySearch.search(key,seq);

    assertThat(searchResult.isFound(), is(true));
    assertThat(searchResult.getPosition(), is(seq.length/2));
  }


  @Test
  void elementIsNotInSequence_SequenceLengthMoreThanOne() {
    key = 40;
    seq = new int[] {3,4,5,6,7,8,22,31};

    SearchResult searchResult = binarySearch.search(key,seq);

    assertThat(searchResult.isFound(), is(false));
  }


}
