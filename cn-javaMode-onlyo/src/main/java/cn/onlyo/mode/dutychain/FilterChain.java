package cn.onlyo.mode.dutychain;

import cn.onlyo.mode.dutychain.web.Request;
import cn.onlyo.mode.dutychain.web.Response;

import java.util.ArrayList;
import java.util.List;

public class FilterChain implements Filter {

    List<Filter> filters = new ArrayList<>();

    public FilterChain addFilters(Filter f) {
        this.filters.add(f);
        return this;
    }

    @Override
    public void doFiler(Request req, Response res) {
        for (Filter f : filters) {
            f.doFiler(req, res);
        }
    }
}
