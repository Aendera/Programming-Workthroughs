#include <iostream>
#include <random>

int roll_dice(int number_of_faces) {
	std::random_device random_device;
	std::default_random_engine random_engine(random_device());
	std::uniform_int_distribution<int> uniform_int_distribution(1, number_of_faces);
	auto random_int = uniform_int_distribution(random_engine);
	return random_int;

}
int main(int argc, char* argv[]) {

	int number_rolls = 10;
	std::cout << "Enter number of times to roll : ";
	std::cin >> number_rolls;
	printf("Rolling die %d times \n", number_rolls);
	int number_of_faces = 6;
	std::cout << "Enter number of faces : ";
	std::cin >> number_of_faces;
	printf("Dice will have %d faces \n", number_of_faces);

	//Setting max_roll and min_roll to values 
	//just below/above possible dice values
	//This guarantees max_roll/min_roll are actual rolled values
	auto max_roll = 0;
	auto min_roll = number_of_faces + 1;
	auto sum=0;
	for (int i = 0; i < number_rolls; i++)
	{
		auto random_int = roll_dice(number_of_faces);
		printf("You rolled a %d on roll %d of %d\n", random_int, i+1, number_rolls);
		sum += random_int;
		if (random_int > max_roll) {
			max_roll = random_int;
		}
		if (random_int < min_roll) {
			min_roll = random_int;
		}
	}

	double average = (double) sum/number_rolls;
	printf("Your average roll was %f\n", average);
	printf("Your maximum roll was %d\n", max_roll);
	printf("Your minimum roll was %d\n", min_roll);
	return 0;
}