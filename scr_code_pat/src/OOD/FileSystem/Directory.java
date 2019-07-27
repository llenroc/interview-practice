package OOD.FileSystem;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Directory extends Entry{
    private List<Entry> contents;

    public Directory(Directory parent, String name) {
        super(parent, name);
    }

    public List<Entry> getContents() {
        return contents;
    }

    public List<Entry> getAllFile(){
        List<Entry> res= new ArrayList<>();
        Queue<Entry> q = new LinkedList<>();
        q.offer(this);

        while(!q.isEmpty()){
            Entry cur = q.poll();
            for(Entry each: contents){
                if(each instanceof Directory){
                    q.offer(each);
                } else{
                    res.add(each);
                }
            }
        }
        return res;
    }

    public boolean isEmpty(){
        return contents.size() == 0;
    }

    public Entry getChild(String name){

        for(Entry component: contents){
            if(component.name.equals(name)){
                return component;
            }
        }
        return null;
    }

    public int numberOfFiles(){
        int count = 0;
        for(Entry each: contents){
            if(each instanceof Directory){
                count++;
                count += ((Directory) each).numberOfFiles();
            }else if (each instanceof File){
                count++;
            }
        }
        return count;
    }

    public boolean deleteEntry(Entry e){
//        for(int i = 0; i < contents.size(); i++){
//            if(contents.get(i).name.equals(e.name)){
//                contents.remove(i);
//                return true;
//            }
//        }
//        return false;
        return contents.remove(e);
    }

    public void addEntry(Entry e){
        contents.add(e);
    }
}
