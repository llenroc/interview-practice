package OOD.FileSystem;

public class Entry {

    protected final long createdTime = System.currentTimeMillis();
    protected int lastModifiedTime;
    protected Directory parent;
    protected String name;

    public Entry(Directory parent, String name) {
        this.parent = parent;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setLastModifiedTime(int lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;

    }

    public void setParent(Directory parent) {
        this.parent = parent;
    }

    public long getCreatedTime() {
        return createdTime;
    }

    public int getLastModifiedTime() {
        return lastModifiedTime;
    }

    public boolean delete(){
        if(parent == null) return false;
        this.parent.deleteEntry(this);
        return true;
    }

    public Directory getParent() {
        return parent;
    }


}
