package OOD.FileSystem;


public class File extends Entry {

    private String content;
    private int size;

    public File(Directory parent, String name,  int size) {
        super(parent, name);
        this.content = content;
        this.size = size;
    }

    public String getContent() {
        return content;
    }

    public int getSize() {
        return size;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setSize(int size) {
        this.size = size;
    }
}

