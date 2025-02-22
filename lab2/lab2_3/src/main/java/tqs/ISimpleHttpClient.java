package tqs;

import java.io.IOException;

public interface ISimpleHttpClient {

    String doHttpGet(String request) throws IOException;

}
