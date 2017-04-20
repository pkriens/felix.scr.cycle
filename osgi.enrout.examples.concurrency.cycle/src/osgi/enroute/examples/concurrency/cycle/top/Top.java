package osgi.enroute.examples.concurrency.cycle.top;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;

import osgi.enroute.examples.concurrency.cycle.bottom.Bottom;

@Component(service=Top.class,immediate=true)
public class Top {

   public Top()
   {
      System.out.println("new Top()");
   }

   @Reference(cardinality=ReferenceCardinality.MULTIPLE, policy=ReferencePolicy.DYNAMIC)
   void addX( Bottom b ) {
      System.out.println("Top.bottom +=" +b);
   }
   
   void removeX(Bottom b) {
      System.out.println("Top.bottom -=" + b);
   }
	
	@Activate
	void activate() {
	   System.out.println("Top.activate()");
	}
	
	public String toString(){
	   return "<top>";
	}
}
