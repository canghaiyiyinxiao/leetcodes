//给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
//
//如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
//
//您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
//
//示例：
//
//输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/add-two-numbers
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
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
            carry = sum / 10
            curr.next = ListNode(sum % 10)
            curr = curr.next
            if (p != null) p = p.next
            if (q != null) q = q.next
        }
        if (carry > 0) curr.next = ListNode(carry)
        return dummyHead.next;
    }


}