package cn.enjoy.netty.aio;

public class AioClient {

    private static AioClientHandler clientHandler;

    public static void start(){
        if (clientHandler != null) {
            return;
        }
        clientHandler = new AioClientHandler("", 6379);
    }

}
