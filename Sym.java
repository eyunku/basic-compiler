public class Sym {
    private String type;

    /**
     * Constructor for the Sym (symbol) class. Initializes Sym to have
     * the given type.
     * 
     * @param type  the type of the identifier, represented by a String.
     */
    public Sym(String type) {
        this.type = type;
    }

    /**
     * Return this Sym's type.
     * @return  the Sym's type.
     */
    public String getType() {
        return type;
    }

    // TODO: proper toString method to be implemented when the stored type is more complex
    /**
     * Return this Sym's type.
     * @return  the Sym's type.
     */
    public String toString() {
        return type;
    }
}