package HelloWorld

object Solution {
  def main(args: Array[String]): Unit = {
    val index = searchInsert(Array(1, 3,5,6), 2)
    println(index)
  }

  def searchInsert(nums: Array[Int], target: Int) = {
    if (nums.length > 0) {
      val index = nums.indexOf(target)
      if (index > -1) index
      else {
        val (num ,inc) = dichotomy(target, nums)
        val index = nums.indexOf(num)
        index + inc
      }
    }
    else 0
  }

  def dichotomy(x: Int, nums: Array[Int]): (Int, Int) = {
    val length = nums.length
    val half: Int = scala.math.floor(length / 2).toInt

    if (x < nums.head) {
      (nums.head, 0)
    } else if (x > nums.last) {
      (nums.last,1)
    } else if (x < nums(half - 1)) {
      val firstHalf = nums.slice(0, half)
      dichotomy(x, firstHalf)
    } else {
      val lasthalf = nums.slice(half, length)
      dichotomy(x, lasthalf)
    }
  }

}
