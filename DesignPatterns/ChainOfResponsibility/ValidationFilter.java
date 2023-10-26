package ChainOfResponsibility;

// 具体的数据校验过滤器
public class ValidationFilter implements Filter {
    @Override
    public void doFilter(Request request, Response response, FilterChain chain) {
        // 执行数据校验逻辑
        if (request.getData().contains("Valid")) {
            response.setData("Data is valid.");
        } else {
            response.setData("Data is not valid.");
        }
    }
}
