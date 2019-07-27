package OOD.FileSystem;

import java.util.ArrayList;
import java.util.List;

public class FileSystem {
    private final Directory root;

    public FileSystem() {
        this.root = new Directory(null,"/");
    }

    public List<String> ls(String path) {

        return null;
    }

    public void mkdir(String path) {
        assert path.startsWith("/");
        List<Entry> components = resolve(path);
        if(components.get(components.size() - 1) != null){
            throw new IllegalArgumentException("Directory has already exist: " + path);
        }
        String[] arr = path.split("/");
        final String dirName = arr[arr.length - 1];
        final Directory parent = (Directory) components.get(components.size() - 2);
        Directory newDir = new Directory(parent,dirName);
        parent.addEntry(newDir);

    }

    public void addContentToFile(String path, String content) {
        List<Entry> components = resolve(path);
        if(components.get(components.size() - 1) != null){
            throw new IllegalArgumentException("File has already exist: " + path);
        }
        String fileName = path.substring(path.lastIndexOf("/") + 1);
        final Directory parent = (Directory) components.get(components.size() - 2);
        File newFile = new File(parent,fileName,0);
        parent.addEntry(newFile);

    }

    public String readContentFromFile(String filePath) {
        List<Entry> components = resolve(filePath);
        if(components.get(components.size() - 1) == null || ! (components.get(components.size() - 1)instanceof Directory) ){
            throw new IllegalArgumentException("There is no such path in the system");
        }
        Directory dir = (Directory) components.get(components.size() - 1);
        StringBuilder sb = new StringBuilder();
        for(Entry content: dir.getContents()){
            if(content instanceof File){
                sb.append(content.getName()).append(" ");
            }
        }

        return sb.toString().substring(0,sb.length() -1);
    }


    private List<Entry> resolve(String path){
        path = path.substring(1);
        String[] components = path.split("/");
        List<Entry> res= new ArrayList<>(components.length + 1);
        res.add(root);

        Entry parent = root;
        for(String component: components){
            if(parent == null || !(parent instanceof Directory)){
                throw new IllegalArgumentException("invalid path: " + path );
            }
            // 防止空string
            if(! component.isEmpty()){
                parent = ((Directory) parent).getChild(component);
                res.add(parent);
            }
        }
        return res;
    }

}
