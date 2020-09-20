package day6;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.*;

public class MainApplication {
	//Injection
	public static void main(String[] args) {
		// Lambdas
		Message msg = new Message();
		msg.printMessage(new ExecuteMessage() {
			public void execute() {
				System.out.println("I have injected this into print message");
			}
		});
		System.out.println("(((((((((((((((((Lambda Expressions))))))))))))))))");
		msg.printMessage(() -> System.out.println("I have injected this into print message with lambda"));
		MyAddLambdaFunction addFunction = (int a, int b) -> (a+b);
		//ForEach
		List<Circle> circles = new ArrayList<Circle>();
		circles.add(new Circle(99.8));
		circles.add(new Circle(9.8));
		circles.add(new Circle(2));;
		circles.add(new Circle(4));
		circles.add(new Circle(949.8));
		circles.add(new Circle(44));
		circles.add(new Circle(33));
		for(Circle circle : circles) {
			System.out.println(circle.toString());
		}
		System.out.println("ForEach");
		circles.forEach((circle -> System.out.println(circle.toString())));
		//Streams
		System.out.println("Stream");
		circles.stream()
		.filter(c->c.getRadius() < 15.0)
		.filter(c -> c.calculateArea() > 20)
		.forEach(c -> System.out.println("radius = "+ c.getRadius()+"\t area = "+c.calculateArea()));
	}

}

class Message
{
	public void printMessage(ExecuteMessage em) {
		System.out.println("This is Java");
		em.execute();
	}
}

interface ExecuteMessage{
	public abstract void execute();
}

interface MyAddLambdaFunction{
	public abstract int addTwoNumbers(int a, int b);
}