package Service;

/**
 * 服务端接口的实现
 */
public class EchoServiceImpl implements EchoService {


    @Override
    public String echo(String ping) {
        return ping != null ? ping + "--> I am ok." : "I am ok";
    }
}
