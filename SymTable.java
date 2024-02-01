class SymTable implements ISymTable {
    

    /**
     * Constructor for SymTable. Initializes the SymTable's List
     * to contain a single, empty HashMap.
     */
    public SymTable() {

    }

    /**
     * If this SymTable's list is empty, throw an EmptySymTableException. 
     * If either name or sym (or both) is null, throw an 
     * IllegalArgumentException. If the first HashMap in the list already 
     * contains the given name as a key, throw a DuplicateSymNameException. 
     * Otherwise, add the given name and sym to the first HashMap in the list.
     * 
     * @throws DuplicateSymNameException    if the given name is a duplicate of 
     *                                          an existing key.
     * @throws EmptySymTableException       if the SymTable's list is empty.
     * @throws IllegalArgumentException     if either name and/or sym are null.
     */
    public void addDecl(String name, Sym sym) throws DuplicateSymNameException, 
        EmptySymTableException {
        throw new UnsupportedOperationException("Unimplemented method 'addDecl'");
    }

    /**
     * Add a new, empty HashMap to the front of the List.
     */
    public void addScope() {
        throw new UnsupportedOperationException("Unimplemented method 'addScope'");
    }

    /**
     * If this SymTable's list is empty, throw an EmptySymTableException. 
     * Otherwise, if the first HashMap in the list contains name as a key, 
     * return the associated Sym; otherwise, return null.
     * 
     * @throws EmptySymTableException   if the SymTable's list is empty.
     * @return                          the Sym associated with the given key 
     *                                      in the first HashMap or null if the 
     *                                      key has no associated value.
     */
    public Sym lookupLocal(String name) throws EmptySymTableException {
        throw new UnsupportedOperationException("Unimplemented method 'lookupLocal'");
    }

    /**
     * If this SymTable's list is empty, throw an EmptySymTableException. 
     * Otherwise, if any HashMap in the list contains name as a key, return the 
     * first associated Sym; otherwise, return null.
     * 
     * @throws EmptySymTableException   if the SymTable's list is empty.
     * @return                          the Sym associated with the given key
     *                                  in the first HashMap that contains the
     *                                  key, or null if the key has no
     *                                  associated value.
     */
    public Sym lookupGlobal(String name) throws EmptySymTableException {
        throw new UnsupportedOperationException("Unimplemented method 'lookupGlobal'");
    }

    /**
     * If this SymTable's list is empty, throw an EmptySymTableException; 
     * otherwise, remove the HashMap from the front of the list.
     */
    public void removeScope() throws EmptySymTableException {
        throw new UnsupportedOperationException("Unimplemented method 'removeScope'");
    }

    /**
     * Prints the contents of the SymTable.
     */
    public void print() {
        throw new UnsupportedOperationException("Unimplemented method 'print'");
    }

    
}