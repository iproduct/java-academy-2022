package course.demos.io;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class NioLocking {
    static final int LENGTH = 0x8FFFFFF; // 128MB
    static FileChannel fc;

    public static void main(String[] args) {
        try {
            fc = new RandomAccessFile("test.db", "rw").getChannel();
            MappedByteBuffer out = fc.map(FileChannel.MapMode.READ_WRITE, 0, LENGTH);
            for(int i = 0; i < LENGTH; i++) {
                out.put((byte)'x');
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static class LockUpdate extends Thread {
        private ByteBuffer buff;
        private int start, end;

        public LockUpdate(ByteBuffer memoryMappedBuffer, int start, int end) {
            memoryMappedBuffer.position(start);
            memoryMappedBuffer.limit(end);
            this.buff = memoryMappedBuffer.slice();
            this.start = start;
            this.end = end;
            start();
        }
        public void run() {
            try {
                FileLock lock = fc.lock(start, end, false);
                System.out.printf("Successfully locked range [%d,%d].%n", start, end);
                // update data
                while (buff.position() < buff.limit() - 1) {
                    buff.put((byte)(buff.get() + 1));
                }
                //release file lock
                lock.release();
                System.out.printf("Successfully unlocked range [%d,%d].%n", start, end);
            } catch(IOException ex){
                ex.printStackTrace();
            }
        }
    }

}








