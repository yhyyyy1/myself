package ChainOfResponsibility;

import java.util.ArrayList;
import java.util.List;

// 具体的字符编码转换过滤器
public class EncodingFilter implements Filter {
    @Override
    public void doFilter(Request request, Response response, FilterChain chain) {
        // 执行字符编码转换逻辑
        request.setData(request.getData() + " (Encoded)");
        chain.doFilter(request, response);
    }
}

