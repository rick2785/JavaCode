public class JavaLessonSeven {
	
	public static void main(String[] args){
		
		// You create an object using the blueprint of this class as follows
		// className objectName = new className();
		
		Monster Frank = new Monster();
		
		// Since the objects name is public you can change it directly
		
		Frank.name = "Frank";
		
		// You retrieve class field values by listing the objectName.fieldName
		// You execute class methods by listing objectName.methodName()
		
		System.out.println(Frank.name + " has an attack value of " + Frank.getAttack());
	
	}
}