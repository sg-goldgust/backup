/*
 Name:		lightSensor.ino
 Created:	1/17/2019 10:28:01 AM
 Author:	student
*/
#include "Led.h"

const int ledPin = 11;
const int photoResistorPin = A0;

int photoResistorValue;
int brightness;

// the setup function runs once when you press reset or power the board
void setup() {
	Serial.begin(9600);
}

// the loop function runs over and over again until power down or reset
void loop() {
	/*photoResistorValue = analogRead(photoResistorPin);
	Serial.print("value :");
	Serial.print(photoResistorValue);

	brightness = map(photoResistorValue, 0, 1023, 0, 100);
	Serial.println(brightness);

	analogWrite(ledPin, brightness);*/

	int sensorValue = analogRead(A0);
	Serial.println(sensorValue);

	if (sensorValue < 400) {

	}
	



}
