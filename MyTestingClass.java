// --- PART 1.2: TESTING CLASS ---
class MyTestingClass {
    private int id;

    public MyTestingClass(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + id; // Tuning for uniform distribution
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj instanceof MyTestingClass other) return this.id == other.id;
        return false;
    }
}
