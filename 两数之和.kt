class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val num1s = nums.filter { 1 and it == 1  }
        val num2s = nums.filter { 1 and it == 0  }
        if (1 and target ==1){
            num1s.forEach {num1->
                val num2 = num2s.filter { it == target - num1 }
                if (num2.isNotEmpty()) return intArrayOf(nums.indexOf(num1),nums.indexOf(num2.first()))
            }
            return intArrayOf()
        }else{
            num1s.forEachIndexed { indexNum, num ->
                val numO = num1s.filterIndexed { index, i ->
                    indexNum != index && i == target - num
                }

                if (numO.isNotEmpty()) {
                    if (numO.first()== num){
                        return intArrayOf(nums.indexOf(num),nums.lastIndexOf(numO.first()))
                    }else{
                        return intArrayOf(nums.indexOf(num),nums.indexOf(numO.first()))
                    }
                }

            }
            num2s.forEachIndexed { indexNum, num ->
                val numO = num2s.filterIndexed { index, i ->
                    indexNum != index && i == target - num
                }
                if (numO.isNotEmpty()) {
                    if (numO.first()== num){
                        return intArrayOf(nums.indexOf(num),nums.lastIndexOf(numO.first()))
                    }else{
                        return intArrayOf(nums.indexOf(num),nums.indexOf(numO.first()))
                    }
                }
            }
            return intArrayOf()
        }
    }
	
	fun twoSumBetter(nums: IntArray, target: Int): IntArray {
        var map = hashMapOf<Int,Int>()
        nums.forEachIndexed { index, i ->
            val result = target - i
            if (map.containsKey(result)) return intArrayOf(index,map[result]!!)
            map.put(i, index);
        }
        return intArrayOf()
    }
}