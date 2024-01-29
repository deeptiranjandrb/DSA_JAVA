class Foo {
    public static void classMethod(){
        System.out.println("classMethod of Foo");
    }
    public void instanceMethod(){
        System.out.println("instanceMethod of Foo");
    }
}
class Bar extends Foo {
     public static void classMethod(){
        System.out.println("classMethod of Bar");
    }
    public void instanceMethod(){
        System.out.println("instanceMethod of Bar");
    }
}

class Test {
    public static void main(String[] args){
        Foo f = new Bar(); // this is where the magic happens
        f.instanceMethod(); // since this is a instance method, jvm will check 'j' is a instance of which class at run time
                            // and it will be Bar class since we created an instance of Bar class even though we declared it as Foo
        
        f.classMethod(); // since this is a class method, jvm will check at complie timem which class is f declared as and it will pick 
                        // it up as type Foo(this is method hiding)
    }
}