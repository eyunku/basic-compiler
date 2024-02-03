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
            // should not reach this point, should throw exception
            System.err.println("Expected IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // Expected exception
        } catch (Exception e) {
            System.err.println("Unexpected exception " +
                                e.getClass().getCanonicalName() + ".");
        }
        // check with name being null
        try {
            checkIllegalArgumentException = new SymTable();
            checkIllegalArgumentException.addDecl(null, new Sym("foo"));
            // should not reach this point, should throw exception
            System.err.println("Expected IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // Expected exception
        } catch (Exception e) {
            System.err.println("Unexpected exception " +
                                e.getClass().getCanonicalName() + ".");
        }
        // check with both being null
        try {
            checkIllegalArgumentException = new SymTable();
            checkIllegalArgumentException.addDecl(null, null);
            // should not reach this point, should throw exception
            System.err.println("Expected IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // Expected exception
        } catch (Exception e) {
            System.err.println("Unexpected exception " +
                                e.getClass().getCanonicalName() + ".");
        }

        // Test DuplicateSymNameException
        try {
            checkDuplicateSymNameException.addDecl("foo", new Sym("foo"));
            checkDuplicateSymNameException.addDecl("foo", new Sym("foo"));
            // should not reach this point, should throw exception
            System.err.println("Expected DuplicateSymNameException.");
        } catch (DuplicateSymNameException e) {
            // Expected exception
        } catch (Exception e) {
            System.err.println("Unexpected exception " +
                                e.getClass().getCanonicalName() + ".");
        }

        // Test EmptySymTableException
        try {
            checkEmptySymTableException.removeScope();
            checkEmptySymTableException.addDecl("foo", new Sym("foo"));
            // should not reach this point, should throw exception
            System.err.println("Expected EmptySymTableException.");
        } catch (EmptySymTableException e) {
            // Expected exception
        } catch (Exception e) {
            System.err.println("Unexpected exception " +
                                e.getClass().getCanonicalName() + ".");
        }

        // Test that valid addition of declaration doesn't result in exception
        try {
            validAddDeclr.addDecl("valid", new Sym("valid"));
        } catch (Exception e) {
            System.err.println("Unexpected exception " +
                                e.getClass().getCanonicalName() + ".");
        }
    }

    private static void testAddScope() {
        SymTable addScope = new SymTable();
        // ensure that addScope succeeds without errors
        try {
            addScope.addScope();
        } catch (Exception e) {
            System.err.println("Unexpected exception " +
                                e.getClass().getCanonicalName() + ".");
        }
        // ensure that an empty list is added
        try {
            // there should be two scopes after initialization & adding scope
            addScope.removeScope();
            addScope.removeScope();
        } catch (Exception e) {
            System.err.println("Unexpected exception " +
                                e.getClass().getCanonicalName() + ".");
        }
        // list should now be empty
        try {
            addScope.removeScope();
            // should not reach this point, should throw exception
            System.err.println("Expected EmptySymTableException.");
        } catch (EmptySymTableException e) {
            // Expected exception
        } catch (Exception e) {
            System.err.println("Unexpected exception " +
                                e.getClass().getCanonicalName() + ".");
        }
    }
    
    private static void testLookupLocal() {
        SymTable checkEmptySymTableException = new SymTable();
        SymTable key = new SymTable();

        // check that EmptySymTableException correctly thrown
        try {
            checkEmptySymTableException.removeScope();
            checkEmptySymTableException.lookupLocal("foo");
            // should not reach this point, should throw exception
            System.err.println("Expected EmptySymTableException.");
        } catch (EmptySymTableException e) {
            // Expected exception
        } catch (Exception e) {
            System.err.println("Unexpected exception " +
                                e.getClass().getCanonicalName() + ".");
        }

        // check that correct value is returned
        try {
            // ensure missing key returns null
            if (key.lookupLocal("foo") != null)
                System.err.println("Key 'foo' should not exist.");
            // ensure existing key returns correct object
            Sym foo = new Sym("foo");
            key.addDecl("foo", foo);
            if (key.lookupLocal("foo") != foo) {
                System.err.println("Incorrect Sym object returned.");
            }
            // ensure local scope
            key.addScope();
            if (key.lookupLocal("foo") != null) {
                System.err.println("Key is out of scope. Should be null.");
            }
        } catch (Exception e) {
            System.err.println("Unexpected exception " +
                                e.getClass().getCanonicalName() + ".");
        }
    }

    private static void testLookupGlobal() {
        SymTable checkEmptySymTableException = new SymTable();
        SymTable key = new SymTable();

        // check that EmptySymTableException correctly thrown
        try {
            checkEmptySymTableException.removeScope();
            checkEmptySymTableException.lookupGlobal("foo");
            // should not reach this point, should throw exception
            System.err.println("Expected EmptySymTableException.");
        } catch (EmptySymTableException e) {
            // Expected exception
        } catch (Exception e) {
            System.err.println("Unexpected exception " +
                                e.getClass().getCanonicalName() + ".");
        }

        // check that correct value is returned
        try {
            // ensure missing key returns null
            if (key.lookupGlobal("foo") != null)
                System.err.println("Key 'foo' should not exist.");
            // ensure existing key returns correct object
            Sym foo = new Sym("foo");
            key.addDecl("foo", foo);
            if (key.lookupGlobal("foo") != foo) {
                System.err.println("Incorrect Sym object returned.");
            }
            // ensure global scope
            key.addScope();
            if (key.lookupGlobal("foo") != foo) {
                System.err.println("Incorrect Sym object returned. May be " +
                                        "scope error.");
            }
        } catch (Exception e) {
            System.err.println("Unexpected exception " +
                                e.getClass().getCanonicalName() + ".");
        }
    }

    private static void testRemoveScope() {
        SymTable table = new SymTable();
        // remove scope that is created upon object initialization
        try {
            table.removeScope();
        } catch (Exception e) {
            System.err.println("Unexpected exception " +
                                e.getClass().getCanonicalName() + ".");
        }

        // check that EmptySymTableException thrown
        try {
            table.removeScope();
            // should not reach this point, should throw exception
            System.err.println("Expected EmptySymTableException.");
        } catch (EmptySymTableException e) {
            // Expected exception
        } catch (Exception e) {
            System.err.println("Unexpected exception " +
                                e.getClass().getCanonicalName() + ".");
        }
    }

    private static void testPrint() {
        SymTable print = new SymTable();
        try {
            print.print();
        } catch (Exception e) {
            System.err.println("Unexpected exception " +
                                e.getClass().getCanonicalName() + ".");
        }
    }

    public static void main(String[] args) {
        testConstructor();
        testAddDecl();
        testAddScope();
        testLookupLocal();
        testLookupGlobal();
        testRemoveScope();
        testPrint();
    }
}