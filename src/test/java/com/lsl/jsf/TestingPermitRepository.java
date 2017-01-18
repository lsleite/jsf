//Workaround for testing classes that accesses DBs
//Subclasse and Override method

public class TestingPermitRepository extends PermitRepository
 {
     private Map permits = new HashMap();
 
     public void addAssociatedPermit(PermitNotice notice, permit) {
         permits.put(notice, permit);
     }
 
     public Permit findAssociatedPermit(PermitNotice notice) {
         return (Permit)permits.get(notice);
     }
 }