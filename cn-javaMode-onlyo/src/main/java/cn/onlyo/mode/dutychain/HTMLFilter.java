package cn.onlyo.mode.dutychain;

import cn.onlyo.mode.dutychain.web.Request;
import cn.onlyo.mode.dutychain.web.Response;

public class HTMLFilter implements Filter {

    @Override
    public void doFiler(Request request, Response response) {
        request.requestStr = request.requestStr.replace('<', '[').replace('>', ']') + "---HTMLFilter()";
        response.responseStr += "---HTMLFilter()";
    }

}
