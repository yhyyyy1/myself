package ChainOfResponsibility;

// 具体的数据类型转换过滤器
public class DataTypeFilter implements Filter {
    @Override
    public void doFilter(Request request, Response response, FilterChain chain) {
        // 执行数据类型转换逻辑
        request.setData(request.getData() + " (Data Type Converted)");
        chain.doFilter(request, response);
    }
}
