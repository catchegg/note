package solution;

import java.util.Stack;

/**
 * @author catchegg
 * @project nowcoder
 * @datetime 2020/3/19 14:19
 */
public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    //当插入时，直接插入 stack1
    //当弹出时，当 stack2 不为空，弹出 stack2 栈顶元素，如果 stack2 为空，将 stack1 中的全部数逐个出栈入栈 stack2，再弹出 stack2 栈顶元素
    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if(stack2.isEmpty()) {
            while(!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public int minNumberInRotateArray(int [] array) {
        if(array == null || array.length == 0) {
            return 0;
        }
        int low = 0;
        int high = array.length - 1;
        int mid;
        while(low < high) {
            if(array[high] >= array[low]) {
                return array[low];
            }
            mid = low + (high - low) / 2;
            if(array[mid] > array[low]) {
                low = mid + 1;
            } else if(array[mid] < array[high]) {
                high = mid;
            } else {
                low++;
            }
        }
        return array[low];
    }

}
