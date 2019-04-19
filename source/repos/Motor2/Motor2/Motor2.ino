const int MotorA1 = 9;
const int MotorA2 = 8;
const int MotorAS = 10;

const int MotorB1 = 7;
const int MotorB2 = 6;
const int MotorBS = 5;

int led = 12;

// the setup function runs once when you press reset or power the board
void setup() {

	pinMode(led, OUTPUT);

	pinMode(MotorA1, OUTPUT);
	pinMode(MotorA2, OUTPUT);
	pinMode(MotorAS, OUTPUT);

	pinMode(MotorB1, OUTPUT);
	pinMode(MotorB2, OUTPUT);
	pinMode(MotorBS, OUTPUT);
}

void forward(int speed = 100) {
	digitalWrite(MotorA1, LOW);
	digitalWrite(MotorA2, HIGH);
	analogWrite(MotorAS, speed);

	digitalWrite(MotorB1, LOW);
	digitalWrite(MotorB2, HIGH);
	analogWrite(MotorBS, speed);
}

void back(int speed = 100) {
	digitalWrite(MotorA1, HIGH);
	digitalWrite(MotorA2, LOW);
	analogWrite(MotorAS, speed);

	digitalWrite(MotorB1, HIGH);
	digitalWrite(MotorB2, LOW);
	analogWrite(MotorBS, speed);
}

void turnLeft(int speed = 100) {
	digitalWrite(MotorA1, LOW);
	digitalWrite(MotorA2, LOW);
	analogWrite(MotorAS, 0);

	digitalWrite(MotorB1, LOW);
	digitalWrite(MotorB2, HIGH);
	analogWrite(MotorBS, speed);
}

void turnRight(int speed = 100) {
	digitalWrite(MotorA1, LOW);
	digitalWrite(MotorA2, HIGH);
	analogWrite(MotorAS, speed);

	digitalWrite(MotorB1, LOW);
	digitalWrite(MotorB2, LOW);
	analogWrite(MotorBS, 0);
}
void stop(int speed = 100) {
	digitalWrite(MotorA1, LOW);
	digitalWrite(MotorA2, LOW);
	analogWrite(MotorAS, 0);

	digitalWrite(MotorB1, LOW);
	digitalWrite(MotorB2, LOW);
	analogWrite(MotorBS, 0);
}


// the loop function runs over and over again until power down or reset
void loop() {
	forward();
	delay(2000);
	back();
	delay(2000);
	turnLeft();
	delay(2000);
	turnRight();
	delay(2000);
	stop();
	delay(2000);

	digitalWrite(led, HIGH);
}