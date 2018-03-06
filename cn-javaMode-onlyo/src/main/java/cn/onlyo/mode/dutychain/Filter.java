package cn.onlyo.mode.dutychain;

import cn.onlyo.mode.dutychain.web.Request;
import cn.onlyo.mode.dutychain.web.Response;

public interface Filter {

    void doFiler(Request request, Response response);
}
