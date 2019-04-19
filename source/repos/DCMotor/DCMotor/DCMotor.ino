/*
 Name:		DCMotor.ino
 Created:	2019-01-21 오후 2:08:48
 Author:	student
*/

//#include "DCMotor.h"
const int MotorA1 = 8;
const int MotorA2 = 7;
const int MotorAS = 9;

const int MotorB1 = 5;
const int MotorB2 = 4;
const int MotorBS = 3;

// the setup function runs once when you press reset or power the board
void setup() {

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
}
