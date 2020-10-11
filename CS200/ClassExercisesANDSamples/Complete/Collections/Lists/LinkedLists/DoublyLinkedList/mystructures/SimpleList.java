package mystructures;
public interface SimpleList <E>  extends Iterable<E> {
  public int size() ;
  public String toString();
  public boolean contains(E element);
  public void append(E inElement);
  public boolean remove(E outElement);
  public E get(int index);
  public String toStringReverse();
  public int indexOf(E element);
  public void appendAll(SimpleList<E> otherList);
  public boolean isSubList(SimpleList<E> potentialSubList); 
}
