public class NestedIterator implements Iterator<Integer> {

    Stack<NestedInteger> stack = new Stack<>();

    public NestedIterator(List<NestedInteger> nestedList) {

        // Push from right to left
        for (int i = nestedList.size() - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        return stack.pop().getInteger();
    }

    @Override
    public boolean hasNext() {

        while (!stack.isEmpty()) {

            NestedInteger top = stack.peek();

            // If top is an integer, we are ready
            if (top.isInteger()) {
                return true;
            }

            // Otherwise, remove the nested list
            stack.pop();

            List<NestedInteger> list = top.getList();

            // Push its elements from right to left
            for (int i = list.size() - 1; i >= 0; i--) {
                stack.push(list.get(i));
            }
        }

        return false;
    }
}