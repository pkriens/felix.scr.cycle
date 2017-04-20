package osgi.enroute.examples.concurrency.cycle.log;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.log.LogReaderService;

@Component(immediate = true)
public class Logger
{
   @Reference
   void addLogReader(LogReaderService lr)
   {
      lr.addLogListener(e ->
      {
         System.out.println(e.getMessage() + " " + e.getBundle() + " " + e.getServiceReference());
         if (e.getException() != null)
            e.getException().printStackTrace(System.out);
      });
   }
}
