package test;

import com.google.common.truth.Truth;
import static com.google.common.truth.Truth.assertThat;
import  AList.AList;


public class testAList {

   public static void main(String[] args)
   {
      AList<Integer>  all =new AList<Integer>(10);
      for(int i=9;i>=0;i--)
      {
         all.addLast(i);
         System.out.println("AList size: "+all.size()+"  add element: "+all.getLast());
      }

      for(int i=0;i<all.size();i++)
         System.out.println(all.get(i));

   }

}
