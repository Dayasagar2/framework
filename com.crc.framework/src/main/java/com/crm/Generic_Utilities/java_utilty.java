package com.crm.Generic_Utilities;

import java.util.Random;

public class java_utilty {
	//**
	public int getRanDomNum()
	{
		Random ran=new Random();
		int RanNum = ran.nextInt(1000);
		return RanNum;
	}
}