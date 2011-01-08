package vitry.primitive;


public class IntStack
    {
        public int push(int v) {
            ensureCapacity(v * 2);
            values[++top] = v;
            return v;
        }

        public int pop() {
            if (top < 0) throw new IndexOutOfBoundsException();
            return values[top--];
        }

        public int peek() {
            if (top < 0) throw new IndexOutOfBoundsException();
            return values[top];
        }

        private void ensureCapacity(int size) {
            if (values.length < size) {
                int[] old = values;
                values = new int[size];
                System.arraycopy(old, 0, values, 0, old.length);
            }
        }

        private int[] values = new int[24];

        private int top = -1;
    }