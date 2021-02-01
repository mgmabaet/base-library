package com.project.sme.baselibrary.aspect;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface ReferenceNumber {
	
	public String seqCd();
	
}