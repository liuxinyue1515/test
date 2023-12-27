import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class IOClass {
    public static void main(String[] args) throws IOException, URISyntaxException {
        System.out.println("用户目录为: " + System.getProperty("user.dir"));
        System.out.println("文件行结束符: " + System.getProperty("line.separator"));
        System.out.println("文件分隔符为: " + File.separator);
        System.out.println(System.getProperty("user.dir") + File.separator);

        // BufferInputStream将字节流放入缓存中, 读取可以从缓存中读
        DataInputStream dataInputStream = new DataInputStream(new BufferedInputStream(new FileInputStream("test.bat")));

        // 可推回流
        PushbackInputStream pushbackInputStream = new PushbackInputStream(new BufferedInputStream(new FileInputStream("test.xx")));
        DataInputStream dataInputStream1 = new DataInputStream(pushbackInputStream);
        int read = pushbackInputStream.read();
        if (read != '<') pushbackInputStream.unread(read);

        // Zip流
        ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream("e.zip"));

        // 字符流
        // 选定编码
        InputStreamReader inputStreamReader = new InputStreamReader(System.in, StandardCharsets.UTF_8);

        // 文本输出
        PrintWriter printWriter = new PrintWriter("xx.txt", StandardCharsets.UTF_8);
        printWriter.println("1");

        // 开启autoFlush 调用println时会自动冲刷缓冲区
        // PrintWriter自带缓冲区
        new PrintWriter(new OutputStreamWriter(
                new FileOutputStream("xx.txt"),
                StandardCharsets.UTF_8), true);

        // 读入文本
        Files.readString(Path.of(new URI("xx")), StandardCharsets.UTF_8);
        Files.readAllLines(Path.of(new URI("xx")), StandardCharsets.UTF_8);
        Files.lines(Path.of(new URI("xx")), StandardCharsets.UTF_8);
            // Files其他操作
        Path path = Paths.get("");
        Files.writeString(path,  "content", StandardCharsets.UTF_8);
        Files.write(path,  "content".getBytes(StandardCharsets.UTF_8),
                StandardOpenOption.APPEND);
        Files.newInputStream(path);
        Files.newOutputStream(path);
        Files.newBufferedReader(path);
        Files.newBufferedWriter(path);

        // scanner nextInt...
        Scanner scanner = new Scanner(new FileInputStream("xx"), "UTF-8");

        // 早期读入文本的做法
        InputStream inputStream = new FileInputStream("xx");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        String line;
        while ((line = bufferedReader.readLine()) != null) {

        }

        // 随机访问文件
        new RandomAccessFile("xx","r"); // 读
        new RandomAccessFile("xx","rw"); // 写

        //Zip
        new ZipInputStream(new FileInputStream("xx"));
        new ZipOutputStream(new FileOutputStream("xx"));

        // 对象序列化
        new ObjectInputStream(new FileInputStream("xx"));
        new ObjectOutputStream(new FileOutputStream("xx"));

        // 利用对象序列化克隆对象

        // 操作文件 Paths and Files
    }

    // 编码
    public void encoding() {
        Charset.defaultCharset(); // 平台使用的编码方式
        Charset.availableCharsets(); // 所有可用的编码
        Charset.forName("Shift-JIS"); // 加载其他编码
        new String(new byte[]{}, StandardCharsets.UTF_8);
    }
}
