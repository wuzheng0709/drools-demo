package com.billing.drools.demo.handler;

import org.drools.KnowledgeBase;
import org.drools.KnowledgeBaseFactory;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderError;
import org.drools.builder.KnowledgeBuilderErrors;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.drools.logger.KnowledgeRuntimeLogger;
import org.drools.logger.KnowledgeRuntimeLoggerFactory;
import org.drools.runtime.StatefulKnowledgeSession;

import com.billing.drools.demo.entity.BillingChargeParam;

public class BillingChargeHandler {
	public static void main(String[] args) {
		try {
			// load up the knowledge base
			KnowledgeBase kbase = readKnowledgeBase();
			 //鍒涘缓浼氳瘽
			StatefulKnowledgeSession ksession = kbase
					.newStatefulKnowledgeSession();
			KnowledgeRuntimeLogger logger = KnowledgeRuntimeLoggerFactory
					.newFileLogger(ksession, "test");
			// go !
			BillingChargeParam param = new BillingChargeParam();
			param.setGameId(2);
			param.setMoney(0);
			param.setBillingType(1);
			param.setMonthCount(3);
			param.setActivityCode(1);
			param.setUserStatus(3);
			param.setMoney(0);
			//鎻掑叆
			ksession.insert(param);
			// ksession.startProcess("rules.GameRule");
			ksession.fireAllRules();
			//ksession.dispose();
			System.out.println("the final money is:" + param.getMoney());
			 //鍏抽棴
			logger.close();
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}

	private static KnowledgeBase readKnowledgeBase() throws Exception {
		//鍒涘缓瑙勫垯鏋勫缓鍣�
		KnowledgeBuilder kbuilder = KnowledgeBuilderFactory
				.newKnowledgeBuilder();
		//鍔犺浇瑙勫垯鏂囦欢锛屽苟澧炲姞鍒版瀯寤哄櫒 
		kbuilder.add(ResourceFactory.newClassPathResource("GameRule.drl"),
				ResourceType.DRL);
		kbuilder.add(ResourceFactory
				.newClassPathResource("AccumulatePointsRule.drl"),
				ResourceType.DRL);
		kbuilder.add(
				ResourceFactory.newClassPathResource("UserStatusRule.drl"),
				ResourceType.DRL);
		kbuilder.add(ResourceFactory.newClassPathResource("ActivityRule.drl"),
				ResourceType.DRL);

		KnowledgeBuilderErrors errors = kbuilder.getErrors();
		if (errors.size() > 0) {
	
			for (KnowledgeBuilderError error : errors) {
				System.err.println(error);
			}
			throw new IllegalArgumentException("Could not parse knowledge.");
		}

		KnowledgeBase kbase = KnowledgeBaseFactory.newKnowledgeBase();

		kbase.addKnowledgePackages(kbuilder.getKnowledgePackages());
		return kbase;
	}

}
