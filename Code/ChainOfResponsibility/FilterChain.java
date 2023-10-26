package ChainOfResponsibility;

import java.util.ArrayList;
import java.util.List;

// FilterChain 类来管理数据过滤器的执行顺序
public class FilterChain {
    private List<Filter> filters = new ArrayList<>();
    private int index = 0;

    public void addFilter(Filter filter) {
        filters.add(filter);
    }

    public void doFilter(Request request, Response response) {
        if (index < filters.size()) {
            Filter filter = filters.get(index);
            index++;
            filter.doFilter(request, response, this);
        }
    }
}
