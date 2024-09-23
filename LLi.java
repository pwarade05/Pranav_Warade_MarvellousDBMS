import java.util.*;


public class LLi 
{
    public static void main(String[] args) 
    {
      LinkedList <Integer>lobj = new LinkedList<Integer>();

      lobj.add(11);
      lobj.add(21);
      lobj.add(31);
      lobj.add(244);

      System.out.println(lobj);
      System.out.println("Number of elements : "+lobj.size());

      lobj.remove(2);

      System.out.println(lobj);
      System.out.println("Number of elements : "+lobj.size());

      for(int no : lobj)
      {
        System.out.println(no);
      }
    }
}