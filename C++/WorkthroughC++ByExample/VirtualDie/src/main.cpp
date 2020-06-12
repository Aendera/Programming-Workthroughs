#include <iostream>
#include <random>

int roll_dice() {
	std::random_device random_device;
	std::default_random_engine random_engine(random_device());
	std::uniform_int_distribution<int> uniform_int_distribution(1, 6);
	auto random_int = uniform_int_distribution(random_engine);
	return random_int;

}
int main(int argc, char* argv[]) {
	double average = 0.0;
	for (int i = 0; i < 20; i++)
	{
		auto random_int = roll_dice();
		printf("You rolled a %d on roll %d of 20\n", random_int, i+1);
		average += (double) random_int;
	}
	average /= 20.0;
	printf("Your average roll was %f", average);
	return 0;
}