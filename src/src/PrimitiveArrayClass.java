public class PrimitiveArrayClass {
    public int[] integers;

    public PrimitiveArrayClass(int[] integers) {
        this.integers = integers.clone();
    }

    public PrimitiveArrayClass(PrimitiveArrayClass obj) {
        this.integers = obj.getIntegers().clone();
    }

    public int[] getIntegers() {
        return integers;
    }

    public int getLength() {
        return integers.length;
    }
}
