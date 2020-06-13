#include<iostream>
#include<random>
class Money {
public:
	void set_money(int start) {
		this->money = start;
	}
	void lose_money(int loss) {
		this->money -= loss;
	}
	void gain_money(int gain) {
		this->money +=gain;
	}
	int get_money() {
		return this->money;
	}
private:
	int money;
};
int house_guess() {
	std::random_device random_device;
	std::default_random_engine random_engine(random_device());
	std::uniform_int_distribution<int> uniform_int_distribution(1, 10);
	auto random_int = uniform_int_distribution(random_engine);
	return random_int;
}
int main(){

	Money PlayerMoney;
	int bet, guess, startup_capital,house;

	std::cout << "Set your starting chip count"<< std::endl;

	std::cin >> startup_capital;
	PlayerMoney.set_money(startup_capital);
	while (PlayerMoney.get_money() > 0){
	//get random number
		house = house_guess();

		std::cout << "You currently have "<< PlayerMoney.get_money()<<" chips remaining" << std::endl;

		do {

			std::cout << "Place a bet" << std::endl;
			std::cin >> bet;
			if (bet > PlayerMoney.get_money()) {
				std::cout << "Betting isn't done on credit here! Don't bet more than you have." << std::endl;

			}
		} while (bet > PlayerMoney.get_money());
		do {

			std::cout << "Choose a value between 1 and 10" << std::endl;
			std::cin >> guess;
		} while (!((guess <= 10) && (guess >= 1)));
		std::cout << "The house chose "<<house << std::endl;

		if (house == guess) {
			std::cout << "You won! You get 10 times your inital bet: "<<10*bet<< " chips" << std::endl;

			PlayerMoney.gain_money(10 * bet);
		}
		else {
			std::cout << "You lost!" << std::endl;

			PlayerMoney.lose_money(bet);
		}
	}
	std::cout <<"You're out !" << std::endl;

	getchar();
}
