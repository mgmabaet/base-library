package com.project.sme.baselibrary.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.sme.baselibrary.service.ReferenceNumberGenerator;

@Aspect
@Component
public class ReferenceNumberAspect {
	
	@Autowired
	private ReferenceNumberGenerator referenceNumberGenerator;
	
	private final Logger LOG = LoggerFactory.getLogger(getClass());
	
	@Before("execution(* org.springframework.data.repository.CrudRepository+.save(..))))")
	public void saveAction(JoinPoint point){
		LOG.info("Generating reference number...");
		setObject(point);
	}
	
	public void setObject(JoinPoint point){
		Object[] argList = point.getArgs();
		if(argList.length > 0){
			Object model = argList[0];
			referenceNumberGenerator.generate(model);
		}
	}

}
