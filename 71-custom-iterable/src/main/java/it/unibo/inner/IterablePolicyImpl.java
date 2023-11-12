package it.unibo.inner;
import java.util.Arrays; 
import java.util.Iterator; 
import java.util.function.Predicate;
import it.unibo.inner.api.IterableWithPolicy;

public class IterableWithPolicyImpl<T>implements
IterableWithPolicy<T> {
    private final T[] elOFArray;
    private Predicate<T> filtering;
    public IterableWithPolicyImpl(T[] elements){
        this(elements, new Predicate<T>() {
            public boolean test(T arg0) {
                return true;
}
}); 
}
    public IterableWithPolicyImpl(T[] elements, Predicate<T>
predicate){
        this.elOFArray = Arrays.copyOf(elements,
elements.length);
        this.filtering = predicate;
    }
    private int getArraySize(){
        return this.elOFArray.length;
}
    private T getElementByIndex(int index){
        return this.elOFArray[index];
}
    private class SimpleIterator implements Iterator<T>{
        private int counter;
        private T current;
        private boolean exist;
        public SimpleIterator(){
            this.counter = -1;

}
        private void incrCounter(){
            this.counter++;
}
        public boolean hasNext() {
            exist = true;
            this.incrCounter();
            if(counter >=
IterableWithPolicyImpl.this.getArraySize()){
                return false;
            }
            current =
IterableWithPolicyImpl.this.getElementByIndex(counter);
            if(!
IterableWithPolicyImpl.this.filtering.test(current)){
                exist = this.hasNext();
            }
            return exist;
        }
        public T next() {
            return current;
}
        public void remove(){}
    }
    public Iterator<T> iterator() {
        return new SimpleIterator();
    }
    public void setIterationPolicy(Predicate<T> filter) {
        this.filtering = filter;
    }
}