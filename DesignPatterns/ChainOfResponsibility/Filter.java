package ChainOfResponsibility;

// Filter 接口定义了数据过滤器的处理方法
public interface Filter {
    void doFilter(Request request, Response response, FilterChain chain);
}
