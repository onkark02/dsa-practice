package threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ExampleRunner {

    private List<String> getPathResources(String path){
        List<String> pathResources = new ArrayList<>();

        int count = 0;
        for(int index = path.indexOf('/'); index != -1;){
            count++;
            if(count > 2){
                pathResources.add(path.substring(0,index));
            }
            index = path.indexOf('/', index+1);
        }
        for (String str:
                pathResources) {
            System.out.println(Thread.currentThread().getName() + "Path: "+ str);
        }
        return pathResources;
    }

    public CompletableFuture<List<String>> getResourcePaths(String path){
        return  CompletableFuture.supplyAsync( ()-> getPathResources(path));
    }
}
