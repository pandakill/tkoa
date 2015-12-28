package com.tk.action;

import java.util.Iterator;
import java.util.Set;

import com.opensymphony.xwork2.ActionSupport;
import com.tk.dao.hbm.Plan;
import com.tk.service.IPlanManager;
import com.tk.util.SomeTool;

public class PlanAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	
	private static IPlanManager iPlanManager;
	
	private String planName;
	private int parentID;
	
	public static void setiPlanManager(IPlanManager iPlanManager) {
		PlanAction.iPlanManager = iPlanManager;
		System.out.println("PlanAction -> setiPlanManager" + PlanAction.iPlanManager);
	}
	
	public static IPlanManager getiPlanManager() {
		return iPlanManager;
	}
	
	public void setParentID(int parentID) {
		this.parentID = parentID;
	}
	
	public int getParentID() {
		return parentID;
	}
	
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	
	public String getPlanName() {
		return planName;
	}
	
//	public void addPlan(){
//		System.out.println("parentID="+parentID);
//		Plan plan = new Plan(planName);
//		Plan parentPlan = null;
//		if( parentID != 0 ){
//			parentPlan = iPlanManager.getPlanByID(parentID);
//		}
//		plan.setParentPlan(parentPlan);
//		String status = iPlanManager.addPlan(plan);
//		SomeTool.out_print(String.valueOf(status));
//	}
	
//	public void getPlan(){
//		System.out.println("parentID"+parentID);
//		Plan plan = iPlanManager.getPlanByID(parentID);
//		System.out.println("----------------");
//		System.out.println("id=" + plan.getId() + " -- name=" +plan.getName() );
//		if( plan.getParentPlan() != null ){
//			System.out.println("parentID=" + plan.getParentPlan().getId() + " -- parentName=" + plan.getParentPlan().getName() );
//		}
//		if( plan.getChildPlans() != null ){
////			Set<Plan> childPlans = plan.getChildPlans();
////			Plan chlidPlan = new Plan();
////			Iterator<Plan> iterator = childPlans.iterator();
////			int i = 1;
////			while ( iterator.hasNext() ) {
////				chlidPlan = iterator.next();
////				System.out.println("--childID"+i+"=" + chlidPlan.getId() + " -- childName"+i+"=" + chlidPlan.getName() );
////				i++;
////			}
//			getChildPlan(plan, plan.getId());
//		}
//	}
//	
//	public void getChildPlan(Plan plan, int parentID){
//		Set<Plan> childPlans = plan.getChildPlans();
//		Plan chlidPlan = new Plan();
//		Iterator<Plan> iterator = childPlans.iterator();
//		int i = 0;
//		while ( iterator.hasNext() ) {
//			chlidPlan = iterator.next();
//			System.out.println("--parentID="+chlidPlan.getParentPlan().getId());
//			System.out.println("--childID"+i+"=" + chlidPlan.getId() + " -- childName"+i+"=" + chlidPlan.getName() );
//			if(chlidPlan.getChildPlans() != null){
//				getChildPlan(chlidPlan, parentID);
//			}
//			i++;
//		}
//	}

}
