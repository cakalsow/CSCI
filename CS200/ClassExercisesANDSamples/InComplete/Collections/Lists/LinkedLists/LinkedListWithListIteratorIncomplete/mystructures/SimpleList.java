package mystructures;
public interface SimpleList <E>  extends Iterable<E> {
  public int size() ;
  public String toString();
  public boolean contains(E element);
  public void append(E inElement);
  public E get(int index);
}