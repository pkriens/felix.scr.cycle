package osgi.enroute.examples.concurrency.cycle.bottom;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import osgi.enroute.examples.concurrency.cycle.top.Top;

@Component(service = Bottom.class, immediate = true)
public class Bottom
{

   public Bottom()
   {
      System.out.println("new Bottom()");
   }

   @Reference
   void setTop(Top top)
   {
      System.out.println("Bottom.top="+top);
   }

   @Activate
   void activate()
   {
      System.out.println("Bottom.activate()");
   }

   public String toString(){
      return "<bottom>";
   }
}
