class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        if (l1 == null || l2 == null) return null
        var ln1 = l1
        var ln2 = l2
        var n1 = ""
        var n2 = ""
        while (ln1 != null) {
            n1 = ln1!!.`val`.toString() + n1
            ln1 = ln1!!.next
        }
        while (ln2 != null) {
            n2 = ln2!!.`val`.toString() + n2
            ln2 = ln2!!.next
        }
        val n = (BigDecimal(n1) + BigDecimal(n2)).toString()
        var result: ListNode? = null
        n.forEach {
            val value = String(charArrayOf(it)).toInt()
            if (null == result)
                result = ListNode(value)
            else {
                result = getnodes(value, result!!)
            }
        }
        return result
    }

    fun getnodes(value: Int, node: ListNode): ListNode {
        var result = ListNode(value)
        result.next = node
        return result
    }

    fun twoSumBetter(l1: ListNode?, l2: ListNode?): ListNode {
        var dummyHead = ListNode(0)
		var p = l1
		var q = l2
		var curr = dummyHead
        var carry = 0
        while (p != null || q != null) {
            val x = p?.`val` ?: 0
            val y = q?.`val` ?: 0
            val sum = x + y + carry
			carry = sum/10
			curr.next = ListNode(sum % 10)
			curr = curr.next
			if (p != null) p = p.next
			if (q != null) q = q.next
        }
		if (carry > 0) curr.next = ListNode(carry)
		return dummyHead.next;
    }


}