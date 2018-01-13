package blobs;

import blobs.engine.Engine;
import blobs.interfaces.Blob;
import blobs.interfaces.InputReader;
import blobs.interfaces.OutputWriter;
import blobs.interfaces.Runnable;
import blobs.io.ConsoleInputReader;
import blobs.io.ConsoleOutputWriter;
import blobs.repositories.BlobRepository;
import blobs.repositories.Repository;
import blobs.utility.MutableBoolean;

public class Main {
    public static void main(String[] args) {
        InputReader reader = new ConsoleInputReader();
        OutputWriter writer = new ConsoleOutputWriter();
        Repository<Blob> blobRepository = new BlobRepository<>();
        MutableBoolean flag = new MutableBoolean();
        Runnable engine = new Engine(reader, writer, blobRepository, flag);

        engine.run();
    }
}
