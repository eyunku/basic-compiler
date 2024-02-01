import java.util.*;

class TestSymTable {
    private static void testConstructor() {
        try {
            SymTable symTable = new SymTable();
            try {
                if (symTable.lookupLocal("foo") != null)
                    System.err.println("HashMap was not empty.");
            } catch (Exception EmptySymTableException) {
                System.err.println("Constructor did not initialize with " + 
                                        "empty HashMap.");
            }
        } catch (Exception e) {
            System.err.println("Unexpected exception " + 
                                e.getClass().getCanonicalName() + ".");
        }
    }

    private static void testAddDecl() {
        SymTable checkIllegalArgumentException = new SymTable();
        SymTable checkDuplicateSymNameException = new SymTable();
        SymTable checkEmptySymTableException = new SymTable();
        SymTable validAddDeclr = new SymTable();
        
        // Test IllegalArgumentException
        // check with sym being null
        try {
            checkIllegalArgumentException.addDecl("foo", null);
        } catch (IllegalArgumentException e) {
            // Expected exception
        } catch (Exception e) {
            System.err.println("Unexpected exception " +
                                e.getClass().getCanonicalName() + ".");
        }
        // check with name being null
        try {
            checkIllegalArgumentException.addDecl(null, new Sym("foo"));
        } catch (IllegalArgumentException e) {
            // Expected exception
        } catch (Exception e) {
            System.err.println("Unexpected exception " +
                                e.getClass().getCanonicalName() + ".");
        }
        // check with both being null
        try {
            checkIllegalArgumentException.addDecl(null, null);
        } catch (IllegalArgumentException e) {
            // Expected exception
        } catch (Exception e) {
            System.err.println("Unexpected exception " +
                                e.getClass().getCanonicalName() + ".");
        }
    }
    
    public static void main(String[] args) {
        testConstructor();

    }
}