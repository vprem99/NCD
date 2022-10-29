package com.ncd.utils;

import java.util.Date;

public class TimeCalculator {

	public static String[] getTime(int incrementValue) {
		Date d = new Date();
		String time = d.toString().split(" ")[3];
		int hr = Integer.parseInt(time.split(":")[0]);
		int mm = Integer.parseInt(time.split(":")[1]);
		// int mm = 59;

		mm = mm + incrementValue;
		if (hr > 12) {
			hr = hr - 12;
		}
		if (mm > 60) {
			hr = hr + 1;
			mm = mm - 60;
		}

		String hr2 = Integer.toString(hr);
		String mm2 = Integer.toString(mm);
		if(hr2.length()==1)
			hr2="0"+hr2;
		if(mm2.length()==1)
			mm2="0"+mm2;
		String t[] = { hr2, mm2 };
		return t;

	}

	public static void main(String[] args) {
		System.out.println(getTime(7)[0]+" "+getTime(7)[1]);
	}
}
