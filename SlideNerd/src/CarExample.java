public class CarExample {
	public static void main(String[] args) {
		Car myCar = new Car();
		myCar.fuelCapacity = 20;
		myCar.amountOfFuel = 12;
		myCar.addGas(22);
		System.out.println(myCar.amountOfFuel);
		myCar.mileage = 15;
		myCar.drive(30);
	}

}

class Car {
	double mileage;
	double amountOfFuel;
	double fuelCapacity;

	public void drive(double distance) {
		double fuelNeeded = distance/mileage;
		if(amountOfFuel>=fuelNeeded){
			amountOfFuel= amountOfFuel-fuelNeeded;
			System.out.println("You travelled " + distance + "kilometers");
		}
		else System.out.println("You don't have enough gas for the trip");
		
	}

	public void addGas(double amount) {
		double emptySpace = fuelCapacity - amountOfFuel;
		if(amount<emptySpace){
			amountOfFuel = amountOfFuel + amount;
			System.out.println(amount + " was added succesfully");
		}
		else{
			amountOfFuel=fuelCapacity;
			System.out.println("The tank is full");
		}
		
	}

	public double getFuelLevel() {
		return amountOfFuel;
	}

}