package cn.java8speclial.onlyo.aaa;

public class SesitiveFilter implements Filter {

	

	@Override
	public void doFilter(Request request, Response response, FilterChain chain) {
		request.requestStr = request.requestStr.replace("����ҵ", "��ҵ")
		 .replace("����", "") + "---SesitiveFilter()";
		chain.doFilter(request, response, chain);
		response.responseStr += "---SesitiveFilter()";
	
	}
	
	

}
