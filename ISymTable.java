public interface ISymTable {
    public SymTable();
    public void addDecl(String name, Sym sym) throws DuplicateSymNameException, EmptySymTableException;
    public void addScope();
    public Sym lookupLocal(String name) throws EmptySymTableException;
    public Sym lookupGlobal(String name) throws EmptySymTableException;
    public void removeScope() throws EmptySymTableException;
    public void print();
}