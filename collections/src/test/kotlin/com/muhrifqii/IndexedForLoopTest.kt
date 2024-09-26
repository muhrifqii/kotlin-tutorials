package com.muhrifqii

import org.junit.jupiter.api.Test

class IndexedForLoopTest {

  @Test
  fun `iterate over open-ended range`() {
    // open-ended range
    for (i in 0..<10) {
      assert(i in 0..9)
    }
    for (i in 0.rangeUntil(10)) {
      assert(i in 0..9)
    }
    // forEach function over the range object
    (0..<10).forEach { i -> assert(i in 0..9) }
    (0.rangeUntil(10)).forEach { i -> assert(i in 0..9) }
  }

  @Test
  fun `iterate over close-ended range`() {
    // close-ended range
    for (i in 0..9) {
      assert(i in 0..<10)
    }
    for (i in 0.rangeTo(9)) {
      assert(i in 0..<10)
    }
    // forEach function over the range object
    (0..9).forEach { i -> assert(i in 0..<10) }
    (0.rangeTo(9)).forEach { i -> assert(i in 0..<10) }
  }

  @Test
  fun `iterate using until`() {
    for (i in 0 until 10) {
      assert(i in 0..<10)
    }
    (0 until 10).forEach { i -> assert(i in 0..<10) }
  }

  @Test
  fun `backward iteration`() {
    for (i in (0..9).reversed()) {
      assert(i in 0..<10)
    }
    for (i in 9 downTo 0) {
      assert(i in 0..<10)
    }
    (0..9).reversed().forEach { i -> assert(i in 0..<10) }
    (9 downTo 0).forEach { i -> assert(i in 0..<10) }
  }

  @Test
  fun `iteration with step`() {
    for (i in 0 until 10 step 4) {
      assert(i in 0..8)
    }
    for (i in 9 downTo 0 step 4) {
      assert(i in 1..9)
    }
    (0 until 10 step 4).forEach { i -> assert(i in 0..8) }
    (9 downTo 0 step 4).forEach { i -> assert(i in 1..9) }
  }

  @Test
  fun `indexed-loop the index on a collection`() {
    val colors = listOf("Red", "Green", "Blue")
    for (i in colors.indices) {
      assert(colors[i] in colors)
    }
    colors.indices.forEach { i -> assert(colors[i] in colors) }
  }

  @Test
  fun `loop index and value on a collection`() {
    val colors = listOf("Red", "Green", "Blue")
    for ((i, v) in colors.withIndex()) {
      assert(v == colors[i])
    }
    colors.forEachIndexed { i, v -> assert(v == colors[i]) }
  }
}
