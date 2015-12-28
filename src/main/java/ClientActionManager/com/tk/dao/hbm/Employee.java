package com.tk.dao.hbm;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @类说明 员工信息实体类 
 * @创建者 湛耀
 * @创建时间 2015年7月7日
 * @修改者 
 * @修改时间
 */
public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;
	private String id;
	private String extension;
	private String duty;
	private String hiredate;
	private String name;
	private String sex;
	private String nativePlace;
	private String birthday;
	private String major;
	private int salary;
	private int seniority;
	private Department department;
	private Users users;
	private Post post;
	private EducationBackground educationBackground;
	private Set<ClockingIn> clockingIns = new HashSet<ClockingIn>();
	private Set<Salary> salaries = new HashSet<Salary>();
	private Set<ExpatriateLabor> expatriateLabors = new HashSet<ExpatriateLabor>();
	private Set<Work> works = new HashSet<Work>();
	private Set<Leave> leaves = new HashSet<Leave>();
	private Set<CheckItem> checkItems = new HashSet<CheckItem>();
	private Set<CooperaticePerson> cooperPlans = new HashSet<CooperaticePerson>();

	public Employee() {
	}

	public Employee(String id, Department department, Users users, Post post,
			String extension, String duty, String hiredate, int salary) {
		this.id = id;
		this.department = department;
		this.users = users;
		this.post = post;
		this.extension = extension;
		this.duty = duty;
		this.hiredate = hiredate;
		this.salary = salary;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Department getDepartment() {
		return this.department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Users getUsers() {
		return this.users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public Post getPost() {
		return this.post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public String getExtension() {
		return this.extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public String getDuty() {
		return this.duty;
	}

	public void setDuty(String duty) {
		this.duty = duty;
	}

	public String getHiredate() {
		return this.hiredate;
	}

	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}

	public int getSalary() {
		return this.salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getNativePlace() {
		return this.nativePlace;
	}

	public void setNativePlace(String nativePlace) {
		this.nativePlace = nativePlace;
	}

	public String getBirthday() {
		return this.birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getMajor() {
		return this.major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public int getSeniority() {
		return this.seniority;
	}

	public void setSeniority(int seniority) {
		this.seniority = seniority;
	}

	public Set<ClockingIn> getClockingIns() {
		return this.clockingIns;
	}

	public void setClockingIns(Set<ClockingIn> clockingIns) {
		this.clockingIns = clockingIns;
	}

	public Set<Salary> getSalaries() {
		return this.salaries;
	}

	public void setSalaries(Set<Salary> salaries) {
		this.salaries = salaries;
	}

	public Set<ExpatriateLabor> getExpatriateLabors() {
		return this.expatriateLabors;
	}

	public void setExpatriateLabors(Set<ExpatriateLabor> expatriateLabors) {
		this.expatriateLabors = expatriateLabors;
	}

	public Set<Work> getWorks() {
		return this.works;
	}

	public void setWorks(Set<Work> works) {
		this.works = works;
	}

	public EducationBackground getEducationBackground() {
		return educationBackground;
	}

	public void setEducationBackground(EducationBackground educationBackground) {
		this.educationBackground = educationBackground;
	}

	public Set<Leave> getLeaves() {
		return leaves;
	}

	public void setLeaves(Set<Leave> leaves) {
		this.leaves = leaves;
	}
	
	public void setCheckItems(Set<CheckItem> checkItems) {
		this.checkItems = checkItems;
	}
	
	public Set<CheckItem> getCheckItems() {
		return checkItems;
	}
	
	public void setCooperPlans(Set<CooperaticePerson> cooperPlans) {
		this.cooperPlans = cooperPlans;
	}
	
	public Set<CooperaticePerson> getCooperPlans() {
		return cooperPlans;
	}
}
