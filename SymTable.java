import java.util.LinkedList;
import java.util.HashMap;

class SymTable implements ISymTable {
    LinkedList<HashMap<String, Sym>> list;

    /**
     * Constructor for SymTable. Initializes the SymTable's list
     * to contain a single, empty HashMap.
     */
    public SymTable() {
        list = new LinkedList<HashMap<String, Sym>>();
        list.push(new HashMap<String, Sym>());
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
        if (name == null || sym == null) throw new IllegalArgumentException();
        if (list.isEmpty()) throw new EmptySymTableException();
        
        // add new element if the new key is unique
        HashMap<String, Sym> head = list.pop();
        if (head.containsKey(name)) {
            list.push(head);
            throw new DuplicateSymNameException();
        } else {
            head.put(name, sym);
            list.push(head);
        }
    }

    /**
     * Add a new, empty HashMap to the front of the List.
     */
    public void addScope() {
        list.push(new HashMap<String, Sym>());
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
        if (list.isEmpty()) throw new EmptySymTableException();
        HashMap<String, Sym> head = list.element();
        return head.get(name);
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
        if (list.isEmpty()) throw new EmptySymTableException();
        for (HashMap<String, Sym> map : list) {
            Sym ret = map.get(name);
            if (ret != null) return ret;
        }
        // failed to find after iterating through whole list
        return null;
    }

    /**
     * If this SymTable's list is empty, throw an EmptySymTableException; 
     * otherwise, remove the HashMap from the front of the list.
     */
    public void removeScope() throws EmptySymTableException {
        if (list.isEmpty()) throw new EmptySymTableException();
        list.pop();
    }

    /**
     * Prints the contents of the SymTable.
     */
    public void print() {
        System.out.print("\n++++ SYMBOL TABLE\n");
        for (HashMap<String, Sym> map : list)
            System.out.println(map.toString());
        System.out.print("\n++++ END TABLE\n");
    }

    public LinkedList<HashMap<String, Sym>> getList() { return list; }

    public static void main(String[] args) {
        SymTable table = new SymTable();
        System.out.println(table.list);
        System.out.println(table.list.isEmpty());
    }
}
