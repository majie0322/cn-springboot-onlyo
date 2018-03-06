//package cn.onlyo.mode.dutychain;
//
//public class Main {
//
//    public static void main(String[] args) {
//        String msg = "大家好 :); <>敏感 测试一下 今天的天气的是真的好 ";
//
//        MsgProcess0r mp = new MsgProcess0r();
//        mp.setMsg(msg);
//
//        FilterChain fc1 = new FilterChain();
//        fc1.addFilters(new HTMLFilter()).addFilters(new FaceFilter());
//
//        FilterChain fc2 = new FilterChain();
//        fc2.addFilters(new SesFilter());
//        fc1.addFilters(fc2);
//        mp.setFilterChain(fc1);
//        String result = mp.process();
//        System.out.println(result);
//    }
//}
