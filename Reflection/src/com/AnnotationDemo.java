package com;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.validation.Range;
import com.validation.Required;

class Validator{
	
	public Map<String, String> validate(Object object) throws Exception {
		
		
		Class clazz =  object.getClass();
		System.out.println(clazz.getName());
		Field [] fields =  clazz.getDeclaredFields();
		
		Map<String, String> errors = new HashMap<String, String>();
		
		for (Field field : fields) {
			
			Required required = field.getAnnotation(Required.class);
			
			if(required != null) {
				
				PropertyDescriptor propertyDescriptor = new PropertyDescriptor(field.getName(), clazz);
				Method getterMethod = propertyDescriptor.getReadMethod();
				Object val = getterMethod.invoke(object);
				
				//Object val = field.get(object);
				
				
				if(val == null) {
					errors.put(field.getName(), "This field is required");
				}
			}
			
			Range range = field.getAnnotation(Range.class);
			if(range != null) {
				
				PropertyDescriptor propertyDescriptor = new PropertyDescriptor(field.getName(), clazz);
				Method getterMethod = propertyDescriptor.getReadMethod();
				double val = (double) getterMethod.invoke(object);
				
				
				//double val = field.getDouble(object);
				if(val > range.min() && val <= range.max()) {
					
				}
				else {
					errors.put(field.getName(), "This field is out of range");
				}
			}
		}
		
		return errors;
		
	}
}




public class AnnotationDemo {

	public static void main(String[] args) {
		
		//Employee employee = new Employee();
		//Employee employee = new Employee(1, "Anil", 0.0);
		//Employee employee = new Employee(1, null, 5000);
		
		Employee employee = new Employee(1, "Anil", 45000);
		//System.out.println(employee.name);
		//employee.print();
		
		Validator validator = new Validator();
		try {
			Map<String, String> errors =  validator.validate(employee);
			if(errors.keySet().isEmpty()) {
				System.out.println("Employee is valid");
			}
			else {
				System.out.println("Errors");
				Set<String> keys = errors.keySet();
				for (String key : keys) {
					System.out.println(String.format("FieldName: %s, ErrorMessage: %s", key, errors.get(key)));
					
				}
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
