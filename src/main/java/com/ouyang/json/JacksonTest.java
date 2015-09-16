package com.ouyang.json;

import java.io.StringWriter;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.junit.Test;


public class JacksonTest{

	@Test
	public void testNullSerializable(){
		System.out.println(toJson(new Person(null, "男", 1)));
	}
	
	/**
	 * 把json java对象转成json字符串
	 * @Methodname: toJson
	 * @Discription: TODO
	 * @param obj 对象类型不受限制
	 * @return
	 *
	 */
	public String toJson(Object obj) {
		ObjectMapper mapper = new ObjectMapper();
		//mapper.setSerializationInclusion(Inclusion.NON_NULL);
		StringWriter sw = new StringWriter();
		try {
			mapper.writeValue(sw, obj);
			return sw.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
	public class Person {
		private String name;
		@JsonIgnore
		private String sex;
		private int age;
		public Person() {
			super();
		}
		public Person(String name, String sex, int age) {
			super();
			this.name = name;
			this.sex = sex;
			this.age = age;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getSex() {
			return sex;
		}
		public void setSex(String sex) {
			this.sex = sex;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		
	}
}
