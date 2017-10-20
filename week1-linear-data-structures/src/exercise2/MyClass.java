package exercise2;

class MyClass<E>{
    private E attribute;
    MyClass(E var){
	    this.attribute = var;
    }
    public E get(){
	    return this.attribute;
    }
    public void set(E value){
	    this.attribute = value;
    }
    
    public boolean equals(Object other){
         if (!(other instanceof MyClass<?>)) 
        	 return false;
         
         // if both attributes are null
         if (this.attribute == null) { 
        	 return ((MyClass<E>) other).get() == null;
         }
         
         return this.attribute.equals(((MyClass<E>) other).get());
    }
    
}