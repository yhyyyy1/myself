package ChainOfResponsibility;

// 主应用程序
public class Main {
    public static void main(String[] args) {
        Request request = new Request("Sample Data");
        Response response = new Response();

        // 创建过滤器和过滤器链
        Filter encodingFilter = new EncodingFilter();
        Filter dataTypeFilter = new DataTypeFilter();
        Filter validationFilter = new ValidationFilter();

        FilterChain filterChain = new FilterChain();
        filterChain.addFilter(encodingFilter);
        filterChain.addFilter(dataTypeFilter);
        filterChain.addFilter(validationFilter);

        // 执行过滤器链
        filterChain.doFilter(request, response);

        // 处理后的数据
        String processedData = response.getData();
        System.out.println("Processed Data: " + processedData);
        System.out.println("Processed Data: Sample Data (Encoded) (Data Type Converted) (Data is valid.)\n");
    }
}
