package nioprograms;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilesWalkExample1 {

    public static void main(String[] args) throws IOException {

        Path path = Paths.get("D:\\tecknohive\\");
        System.out.println("Path is "+path);
        List<Path> paths = listFiles(path);
        //paths.forEach(x -> System.out.println(x));
        //above code is same as below
        paths.forEach(new Consumer<Path>() {
            @Override
            public void accept(Path x) {
                System.out.println(x);
            }
        });
    }

    // list all files from this path
    public static List<Path> listFiles(Path path) throws IOException {

        List<Path> result;
        try (Stream<Path> walk = Files.walk(path)) {
        /*    result = walk.filter(Files::isRegularFile)
                    .collect(Collectors.toList());
        */
            //above code is same as below

            result = walk.filter(new Predicate<Path>() {
                        @Override
                        public boolean test(Path path1) {
                            return Files.isRegularFile(path1);
                        }
                    })
                    .collect(Collectors.toList());

        }
        return result;

    }

}

class UserDef
{
                 static void fun()
                 {


                 }

                 public static void main(String...args)
                 {
                     UserDef.fun();

                 }

}


