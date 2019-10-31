package com.xr.util;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.swing.JSlider;

import com.xr.entity.JL;

public class Number {
	
	
	
	
	/**
	 * 计算Jl中检测合格人数，合格项目大于5则合格
	 * @param jls
	 * @return
	 */
	public static Map<String, int[]> qualifiedPersons(List<JL> jls) {
		int currentMaxDays = DataUtil.getCurrentMonthDay();
		Map<String, int[]> maps=new HashMap<String, int[]>();
		int[] ints=new int[currentMaxDays];
		int[] bjg=new int[currentMaxDays];
		for (int i = 0; i < jls.size(); i++) {
			JL jl = jls.get(i);
			int js=0;
			//按年龄成年人否则未成年人
			if(jls.get(i).getCids().getCage()>=18){
				//满足醇成人:2.9～6.0mmol/L
				if(Double.valueOf(jl.getDgc())>=2.9&&Double.valueOf(jl.getDgc())<=6.0){
					++js;
				}
			}else{
				//满足儿童:3.1～5.2mmol/L
				if(Double.valueOf(jl.getDgc())>=3.1&&Double.valueOf(jl.getDgc())<=5.2){
					++js;
				}
			}
			//收缩压标准90~140毫米汞柱
			if(Double.valueOf(jl.getSsy())>=90&&Double.valueOf(jl.getSsy())<=140){
				++js;
			}
			//舒张压标准60~90mmHg(12kpa)	
			if(Double.valueOf(jl.getSzy())>=60&&Double.valueOf(jls.get(i).getSzy())<=90){
				++js;
			}
			//血糖标准3.9～6.1毫摩尔/升
			if(Double.valueOf(jl.getXtang())>=3.9&&Double.valueOf(jl.getXtang())<=6.1){
				++js;
			}
			//甘油三脂标准<1.70mmol/L
			if(Double.valueOf(jl.getGysc())<1.70){
				++js;
			}
			if(js>=5){
				ints[Integer.valueOf(DataUtil.getDataDay(jl.getTime()))]++;
				continue;
			}
			//血红蛋白标准
			//成年标准
			if(jl.getCids().getCage()>=18){
				//男性标准
				if(jls.get(i).getCids().getCsex().equals("男")){
					if(Double.valueOf(jl.getXhdb())>=120&&Double.valueOf(jl.getXhdb())<=160){
						++js;
					}
				//女性标准
				}else{
					if(Double.valueOf(jl.getXhdb())>=110&&Double.valueOf(jl.getXhdb())<=150){
						++js;
					}
				}
			//未成年标准
			}else{
				if(Double.valueOf(jl.getXhdb())>=110&&Double.valueOf(jl.getXhdb())<=160){
					++js;
				}
			}
			//判断合格数
			if(js>=5){
				ints[Integer.valueOf(DataUtil.getDataDay(jl.getTime()))]++;
				continue;
			}
			//血尿酸标准80~420
			if(Double.valueOf(jl.getXnc())>=80&&Double.valueOf(jl.getXnc())<=420){
				++js;
			}
			//判断合格数
			if(js>=5){
				ints[Integer.valueOf(DataUtil.getDataDay(jl.getTime()))]++;
				continue;
			}
			//血酮标准0.02-0.27
			if(Double.valueOf(jl.getXton())>=0.02&&Double.valueOf(jl.getXton())<=0.27){
				++js;
			}
			if(js>=5){
				ints[Integer.valueOf(DataUtil.getDataDay(jl.getTime()))]++;
				continue;
			}
			if(js<5){
				bjg[Integer.valueOf(DataUtil.getDataDay(jl.getTime()))]++;
			}
		}
		System.out.println(currentMaxDays);
		System.out.println(ints.length);
		maps.put("pass", ints);
		maps.put("nopass", bjg);
		return maps;
	}
	/**
	 * 计算Jl中检测合格人数，合格项目大于5则合格(未封装)
	 * @param <T>
	 * @param jls
	 * @return
	 */
	public static Map<String, int[]> qualifiedPersonsDB(List<Map<String, String>> jls) {
		int currentMaxDays = DataUtil.getCurrentMonthDay();
		Map<String, int[]> maps=new HashMap<String, int[]>();
		int[] ints=new int[currentMaxDays];
		int[] bjg=new int[currentMaxDays];
		for (int i = 0; i < jls.size(); i++) {
			Map<String, String> a = jls.get(i);
			int js=0;
			//按年龄成年人否则未成年人
			if(Integer.valueOf(a.get("age"))>=18){
				//满足胆固醇醇成人:2.9～6.0mmol/L
				if(Double.valueOf(a.get("dgc"))>=2.9&&Double.valueOf(a.get("dgc"))<=6.0){
					++js;
				}
			}else{
				//满足胆固醇儿童:3.1～5.2mmol/L
				if(Double.valueOf(a.get("dgc"))>=3.1&&Double.valueOf(a.get("dgc"))<=5.2){
					++js;
				}
			}
			//收缩压标准90~140毫米汞柱
			if(Double.valueOf(a.get("ssy"))>=90&&Double.valueOf(a.get("ssy"))<=140){
				++js;
			}
			//舒张压标准60~90mmHg(12kpa)	
			if(Double.valueOf(a.get("szy"))>=60&&Double.valueOf(a.get("szy"))<=90){
				++js;
			}
			//血糖标准3.9～6.1毫摩尔/升
			if(Double.valueOf(a.get("xtang"))>=3.9&&Double.valueOf(a.get("xtang"))<=6.1){
				++js;
			}
			//甘油三脂标准<1.70mmol/L
			if(Double.valueOf(a.get("gysz"))<1.70){
				++js;
			}
			if(js>=5){
				ints[Integer.valueOf(DataUtil.getDataDay(DataUtil.formatString(a.get("time"))))]++;
				continue;
			}
			//血红蛋白标准
			//成年标准
			if(Integer.valueOf(a.get("age"))>=18){
				//男性标准
				if(a.get(13).toString().equals("男")){
					if(Double.valueOf((String) a.get(6))>=120&&Double.valueOf((String) a.get(6))<=160){
						++js;
					}
				//女性标准
				}else{
					if(Double.valueOf((String) a.get(6))>=110&&Double.valueOf((String) a.get(6))<=150){
						++js;
					}
				}
			//未成年标准
			}else{
				if(Double.valueOf( a.get("xhdb"))>=110&&Double.valueOf( a.get("xhdb"))<=160){
					++js;
				}
			}
			//判断合格数
			if(js>=5){
				ints[Integer.valueOf(DataUtil.getDataDay(DataUtil.formatString(a.get("time"))))]++;
				continue;
			}
			//血尿酸标准80~420
			if(Double.valueOf( a.get("xns"))>=80&&Double.valueOf( a.get("xns"))<=420){
				++js;
			}
			//判断合格数
			if(js>=5){
				ints[Integer.valueOf(DataUtil.getDataDay(DataUtil.formatString(a.get("time"))))]++;
				continue;
			}
			//血酮标准0.02-0.27
			if(Double.valueOf( a.get("xton"))>=0.02&&Double.valueOf( a.get("xton"))<=0.27){
				++js;
			}
			if(js>=5){
				ints[Integer.valueOf(DataUtil.getDataDay(DataUtil.formatString(a.get("time"))))]++;
				continue;
			}
			if(js<5){
				bjg[Integer.valueOf(DataUtil.getDataDay(DataUtil.formatString(a.get("time"))))]++;
			}
		}
		System.out.println(currentMaxDays);
		System.out.println(ints.length);
		maps.put("pass", ints);
		maps.put("nopass", bjg);
		return maps;
	}

	/**
	 * 判断是否为素数
	 * 
	 * @param p
	 *            需要判断的数字
	 * @return
	 */
	private static boolean small0(Integer num) {
		if (num < 10) {
			if (num == 0)
				return true;
			if (num % 2 == 0 && num % 4 == 0 && num % 6 == 0 && num % 8 == 0)
				return true;
		}
		return false;
	}

	public static boolean isPrime(Integer num) {
		if (num % 2 == 0) {
			return false;
		}
		if (small0(num)) {
			return false;
		} else {
			while (num > 9) {
				num = num % 10;
			}
			if (!small0(num)) {
				return false;
			}
		}
		if (num == 1) {
			return false;
		}
		/*
		 * for(int i=2;i<=num/2;i++) { if(num%i==0) { return false; } }
		 */
		return true;
	}
}
