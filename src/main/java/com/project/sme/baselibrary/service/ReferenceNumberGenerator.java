package com.project.sme.baselibrary.service;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.project.sme.baselibrary.aspect.ReferenceNumber;

@Component
public class ReferenceNumberGenerator {
	
	public void generate(Object object) {
		Class<?> clazz = object.getClass();
		for (Field field : clazz.getDeclaredFields()) {
			ReferenceNumber refNo = field.getAnnotation(ReferenceNumber.class);
			if (refNo != null) {
				try {
					field.setAccessible(true);
					String seqCd = refNo.seqCd() == null ? "" : refNo.seqCd();
					Date currDt = new Date();
					SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-HHmmssSSS");
					field.set(object, seqCd + sdf.format(currDt));
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
