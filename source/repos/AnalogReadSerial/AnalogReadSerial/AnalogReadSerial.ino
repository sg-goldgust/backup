/*
 Name:		AnalogReadSerial.ino
 Created:	2019-01-17 오전 9:27:26
 Author:	student
*/

// the setup function runs once when you press reset or power the board

int led = 11;
int brightness = 0;


void setup() {
	pinMode(11, OUTPUT);
	Serial.begin(9600);
}

// the loop function runs over and over again until power down or reset
void loop() {

	int sensorValue = analogRead(A0);
	brightness = map(sensorValue,0,1023,0,255);
	analogWrite(led,brightness);
	
	delay(1);
}
