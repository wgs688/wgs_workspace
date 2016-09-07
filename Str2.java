package light_app;

import java.util.HashSet;
import java.util.Set;

public class Str2 {
	
	private Set parseStr(String regrex) throws Exception{
		Set set = new HashSet();
		if(null == regrex || "".equals(regrex)){
			throw  new Exception("不能填null或者空字符串!");
		}
		String trimedRegrex = regrex.trim();
		String[] splitedRegrex = trimedRegrex.split(",");
		if(splitedRegrex.length >1){
			for(int i = 0;i< splitedRegrex.length;i++){
				if(splitedRegrex[i]!=null&&splitedRegrex[i]!=""){
					set.add(splitedRegrex[i]);
				}
			}
			return set;
		}
		int index = trimedRegrex.indexOf("...");
		if(index >= 1){
			String leftStr = trimedRegrex.substring(0, index);
			String rightStr = trimedRegrex.substring(index+3);
			boolean isWrongFormat = (leftStr==null)||(leftStr=="")||(rightStr==null)||(rightStr=="")||leftStr.length()!=rightStr.length();
			if(isWrongFormat){
				throw new Exception("左边字符串...右边字符串 中左边字符串和右边字符串不能为null或者空字符串并且长度需相等！");
			}
			int leftLastNum = getLastChar(leftStr);
			int rightLastNum = getLastChar(rightStr);
			String leftStrChars = leftStr.substring(0, leftLastNum);
			String rightStrChars = rightStr.substring(0, rightLastNum);
			isWrongFormat = (leftLastNum==leftStr.length())||(rightLastNum==rightStr.length()||(!leftStrChars.equals(rightStrChars)));
			if(isWrongFormat){
				throw new Exception("如AA012...AA021该格式字符串...左右两边部分字母要相同(数字位数也要相同)");
			}
			String leftNum = leftStr.substring(leftLastNum);
			String rightNum = rightStr.substring(rightLastNum);
			if(Integer.parseInt(leftNum)>Integer.parseInt(rightNum)){
				throw new Exception("如AA012...AA020该格式字符串...右边数字部分要大于左边部分");
			}
		    int n = leftNum.length() - (Integer.parseInt(leftNum)+"").length();
		    if(n==0){//代表数字前面没有0
		    	int k = Integer.parseInt(rightNum);
		    	for(int i=Integer.parseInt(leftNum);i<k;i++){
		    		set.add(i+"");
		    	}
		    	return set;
		    }
		    int len = leftNum.length();
		    String temp = "";
		    for(int i = Integer.parseInt(leftNum);i<=Integer.parseInt(rightNum);i++){
		    	temp += i;
		    	if(temp.length()<len){
		    		System.out.println(getZero(len-temp.length())+temp);
		    		set.add(getZero(len-temp.length())+temp);
		    	}else{
		    		System.out.println(temp);
		    		set.add(temp);
		    	}
		    	temp = "";
		    }
		    return set;
		}
		set.add(regrex);
		return set;
	}
	
	private String getZero(int n){
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<n;i++){
			sb.append("0");
		}
		return sb.toString();
	}
	
	private int getLastChar(String str){
		int index = 0;
		for(int i=str.length()-1;i>=0;i--){
			if(str.charAt(i)<47||str.charAt(i)>57){
				 index = i+1;
				 break;
			}
		}
		return index;
	}
	
	public static void main(String[] args) throws Exception {
		new Str2().parseStr("b010..b120");
	}
}
