import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class Commands {

    Path curDir;

    public void ls() throws IOException {
        List<Path> list;
        Stream<Path> stream = Files.walk(curDir, 1);
        list = stream.collect(Collectors.toList());
        for (Path x : list) {
            if (x.getFileName().toString().startsWith("."))
                continue;
            if (!x.equals(curDir))
                System.out.println(x.getFileName() + " " + Files.size(x) + " KB");

        }
    }

    public void cd(Path newPath) throws IOException {
        Path sumOfPaths = Paths.get(this.getCurDir().toString() + "/" + newPath.toString());
        if (Files.exists(sumOfPaths) && Files.isDirectory(sumOfPaths)) {
            this.setCurDir(sumOfPaths.normalize());
            System.out.println(this.getCurDir());
        }
        else
            System.out.println("Wrong path");
    }

    public void mv(Path srcP, Path destP) throws IOException {
        Path tmpS = Paths.get(this.getCurDir() + "/" + srcP).normalize();
        Path tmpD = Paths.get(this.getCurDir() + "/" + destP).normalize();

        if (Files.isRegularFile(tmpS)) {
            if (Files.isDirectory(tmpD))
                tmpD = Paths.get(tmpD + "/" + tmpS.getFileName());
            Files.move(tmpS, tmpD, REPLACE_EXISTING);
        }
        else
            System.out.println("Wrong source file path");

    }

    public Commands(Path curDir) {
        System.out.println(curDir);
        if (!Files.exists(curDir)) {
            try {
                Files.createDirectory(curDir);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        this.curDir = curDir;
    }

    public Path getCurDir() {
        return curDir;
    }

    public void setCurDir(Path curDir) {
        this.curDir = curDir;
    }
}
